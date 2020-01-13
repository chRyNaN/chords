package com.chrynan.guitarchords.view

import android.graphics.Color
import com.chrynan.guitarchords.model.Chord
import com.chrynan.guitarchords.model.ColorInt

interface ChordView {

    var chord: Chord?

    var showFretNumbers: Boolean

    var showFingerNumbers: Boolean

    var stringLabelState: StringLabelState

    var stringCount: Int

    var fretStart: Int

    var fretEnd: Int

    var mutedText: String

    var openStringText: String

    var fretMarkerColor: ColorInt

    var stringColor: ColorInt

    var fretNumberColor: ColorInt

    var stringMarkerColor: ColorInt

    var noteColor: ColorInt

    var noteNumberColor: ColorInt

    var barLineColor: ColorInt

    companion object {

        const val DEFAULT_COLOR = Color.BLACK
        const val DEFAULT_TEXT_COLOR = Color.WHITE
        const val DEFAULT_MUTED_TEXT = "X"
        const val DEFAULT_OPEN_TEXT = "O"
        const val DEFAULT_FRET_START = 1
        const val DEFAULT_FRET_END = 4
        const val DEFAULT_STRING_COUNT = 6
        const val DEFAULT_SHOW_FINGER_NUMBERS = true
        const val DEFAULT_SHOW_FRET_NUMBERS = true
        val DEFAULT_STRING_LABEL_STATE = StringLabelState.HIDE
    }
}