package com.chrynan.chords.model

import com.chrynan.chords.view.ChordView

data class ChordViewModel(
        val fitToHeight: Boolean = ChordView.DEFAULT_FIT_TO_HEIGHT,
        val showFretNumbers: Boolean = ChordView.DEFAULT_SHOW_FRET_NUMBERS,
        val showFingerNumbers: Boolean = ChordView.DEFAULT_SHOW_FINGER_NUMBERS,
        val stringLabelState: StringLabelState = ChordView.DEFAULT_STRING_LABEL_STATE,
        val mutedText: String = ChordView.DEFAULT_MUTED_TEXT,
        val openStringText: String = ChordView.DEFAULT_OPEN_TEXT,
        val fretMarkerColor: ColorInt,
        val stringMarkerColor: ColorInt,
        val stringColor: ColorInt,
        val noteColor: ColorInt,
        val noteNumberColor: ColorInt,
        val fretNumberColor: ColorInt
)