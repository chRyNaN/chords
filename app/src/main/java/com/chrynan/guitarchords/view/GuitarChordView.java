package com.chrynan.guitarchords.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.chrynan.guitarchords.R;

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
 * Created by chRyNaN on 2/2/2016. A View class to display guitar (or other stringed fretted instruments) chords
 * as a chart.  
 */
public class GuitarChordView extends View {
    private static final String TAG = GuitarChordView.class.getSimpleName();
    private static final int DEFAULT_COLOR = Color.parseColor("#000000");
    private static final int BLACK = Color.parseColor("#000000");
    private static final int WHITE = Color.parseColor("#FFFFFF");
    private static final String MUTED_TEXT = "X";
    private static final String OPEN_STRING_TEXT = "O";

    //These static fields correspond to inner class static fields for convenience reasons.
    //For instance, rather than having to use GuitarChordView.Chord.NO_FRET, you can simply
    //use GuitarChordView.NO_FRET. Much easier for a user who isn't aware of the inner classes
    //(even though they are public). Keep these values equal to their inner class counterparts.
    public static final int NO_FRET = Chord.NO_FRET;
    public static final int MAX_FRET = Chord.MAX_FRET;
    public static final String BLANK_TITLE = Chord.BLANK_TITLE;
    public static final String TYPE_BAR = ChordMarker.TYPE_BAR;
    public static final String TYPE_NOTE = ChordMarker.TYPE_NOTE;
    public static final String TYPE_MUTE = ChordMarker.TYPE_MUTE;
    public static final String TYPE_BAR_MUTE = ChordMarker.TYPE_BAR_MUTE;
    public static final int FIRST_STRING = ChordMarker.FIRST_STRING; //Corresponds to the high E string on a standard tuned guitar
    public static final int SECOND_STRING = ChordMarker.SECOND_STRING;
    public static final int THIRD_STRING = ChordMarker.THIRD_STRING;
    public static final int FOURTH_STRING = ChordMarker.FOURTH_STRING;
    public static final int FIFTH_STRING = ChordMarker.FIFTH_STRING;
    public static final int SIXTH_STRING = ChordMarker.SIXTH_STRING; //Corresponds to the low E string on a standard tuned guitar
    public static final int NO_FINGER = ChordMarker.NO_FINGER;
    public static final int INDEX_FINGER = ChordMarker.INDEX_FINGER;
    public static final int MIDDLE_FINGER = ChordMarker.MIDDLE_FINGER;
    public static final int RING_FINGER = ChordMarker.RING_FINGER;
    public static final int PINKY = ChordMarker.PINKY;
    public static final int THUMB = ChordMarker.THUMB;
    public static final int OPEN = ChordMarker.OPEN;
    public static final int OPEN_FRET = OPEN;
    public static final int OPEN_STRING = OPEN;
    public static final int FRET_OPEN = OPEN;
    public static final int FRET_MUTE = ChordMarker.FRET_MUTE;
    public static final int MAX_FRET_COUNT = ChordMarker.MAX_FRET_COUNT;

    //It can be more convenient and user friendly to use static classes with static fields for this purpose
    //since it seems more natural and expected (example, instead of GuitarChordView.FIRST_STRING, use
    //GuitarChordView.String.FIRST). Will keep both approaches for convenience for the programmer
    //(shouldn't be too much more memory).
    public static class Fret{
        public static final int NONE = Chord.NO_FRET;
        public static final int MAX = Chord.MAX_FRET;
        public static final int OPEN = ChordMarker.FRET_OPEN;
        public static final int MUTE = ChordMarker.FRET_MUTE;
    }

    public static class GuitarString{
        public static final int FIRST = ChordMarker.FIRST_STRING;
        public static final int SECOND = ChordMarker.SECOND_STRING;
        public static final int THIRD = ChordMarker.THIRD_STRING;
        public static final int FOURTH = ChordMarker.FOURTH_STRING;
        public static final int FIFTH = ChordMarker.FIFTH_STRING;
        public static final int SIXTH = ChordMarker.SIXTH_STRING;
    }

    public static class Finger{
        public static final int NONE = ChordMarker.NO_FINGER;
        public static final int INDEX = ChordMarker.INDEX_FINGER;
        public static final int MIDDLE = ChordMarker.MIDDLE_FINGER;
        public static final int RING = ChordMarker.RING_FINGER;
        public static final int PINKY = ChordMarker.PINKY;
        public static final int THUMB = ChordMarker.THUMB;
    }

    public static class Type{
        public static final String BAR = ChordMarker.TYPE_BAR;
        public static final String NOTE = ChordMarker.TYPE_NOTE;
        public static final String MUTE = ChordMarker.TYPE_MUTE;
        public static final String BAR_MUTE = ChordMarker.TYPE_BAR_MUTE;
    }

