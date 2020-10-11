package com.chrynan.chords.util

import com.chrynan.chords.model.ChordViewModel
import com.chrynan.chords.model.StringLabelState
import com.chrynan.chords.view.ChordView
import com.chrynan.colors.Color

@Suppress("unused", "FunctionName")
fun ChordViewModel(
        fitToHeight: Boolean = ChordView.DEFAULT_FIT_TO_HEIGHT,
        showFretNumbers: Boolean = ChordView.DEFAULT_SHOW_FRET_NUMBERS,
        showFingerNumbers: Boolean = ChordView.DEFAULT_SHOW_FINGER_NUMBERS,
        stringLabelState: StringLabelState = ChordView.DEFAULT_STRING_LABEL_STATE,
        mutedStringText: String = ChordView.DEFAULT_MUTED_TEXT,
        openStringText: String = ChordView.DEFAULT_OPEN_TEXT,
        fretColor: Color,
        fretLabelTextColor: Color,
        stringColor: Color,
        stringLabelTextColor: Color,
        noteColor: Color,
        noteLabelTextColor: Color
): ChordViewModel = ChordViewModel(
        fitToHeight = fitToHeight,
        showFretNumbers = showFretNumbers,
        showFingerNumbers = showFingerNumbers,
        stringLabelState = stringLabelState,
        mutedStringText = mutedStringText,
        openStringText = openStringText,
        fretColor = fretColor.colorInt,
        fretLabelTextColor = fretLabelTextColor.colorInt,
        stringColor = stringColor.colorInt,
        stringLabelTextColor = stringLabelTextColor.colorInt,
        noteColor = noteColor.colorInt,
        noteLabelTextColor = noteLabelTextColor.colorInt)