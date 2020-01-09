package com.chrynan.guitarchords.span;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import android.view.MotionEvent;
import android.view.View;

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
 * Created by chRyNaN on 2/13/2016. References: http://stackoverflow.com/a/7292485/1478764,
 * http://stackoverflow.com/a/20905824/1478764
 */
/**
 * If an object of this type is attached to the text of a TextView
 * with a movement method of LinkTouchMovementMethod, the affected spans of
 * text can be selected.  If touched, the {@link #onTouch} method will
 * be called.
 */
public abstract class TouchableSpan extends CharacterStyle implements UpdateAppearance {
    private boolean isPressed = false;
    private int pressedBackgroundColor = Color.TRANSPARENT;
    private int textColor = Color.parseColor("#2196F3");
    private int pressedTextColor = Color.parseColor("#4ECDC4");

    /**
     * Performs the touch action associated with this span.
     * @return
     */
    public abstract boolean onTouch(View widget, MotionEvent m);

    /**
     * Could make the text underlined or change link color.
     */
    @Override
    public void updateDrawState(TextPaint ds){
        ds.setColor(isPressed ? pressedTextColor : textColor);
        ds.bgColor = isPressed ? pressedBackgroundColor : Color.TRANSPARENT;
        ds.setUnderlineText(false);
    }

    public boolean isPressed(){
        return isPressed;
    }

    public void setPressed(boolean isSelected) {
        isPressed = isSelected;
    }

    public int getPressedBackgroundColor() {
        return pressedBackgroundColor;
    }

    public void setPressedBackgroundColor(@ColorInt int pressedBackgroundColor) {
        this.pressedBackgroundColor = pressedBackgroundColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(@ColorInt int textColor) {
        this.textColor = textColor;
    }

    public int getPressedTextColor() {
        return pressedTextColor;
    }

    public void setPressedTextColor(@ColorInt int pressedTextColor) {
        this.pressedTextColor = pressedTextColor;
    }

}