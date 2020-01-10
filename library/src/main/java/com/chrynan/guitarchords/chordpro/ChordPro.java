package com.chrynan.guitarchords.chordpro;

import android.text.SpannableStringBuilder;

import com.chrynan.guitarchords.span.ChordSpan;
import com.chrynan.guitarchords.view.GuitarChordView;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 * Created by chRyNaN on 2/15/2016. A helper class for converting Strings in ChordPro text format to a SpannableStringBuilder
 * and retrieving useful information from ChordPro text formatted Strings.
 */
public class ChordPro {

    public static SpannableStringBuilder parseString(String string){
        //This method can take awhile consider running this on a different thread than the UI thread
        if(string == null){
            throw new IllegalArgumentException("String parameter in parseString method must not be null.");
        }
        List<MetaTag> metaTags = getMetaTags(string);
        SpannableStringBuilder sb = new SpannableStringBuilder();
        BufferedReader reader = null;
        String line;
        try{
            reader = new BufferedReader(new StringReader(string));
            while((line = reader.readLine()) != null){
                //Don't show the MetaTags
                //TODO add formatting and detail support from the MetaTags
                for(String s : getCurvedBracketTags(line)){
                    line = line.replace(s, "");
                }
                int pos = 0;
                String name;
                MetaTag t;
                List<String> squareBrackets = getSquareBracketTags(line);
                for(String s : squareBrackets){
                    int i = line.indexOf(s);
                    if(i != -1) {
                        //Add spaces to position the Chord correctly
                        for (int j = 0; j < i; j++) {
                            sb.append(" ");
                        }
                        name = s.replace("[", "").replace("]", "").trim();
                        sb.append(name);
                        t = getDefineTag(metaTags, name);
                        if(t != null){
                            sb.setSpan(new ChordSpan(getChordFromDefineTag(t)), sb.length() - name.length(),
                            sb.length() + name.length(), 0);
                        }
                    }
                    line = line.replace(s, "");
                    if(pos + 1 == squareBrackets.size()){
                        sb.append(System.getProperty("line.separator"));
                    }
                    pos++;
                }
                sb.append(line + System.getProperty("line.separator"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(reader != null){
                    reader.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return sb;
    }

    public static List<Tag> getTags(String string){
        if(string == null){
            throw new IllegalArgumentException("String parameter in getTags method must not be null.");
        }
        List<Tag> tags = new ArrayList<>();
        tags.addAll(getMetaTags(string));
        tags.addAll(getChordTags(string));
        return tags;
    }

    public static List<MetaTag> getMetaTags(String string){
        if(string == null){
            throw new IllegalArgumentException("String parameter in getMetaTags method must not be null.");
        }
        List<MetaTag> tags = new ArrayList<>();
        Pattern p = Pattern.compile("\\{(.*?)\\}");
        Matcher m = p.matcher(string);
        while(m.find()){
            tags.add(new MetaTag(m.group(1)));
        }
        return tags;
    }

    public static List<ChordTag> getChordTags(String string){
        if(string == null){
            throw new IllegalArgumentException("String parameter in getChordTags method must not be null.");
        }
        List<ChordTag> tags = new ArrayList<>();
        Pattern p = Pattern.compile("\\[(.*?)\\]");
        Matcher m = p.matcher(string);
        while(m.find()){
            tags.add(new ChordTag(m.group(1)));
        }
        return tags;
    }

    public static List<String> getSquareBracketTags(String string){
        if(string == null){
            throw new IllegalArgumentException("String parameter in getSquareBracketTags method must not be null.");
        }
        List<String> tags = new ArrayList<>();
        Pattern p = Pattern.compile("\\[(.*?)\\]");
        Matcher m = p.matcher(string);
        while(m.find()){
            tags.add("[" + m.group(1) + "]");
        }
        return tags;
    }

    public static List<String> getCurvedBracketTags(String string){
        if(string == null){
            throw new IllegalArgumentException("String parameter in getCurvedBracketTags method must not be null.");
        }
        List<String> tags = new ArrayList<>();
        Pattern p = Pattern.compile("\\{(.*?)\\}");
        Matcher m = p.matcher(string);
        while(m.find()){
            tags.add("{" + m.group(1) + "}");
        }
        return tags;
    }

    public static GuitarChordView.Chord getChordFromDefineTag(MetaTag tag){
        if(tag == null){
            throw new IllegalArgumentException("Tag parameter in getChordFromDefineTag method must not be null.");
        }
        if(tag.getType() != MetaTag.TYPE_INLINE){
            throw new IllegalArgumentException("Tag parameter in getChordFromDefineTag method must be of type TYPE_INLINE.");
        }
        if(!tag.getKey().equals(MetaTag.Inline.DEFINE)){
            throw new IllegalArgumentException("Tag parameter in getChordFromDefineTag method must have DEFINE key.");
        }
        return getChordFromString(tag.getValue());
    }

    public static GuitarChordView.Chord getChordFromString(String string){
        //String should come in the format:  E5 base-fret 7 frets 0 1 3 3 x x fingers - 1 2 3 - - key E
        //Comes from define tag: {define: E5 base-fret 7 frets 0 1 3 3 x x fingers - 1 2 3 - - key E}
        if(string == null){
            throw new IllegalArgumentException("String parameter in getChordFromString method must not be null.");
        }
        string = string.trim();
        int baseFretStart = string.indexOf(MetaTag.BASE_FRET);
        int fretStart = string.indexOf(MetaTag.FRETS);
        int fingerStart = string.indexOf(MetaTag.FINGERS);
        int keyStart = string.indexOf(MetaTag.KEY);
        String baseFret, key, title;
        String[] frets = null, fingers = null;
        if(baseFretStart != -1){
            title = string.substring(0, baseFretStart);
            if(fretStart != -1){
                baseFret = string.substring(baseFretStart + MetaTag.BASE_FRET.length(), fretStart).trim();
                if(fingerStart != -1){
                    frets = string.substring(fretStart + MetaTag.FRETS.length(), fingerStart).trim().split("\\s+");
                    if(keyStart != -1){
                        fingers = string.substring(fingerStart + MetaTag.FINGERS.length(), keyStart).trim().split("\\s+");
                        key = string.substring(keyStart + MetaTag.KEY.length(), string.length()).trim();
                    }else{
                        fingers = string.substring(fingerStart + MetaTag.FINGERS.length(), string.length()).trim().split("\\s+");
                    }
                }else{
                    frets = string.substring(fretStart + MetaTag.FRETS.length(), string.length()).trim().split("\\s+");
                }
            }else{
                baseFret = string.substring(baseFretStart + MetaTag.BASE_FRET.length(), string.length()).trim();
            }
            GuitarChordView.Chord chord = new GuitarChordView.Chord();
            chord.title = title;
            int b;
            try {
                b = (Integer.valueOf(baseFret) < 0) ? 0 : Integer.valueOf(baseFret);
            }catch(NumberFormatException e){
                b = 0;
            }
            if(frets != null) {
                for (int i = 0; i < frets.length; i++) {
                    if(fingers != null && fingers.length == frets.length){
                        chord.addMarker(new GuitarChordView.ChordMarker(frets.length - i,
                                b + Integer.valueOf(frets[i]),
                                Integer.valueOf(fingers[i])));
                    }else{
                        chord.addMarker(new GuitarChordView.ChordMarker(frets.length - i,
                                b + Integer.valueOf(frets[i]),
                                GuitarChordView.ChordMarker.NO_FINGER));
                    }
                }
            }
            return chord;
        }
        return null;
    }

    public static MetaTag getDefineTag(List<MetaTag> tags, String chordName){
        if(tags == null){
            throw new IllegalArgumentException("Tags parameter in getDefineTag method must not be null.");
        }
        if(chordName == null){
            throw new IllegalArgumentException("ChordName parameter in getDefineTag method must not be null.");
        }
        MetaTag tag = null;
        String s;
        int i;
        for(MetaTag t : tags){
            if(t.getKey() == MetaTag.Inline.DEFINE){
                s = t.getValue().trim();
                i = t.getValue().indexOf(" ");
                if(i != -1){
                    s = s.substring(0, i);
                }
                if(s.equals(chordName)){
                    tag = t;
                    break;
                }
            }
        }
        return tag;
    }

}
