package com.chrynan.chords.util

import com.chrynan.chords.view.ChordView

fun ChordView.setFretColor(color: Color) {
    fretColor = color.colorInt
}

fun ChordView.setFretLabelTextColor(color: Color) {
    fretLabelTextColor = color.colorInt
}

fun ChordView.setStringColor(color: Color) {
    stringColor = color.colorInt
}

fun ChordView.setStringLabelTextColor(color: Color) {
    stringLabelTextColor = color.colorInt
}

fun ChordView.setNoteColor(color: Color) {
    noteColor = color.colorInt
}

fun ChordView.setNoteLabelTextColor(color: Color) {
    noteLabelTextColor = color.colorInt
}