    private Chord chord;
    private boolean showFretNumbers;
    private boolean showFingerNumbers;
    private boolean editable;
    private int stringCount;
    private List<OnChordSelectedListener> listeners;

    private String mutedText;
    private String openStringText;

    private RectF drawingBounds;
    private RectF stringMarkerBounds;
    private RectF fretNumberBounds;

    private int fretSize; //y value
    private float stringDistance;//x value
    private int bridgeNutSize;
    private int bridgeNutColor;
    private int fretMarkerSize;
    private int fretMarkerColor;
    private float stringSize;
    private int stringColor;
    private int fretNumberSize;
    private int fretNumberColor;
    private int stringMarkerSize;
    private int stringMarkerColor;
    private int noteSize;
    private int noteColor;
    private int noteNumberSize;
    private int noteNumberColor;
    private int barLineColor;

    private Paint bridgeNutPaint;
    private Paint fretMarkerPaint;
    private Paint stringPaint;
    private Paint fretNumberPaint;
    private Paint stringMarkerPaint;
    private Paint notePaint;
    private Paint noteNumberPaint;
    private Paint barLinePaint;
    private Path barLinePath;

    public GuitarChordView(Context context){
        super(context);
        init(context, null);
    }

    public GuitarChordView(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context, attrs);
    }

    public GuitarChordView(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public GuitarChordView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        chord = new Chord();
        showFretNumbers = true;
        showFingerNumbers = true;
        editable = false;
        stringCount = 6;
        listeners = new ArrayList<>();
        mutedText = MUTED_TEXT;
        openStringText = OPEN_STRING_TEXT;
        initPaint();
        if(attrs != null){
            //TODO handle custom attribute values
            TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.GuitarChordView, 0, 0);
            try{
                bridgeNutColor = a.getColor(R.styleable.GuitarChordView_bridgeNutColor, DEFAULT_COLOR);
                bridgeNutPaint.setColor(bridgeNutColor);
                fretMarkerColor = a.getColor(R.styleable.GuitarChordView_fretMarkerColor, DEFAULT_COLOR);
                fretMarkerPaint.setColor(fretMarkerColor);
                stringColor = a.getColor(R.styleable.GuitarChordView_stringColor, DEFAULT_COLOR);
                stringPaint.setColor(stringColor);
                fretNumberColor = a.getColor(R.styleable.GuitarChordView_fretNumberColor, DEFAULT_COLOR);
                fretNumberPaint.setColor(fretNumberColor);
                stringMarkerColor = a.getColor(R.styleable.GuitarChordView_stringMarkerColor, DEFAULT_COLOR);
                stringMarkerPaint.setColor(stringMarkerColor);
                noteColor = a.getColor(R.styleable.GuitarChordView_noteColor, DEFAULT_COLOR);
                notePaint.setColor(noteColor);
                noteNumberColor = a.getColor(R.styleable.GuitarChordView_noteNumberColor, WHITE);
                noteNumberPaint.setColor(noteNumberColor);
                barLineColor = a.getColor(R.styleable.GuitarChordView_barLineColor, DEFAULT_COLOR);
                barLinePaint.setColor(barLineColor);
                mutedText = a.getString(R.styleable.GuitarChordView_mutedText);
                mutedText = (mutedText == null) ? MUTED_TEXT : mutedText;
                openStringText = a.getString(R.styleable.GuitarChordView_openStringText);
                openStringText = (openStringText == null) ? OPEN_STRING_TEXT : openStringText;
                stringCount = a.getInt(R.styleable.GuitarChordView_stringAmount, 6);
                editable = a.getBoolean(R.styleable.GuitarChordView_editable, false);
                showFingerNumbers = a.getBoolean(R.styleable.GuitarChordView_showFingerNumbers, true);
                showFretNumbers = a.getBoolean(R.styleable.GuitarChordView_showFretNumbers, true);
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                a.recycle();
            }
        }
    }

    private void initPaint(){
        bridgeNutPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bridgeNutColor = DEFAULT_COLOR;
        bridgeNutPaint.setColor(bridgeNutColor);
        bridgeNutPaint.setStyle(Paint.Style.STROKE);
        bridgeNutPaint.setStrokeCap(Paint.Cap.BUTT);
        fretMarkerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fretMarkerColor = DEFAULT_COLOR;
        fretMarkerPaint.setColor(fretMarkerColor);
        fretMarkerPaint.setStyle(Paint.Style.STROKE);
        fretMarkerPaint.setStrokeCap(Paint.Cap.ROUND);
        stringPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        stringColor = DEFAULT_COLOR;
        stringPaint.setColor(stringColor);
        stringPaint.setStyle(Paint.Style.STROKE);
        stringPaint.setStrokeCap(Paint.Cap.BUTT);
        fretNumberPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fretNumberColor = DEFAULT_COLOR;
        fretNumberPaint.setColor(fretNumberColor);
        fretNumberPaint.setTextAlign(Paint.Align.CENTER);
        stringMarkerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        stringMarkerColor = DEFAULT_COLOR;
        stringMarkerPaint.setColor(stringMarkerColor);
        stringMarkerPaint.setTextAlign(Paint.Align.CENTER);
        notePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        noteColor = DEFAULT_COLOR;
        notePaint.setColor(noteColor);
        noteNumberPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        noteNumberColor = WHITE;
        noteNumberPaint.setColor(noteNumberColor);
        noteNumberPaint.setTextAlign(Paint.Align.CENTER);
        barLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        barLineColor = DEFAULT_COLOR;
        barLinePaint.setColor(barLineColor);
        barLinePaint.setStyle(Paint.Style.STROKE);
    }

    private void setPaintSizes(){
        if(fretMarkerPaint == null){
            initPaint();
        }
        bridgeNutPaint.setStrokeWidth(bridgeNutSize);
        fretMarkerPaint.setStrokeWidth(fretMarkerSize);
        stringPaint.setStrokeWidth(stringSize);
        fretNumberPaint.setTextSize(fretNumberSize);
        stringMarkerPaint.setTextSize(stringMarkerSize);
        notePaint.setStrokeWidth(noteSize);
        noteNumberPaint.setTextSize(noteNumberSize);
        barLinePaint.setStrokeWidth(2 * stringSize);
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight){
        //TODO adjust lowest and highest notes to be within the draw bounds (notes on 1st and 6th string exceed draw bounds by half
        //the note size)
        float aWidth = (float) width - ((float) (getPaddingLeft() + getPaddingRight()));
        float aHeight = (float) width - ((float) (getPaddingTop() + getPaddingBottom()));
        float pWidth = aWidth;
        float pHeight = aHeight;
        float w = aHeight * (2f/3f);
        if(w <= aWidth){
            aWidth = w;
        }else{
            aHeight = 3 * (aWidth / 2);
        }
        //Center everything
        drawingBounds = new RectF((pWidth - aWidth) / 2, (pHeight - aHeight) / 2,
                (pWidth - aWidth) / 2 + aWidth, (pHeight - aHeight) / 2 + aHeight);
        if(showFretNumbers){
            fretNumberSize = (int) ((aWidth / (stringCount + 1)) * (3f / 4f));
            stringMarkerSize = fretNumberSize;
            stringDistance = (aWidth - (fretNumberSize + (fretNumberSize / 2))) / stringCount;
        }else {
            fretNumberSize = 0;
            stringMarkerSize = (int) ((aWidth / (stringCount + 1)) * (3f / 4f));
            stringDistance = aWidth / stringCount;
        }
        stringSize = stringDistance / stringCount;
        stringSize = (stringSize < 1) ? 1 : stringSize;
        fretMarkerSize = (int) stringSize;
        bridgeNutSize = (int) (3 * stringSize);
        noteSize = (int) stringDistance;
        noteNumberSize = (int) (noteSize * (3f / 4f));
        //TODO need to take into account whether or not to show bridgeNut
        int fretCount = (chord != null && chord.getFretCount() >= 4) ? chord.getFretCount() : 4;
        fretSize = Math.round(((aHeight - (fretNumberSize + fretNumberSize / 2)) -
                ((fretCount + 1) * fretMarkerSize)) / fretCount);
        if(showFretNumbers) {
            stringMarkerBounds = new RectF(drawingBounds.left + (fretNumberSize + (fretNumberSize / 2)), drawingBounds.top,
                    drawingBounds.right, drawingBounds.top + (stringMarkerSize + (stringMarkerSize / 2)));
            fretNumberBounds = new RectF(drawingBounds.left, stringMarkerBounds.bottom,
                    drawingBounds.left + (fretNumberSize + (fretNumberSize / 2)), drawingBounds.bottom);
        }else{
            stringMarkerBounds = new RectF(drawingBounds.left, drawingBounds.top,
                    drawingBounds.right, drawingBounds.top + (stringMarkerSize + (stringMarkerSize / 2)));
            fretNumberBounds = new RectF(0, 0, 0, 0);
        }
        setPaintSizes();
    }//End of onSizeChanged

    @Override
    protected void onDraw(Canvas canvas){
        //This method handles a lot of work, possibly too much for an onDraw method, but since I'm not animating
        //or updating the view often, it should be capable of performing the tasks without too much effort.
        //I can optimize this later.

        //First draw the strings and fret markers
        //Fret markers; not worrying about whether or not to show the bridge nut now (since that wasn't calculated
        //in to the drawing size)
        //TODO need to take into account whether or not to show bridgeNut
        int fretCount = chord.getFretCount();
        fretCount = (fretCount < 4) ? 4 : fretCount;
        for(int i = 0; i < fretCount + 1; i++){
            canvas.drawLine(drawingBounds.left + fretNumberBounds.width(),
                    (drawingBounds.top + stringMarkerBounds.height()) + (i * fretSize) + (i * fretMarkerSize),
                    drawingBounds.right - stringSize,
                    (drawingBounds.top + stringMarkerBounds.height()) + (i * fretSize) + (i * fretMarkerSize),
                    fretMarkerPaint);
        }
        //Strings
        for(int i = 0; i < stringCount; i++){
            canvas.drawLine((stringMarkerBounds.left) + (i * stringDistance) + (i * stringSize),
                    drawingBounds.top + stringMarkerBounds.height(),
                    (stringMarkerBounds.left) + (i * stringDistance) + (i * stringSize),
                    drawingBounds.bottom - fretMarkerSize,
                    stringPaint);
        }
        //Next draw the fret numbers and string markers
        //Fret numbers; check if we are showing them or not
        if(showFretNumbers){
            for(int i = 0; i < fretCount; i++){
                canvas.drawText(String.valueOf(i + 1),
                        drawingBounds.left + fretNumberBounds.width() / 2,
                        getVerticalCenterTextPosition(stringMarkerBounds.bottom + (i * fretMarkerSize) + (i * fretSize) + (fretSize / 2),
                                String.valueOf(i + 1), fretNumberPaint),
                        fretNumberPaint);
            }
        }
        //String markers
        for(int i : chord.getMutedStrings()){
            canvas.drawText(mutedText,
                    (drawingBounds.left + fretNumberBounds.width()) + ((stringCount - i) * stringDistance) +
                            ((stringCount - i) * stringSize),
                    getVerticalCenterTextPosition(drawingBounds.top + (stringMarkerBounds.height() / 2),
                            mutedText, stringMarkerPaint),
                    stringMarkerPaint);
        }
        for(int i : chord.getOpenStrings()){
            canvas.drawText(openStringText,
                    (drawingBounds.left + fretNumberBounds.width()) + ((stringCount - i) * stringDistance) +
                            ((stringCount - i) * stringSize),
                    getVerticalCenterTextPosition(drawingBounds.top + (stringMarkerBounds.height() / 2),
                            openStringText, stringMarkerPaint),
                    stringMarkerPaint);
        }
        //Finally, draw all the notes and the note text
        //Bars
        float startCenterX;
        float startCenterY;
        for(ChordMarker cm : chord.getBars()){
            startCenterX = (drawingBounds.left + fretNumberBounds.width()) + ((stringCount - cm.getStartString()) * stringDistance) +
                    ((stringCount - cm.getStartString()) * stringSize);
            startCenterY = stringMarkerBounds.bottom + (((cm.getFret() * fretSize) + (cm.getFret() * fretMarkerSize)) - (fretSize / 2));
            float endCenterX = (drawingBounds.left + fretNumberBounds.width()) + ((stringCount - cm.getEndString()) * stringDistance) +
                    ((stringCount - cm.getEndString()) * stringSize);
            float endCenterY = startCenterY;
            canvas.drawCircle(startCenterX, startCenterY, noteSize / 2, notePaint);
            canvas.drawCircle(endCenterX, endCenterY, noteSize / 2, notePaint);
            if(showFingerNumbers){
                canvas.drawText(String.valueOf(cm.getFinger()), startCenterX,
                        getVerticalCenterTextPosition(startCenterY, String.valueOf(cm.getFinger()), noteNumberPaint), noteNumberPaint);
                canvas.drawText(String.valueOf(cm.getFinger()), endCenterX,
                        getVerticalCenterTextPosition(endCenterY, String.valueOf(cm.getFinger()), noteNumberPaint), noteNumberPaint);
            }
            barLinePath = new Path();
            barLinePath.moveTo(startCenterX, startCenterY - (noteSize / 2));
            barLinePath.quadTo((startCenterX + endCenterX) / 2,
                    (startCenterY + endCenterY - (noteSize / 2)) / 4,
                    endCenterX, endCenterY - (noteSize / 2));
            canvas.drawPath(barLinePath, barLinePaint);
        }
        //Individual notes
        for(ChordMarker cm : chord.getIndividualNotes()){
            startCenterX = (drawingBounds.left + fretNumberBounds.width()) + ((stringCount - cm.getStartString()) * stringDistance) +
                    ((stringCount - cm.getStartString()) * stringSize);
            startCenterY = stringMarkerBounds.bottom + (((cm.getFret() * fretSize) + (cm.getFret() * fretMarkerSize)) - (fretSize / 2));
            canvas.drawCircle(startCenterX, startCenterY, noteSize / 2, notePaint);
            if(showFingerNumbers){
                canvas.drawText(String.valueOf(cm.getFinger()), startCenterX,
                        getVerticalCenterTextPosition(startCenterY, String.valueOf(cm.getFinger()), noteNumberPaint), noteNumberPaint);
            }
        }
    }//End of onDraw

    @Override
    public boolean onTouchEvent(MotionEvent event){
        ChordMarker marker = null;
        boolean isMarkerInChord = false;
        //TODO get marker corresponding to the touch event
        alertOnChordSelected(event, marker, isMarkerInChord);
        if(editable){
            return true;
        }
        return super.onTouchEvent(event);
    }

    protected float getVerticalCenterTextPosition(float originalYPosition, String text, Paint textPaint){
        Rect bounds = new Rect();
        textPaint.getTextBounds(text, 0, text.length(), bounds);
        return originalYPosition + (bounds.height() / 2);
    }

    protected float getVerticalCenterTextPosition(float originalYPosition, String text, int textSizeInPixels){
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setTextAlign(Paint.Align.CENTER);
        p.setTextSize(textSizeInPixels);
        return getVerticalCenterTextPosition(originalYPosition, text, p);
    }

    public Bitmap getBitmap(){
        setDrawingCacheEnabled(true);
        buildDrawingCache();
        Bitmap b = getDrawingCache();
        b = b.copy(Bitmap.Config.ARGB_8888, false);
        destroyDrawingCache();
        setDrawingCacheEnabled(false);
        return b;
    }

    public void addNote(int fret, int string, int finger){
        if (chord == null) {
            chord = new Chord();
        }
        chord.addMarker(new ChordMarker(string, fret, finger));
        invalidate();
    }

    public void addBar(int fret, int startString, int endString, int finger){
        if(chord == null){
            chord = new Chord();
        }
        chord.addMarker(new ChordMarker(startString, endString, fret, finger));
        invalidate();
    }

    public void addMutedString(int string){
        chord.addMarker(new ChordMarker(string, ChordMarker.FRET_MUTE, ChordMarker.NO_FINGER));
        invalidate();
    }

    public void addOpenString(int string){
        chord.addMarker(new ChordMarker(string, ChordMarker.FRET_OPEN, ChordMarker.NO_FINGER));
        invalidate();
    }

    public void addMarker(ChordMarker marker){
        if(marker != null){
            if(chord == null){
                chord = new Chord();
            }
            chord.addMarker(marker);
            invalidate();
        }
    }

    public boolean removeMarker(ChordMarker marker){
        if(marker != null){
            if(chord != null){
                boolean b = chord.removeMarker(marker);
                if(b){
                    invalidate();
                }
                return b;
            }
        }
        return false;
    }

    public void clear(){
        if(chord == null){
            chord = new Chord();
        }
        chord.clear();
        invalidate();
    }

    //Title is not visible in the View, it's just there for convenience reasons.
    //To make it visible, simple add a TextView to the layout and set it's text as the title.
    public String getTitle(){
        return chord.getTitle();
    }

    //Title is not visible in the View, it's just there for convenience reasons.
    //To make it visible, simple add a TextView to the layout and set it's text as the title.
    public void setTitle(String title){
        chord.setTitle(title);
    }

    public int getStringAmount(){
        return stringCount;
    }

    public void setStringAmount(int count){
        this.stringCount = count;
        requestLayout();
    }

    public Chord getChord(){
        return chord;
    }

    public void setChord(Chord chord){
        this.chord = chord;
        invalidate();
    }

    public boolean showFretNumbers(){
        return showFretNumbers;
    }

    public void showFretNumbers(boolean show){
        this.showFretNumbers = show;
        requestLayout();
    }

    public boolean showFingerNumbers(){
        return showFingerNumbers;
    }

    public void showFingerNumbers(boolean show){
        this.showFingerNumbers = show;
        invalidate();
    }

    public int getBridgeNutColor(){
        return bridgeNutColor;
    }

    public void setBridgeNutColor(@ColorInt int color){
        this.bridgeNutColor = color;
        this.bridgeNutPaint.setColor(color);
        invalidate();
    }

    public int getFretMarkerColor(){
        return fretMarkerColor;
    }

    public void setFretMarkerColor(@ColorInt int color){
        this.fretMarkerColor = color;
        this.fretMarkerPaint.setColor(color);
        invalidate();
    }

    public int getStringColor(){
        return stringColor;
    }

    public void setStringColor(@ColorInt int color){
        this.stringColor = color;
        this.stringPaint.setColor(color);
        invalidate();
    }

    public int getFretNumberColor(){
        return fretNumberColor;
    }

    public void setFretNumberColor(@ColorInt int color){
        this.fretNumberColor = color;
        this.fretNumberPaint.setColor(color);
        invalidate();
    }

    public int getStringMarkerColor(){
        return stringMarkerColor;
    }

    public void setStringMarkerColor(@ColorInt int color){
        this.stringMarkerColor = color;
        this.stringMarkerPaint.setColor(color);
        invalidate();
    }

    public int getNoteColor(){
        return noteColor;
    }

    public void setNoteColor(@ColorInt int color){
        this.noteColor = color;
        this.notePaint.setColor(color);
        invalidate();
    }

    public int getNoteNumberColor(){
        return noteNumberColor;
    }

    public void setNoteNumberColor(@ColorInt int color){
        this.noteNumberColor = color;
        this.noteNumberPaint.setColor(color);
        invalidate();
    }

    public int getBarLineColor(){
        return barLineColor;
    }

    public void setBarLineColor(@ColorInt int color){
        this.barLineColor = color;
        this.barLinePaint.setColor(color);
        invalidate();
    }

    public boolean isEditable(){
        return editable;
    }

    public void setEditable(boolean edit){
        this.editable = edit;
    }

    public String getMutedText(){
        return mutedText;
    }

    public void setMutedText(String text){
        this.mutedText = text;
        invalidate();
    }

    public String getOpenStringText(){
        return openStringText;
    }

    public void setOpenStringText(String text){
        this.openStringText = text;
        invalidate();
    }


    public interface OnChordSelectedListener{
        void onChordSelected(MotionEvent event, ChordMarker marker, boolean isMarkerInChord);
    }

    public void addOnChordSelectedListener(OnChordSelectedListener l){
        if(listeners == null){
            listeners = new ArrayList<>();
        }
        listeners.add(l);
    }

    public boolean removeOnChordSelectedListener(OnChordSelectedListener l){
        if(listeners != null){
            return listeners.remove(l);
        }
        return false;
    }

    private void alertOnChordSelected(MotionEvent event, ChordMarker marker, boolean isMarkerInChord){
        for(OnChordSelectedListener l : listeners){
            l.onChordSelected(event, marker, isMarkerInChord);
        }
    }


    public static class Chord{
        public static final int NO_FRET = -1;
        public static final int MAX_FRET = 24;
        public static final String BLANK_TITLE = "";

        private List<ChordMarker> bars;
        private List<ChordMarker> notes;
        private int fretStart;
        private int fretEnd;
        private String title;

        public Chord(){
            this.bars = new ArrayList<>();
            this.notes = new ArrayList<>();
            this.fretStart = NO_FRET;
            this.fretEnd = NO_FRET;
            this.title = BLANK_TITLE;
        }

        public Chord(String title){
            this();
            setTitle(title);
        }

        public void addMarker(ChordMarker marker){
            if(marker != null){
                if(marker.getType() != null && (marker.getType().equals(ChordMarker.TYPE_BAR) ||
                        marker.getType().equals(ChordMarker.TYPE_BAR_MUTE))){
                    if(marker.getFret() == ChordMarker.FRET_OPEN){
                        //No need to add a bar for the open strings
                        //So, simply add note markers for each of the open strings
                        for(int i = marker.getStartString(); i <= marker.getEndString(); i++){
                            addMarker(new ChordMarker(i, marker.getFret(), marker.getFinger()));
                        }
                    }else{
                        //Add this marking to the bar list
                        bars.add(marker);
                        int fret = marker.getFret();
                        fret = (fret < NO_FRET) ? NO_FRET : fret;
                        fret = (fret > MAX_FRET) ? MAX_FRET : fret;
                        if(fretStart == NO_FRET && fretEnd == NO_FRET){
                            fretStart = fret;
                            fretEnd = fret;
                        }else if(fret < fretStart){
                            fretStart = fret;
                        }else if(fret > fretEnd){
                            fretEnd = fret;
                        }
                    }
                }else{
                    //Remove any previous markers that may be on this string
                    List<ChordMarker> removeList = new ArrayList<>(); //Avoid ConcurrentModificationException
                    for(ChordMarker cm : notes){
                        if(cm.getStartString() == marker.getStartString()){
                            removeList.add(cm);
                        }
                    }
                    notes.removeAll(removeList); //Avoid ConcurrentModificationException
                    notes.add(marker);
                    int fret = marker.getFret();
                    fret = (fret < NO_FRET) ? NO_FRET : fret;
                    fret = (fret > MAX_FRET) ? MAX_FRET : fret;
                    if(fretStart == NO_FRET && fretEnd == NO_FRET){
                        fretStart = fret;
                        fretEnd = fret;
                    }else if(fret < fretStart){
                        fretStart = fret;
                    }else if(fret > fretEnd){
                        fretEnd = fret;
                    }
                }
            }
        }

        public boolean removeMarker(ChordMarker marker){
            boolean containsMarker = false;
            containsMarker = bars.remove(marker);
            if(notes.remove(marker)){
                containsMarker = true;
            }
            if(containsMarker && (marker.getFret() < fretStart || marker.getFret() > fretEnd)){
                for(int i = 0; i < notes.size(); i++){
                    if(i == 0){
                        fretStart = notes.get(i).getFret();
                        fretEnd = fretStart;
                    }else{
                        fretStart = (notes.get(i).getFret() < fretStart) ? notes.get(i).getFret() : fretStart;
                        fretEnd = (notes.get(i).getFret() > fretEnd) ? notes.get(i).getFret() : fretEnd;
                    }
                }
                for(ChordMarker cm : bars){
                    if(cm.getFret() < fretStart){
                        fretStart = cm.getFret();
                    }else if(cm.getFret() > fretEnd){
                        fretEnd = cm.getFret();
                    }
                }
            }
            return containsMarker;
        }

        public int getMarkerAmount(){
            return notes.size() + bars.size();
        }

        public void clear(){
            notes.clear();
            bars.clear();
            fretStart = NO_FRET;
            fretEnd = NO_FRET;
            title = BLANK_TITLE;
        }

        public int getFretStart(){
            return fretStart;
        }

        public int getFretEnd(){
            return fretEnd;
        }

        public int getFretCount(){
            return fretEnd - fretStart + 1;
        }

        public List<ChordMarker> getBars(){
            return bars;
        }

        public List<ChordMarker> getIndividualNotes(){
            return notes;
        }

        public List<Integer> getOpenStrings(){
            List<Integer> openStrings = new ArrayList<>();
            openStrings.add(1);
            openStrings.add(2);
            openStrings.add(3);
            openStrings.add(4);
            openStrings.add(5);
            openStrings.add(6);
            for(ChordMarker cm : notes){
                if(cm.getFret() != ChordMarker.FRET_OPEN){
                    openStrings.remove(Integer.valueOf(cm.getStartString()));
                }
            }
            for(ChordMarker cm : bars){
                for(int i = cm.getStartString(); i <= cm.getEndString(); i++){
                    if(cm.getFret() != ChordMarker.FRET_OPEN){
                        openStrings.remove(Integer.valueOf(i));
                    }
                }
            }
            return openStrings;
        }

        public List<Integer> getMutedStrings(){
            List<Integer> mutedStrings = new ArrayList<>();
            for(ChordMarker cm : notes){
                if(cm.getFret() == ChordMarker.FRET_MUTE){
                    mutedStrings.add(cm.getStartString());
                }
            }
            for(ChordMarker cm : bars){
                if(cm.getType().equals(ChordMarker.TYPE_BAR_MUTE) && cm.getFret() == ChordMarker.FRET_MUTE){
                    for(int i = cm.getStartString(); i <= cm.getEndString(); i++){
                        mutedStrings.add(i);
                    }
                }
            }
            return mutedStrings;
        }

        //Returns just single notes on the string, not notes that are part of a bar
        public List<ChordMarker> getNotesOnString(int string){
            List<ChordMarker> stringNotes = new ArrayList<>();
            for(ChordMarker cm : notes){
                if(cm.getStartString() == string){
                    stringNotes.add(cm);
                }
            }
            return stringNotes;
        }

        //Returns any notes on the specified string including barred notes
        public List<ChordMarker> getAllNotesOnString(int string){
            List<ChordMarker> stringNotes = new ArrayList<>();
            for(ChordMarker cm : notes){
                if(cm.getStartString() == string){
                    stringNotes.add(cm);
                }
            }
            for(ChordMarker cm : bars){
                for(int i = cm.getStartString(); i <= cm.getEndString(); i++){
                    if(i == string){
                        stringNotes.add(cm);
                    }
                }
            }
            return stringNotes;
        }

        //Returns any note on any string on the specified fret
        public List<ChordMarker> getNotesOnFret(int fret){
            List<ChordMarker> fretNotes = new ArrayList<>();
            for(ChordMarker cm : notes){
                if(cm.getFret() == fret){
                    fretNotes.add(cm);
                }
            }
            for(ChordMarker cm : bars){
                if(cm.getFret() == fret){
                    fretNotes.add(cm);
                }
            }
            return fretNotes;
        }

        public ChordMarker getMarkerAt(int string, int fret){
            ChordMarker marker = null;
            for(ChordMarker cm : notes){
                if(cm.getStartString() == string && cm.getFret() == fret){
                    marker = cm;
                    break;
                }
            }
            if(marker == null){
                for(ChordMarker cm : bars){
                    if(cm.getFret() == fret){
                        for(int i = cm.getStartString(); i <= cm.getEndString(); i++){
                            if(string == i){
                                marker = cm;
                                break;
                            }
                        }
                    }
                }
            }
            return marker;
        }

        public String getTitle(){
            return title;
        }

        public void setTitle(String title){
            this.title = title;
        }

    }//End of Chord class


    public static class ChordMarker{
        //Should be used for the type field
        public static final String TYPE_BAR = "Bar";
        public static final String TYPE_NOTE = "Note";
        public static final String TYPE_MUTE = "Mute";
        public static final String TYPE_BAR_MUTE = "Bar_Mute";
        //Should be used for the string field
        public static final int FIRST_STRING = 1; //Corresponds to the high E string on a standard tuned guitar
        public static final int SECOND_STRING = 2;
        public static final int THIRD_STRING = 3;
        public static final int FOURTH_STRING = 4;
        public static final int FIFTH_STRING = 5;
        public static final int SIXTH_STRING = 6; //Corresponds to the low E string on a standard tuned guitar
        //Should be used for the finger field
        public static final int NO_FINGER = 0;
        public static final int INDEX_FINGER = 1;
        public static final int MIDDLE_FINGER = 2;
        public static final int RING_FINGER = 3;
        public static final int PINKY = 4;
        public static final int THUMB = 5;
        //Should be used for the fret field
        public static final int OPEN = 0;
        public static final int OPEN_FRET = OPEN;
        public static final int OPEN_STRING = OPEN;
        public static final int FRET_OPEN = OPEN;
        public static final int FRET_MUTE = -1;
        public static final int MAX_FRET_COUNT = 24;

        private String type;
        private int startString; //Inclusive
        private int endString; //Inclusive
        private int fret;
        private int finger;

        public ChordMarker(int string, int fret, int finger){
            string = (string < FIRST_STRING) ? FIRST_STRING : string;
            string = (string > SIXTH_STRING) ? SIXTH_STRING : string;
            this.startString = string;
            this.endString = string;
            fret = (fret < FRET_MUTE) ? FRET_MUTE : fret;
            fret = (fret > MAX_FRET_COUNT) ? MAX_FRET_COUNT : fret;
            this.fret = fret;
            finger = (finger < NO_FINGER) ? NO_FINGER : finger;
            finger = (finger > THUMB) ? THUMB : finger;
            this.finger = finger;
            if(this.fret == FRET_MUTE){
                this.type = TYPE_MUTE;
            }else{
                this.type = TYPE_NOTE;
            }
        }

        public ChordMarker(int startString, int endString, int fret, int finger){
            startString = (startString < FIRST_STRING) ? FIRST_STRING : startString;
            startString = (startString > SIXTH_STRING) ? SIXTH_STRING : startString;
            this.startString = startString;
            endString = (endString < FIRST_STRING) ? FIRST_STRING : endString;
            endString = (endString > SIXTH_STRING) ? SIXTH_STRING : endString;
            endString = (endString < startString) ? startString : endString;
            this.endString = endString;
            fret = (fret < FRET_MUTE) ? FRET_MUTE : fret;
            fret = (fret > MAX_FRET_COUNT) ? MAX_FRET_COUNT : fret;
            this.fret = fret;
            finger = (finger < NO_FINGER) ? NO_FINGER : finger;
            finger = (finger > THUMB) ? THUMB : finger;
            this.finger = finger;
            if(this.startString == this.endString){
                if(this.fret == FRET_MUTE){
                    this.type = TYPE_MUTE;
                }else{
                    this.type = TYPE_NOTE;
                }
            }else{
                if(this.fret == FRET_MUTE){
                    this.type = TYPE_BAR_MUTE;
                }else{
                    this.type = TYPE_BAR;
                }
            }
        }

        public String getType(){
            return type;
        }

        public int getStartString(){
            return startString;
        }

        public int getEndString(){
            return endString;
        }

        public int getFret(){
            return fret;
        }

        public int getFinger(){
            return finger;
        }

    }//End of ChordMarker class


}//End of GuitarChordView class
