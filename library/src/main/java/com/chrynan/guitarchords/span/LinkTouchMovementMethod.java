package com.chrynan.guitarchords.span;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;

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
public class LinkTouchMovementMethod extends LinkMovementMethod {
    private static LinkTouchMovementMethod instance;
    private TouchableSpan pressedSpan;

    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        int action = event.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN:
                pressedSpan = getPressedSpan(widget, buffer, event);
                if(pressedSpan != null) {
                    pressedSpan.setPressed(true);
                    Selection.setSelection(buffer, buffer.getSpanStart(pressedSpan),
                            buffer.getSpanEnd(pressedSpan));
                    pressedSpan.onTouch(widget, event);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                TouchableSpan touchedSpan = getPressedSpan(widget, buffer, event);
                if(pressedSpan != null && touchedSpan != pressedSpan) {
                    pressedSpan.setPressed(false);
                    pressedSpan = null;
                    Selection.removeSelection(buffer);
                }else if(pressedSpan != null){
                    pressedSpan.onTouch(widget, event);
                }
                break;
            default:
                if(pressedSpan != null) {
                    pressedSpan.onTouch(widget, event);
                    pressedSpan.setPressed(false);
                    super.onTouchEvent(widget, buffer, event);
                }
                pressedSpan = null;
                Selection.removeSelection(buffer);
                break;
        }
        return true;
    }

    private TouchableSpan getPressedSpan(TextView textView, Spannable spannable, MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        x -= textView.getTotalPaddingLeft();
        y -= textView.getTotalPaddingTop();

        x += textView.getScrollX();
        y += textView.getScrollY();

        Layout layout = textView.getLayout();
        int line = layout.getLineForVertical(y);
        int off = layout.getOffsetForHorizontal(line, x);

        TouchableSpan[] link = spannable.getSpans(off, off, TouchableSpan.class);
        TouchableSpan touchedSpan = null;
        if (link.length > 0) {
            touchedSpan = link[0];
        }
        return touchedSpan;
    }

    public static MovementMethod getInstance(){
        if(instance == null){
            instance = new LinkTouchMovementMethod();
        }
        return instance;
    }

}
