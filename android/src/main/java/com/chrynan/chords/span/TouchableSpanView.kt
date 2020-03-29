package com.chrynan.chords.span

import android.graphics.Color
import android.graphics.Typeface
import com.chrynan.chords.model.ColorInt

/**
 * An interface defining the display properties of text that can be touchable.
 *
 * @author chRyNaN
 */
interface TouchableSpanView {

    /**
     * The background [ColorInt] of the touchable text when it is not selected.
     *
     * @author chRyNaN
     */
    var backgroundColor: ColorInt

    /**
     * The background [ColorInt] of the touchable text when it is selected.
     *
     * @author chRyNaN
     */
    var selectedBackgroundColor: ColorInt

    /**
     * The text [ColorInt] of the touchable text when it is not selected.
     *
     * @author chRyNaN
     */
    var textColor: ColorInt

    /**
     * The text [ColorInt] of the touchable text when it is selected.
     *
     * @author chRyNaN
     */
    var selectedTextColor: ColorInt

    /**
     * Whether the touchable text is underlined when it is not selected.
     *
     * @author chRyNaN
     */
    var isUnderlined: Boolean

    /**
     * Whether the touchable text is underlined when it is selected.
     *
     * @author chRyNaN
     */
    var isUnderlinedWhenSelected: Boolean

    /**
     * The [Typeface] for the touchable text when it is not selected.
     *
     * @author chRyNaN
     */
    var textTypeface: Typeface

    /**
     * The [Typeface] for the touchable text when it is selected.
     *
     * @author chRyNaN
     */
    var selectedTextTypeface: Typeface

    companion object {

        const val DEFAULT_IS_UNDERLINED = false
        const val DEFAULT_SELECTED_IS_UNDERLINED = false

        val DEFAULT_BACKGROUND_COLOR = Color.TRANSPARENT
        val DEFAULT_SELECTED_BACKGROUND_COLOR = Color.TRANSPARENT
        val DEFAULT_TEXT_COLOR = Color.BLUE
        val DEFAULT_SELECTED_TEXT_COLOR = Color.BLUE
        val DEFAULT_TEXT_TYPEFACE = Typeface.DEFAULT
        val DEFAULT_SELECTED_TEXT_TYPEFACE = Typeface.DEFAULT
    }
}