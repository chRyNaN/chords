package com.chrynan.chords.model

sealed class ChordMarker {

    data class Note(
            val finger: Finger,
            val fretNumber: FretNumber,
            val string: ChordString
    ) : ChordMarker()

    data class Bar(
            val finger: Finger,
            val fretNumber: FretNumber,
            val startString: ChordString,
            val endString: ChordString
    ) : ChordMarker() {

        val notes: Set<Note> by lazy {
            (startString.number..endString.number).map {
                Note(finger = finger,
                        fretNumber = fretNumber,
                        string = ChordString(number = it))
            }.toSet()
        }
    }

    data class Open(val stringNumber: ChordString) : ChordMarker()

    data class Muted(val stringNumber: ChordString) : ChordMarker()
}