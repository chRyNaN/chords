package com.chrynan.chords.model

sealed class ChordMarker {

    data class Note(
            override val fret: FretNumber,
            override val finger: Finger = Finger.UNKNOWN,
            override val string: StringNumber
    ) : ChordMarker(),
            FretMarker,
            FingerMarker,
            StringMarker

    data class Bar(
            override val fret: FretNumber,
            override val finger: Finger = Finger.UNKNOWN,
            override val startString: StringNumber,
            override val endString: StringNumber
    ) : ChordMarker(),
            FretMarker,
            FingerMarker,
            StringRangeMarker {

        override val string = startString
    }

    data class Open(override val string: StringNumber) : ChordMarker(),
            FretMarker,
            StringMarker {

        override val fret: FretNumber = FretNumber(0)
    }

    data class Muted(override val string: StringNumber) : ChordMarker(),
            StringMarker
}