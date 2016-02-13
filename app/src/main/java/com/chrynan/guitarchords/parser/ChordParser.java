package com.chrynan.guitarchords.parser;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Xml;

import com.chrynan.guitarchords.view.GuitarChordView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/*
 * Copyright 2016 chRyNaN
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Created by chRyNaN on 2/12/2016. A class for parsing text and other formats representing chords to and from a
 * GuitarChordView.Chord object for better support between formats.
 */
public class ChordParser {

    public static GuitarChordView.Chord parseFromASCII(String singleASCIIChord){
        //Takes the first number on each line and counts that as a fret for the string it's on
        if(singleASCIIChord == null){
            throw new IllegalArgumentException("String parameter in parseFromASCII method must not be null.");
        }
        GuitarChordView.Chord chord = new GuitarChordView.Chord();
        BufferedReader br = null;
        String line;
        int string = 1;
        try{
            br = new BufferedReader(new StringReader(singleASCIIChord));
            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(Character.isDigit(line.charAt(i))){
                        chord.addMarker(new GuitarChordView.ChordMarker(string, Character.getNumericValue(line.charAt(i)),
                                GuitarChordView.ChordMarker.NO_FINGER));
                        break;
                    }
                }
                string++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return chord;
    }

    public static String toASCII(GuitarChordView.Chord chord){
        if(chord == null){
            throw new IllegalArgumentException("Chord parameter in toASCII method must not be null.");
        }
        List<GuitarChordView.ChordMarker> markers;
        StringBuilder sb = new StringBuilder();
        String line;
        int fret;
        for(int i = 1; i < chord.getStringCount(); i++){
            markers = chord.getAllNotesOnString(i);
            if(markers != null && markers.size() > 0){
                fret = markers.get(0).getFret();
                if(fret >= 0) {
                    line = "|--" + fret + "--|" + System.getProperty("line.separator");
                }else{
                    line = "|-----|" + System.getProperty("line.separator");
                }
            }else{
                line = "|-----|" + System.getProperty("line.separator");
            }
            sb.append(line);
        }
        return sb.toString();
    }

    public static GuitarChordView.Chord parseFromMusicXML(InputStream stream){
        if(stream == null){
            throw new IllegalArgumentException("Stream parameter in parseFromMusicXML method must not be null.");
        }
        GuitarChordView.Chord chord = new GuitarChordView.Chord();
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(stream, null);
            parser.nextTag();
            List<GuitarChordView.ChordMarker> markers = readMusicXML(parser);
            if(markers != null && markers.size() > 0){
                for(GuitarChordView.ChordMarker marker : markers){
                    chord.addMarker(marker);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return chord;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static GuitarChordView.Chord parseFromMusicXML(String xmlString){
        return parseFromMusicXML(new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8)));
    }

    public static GuitarChordView.Chord parseFromMusicXML(String xmlString, Charset charset){
        return parseFromMusicXML(new ByteArrayInputStream(xmlString.getBytes(charset)));
    }

    public static String toMusicXML(GuitarChordView.Chord chord){
        if(chord == null){
            throw new IllegalArgumentException("Chord parameter in toMusicXML method must not be null.");
        }
        try{
            XmlSerializer xmlSerializer = Xml.newSerializer();
            StringWriter writer = new StringWriter();
            xmlSerializer.setOutput(writer);
            xmlSerializer.startDocument("UTF-8", true);
            xmlSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            xmlSerializer.startTag("", "harmony");
            xmlSerializer.startTag("", "frame");
            for(GuitarChordView.ChordMarker marker : chord.getBars()){
                for(int i = marker.getStartString(); i <= marker.getEndString(); i++){
                    xmlSerializer.startTag("", "frame-note");
                    xmlSerializer.startTag("", "string");
                    xmlSerializer.text(String.valueOf(i));
                    xmlSerializer.endTag("", "string");
                    xmlSerializer.startTag("", "fret");
                    xmlSerializer.text(String.valueOf(marker.getFret()));
                    xmlSerializer.endTag("", "fret");
                    xmlSerializer.endTag("", "frame-note");
                }
            }
            for(GuitarChordView.ChordMarker marker : chord.getIndividualNotes()){
                xmlSerializer.startTag("", "frame-note");
                xmlSerializer.startTag("", "string");
                xmlSerializer.text(String.valueOf(marker.getStartString()));
                xmlSerializer.endTag("", "string");
                xmlSerializer.startTag("", "fret");
                xmlSerializer.text(String.valueOf(marker.getFret()));
                xmlSerializer.endTag("", "fret");
                xmlSerializer.endTag("", "frame-note");
            }
            xmlSerializer.endTag("", "frame");
            xmlSerializer.endTag("", "harmony");
            xmlSerializer.endDocument();
            return writer.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static List<GuitarChordView.ChordMarker> readMusicXML(XmlPullParser parser){
        List<GuitarChordView.ChordMarker> markers = new ArrayList<>();
        try {
            parser.require(XmlPullParser.START_TAG, null, "harmony");
            while (parser.next() != XmlPullParser.END_TAG) {
                if (parser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }
                String name = parser.getName();
                if(name.equals("frame")) {
                    markers = readFrame(parser);
                    break;
                } else {
                    skip(parser);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return markers;
    }

    private static List<GuitarChordView.ChordMarker> readFrame(XmlPullParser parser){
        List<GuitarChordView.ChordMarker> markers = new ArrayList<>();
        try{
            parser.require(XmlPullParser.START_TAG, null, "frame");
            while (parser.next() != XmlPullParser.END_TAG) {
                if (parser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }
                String name = parser.getName();
                if(name.equals("frame-note")){
                    markers.add(readFrameNote(parser));
                }
            }
            }catch(Exception e){
            e.printStackTrace();
        }
        return markers;
    }

    private static GuitarChordView.ChordMarker readFrameNote(XmlPullParser parser){
        GuitarChordView.ChordMarker marker = null;
        try{
            parser.require(XmlPullParser.START_TAG, null, "frame-note");
            int string = 0, fret = 0;
            while (parser.next() != XmlPullParser.END_TAG) {
                if (parser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }
                String name = parser.getName();
                if(name.equals("string")) {
                    string = readString(parser);
                }else if(name.equals("fret")) {
                    fret = readFret(parser);
                }
            }
            marker = new GuitarChordView.ChordMarker(string, fret, GuitarChordView.ChordMarker.NO_FINGER);
        }catch(Exception e){
            e.printStackTrace();
        }
        return marker;
    }

    private static int readString(XmlPullParser parser){
        int string = 0;
        try{
            parser.require(XmlPullParser.START_TAG, null, "string");
            String s = readText(parser);
            parser.require(XmlPullParser.END_TAG, null, "string");
            string = Integer.valueOf(s);
        }catch(Exception e){
            e.printStackTrace();
        }
        return string;
    }

    private static int readFret(XmlPullParser parser){
        int fret = 0;
        try{
            parser.require(XmlPullParser.START_TAG, null, "fret");
            String s = readText(parser);
            parser.require(XmlPullParser.END_TAG, null, "fret");
            fret = Integer.valueOf(s);
        }catch(Exception e){
            e.printStackTrace();
        }
        return fret;
    }

    private static String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }


    private static void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }

}
