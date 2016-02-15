package com.chrynan.guitarchords.chordpro;

import com.chrynan.guitarchords.view.GuitarChordView;

/**
 * Created by chRyNaN on 2/15/2016.
 */
public class ChordTag extends Tag<String, String>{
    private GuitarChordView.Chord chord;

    public ChordTag(){
        super();
    }

    public ChordTag(String chordName){
        super(chordName, null);
    }

    public ChordTag(String key, String value){
        super(key, value);
    }

    public ChordTag(String chordName, GuitarChordView.Chord chord){
        super(chordName, null);
        setChord(chord);
    }

    public String getChordName(){
        return getKey();
    }

    public void setChordName(String name){
        setKey(name);
    }

    public GuitarChordView.Chord getChord(){
        return chord;
    }

    public void setChord(GuitarChordView.Chord chord){
        this.chord = chord;
    }

    @Override
    public String toString() {
        return "ChordTag{" +
                "chord=" + chord +
                "key=" + getKey() +
                "value=" + getValue() +
                '}';
    }

    @Override
    public String toTagString(){
        String k = getKey();
        String v = getValue();
        if(k != null && v != null) {
            return "[" + k.toString() + DELIMITER + v.toString() + "]";
        }else if(k != null){
            return "[" + k.toString() + "]";
        }else if(v != null){
            return "[" + v.toString() + "]";
        }else{
            return this.toString();
        }
    }

}
