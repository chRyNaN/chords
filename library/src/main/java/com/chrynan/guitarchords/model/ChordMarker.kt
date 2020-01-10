package com.chrynan.guitarchords.model

sealed class ChordMarker {

    data class Note(
            val finger: Finger,
            val fretNumber: FretNumber,
            val stringNumber: StringNumber
    ) : ChordMarker()

    data class Bar(
            val finger: Finger,
            val fretNumber: FretNumber,
            val startString: StringNumber,
            val endString: StringNumber
    ) : ChordMarker()

    data class Open(val stringNumber: StringNumber) : ChordMarker()

    data class Muted(val stringNumber: StringNumber) : ChordMarker()
}