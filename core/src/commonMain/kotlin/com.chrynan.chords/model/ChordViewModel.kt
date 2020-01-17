package com.chrynan.chords.model

import com.chrynan.chords.view.ChordView

data class ChordViewModel(
        val fitToHeight: Boolean = ChordView.DEFAULT_FIT_TO_HEIGHT,
        val showFretNumbers: Boolean = ChordView.DEFAULT_SHOW_FRET_NUMBERS,
        val showFingerNumbers: Boolean = ChordView.DEFAULT_SHOW_FINGER_NUMBERS,
        val stringLabelState: StringLabelState = ChordView.DEFAULT_STRING_LABEL_STATE,
        val mutedText: String = ChordView.DEFAULT_MUTED_TEXT,
        val openStringText: String = ChordView.DEFAULT_OPEN_TEXT,
        val fretColor: ColorInt,
        val fretLabelTextColor: ColorInt,
        val stringColor: ColorInt,
        val stringLabelTextColor: ColorInt,
        val noteColor: ColorInt,
        val noteLabelTextColor: ColorInt
)