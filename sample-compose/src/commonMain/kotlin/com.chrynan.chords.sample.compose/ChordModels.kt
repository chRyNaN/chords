package com.chrynan.chords.sample.compose

import com.chrynan.chords.model.*

val chord = chord(name = "D Major") {
    +ChordMarker.Muted(string = StringNumber(6))
    +ChordMarker.Muted(string = StringNumber(5))
    +ChordMarker.Open(string = StringNumber(4))
    +ChordMarker.Note(
        fret = FretNumber(2),
        finger = Finger.INDEX,
        string = StringNumber(3)
    )
    +ChordMarker.Note(
        fret = FretNumber(3),
        finger = Finger.RING,
        string = StringNumber(2)
    )
    +ChordMarker.Note(
        fret = FretNumber(2),
        finger = Finger.MIDDLE,
        string = StringNumber(1)
    )
}

val chordChart = ChordChart.STANDARD_TUNING_GUITAR_CHART

@OptIn(ExperimentalUnsignedTypes::class)
val chordViewModel = ChordViewModel(
    showFingerNumbers = true,
    showFretNumbers = true,
    stringLabelState = StringLabelState.SHOW_LABEL
)
