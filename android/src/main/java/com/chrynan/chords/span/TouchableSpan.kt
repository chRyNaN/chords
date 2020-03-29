package com.chrynan.chords.span

import android.graphics.Typeface
import android.text.TextPaint
import android.text.style.CharacterStyle
import android.text.style.UpdateAppearance
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import com.chrynan.chords.span.TouchableSpanView.Companion.DEFAULT_BACKGROUND_COLOR
import com.chrynan.chords.span.TouchableSpanView.Companion.DEFAULT_IS_UNDERLINED
import com.chrynan.chords.span.TouchableSpanView.Companion.DEFAULT_SELECTED_BACKGROUND_COLOR
import com.chrynan.chords.span.TouchableSpanView.Companion.DEFAULT_SELECTED_IS_UNDERLINED
import com.chrynan.chords.span.TouchableSpanView.Companion.DEFAULT_SELECTED_TEXT_COLOR
import com.chrynan.chords.span.TouchableSpanView.Companion.DEFAULT_SELECTED_TEXT_TYPEFACE
import com.chrynan.chords.span.TouchableSpanView.Companion.DEFAULT_TEXT_COLOR
import com.chrynan.chords.span.TouchableSpanView.Companion.DEFAULT_TEXT_TYPEFACE

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
 * If an object of this type is attached to the text of a [TextView] with a movement method of
 * [LinkTouchMovementMethod], the affected spans of the text can be selected. If touched, the
 * [onTouch] method will be called.
 *
 * @author chRyNaN
 */
abstract class TouchableSpan : CharacterStyle(),
        UpdateAppearance,
        TouchableSpanView {

    /**
     * Indicates whether this [TouchableSpan] is selected or not. A value of true means that this
     * [TouchableSpan] is selected, a value of false means that it is not selected.
     *
     * @author chRyNaN
     */
    var isSelected = false
        internal set

    /**
     * The [DrawStateListener] that is called when the touchable text display state should be
     * updated. If this is null then the [TouchableSpanView] properties will be used. If this is
     * not null, then this will be called instead of using the [TouchableSpanView] properties.
     *
     * @author chRyNaN
     */
    var drawStateListener: DrawStateListener? = null

    override var backgroundColor = DEFAULT_BACKGROUND_COLOR
    override var selectedBackgroundColor = DEFAULT_SELECTED_BACKGROUND_COLOR
    override var textColor = DEFAULT_TEXT_COLOR
    override var selectedTextColor = DEFAULT_SELECTED_TEXT_COLOR
    override var isUnderlined = DEFAULT_IS_UNDERLINED
    override var isUnderlinedWhenSelected = DEFAULT_SELECTED_IS_UNDERLINED
    override var textTypeface: Typeface = DEFAULT_TEXT_TYPEFACE
    override var selectedTextTypeface: Typeface = DEFAULT_SELECTED_TEXT_TYPEFACE

    /**
     * Performs the touch action associated with this span.
     *
     * @return A [Boolean] value indicating whether the touch event was handled or not.
     *
     * @author chRyNaN
     */
    abstract fun onTouch(widget: View, m: MotionEvent): Boolean

    /**
     * Updates the draw state of the underlying text in this span.
     *
     * @author chRyNaN
     */
    override fun updateDrawState(textPaint: TextPaint) {
        drawStateListener?.updateDrawState(textPaint = textPaint, isSelected = isSelected)
                ?: textPaint.apply {
                    color = if (isSelected) selectedTextColor else textColor
                    bgColor = if (isSelected) selectedBackgroundColor else backgroundColor
                    isUnderlineText = if (isSelected) isUnderlinedWhenSelected else isUnderlined
                    typeface = if (isSelected) selectedTextTypeface else textTypeface
                }
    }

    /**
     * A listener that is called when a [TouchableSpan] should update it's draw state. This allows
     * complete control over the display of the touchable text marked by a [TouchableSpan].
     *
     * @author chRyNaN
     */
    interface DrawStateListener {

        /**
         * A function that is called when a [TouchableSpan] should update it's draw state.
         *
         * @param [textPaint] The [TextPaint] that is used for the touchable text.
         * @param [isSelected] Indicates whether the [TouchableSpan] is currently selected.
         *
         * @author chRyNaN
         */
        fun updateDrawState(textPaint: TextPaint, isSelected: Boolean)
    }
}