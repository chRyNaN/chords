package com.chrynan.sample.repository.values

import com.chrynan.chords.model.*

// This is just setup this way for now because I'm too lazy to setup a database

private val chordA by lazy {
    chord("A") {
        +ChordMarker.Muted(string = StringNumber(6))
        +ChordMarker.Open(string = StringNumber(5))
        +ChordMarker.Note(
                fret = FretNumber(2),
                finger = Finger.INDEX,
                string = StringNumber(4))
        +ChordMarker.Note(
                fret = FretNumber(2),
                finger = Finger.MIDDLE,
                string = StringNumber(3))
        +ChordMarker.Note(
                fret = FretNumber(2),
                finger = Finger.RING,
                string = StringNumber(2))
        +ChordMarker.Open(string = StringNumber(1))
    }
}

private val chordAMinor by lazy {
    chord("Am") {
        +ChordMarker.Muted(string = StringNumber(6))
        +ChordMarker.Open(string = StringNumber(5))
        +ChordMarker.Note(
                fret = FretNumber(2),
                finger = Finger.MIDDLE,
                string = StringNumber(4))
        +ChordMarker.Note(
                fret = FretNumber(2),
                finger = Finger.RING,
                string = StringNumber(3))
        +ChordMarker.Note(
                fret = FretNumber(1),
                finger = Finger.INDEX,
                string = StringNumber(2))
        +ChordMarker.Open(string = StringNumber(1))
    }
}

private val chordB by lazy {
    chord("B") {
        +ChordMarker.Muted(string = StringNumber(6))
        +ChordMarker.Note(
                fret = FretNumber(1),
                finger = Finger.INDEX,
                string = StringNumber(5))
        +ChordMarker.Note(
                fret = FretNumber(3),
                finger = Finger.MIDDLE,
                string = StringNumber(4))
        +ChordMarker.Note(
                fret = FretNumber(3),
                finger = Finger.RING,
                string = StringNumber(3))
        +ChordMarker.Note(
                fret = FretNumber(3),
                finger = Finger.PINKY,
                string = StringNumber(2))
        +ChordMarker.Muted(string = StringNumber(1))
    }
}

private val chordBMinor by lazy {
    chord("Bm") {
        +ChordMarker.Muted(string = StringNumber(6))
        +ChordMarker.Note(
                fret = FretNumber(2),
                finger = Finger.INDEX,
                string = StringNumber(5))
        +ChordMarker.Note(
                fret = FretNumber(4),
                finger = Finger.RING,
                string = StringNumber(4))
        +ChordMarker.Note(
                fret = FretNumber(4),
                finger = Finger.PINKY,
                string = StringNumber(3))
        +ChordMarker.Note(
                fret = FretNumber(3),
                finger = Finger.MIDDLE,
                string = StringNumber(2))
        +ChordMarker.Muted(string = StringNumber(1))
    }
}

private val chordC by lazy {
    chord("C") {
        +ChordMarker.Muted(string = StringNumber(6))
        +ChordMarker.Note(
                fret = FretNumber(3),
                finger = Finger.RING,
                string = StringNumber(5))
        +ChordMarker.Note(
                fret = FretNumber(2),
                finger = Finger.MIDDLE,
                string = StringNumber(4))
        +ChordMarker.Open(string = StringNumber(3))
        +ChordMarker.Note(
                fret = FretNumber(1),
                finger = Finger.INDEX,
                string = StringNumber(2))
        +ChordMarker.Open(string = StringNumber(1))
    }
}

private val chordD by lazy {
    chord("D") {
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
                string = StringNumber(2))
        +ChordMarker.Note(
                fret = FretNumber(2),
                finger = Finger.MIDDLE,
                string = StringNumber(1))
    }
}

private val chordDMinor by lazy {
    chord("Dm") {
        +ChordMarker.Muted(string = StringNumber(6))
        +ChordMarker.Muted(string = StringNumber(5))
        +ChordMarker.Open(string = StringNumber(4))
        +ChordMarker.Note(
                fret = FretNumber(2),
                finger = Finger.MIDDLE,
                string = StringNumber(3)
        )
        +ChordMarker.Note(
                fret = FretNumber(3),
                finger = Finger.RING,
                string = StringNumber(2))
        +ChordMarker.Note(
                fret = FretNumber(1),
                finger = Finger.INDEX,
                string = StringNumber(1))
    }
}

private val chordE by lazy {
    chord("E") {
        +ChordMarker.Open(string = StringNumber(6))
        +ChordMarker.Note(
                fret = FretNumber(2),
                finger = Finger.MIDDLE,
                string = StringNumber(5))
        +ChordMarker.Note(
                fret = FretNumber(2),
                finger = Finger.RING,
                string = StringNumber(4))
        +ChordMarker.Note(
                fret = FretNumber(1),
                finger = Finger.INDEX,
                string = StringNumber(3))
        +ChordMarker.Open(string = StringNumber(2))
        +ChordMarker.Open(string = StringNumber(1))
    }
}

private val chordEMinor by lazy {
    chord("Em") {
        +ChordMarker.Open(string = StringNumber(6))
        +ChordMarker.Note(
                fret = FretNumber(2),
                finger = Finger.MIDDLE,
                string = StringNumber(5))
        +ChordMarker.Note(
                fret = FretNumber(2),
                finger = Finger.RING,
                string = StringNumber(4))
        +ChordMarker.Open(string = StringNumber(3))
        +ChordMarker.Open(string = StringNumber(2))
        +ChordMarker.Open(string = StringNumber(1))
    }
}

private val chordF by lazy {
    chord("F") {
        +ChordMarker.Muted(string = StringNumber(6))
        +ChordMarker.Muted(string = StringNumber(5))
        +ChordMarker.Note(
                fret = FretNumber(3),
                finger = Finger.RING,
                string = StringNumber(4))
        +ChordMarker.Note(
                fret = FretNumber(2),
                finger = Finger.MIDDLE,
                string = StringNumber(3))
        +ChordMarker.Bar(
                fret = FretNumber(1),
                finger = Finger.INDEX,
                startString = StringNumber(1),
                endString = StringNumber(2))
    }
}

private val chordG by lazy {
    chord("G") {
        +ChordMarker.Note(
                fret = FretNumber(3),
                finger = Finger.MIDDLE,
                string = StringNumber(6)
        )
        +ChordMarker.Note(
                fret = FretNumber(2),
                finger = Finger.INDEX,
                string = StringNumber(5)
        )
        +ChordMarker.Open(string = StringNumber(4))
        +ChordMarker.Open(string = StringNumber(3))
        +ChordMarker.Note(
                fret = FretNumber(3),
                finger = Finger.RING,
                string = StringNumber(2)
        )
        +ChordMarker.Note(
                fret = FretNumber(3),
                finger = Finger.PINKY,
                string = StringNumber(1)
        )
    }
}

val openStandardGuitarChords = setOf(chordA, chordAMinor, chordB, chordBMinor, chordC, chordD, chordDMinor, chordE, chordEMinor, chordF, chordG)