package com.chrynan.guitarchords.span;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorInt;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.chrynan.guitarchords.view.GuitarChordView;

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
 * Created by chRyNaN on 2/13/2016. A Span for linking a GuitarChordView with text. When the spanned text
 * in the TextView is touched or clicked, a popup displaying the GuitarChordView is displayed. This can
 * be convenient for a TextView displaying lyrics with the chord name above the lyrics, in this case,
 * the chord name text can be a ChordSpan that will display the appropriate Chord in a GuitarChordView.
 */
public class ChordSpan extends TouchableSpan {
    private GuitarChordView.Chord chord;
    private GuitarChordView chordView;
    private Object tag;
    private int popupBackgroundColor = -1;
    private PopupWindow popup;
    private LinearLayout containerView;

    public ChordSpan(){

    }

    public ChordSpan(GuitarChordView.Chord chord){
        this.chord = chord;
    }

    @Override
    public boolean onTouch(View widget, MotionEvent m){
        if(chordView == null) {
            chordView = new GuitarChordView(widget.getContext());
            chordView.setLayoutParams(new LinearLayout.LayoutParams(450, 450));
            chordView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hidePopup();
                }
            });
            if(chord != null){
                chordView.setChord(chord);
            }
        }
        if(chord == null) {
            chord = chordView.getChord();
        }
        if(popup == null) {
            popup = new PopupWindow(widget.getContext());
            containerView = new LinearLayout(widget.getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            containerView.setLayoutParams(params);
            if(popupBackgroundColor == -1){
                popupBackgroundColor = Color.parseColor("#FFFFFF");
            }
            containerView.setBackgroundColor(popupBackgroundColor);
            containerView.addView(chordView);
            popup.setContentView(containerView);
            popup.setTouchable(true);
            popup.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            popup.setFocusable(true);
        }
        if(m.getAction() == MotionEvent.ACTION_UP && !popup.isShowing()) {
            WindowManager wm = (WindowManager) widget.getContext().getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point screenSize = new Point();
            display.getSize(screenSize);
            float x = getX(m.getRawX(), chordView.getWidth(), screenSize.x);
            float y = getY(m.getRawY(), chordView.getHeight(), screenSize.y);
            if(x == -1){
                popup.setWidth(getDP(widget.getContext(), (int) (screenSize.x - getPixels(widget.getContext(), 32))));
                x = getPixels(widget.getContext(), 16);
            }
            if(y == -1){
                popup.setHeight(getDP(widget.getContext(), (int) (screenSize.y - getPixels(widget.getContext(), 32))));
                y = getPixels(widget.getContext(), 16);
            }
            showPopup(widget, Gravity.NO_GRAVITY, (int) x, (int) y);
        }
        return true;
    }

    private float getY(float y, float height, float screenHeight){
        if(y - height > 0 && y < screenHeight){
            return y - height;
        }else if(y - (height / 2) > 0 && y + (height / 2) < screenHeight){
            return y - height / 2;
        }else if(y + height > 0 && y + height < screenHeight){
            return y + height;
        }
        return -1;
    }

    private float getX(float x, float width, float screenWidth){
        if(x + width > 0 && x + width < screenWidth){
            return x + width;
        }else if(x - (width / 2) > 0 && x + (width / 2) < screenWidth){
            return x - width / 2;
        }else if(x - width > 0 && x < screenWidth){
            return x - width;
        }
        return -1;
    }

    private float getPixels(Context context, int dp){
        Resources r = context.getResources();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
    }

    private int getDP(Context context, int pixels){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return pixels / (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public void hidePopup(){
        if(popup != null){
            popup.dismiss();
        }
        if(containerView != null){
            containerView.removeAllViews();
        }
        popup = null;
    }

    public void showPopup(View textView, int gravity, int x, int y){
        if(popup != null){
            popup.showAtLocation(textView, gravity, x, y);
        }
    }

    public Object getTag(){
        return tag;
    }

    public void setTag(Object tag){
        this.tag = tag;
    }

    public GuitarChordView.Chord getChord(){
        return chord;
    }

    public void setChord(GuitarChordView.Chord chord){
        this.chord = chord;
        if(chordView != null){
            chordView.clear();
            chordView.setChord(chord);
        }
    }

    public GuitarChordView getChordView(){
        return chordView;
    }

    public void setChordView(GuitarChordView chordView){
        this.chordView = chordView;
    }

    public int getPopupBackgroundColor() {
        return popupBackgroundColor;
    }

    public void setPopupBackgroundColor(@ColorInt int popupBackgroundColor) {
        this.popupBackgroundColor = popupBackgroundColor;
    }

}
