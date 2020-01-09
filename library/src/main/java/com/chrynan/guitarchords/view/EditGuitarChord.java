package com.chrynan.guitarchords.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

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
 * Created by chRyNaN on 2/9/2016. An editable version of GuitarChordView, where the user can add and remove notes.
 * TODO add entering finger support and fret number scroll change support
 */
public class EditGuitarChord extends GuitarChordView implements GuitarChordView.OnChordSelectedListener, GuitarChordView.OnFretNumberSelectedListener, GuitarChordView.OnStringSelectedListener {
    private static final String TAG = GuitarChordView.class.getSimpleName();

    public EditGuitarChord(Context context){
        super(context);
        init();
    }

    public EditGuitarChord(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }

    public EditGuitarChord(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init();
    }

    public EditGuitarChord(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        showFingerNumbers(false);
        setEditable(true);
        addOnChordSelectedListener(this);
        addOnFretNumberSelectedListener(this);
        addOnStringSelectedListener(this);
    }

    @Override
    public void onChordSelected(MotionEvent event, ChordMarker marker, boolean isMarkerInChord) {
        //TODO add bar adding and removing support
        if(isMarkerInChord){
            if(event == null){
                removeMarker(marker);
                addMarker(marker);
            }else {
                removeMarker(marker);
            }
        }else{
            addMarker(marker);
        }
    }

    @Override
    public void onFretNumberSelected(MotionEvent event, int fret) {
        //TODO
    }

    @Override
    public void onStringSelected(MotionEvent event, int string) {
        //TODO fix change from mute to open string (when selecting muted marker it doesn't change to open marker)
        List<ChordMarker> notes = getChord().getAllNotesOnString(string);
        List<Integer> openStrings = getChord().getOpenStrings();
        List<Integer> mutedStrings = getChord().getMutedStrings();
        if(notes == null || notes.size() < 1){
            if(openStrings.contains(string) && !mutedStrings.contains(string)){
                addMarker(new ChordMarker(string, ChordMarker.FRET_MUTE, ChordMarker.NO_FINGER));
            }else{
                addMarker(new ChordMarker(string, ChordMarker.OPEN_FRET, ChordMarker.NO_FINGER));
            }
        }
    }

    public void changeFretStart(int fretStart){
        fretStart = (fretStart < 1) ? 1 : fretStart;
        fretStart = (fretStart > (Chord.MAX_FRET - getChord().getFretCount())) ? (Chord.MAX_FRET - getChord().getFretCount()) : fretStart;
        List<ChordMarker> allNotes = getChord().getAllMarkers();
        int prevStart = getChord().getFretStart();
        int diff = prevStart - fretStart;
        List<ChordMarker> newNotes = new ArrayList<>();
        for(ChordMarker marker : allNotes){
            newNotes.add(new ChordMarker(marker.getStartString(), marker.getEndString(), marker.getFinger() - diff, marker.getFinger()));
        }
        clear();
        addMarkers(newNotes);
    }

}
