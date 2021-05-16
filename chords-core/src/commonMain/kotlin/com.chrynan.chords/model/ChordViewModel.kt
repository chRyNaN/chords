package com.chrynan.chords.model

import com.chrynan.chords.view.ChordView
import com.chrynan.chords.view.ChordViewBinder
import com.chrynan.colors.Color
import com.chrynan.colors.ColorInt
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A model that represents the visual state of a UI Widget that displays a [ChordChart] for a
 * [Chord]. Note that this class does not contain any information about a [ChordChart] or a [Chord]
 * and only contains visual information relating to the UI Widget. This class can be used to
 * explicitly update a [ChordView], or a [ChordViewBinder] can be used to implicitly update the
 * [ChordView].
 *
 * @property [fitToHeight] Whether the [ChordView] should scale the visual Chord Chart relative to
 * it's height. A value of true indicates that it will be scaled to the height.
 * @property [showFretNumbers] Whether the [ChordView] should display the fret numbers to the side
 * of the chart.
 * @property [showFingerNumbers] Whether the [ChordView] should display the finger numbers on the
 * notes and bars of the chart.
 * @property [stringLabelState] A [StringLabelState] enum indicating whether the String number or
 * label should be displayed, or if there should be no String label shown. String labels appear on
 * the bottom of the chart.
 * @property [mutedStringText] A [String] value used to indicate that an instrument String should
 * be muted.
 * @property [openStringText] A [String] value used to indicate that an instrument String should be
 * open.
 * @property [fretColor] The [ColorInt] value that will be used for the fret lines.
 * @property [fretLabelTextColor] The [ColorInt] value that will be used for the fret labels.
 * @property [stringColor] The [ColorInt] value that will be used for the instrument String lines.
 * @property [stringLabelTextColor] The [ColorInt] value that will be used for the String labels.
 * @property [noteColor] The [ColorInt] value that will be used for the notes and bars.
 * @property [noteLabelTextColor] The [ColorInt] value that will be used for the note and bar
 * labels.
 *
 * @author chRyNaN
 */
@Serializable
@ExperimentalUnsignedTypes
data class ChordViewModel(
    @SerialName(value = "fit_to_height") val fitToHeight: Boolean = ChordView.DEFAULT_FIT_TO_HEIGHT,
    @SerialName(value = "show_fret_numbers") val showFretNumbers: Boolean = ChordView.DEFAULT_SHOW_FRET_NUMBERS,
    @SerialName(value = "show_finger_numbers") val showFingerNumbers: Boolean = ChordView.DEFAULT_SHOW_FINGER_NUMBERS,
    @SerialName(value = "string_label_state") val stringLabelState: StringLabelState = ChordView.DEFAULT_STRING_LABEL_STATE,
    @SerialName(value = "muted_string_text") val mutedStringText: String = ChordView.DEFAULT_MUTED_TEXT,
    @SerialName(value = "open_string_text") val openStringText: String = ChordView.DEFAULT_OPEN_TEXT,
    @SerialName(value = "fret_color") val fretColor: @Contextual Color = Color.BLACK,
    @SerialName(value = "fret_label_text_color") val fretLabelTextColor: @Contextual Color = Color.BLACK,
    @SerialName(value = "string_color") val stringColor: @Contextual Color = Color.BLACK,
    @SerialName(value = "string_label_text_color") val stringLabelTextColor: @Contextual Color = Color.BLACK,
    @SerialName(value = "note_color") val noteColor: @Contextual Color = Color.BLACK,
    @SerialName(value = "note_label_text_color") val noteLabelTextColor: @Contextual Color = Color.WHITE
) {

    companion object
}
