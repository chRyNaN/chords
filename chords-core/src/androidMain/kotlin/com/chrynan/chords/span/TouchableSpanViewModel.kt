package com.chrynan.chords.span

import android.graphics.Typeface
import com.chrynan.colors.Color
import com.chrynan.colors.ColorInt

@OptIn(ExperimentalUnsignedTypes::class)
data class TouchableSpanViewModel(
    val backgroundColor: ColorInt = DEFAULT_BACKGROUND_COLOR,
    val selectedBackgroundColor: ColorInt = DEFAULT_SELECTED_BACKGROUND_COLOR,
    val textColor: ColorInt = DEFAULT_TEXT_COLOR,
    val selectedTextColor: ColorInt = DEFAULT_SELECTED_TEXT_COLOR,
    val isUnderlined: Boolean = DEFAULT_IS_UNDERLINED,
    val isUnderlinedWhenSelected: Boolean = DEFAULT_SELECTED_IS_UNDERLINED,
    val textTypeface: Typeface = DEFAULT_TEXT_TYPEFACE,
    val selectedTextTypeface: Typeface = DEFAULT_SELECTED_TEXT_TYPEFACE
) {

    companion object {

        const val DEFAULT_IS_UNDERLINED = false
        const val DEFAULT_SELECTED_IS_UNDERLINED = false

        val DEFAULT_BACKGROUND_COLOR = Color.TRANSPARENT.colorInt
        val DEFAULT_SELECTED_BACKGROUND_COLOR = Color.TRANSPARENT.colorInt
        val DEFAULT_TEXT_COLOR = Color(-0xffff01).colorInt
        val DEFAULT_SELECTED_TEXT_COLOR = Color(-0xffff01).colorInt
        val DEFAULT_TEXT_TYPEFACE: Typeface = Typeface.DEFAULT
        val DEFAULT_SELECTED_TEXT_TYPEFACE: Typeface = Typeface.DEFAULT
    }
}
