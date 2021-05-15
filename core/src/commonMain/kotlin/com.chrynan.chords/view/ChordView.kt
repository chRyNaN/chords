package com.chrynan.chords.view

import com.chrynan.chords.model.Chord
import com.chrynan.chords.model.ChordChart
import com.chrynan.chords.model.StringLabelState
import com.chrynan.colors.Color

/**
 * An interface representing a UI Widget that can display a [ChordChart] for a [Chord].
 *
 * @author chRyNaN
 */
interface ChordView {

    var chord: Chord?

    var chart: ChordChart

    var fitToHeight: Boolean

    var showFretNumbers: Boolean

    var showFingerNumbers: Boolean

    var stringLabelState: StringLabelState

    var mutedStringText: String

    var openStringText: String

    var fretColor: Color

    var fretLabelTextColor: Color

    var stringColor: Color

    var stringLabelTextColor: Color

    var noteColor: Color

    var noteLabelTextColor: Color

    companion object {

        const val DEFAULT_MUTED_TEXT = "X"
        const val DEFAULT_OPEN_TEXT = "O"
        const val DEFAULT_SHOW_FINGER_NUMBERS = true
        const val DEFAULT_SHOW_FRET_NUMBERS = true
        const val DEFAULT_FIT_TO_HEIGHT = false
        val DEFAULT_STRING_LABEL_STATE = StringLabelState.HIDE
    }
}
