package com.chrynan.chords.span

import android.graphics.Typeface
import com.chrynan.colors.ColorInt

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
    val backgroundColor: ColorInt

    /**
     * The background [ColorInt] of the touchable text when it is selected.
     *
     * @author chRyNaN
     */
    val selectedBackgroundColor: ColorInt

    /**
     * The text [ColorInt] of the touchable text when it is not selected.
     *
     * @author chRyNaN
     */
    val textColor: ColorInt

    /**
     * The text [ColorInt] of the touchable text when it is selected.
     *
     * @author chRyNaN
     */
    val selectedTextColor: ColorInt

    /**
     * Whether the touchable text is underlined when it is not selected.
     *
     * @author chRyNaN
     */
    val isUnderlined: Boolean

    /**
     * Whether the touchable text is underlined when it is selected.
     *
     * @author chRyNaN
     */
    val isUnderlinedWhenSelected: Boolean

    /**
     * The [Typeface] for the touchable text when it is not selected.
     *
     * @author chRyNaN
     */
    val textTypeface: Typeface

    /**
     * The [Typeface] for the touchable text when it is selected.
     *
     * @author chRyNaN
     */
    val selectedTextTypeface: Typeface
}
