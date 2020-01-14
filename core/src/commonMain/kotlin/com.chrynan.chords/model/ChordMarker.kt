package com.chrynan.chords.model

sealed class ChordMarker {

    data class Note(
            val finger: Finger = Finger.UNKNOWN,
            val fret: Int,
            val string: ChordString
    ) : ChordMarker()

    data class Bar(
            val finger: Finger = Finger.UNKNOWN,
            val fret: Int,
            val startString: ChordString,
            val endString: ChordString
    ) : ChordMarker() {

        val notes: Set<Note> by lazy {
            (startString.number..endString.number).map {
                Note(finger = finger,
                        fret = fret,
                        string = ChordString(number = it))
            }.toSet()
        }
    }

    data class Open(val string: ChordString) : ChordMarker()

    data class Muted(val string: ChordString) : ChordMarker()
}