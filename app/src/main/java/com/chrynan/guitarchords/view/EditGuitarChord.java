package com.chrynan.guitarchords.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by chRyNaN on 2/9/2016. An editable version of GuitarChordView, where the user can add and remove notes.
 */
public class EditGuitarChord extends GuitarChordView implements GuitarChordView.OnChordSelectedListener {

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
        setEditable(true);
        addOnChordSelectedListener(this);
    }

    @Override
    public void onChordSelected(MotionEvent event, ChordMarker marker, boolean isMarkerInChord) {
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

}
