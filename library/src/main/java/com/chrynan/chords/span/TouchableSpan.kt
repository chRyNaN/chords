package com.chrynan.chords.span

import android.graphics.Color
import android.text.TextPaint
import android.text.style.CharacterStyle
import android.text.style.UpdateAppearance
import android.view.MotionEvent
import android.view.View

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
 * References: http://stackoverflow.com/a/7292485/1478764,
 * http://stackoverflow.com/a/20905824/1478764
 *
 * If an object of this type is attached to the text of a TextView
 * with a movement method of LinkTouchMovementMethod, the affected spans of
 * text can be selected.  If touched, the [onTouch] method will
 * be called.
 */
abstract class TouchableSpan : CharacterStyle(), UpdateAppearance {

    var isPressed = false
        internal set

    var backgroundColor = Color.TRANSPARENT
    var pressedBackgroundColor = Color.TRANSPARENT
    var textColor = Color.BLUE
    var pressedTextColor = Color.BLUE
    var isUnderlined = false
    var isUnderlinedWhenPressed = false

    /**
     * Performs the touch action associated with this span.
     *
     * @return
     */
    abstract fun onTouch(widget: View, m: MotionEvent): Boolean

    /**
     * Could make the text underlined or change link color.
     */
    override fun updateDrawState(textPaint: TextPaint) {
        textPaint.apply {
            color = if (isPressed) pressedTextColor else textColor
            bgColor = if (isPressed) pressedBackgroundColor else backgroundColor
            isUnderlineText = if (isPressed) isUnderlinedWhenPressed else isUnderlined
        }
    }
}