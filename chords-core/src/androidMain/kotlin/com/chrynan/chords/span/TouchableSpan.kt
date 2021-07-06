package com.chrynan.chords.span

import android.graphics.Typeface
import android.text.TextPaint
import android.text.style.CharacterStyle
import android.text.style.UpdateAppearance
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import com.chrynan.colors.ColorInt

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

    var viewModel: TouchableSpanViewModel = TouchableSpanViewModel()
        set(value) {
            field = value

            backgroundColor = value.backgroundColor
            selectedBackgroundColor = value.selectedBackgroundColor
            textColor = value.textColor
            selectedTextColor = value.selectedTextColor
            isUnderlined = value.isUnderlined
            isUnderlinedWhenSelected = value.isUnderlinedWhenSelected
            textTypeface = value.textTypeface
            selectedTextTypeface = value.selectedTextTypeface
        }

    override var backgroundColor: ColorInt = viewModel.backgroundColor
        internal set
    override var selectedBackgroundColor: ColorInt = viewModel.selectedBackgroundColor
        internal set
    override var textColor: ColorInt = viewModel.textColor
        internal set
    override var selectedTextColor: ColorInt = viewModel.selectedTextColor
        internal set
    override var isUnderlined: Boolean = viewModel.isUnderlined
        internal set
    override var isUnderlinedWhenSelected: Boolean = viewModel.isUnderlinedWhenSelected
        internal set
    override var textTypeface: Typeface = viewModel.textTypeface
        internal set
    override var selectedTextTypeface: Typeface = viewModel.selectedTextTypeface
        internal set

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
        textPaint.apply {
            color = if (isSelected) selectedTextColor.value else textColor.value
            bgColor = if (isSelected) selectedBackgroundColor.value else backgroundColor.value
            isUnderlineText = if (isSelected) isUnderlinedWhenSelected else isUnderlined
            typeface = if (isSelected) selectedTextTypeface else textTypeface
        }
    }
}
