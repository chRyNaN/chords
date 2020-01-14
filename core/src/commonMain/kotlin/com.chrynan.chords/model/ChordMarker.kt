package com.chrynan.chords.model

sealed class ChordMarker {

    /**
     * The [MarkerType] of this [ChordMarker]. This is useful for parsing.
     */
    abstract val type: MarkerType

    data class Note(
            override val fret: FretNumber,
            override val finger: Finger = Finger.UNKNOWN,
            override val string: StringNumber
    ) : ChordMarker(),
            FretMarker,
            FingerMarker,
            StringMarker {

        override val type = MarkerType.NOTE
    }

    data class Bar(
            override val fret: FretNumber,
            override val finger: Finger = Finger.UNKNOWN,
            override val startString: StringNumber,
            override val endString: StringNumber
    ) : ChordMarker(),
            FretMarker,
            FingerMarker,
            StringRangeMarker {

        override val type = MarkerType.BAR

        override val string = startString
    }

    data class Open(override val string: StringNumber) : ChordMarker(),
            FretMarker,
            StringMarker {

        override val type = MarkerType.OPEN

        override val fret: FretNumber = FretNumber(0)
    }

    data class Muted(override val string: StringNumber) : ChordMarker(),
            StringMarker {

        override val type = MarkerType.MUTED
    }
}