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
import android.text.Editable;
import android.text.InputType;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;

import com.chrynan.chords.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.ColorInt;

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

    private Chord chord;
    private boolean showFretNumbers;
    private boolean showFingerNumbers;
    private boolean editable;
    private int stringCount;
    private List<OnChordSelectedListener> listeners;
    private List<OnFretNumberSelectedListener> fretNumberListeners;
    private List<OnStringSelectedListener> stringListeners;

    private GestureDetector detector;
    private ChordMarker touchEventMarker;

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
        detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onDown(MotionEvent event){
                boolean isMarkerInChord = false;
                int fret = NO_FRET, string = -1;
                fret = getSelectedFret(event);
                string = getSelectedString(event);
                touchEventMarker = new ChordMarker(string, fret, NO_FINGER);
                return true;
            }
            @Override
            public void onLongPress(MotionEvent event){
                if(editable && touchEventMarker != null && chord != null && chord.contains(touchEventMarker)){
                    InputMethodManager imm =(InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(GuitarChordView.this,InputMethodManager.SHOW_IMPLICIT);
                }
            }
        });
        chord = new Chord();
        showFretNumbers = true;
        showFingerNumbers = true;
        editable = false;
        stringCount = 6;
        listeners = new ArrayList<>();
        fretNumberListeners = new ArrayList<>();
        stringListeners = new ArrayList<>();
        touchEventMarker = null;
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
        if(isInChartBounds(event)){
            boolean isMarkerInChord = false;
            int fret = NO_FRET, string = -1;
            fret = getSelectedFret(event);
            string = getSelectedString(event);
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                detector.onTouchEvent(event);
            }
            if (event.getAction() == MotionEvent.ACTION_UP && touchEventMarker != null) {
                if (fret == touchEventMarker.getFret()) {
                    int startString = 1, endString = 1;
                    startString = (touchEventMarker.getStartString() < string) ? touchEventMarker.getStartString() : string;
                    endString = (touchEventMarker.getEndString() >= string) ? touchEventMarker.getEndString() : string;
                    ChordMarker marker = new ChordMarker(startString, endString, fret, touchEventMarker.getFinger());
                    isMarkerInChord = chord.contains(marker);
                    alertOnChordSelected(event, marker, isMarkerInChord);
                    if (editable) {
                        return true;
                    }
                    return super.onTouchEvent(event);
                }
            }
            if (editable) {
                return true;
            }
        }else if(isInFretNumberBounds(event)){
            alertOnFretNumberSelected(event, getSelectedFret(event));
        }else if(isInStringMarkerBounds(event)){
            alertOnStringSelectedListener(event, getSelectedString(event));
        }
        return super.onTouchEvent(event);
    }

    //Needed for handling the text input if this View is editable
    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        if(editable){
            final InputConnectionAccomodatingLatinIMETypeNullIssues baseInputConnection =
                    new InputConnectionAccomodatingLatinIMETypeNullIssues(this, false);
            outAttrs.actionLabel = null;
            outAttrs.inputType = InputType.TYPE_NULL;
            outAttrs.imeOptions = EditorInfo.IME_ACTION_DONE;
            setOnKeyListener(new OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (editable){
                        if(event.getUnicodeChar() ==
                                (int) EditableAccomodatingLatinIMETypeNullIssues.ONE_UNPROCESSED_CHARACTER.charAt(0)){
                            //We are ignoring this character, and we want everyone else to ignore it, too, so
                            // we return true indicating that we have handled it (by ignoring it).
                            return true;
                        }
                        if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP){
                            //Trap the Done key and close the keyboard if it is pressed (if that's what you want to do)
                            InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(GuitarChordView.this.getWindowToken(), 0);
                            if(touchEventMarker != null) {
                                Integer finger;
                                try{
                                    finger = Integer.valueOf(baseInputConnection.getEditable().toString());
                                }catch(Exception e){
                                    e.printStackTrace();
                                    finger = touchEventMarker.getFinger();
                                }
                                touchEventMarker = new ChordMarker(touchEventMarker.getStartString(),
                                        touchEventMarker.getEndString(), touchEventMarker.getFret(), finger);
                                alertOnChordSelected(null, new ChordMarker(touchEventMarker), chord.contains(touchEventMarker));
                            }
                            return true;
                        }
                    }
                    return false;
                }
            });
            return baseInputConnection;
        }
        return null;
    }

    protected boolean isInChartBounds(MotionEvent event){
        float x = event.getX();
        float y = event.getY();
        if(x >= (drawingBounds.left + fretNumberBounds.width()) && x < drawingBounds.right){
            if(y >= (drawingBounds.top + stringMarkerBounds.height()) && y < drawingBounds.bottom){
                return true;
            }
        }
        return false;
    }

    protected boolean isInFretNumberBounds(MotionEvent event){
        if(showFretNumbers){
            float x = event.getX();
            float y = event.getY();
            if(x >= drawingBounds.left && x < (drawingBounds.left + fretNumberBounds.width())){
                if(y >= drawingBounds.top && y < drawingBounds.bottom){
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean isInStringMarkerBounds(MotionEvent event){
        float x = event.getX();
        float y = event.getY();
        if(x >= drawingBounds.left && x < drawingBounds.right){
            if(y >= drawingBounds.top && y < (drawingBounds.top + stringMarkerBounds.height())){
                return true;
            }
        }
        return false;
    }

    protected int getSelectedFret(MotionEvent event){
        int fretStart = chord.getFretStart();
        float y = event.getY();
        int i;
        for(i = 0; i < chord.getFretCount(); i++){
            if(y < (stringMarkerBounds.bottom + (i * fretSize) + (i * fretMarkerSize))){
                break;
            }
        }
        i = (fretStart < 0) ? i : (fretStart - 1) + i;
        return i;
    }

    protected int getSelectedString(MotionEvent event){
        float x = event.getX();
        int i;
        for(i = 0; i < stringCount; i++){
            if(x < (((stringMarkerBounds.left) + (i * stringDistance) + (i * stringSize)) + (stringDistance / 2))){
                break;
            }
        }
        return stringCount - i;
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

    public void addMarkers(List<ChordMarker> markers){
        for(ChordMarker marker : markers){
            chord.addMarker(marker);
        }
        invalidate();
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


    public interface OnFretNumberSelectedListener{
        void onFretNumberSelected(MotionEvent event, int fret);
    }

    public void addOnFretNumberSelectedListener(OnFretNumberSelectedListener l){
        if(fretNumberListeners == null){
            fretNumberListeners = new ArrayList<>();
        }
        fretNumberListeners.add(l);
    }

    public boolean removeOnFretNumberSelectedListener(OnFretNumberSelectedListener l){
        if(fretNumberListeners != null){
            return fretNumberListeners.remove(l);
        }
        return false;
    }

    private void alertOnFretNumberSelected(MotionEvent event, int fret){
        for(OnFretNumberSelectedListener l : fretNumberListeners){
            l.onFretNumberSelected(event, fret);
        }
    }


    public interface OnStringSelectedListener{
        void onStringSelected(MotionEvent event, int string);
    }

    public void addOnStringSelectedListener(OnStringSelectedListener l){
        if(stringListeners == null){
            stringListeners = new ArrayList<>();
        }
        stringListeners.add(l);
    }

    public boolean removeOnStringSelectedListener(OnStringSelectedListener l){
        if(stringListeners != null){
            return stringListeners.remove(l);
        }
        return false;
    }

    private void alertOnStringSelectedListener(MotionEvent event, int string){
        for(OnStringSelectedListener l : stringListeners){
            l.onStringSelected(event, string);
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
            this.fretStart = 1;
            this.fretEnd = 4;
            this.title = BLANK_TITLE;
        }

        public Chord(String title){
            this();
            setTitle(title);
        }

        public Chord(Chord chord){
            this.bars = chord.getBars();
            this.notes = chord.getIndividualNotes();
            this.fretStart = chord.getFretStart();
            this.fretEnd = chord.getFretEnd();
            this.title = chord.getTitle();
        }

        public Chord(JSONObject obj){
            this();
            fromJSON(obj);
        }

        public void fromJSON(JSONObject obj){
            try{
                if(obj != null){
                    if(obj.has("fretStart")){
                        this.fretStart = obj.getInt("fretStart");
                    }
                    if(obj.has("fretEnd")){
                        this.fretEnd = obj.getInt("fretEnd");
                    }
                    if(obj.has("title")){
                        this.title = obj.getString("title");
                    }
                    if(obj.has("bars")){
                        JSONArray bArray = obj.getJSONArray("bars");
                        for(int i = 0; i < bArray.length(); i++){
                            bars.add(new ChordMarker(bArray.getJSONObject(i)));
                        }
                    }
                    if(obj.has("notes")){
                        JSONArray nArray = obj.getJSONArray("notes");
                        for(int i = 0; i < nArray.length(); i++){
                            notes.add(new ChordMarker(nArray.getJSONObject(i)));
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        public JSONObject toJSON(){
            try{
                JSONObject obj = new JSONObject();
                obj.put("fretStart", fretStart);
                obj.put("fretEnd", fretEnd);
                if(title != null){
                    obj.put("title", title);
                }
                if(bars != null){
                    JSONArray bArray = new JSONArray();
                    for(ChordMarker marker : bars){
                        bArray.put(marker.toJSON());
                    }
                    obj.put("bars", bArray);
                }
                if(notes != null){
                    JSONArray nArray = new JSONArray();
                    for(ChordMarker marker : notes){
                        nArray.put(marker.toJSON());
                    }
                    obj.put("notes", nArray);
                }
                return obj;
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }

        public String toJSONString(){
            JSONObject obj = this.toJSON();
            if(obj != null){
                return obj.toString();
            }
            return this.toString();
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
                        fret = (fret < 1) ? 1 : fret;
                        fret = (fret > MAX_FRET) ? MAX_FRET : fret;
                        if(fretStart == NO_FRET && fretEnd == NO_FRET){
                            fretStart = fret;
                            fretEnd = fret;
                        }else if(fret < fretStart && fret > 0){
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
                    fret = (fret < 1) ? 1 : fret;
                    fret = (fret > MAX_FRET) ? MAX_FRET : fret;
                    if(fretStart == NO_FRET && fretEnd == NO_FRET){
                        fretStart = fret;
                        fretEnd = fret;
                    }else if(fret < fretStart && fret > 0){
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

        public boolean contains(ChordMarker marker){
            for(ChordMarker cm : bars){
                if(cm.equals(marker)){
                    return true;
                }
            }
            for(ChordMarker cm : notes){
                if(cm.equals(marker)){
                    return true;
                }
            }
            return false;
        }

        public int getMarkerAmount(){
            return notes.size() + bars.size();
        }

        public void clear(){
            notes.clear();
            bars.clear();
            fretStart = 1;
            fretEnd = 4;
            title = BLANK_TITLE;
        }

        public int getStringCount(){
            int maxString = 1;
            for(ChordMarker marker : getAllMarkers()){
                if(marker.getEndString() > maxString){
                    maxString = marker.getEndString();
                }
            }
            for(Integer i : getOpenStrings()){
                if(i > maxString){
                    maxString = i;
                }
            }
            for(Integer i : getMutedStrings()){
                if(i > maxString){
                    maxString = i;
                }
            }
            return maxString;
        }

        public int getFretStart(){
            return fretStart;
        }

        public int getFretEnd(){
            return fretEnd;
        }

        public int getFretCount(){
            if((fretEnd - fretStart + 1) < 4){
                return 4;
            }
            return fretEnd - fretStart + 1;
        }

        public List<ChordMarker> getBars(){
            return bars;
        }

        public List<ChordMarker> getIndividualNotes(){
            return notes;
        }

        public List<ChordMarker> getAllMarkers(){
            List<ChordMarker> allMarkers = new ArrayList<>();
            allMarkers.addAll(notes);
            allMarkers.addAll(bars);
            return allMarkers;
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

        public int getFret(int string){
            //returns the highest fret marked on the given string or 0, as in open, if none is marked
            int fret = 0;
            List<ChordMarker> markers = getAllNotesOnString(string);
            if(markers != null){
                for(ChordMarker marker : markers){
                    if(marker.getFret() > fret){
                        fret = marker.getFret();
                    }
                }
            }
            return fret;
        }

        public List<Integer> getStrings(int fret){
            //returns all the strings that are marked with this fret
            List<Integer> strings = new ArrayList<>();
            if(fret == FRET_OPEN){
                return getOpenStrings();
            }else if(fret == FRET_MUTE){
                return getMutedStrings();
            }else{
                List<ChordMarker> markers;
                for(int i = 0; i < getStringCount(); i++){
                    markers = getAllNotesOnString(i + 1);
                    for(ChordMarker marker : markers){
                        if(marker.getFret() == fret){
                            strings.add(new Integer(marker.getFret()));
                        }
                    }
                }
            }
            return strings;
        }

        public String getTitle(){
            return title;
        }

        public void setTitle(String title){
            this.title = title;
        }

        @Override
        public String toString() {
            return "Chord{" +
                    "bars=" + bars +
                    ", notes=" + notes +
                    ", fretStart=" + fretStart +
                    ", fretEnd=" + fretEnd +
                    ", title='" + title + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Chord chord = (Chord) o;

            if (fretStart != chord.fretStart) return false;
            if (fretEnd != chord.fretEnd) return false;
            if (bars != null ? !bars.equals(chord.bars) : chord.bars != null) return false;
            if (notes != null ? !notes.equals(chord.notes) : chord.notes != null) return false;
            return !(title != null ? !title.equals(chord.title) : chord.title != null);
        }

        @Override
        public int hashCode() {
            int result = bars != null ? bars.hashCode() : 0;
            result = 31 * result + (notes != null ? notes.hashCode() : 0);
            result = 31 * result + fretStart;
            result = 31 * result + fretEnd;
            result = 31 * result + (title != null ? title.hashCode() : 0);
            return result;
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

        public ChordMarker(ChordMarker marker){
            this.type = marker.getType();
            this.startString = marker.getStartString();
            this.endString = marker.getEndString();
            this.fret = marker.getFret();
            this.finger = marker.getFinger();
        }

        public ChordMarker(JSONObject obj){
            this.type = null;
            this.startString = -1;
            this.endString = -1;
            this.fret = -1;
            this.finger = -1;
            fromJSON(obj);
        }

        public void fromJSON(JSONObject obj){
            try{
                if(obj != null){
                    if(obj.has("type")){
                        this.type = obj.getString("type");
                    }
                    if(obj.has("startString")){
                        this.startString = obj.getInt("startString");
                    }
                    if(obj.has("endString")){
                        this.endString = obj.getInt("endString");
                    }
                    if(obj.has("fret")){
                        this.fret = obj.getInt("fret");
                    }
                    if(obj.has("finger")){
                        this.finger = obj.getInt("finger");
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        public JSONObject toJSON(){
            try{
                JSONObject obj = new JSONObject();
                if(type != null){
                    obj.put("type", type);
                }
                obj.put("startString", startString);
                obj.put("endString", endString);
                obj.put("fret", fret);
                obj.put("finger", finger);
                return obj;
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }

        public String toJSONString(){
            JSONObject obj = this.toJSON();
            if(obj != null){
                return obj.toString();
            }
            return this.toString();
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

        @Override
        public String toString() {
            return "ChordMarker{" +
                    "type='" + type + '\'' +
                    ", startString=" + startString +
                    ", endString=" + endString +
                    ", fret=" + fret +
                    ", finger=" + finger +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ChordMarker that = (ChordMarker) o;

            if (startString != that.startString) return false;
            if (endString != that.endString) return false;
            if (fret != that.fret) return false;
            if (finger != that.finger) return false;
            return !(type != null ? !type.equals(that.type) : that.type != null);
        }

        @Override
        public int hashCode() {
            int result = type != null ? type.hashCode() : 0;
            result = 31 * result + startString;
            result = 31 * result + endString;
            result = 31 * result + fret;
            result = 31 * result + finger;
            return result;
        }

    }//End of ChordMarker class


    /**
     * Reference: http://stackoverflow.com/a/19980975/1478764
     * @author Carl Gunther
     * There are bugs with the LatinIME keyboard's generation of KEYCODE_DEL events
     * that this class addresses in various ways.  These bugs appear when the app
     * specifies TYPE_NULL, which is the only circumstance under which the app
     * can reasonably expect to receive key events for KEYCODE_DEL.
     *
     * This class is intended for use by a view that overrides
     * onCreateInputConnection() and specifies to the invoking IME that it wishes
     * to use the TYPE_NULL InputType.  This should cause key events to be returned
     * to the view.
     *
     */
    public static class InputConnectionAccomodatingLatinIMETypeNullIssues extends BaseInputConnection {

        //This holds the Editable text buffer that the LatinIME mistakenly *thinks*
        // that it is editing, even though the views that employ this class are
        // completely driven by key events.
        Editable myEditable = null;

        //Basic constructor
        public InputConnectionAccomodatingLatinIMETypeNullIssues(View targetView, boolean fullEditor) {
            super(targetView, fullEditor);
        }

        //This method is called by the IME whenever the view that returned an
        // instance of this class to the IME from its onCreateInputConnection()
        // gains focus.
        @Override
        public Editable getEditable() {
            //Some versions of the Google Keyboard (LatinIME) were delivered with a
            // bug that causes KEYCODE_DEL to no longer be generated once the number
            // of KEYCODE_DEL taps equals the number of other characters that have
            // been typed.  This bug was reported here as issue 62306.
            //
            // As of this writing (1/7/2014), it is fixed in the AOSP code, but that
            // fix has not yet been released.  Even when it is released, there will
            // be many devices having versions of the Google Keyboard that include the bug
            // in the wild for the indefinite future.  Therefore, a workaround is required.
            //
            //This is a workaround for that bug which just jams a single garbage character
            // into the internal buffer that the keyboard THINKS it is editing even
            // though we have specified TYPE_NULL which *should* cause LatinIME to
            // generate key events regardless of what is in that buffer.  We have other
            // code that attempts to ensure as the user edites that there is always
            // one character remaining.
            //
            // The problem arises because when this unseen buffer becomes empty, the IME
            // thinks that there is nothing left to delete, and therefore stops
            // generating KEYCODE_DEL events, even though the app may still be very
            // interested in receiving them.
            //
            //So, for example, if the user taps in ABCDE and then positions the
            // (app-based) cursor to the left of A and taps the backspace key three
            // times without any evident effect on the letters (because the app's own
            // UI code knows that there are no letters to the left of the
            // app-implemented cursor), and then moves the cursor to the right of the
            // E and hits backspace five times, then, after E and D have been deleted,
            // no more KEYCODE_DEL events will be generated by the IME because the
            // unseen buffer will have become empty from five letter key taps followed
            // by five backspace key taps (as the IME is unaware of the app-based cursor
            // movements performed by the user).
            //
            // In other words, if your app is processing KEYDOWN events itself, and
            // maintaining its own cursor and so on, and not telling the IME anything
            // about the user's cursor position, this buggy processing of the hidden
            // buffer will stop KEYCODE_DEL events when your app actually needs them -
            // in whatever Android releases incorporate this LatinIME bug.
            //
            // By creating this garbage characters in the Editable that is initially
            // returned to the IME here, we make the IME think that it still has
            // something to delete, which causes it to keep generating KEYCODE_DEL
            // events in response to backspace key presses.
            //
            // A specific keyboard version that I tested this on which HAS this
            // problem but does NOT have the "KEYCODE_DEL completely gone" (issue 42904)
            // problem that is addressed by the deleteSurroundingText() override below
            // (the two problems are not both present in a single version) is
            // 2.0.19123.914326a, tested running on a Nexus7 2012 tablet.
            // There may be other versions that have issue 62306.
            //
            // A specific keyboard version that I tested this on which does NOT have
            // this problem but DOES have the "KEYCODE_DEL completely gone" (issue
            // 42904) problem that is addressed by the deleteSurroundingText()
            // override below is 1.0.1800.776638, tested running on the Nexus10
            // tablet.  There may be other versions that also have issue 42904.
            //
            // The bug that this addresses was first introduced as of AOSP commit tag
            // 4.4_r0.9, and the next RELEASED Android version after that was
            // android-4.4_r1, which is the first release of Android 4.4.  So, 4.4 will
            // be the first Android version that would have included, in the original
            // RELEASED version, a Google Keyboard for which this bug was present.
            //
            // Note that this bug was introduced exactly at the point that the OTHER bug
            // (the one that is addressed in deleteSurroundingText(), below) was first
            // FIXED.
            //
            // Despite the fact that the above are the RELEASES associated with the bug,
            // the fact is that any 4.x Android release could have been upgraded by the
            // user to a later version of Google Keyboard than was present when the
            // release was originally installed to the device.  I have checked the
            // www.archive.org snapshots of the Google Keyboard listing page on the Google
            // Play store, and all released updates listed there (which go back to early
            // June of 2013) required Android 4.0 and up, so we can be pretty sure that
            // this bug is not present in any version earlier than 4.0 (ICS), which means
            // that we can limit this fix to API level 14 and up.  And once the LatinIME
            // problem is fixed, we can limit the scope of this workaround to end as of
            // the last release that included the problem, since we can assume that
            // users will not upgrade Google Keyboard to an EARLIER version than was
            // originally included in their Android release.
            //
            // The bug that this addresses was FIXED but NOT RELEASED as of this AOSP
            // commit:
            //https://android.googlesource.com/platform/packages/inputmethods/LatinIME/+
            // /b41bea65502ce7339665859d3c2c81b4a29194e4/java/src/com/android
            // /inputmethod/latin/LatinIME.java
            // so it can be assumed to affect all of KitKat released thus far
            // (up to 4.4.2), and could even affect beyond KitKat, although I fully
            // expect it to be incorporated into the next release *after* API level 19.
            //
            // When it IS released, this method should be changed to limit it to no
            // higher than API level 19 (assuming that the fix is released before API
            // level 20), just in order to limit the scope of this fix, since poking
            // 1024 characters into the Editable object returned here is of course a
            // kluge.  But right now the safest thing is just to not have an upper limit
            // on the application of this kluge, since the fix for the problem it
            // addresses has not yet been released (as of 1/7/2014).
            if (Build.VERSION.SDK_INT >= 14) {
                if (myEditable == null) {
                    myEditable = new EditableAccomodatingLatinIMETypeNullIssues(
                            EditableAccomodatingLatinIMETypeNullIssues.ONE_UNPROCESSED_CHARACTER);
                    Selection.setSelection(myEditable, 1);
                } else {
                    int myEditableLength = myEditable.length();
                    if (myEditableLength == 0) {
                        //I actually HAVE seen this be zero on the Nexus 10 with the keyboard
                        // that came with Android 4.4.2
                        // On the Nexus 10 4.4.2 if I tapped away from the view and then back to it, the
                        // myEditable would come back as null and I would create a new one.  This is also
                        // what happens on other devices (e.g., the Nexus 6 with 4.4.2,
                        // which has a slightly later version of the Google Keyboard).  But for the
                        // Nexus 10 4.4.2, the keyboard had a strange behavior
                        // when I tapped on the rack, and then tapped Done on the keyboard to close it,
                        // and then tapped on the rack AGAIN.  In THAT situation,
                        // the myEditable would NOT be set to NULL but its LENGTH would be ZERO.  So, I
                        // just append to it in that situation.
                        myEditable.append(
                                EditableAccomodatingLatinIMETypeNullIssues.ONE_UNPROCESSED_CHARACTER);
                        Selection.setSelection(myEditable, 1);
                    }
                }
                return myEditable;
            } else {
                //Default behavior for keyboards that do not require any fix
                return super.getEditable();
            }
        }

        //This method is called INSTEAD of generating a KEYCODE_DEL event, by
        // versions of Latin IME that have the bug described in Issue 42904.
        @Override
        public boolean deleteSurroundingText(int beforeLength, int afterLength) {
            //If targetSdkVersion is set to anything AT or ABOVE API level 16
            // then for the GOOGLE KEYBOARD versions DELIVERED
            // with Android 4.1.x, 4.2.x or 4.3.x, NO KEYCODE_DEL EVENTS WILL BE
            // GENERATED BY THE GOOGLE KEYBOARD (LatinIME) EVEN when TYPE_NULL
            // is being returned as the InputType by your view from its
            // onCreateInputMethod() override, due to a BUG in THOSE VERSIONS.
            //
            // When TYPE_NULL is specified (as this entire class assumes is being done
            // by the views that use it, what WILL be generated INSTEAD of a KEYCODE_DEL
            // is a deleteSurroundingText(1,0) call.  So, by overriding this
            // deleteSurroundingText() method, we can fire the KEYDOWN/KEYUP events
            // ourselves for KEYCODE_DEL.  This provides a workaround for the bug.
            //
            // The specific AOSP RELEASES involved are 4.1.1_r1 (the very first 4.1
            // release) through 4.4_r0.8 (the release just prior to Android 4.4).
            // This means that all of KitKat should not have the bug and will not
            // need this workaround.
            //
            // Although 4.0.x (ICS) did not have this bug, it was possible to install
            // later versions of the keyboard as an app on anything running 4.0 and up,
            // so those versions are also potentially affected.
            //
            // The first version of separately-installable Google Keyboard shown on the
            // Google Play store site by www.archive.org is Version 1.0.1869.683049,
            // on June 6, 2013, and that version (and probably other, later ones)
            // already had this bug.
            //
            //Since this required at least 4.0 to install, I believe that the bug will
            // not be present on devices running versions of Android earlier than 4.0.
            //
            //AND, it should not be present on versions of Android at 4.4 and higher,
            // since users will not "upgrade" to a version of Google Keyboard that
            // is LOWER than the one they got installed with their version of Android
            // in the first place, and the bug will have been fixed as of the 4.4 release.
            //
            // The above scope of the bug is reflected in the test below, which limits
            // the application of the workaround to Android versions between 4.0.x and 4.3.x.
            //
            //UPDATE:  A popular third party keyboard was found that exhibits this same issue.  It
            // was not fixed at the same time as the Google Play keyboard, and so the bug in that case
            // is still in place beyond API LEVEL 19.  So, even though the Google Keyboard fixed this
            // as of level 19, we cannot take out the fix based on that version number.  And so I've
            // removed the test for an upper limit on the version; the fix will remain in place ad
            // infinitum - but only when TYPE_NULL is used, so it *should* be harmless even when
            // the keyboard does not have the problem...
            if ((Build.VERSION.SDK_INT >= 14) // && (Build.VERSION.SDK_INT < 19)
                    && (beforeLength == 1 && afterLength == 0)) {
                //Send Backspace key down and up events to replace the ones omitted
                // by the LatinIME keyboard.
                return super.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL))
                        && super.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DEL));
            } else {
                //Really, I can't see how this would be invoked, given that we're using
                // TYPE_NULL, for non-buggy versions, but in order to limit the impact
                // of this change as much as possible (i.e., to versions at and above 4.0)
                // I am using the original behavior here for non-affected versions.
                return super.deleteSurroundingText(beforeLength, afterLength);
            }
        }
    }


    //Reference: http://stackoverflow.com/a/19980975/1478764
    public static class EditableAccomodatingLatinIMETypeNullIssues extends SpannableStringBuilder {
        EditableAccomodatingLatinIMETypeNullIssues(CharSequence source) {
            super(source);
        }

        //This character must be ignored by your onKey() code.
        public static CharSequence ONE_UNPROCESSED_CHARACTER = "/";

        @Override
        public SpannableStringBuilder replace(final int
                                                      spannableStringStart, final int spannableStringEnd, CharSequence replacementSequence,
                                              int replacementStart, int replacementEnd) {
            if (replacementEnd > replacementStart) {
                //In this case, there is something in the replacementSequence that the IME
                // is attempting to replace part of the editable with.
                //We don't really care about whatever might already be in the editable;
                // we only care about making sure that SOMETHING ends up in it,
                // so that the backspace key will continue to work.
                // So, start by zeroing out whatever is there to begin with.
                super.replace(0, length(), "", 0, 0);

                //We DO care about preserving the new stuff that is replacing the stuff in the
                // editable, because this stuff might be sent to us as a keydown event.  So, we
                // insert the new stuff (typically, a single character) into the now-empty editable,
                // and return the result to the caller.
                return super.replace(0, 0, replacementSequence, replacementStart, replacementEnd);
            }
            else if (spannableStringEnd > spannableStringStart) {
                //In this case, there is NOTHING in the replacementSequence, and something is
                // being replaced in the editable.
                // This is characteristic of a DELETION.
                // So, start by zeroing out whatever is being replaced in the editable.
                super.replace(0, length(), "", 0, 0);

                //And now, we will place our ONE_UNPROCESSED_CHARACTER into the editable buffer, and return it.
                return super.replace(0, 0, ONE_UNPROCESSED_CHARACTER, 0, 1);
            }

            // In this case, NOTHING is being replaced in the editable.  This code assumes that there
            // is already something there.  This assumption is probably OK because in our
            // InputConnectionAccomodatingLatinIMETypeNullIssues.getEditable() method
            // we PLACE a ONE_UNPROCESSED_CHARACTER into the newly-created buffer.  So if there
            // is nothing replacing the identified part
            // of the editable, and no part of the editable that is being replaced, then we just
            // leave whatever is in the editable ALONE,
            // and we can be confident that there will be SOMETHING there.  This call to super.replace()
            // in that case will be a no-op, except
            // for the value it returns.
            return super.replace(spannableStringStart, spannableStringEnd,
                    replacementSequence, replacementStart, replacementEnd);
        }
    }


}//End of GuitarChordView class
