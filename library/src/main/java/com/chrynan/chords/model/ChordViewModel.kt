package com.chrynan.chords.model

import com.chrynan.chords.view.ChordView
import com.chrynan.chords.view.StringLabelState

data class ChordViewModel(
        val showFretNumbers: Boolean = ChordView.DEFAULT_SHOW_FRET_NUMBERS,
        val showFingerNumbers: Boolean = ChordView.DEFAULT_SHOW_FINGER_NUMBERS,
        val stringLabelState: StringLabelState = ChordView.DEFAULT_STRING_LABEL_STATE,
        val stringCount: Int = ChordView.DEFAULT_STRING_COUNT,
        val fretStart: Int = ChordView.DEFAULT_FRET_START,
        val fretEnd: Int = ChordView.DEFAULT_FRET_END,
        val mutedText: String = ChordView.DEFAULT_MUTED_TEXT,
        val openStringText: String = ChordView.DEFAULT_OPEN_TEXT,
        val fretMarkerColor: ColorInt = ChordView.DEFAULT_COLOR,
        val stringMarkerColor: ColorInt = ChordView.DEFAULT_COLOR,
        val stringColor: ColorInt = ChordView.DEFAULT_COLOR,
        val noteColor: ColorInt = ChordView.DEFAULT_COLOR,
        val barLineColor: ColorInt = ChordView.DEFAULT_COLOR,
        val noteNumberColor: ColorInt = ChordView.DEFAULT_TEXT_COLOR,
        val fretNumberColor: ColorInt = ChordView.DEFAULT_TEXT_COLOR
)