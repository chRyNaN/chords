package com.chrynan.sample.repository

import com.chrynan.chords.model.*
import com.chrynan.sample.model.AdapterItemViewModel
import com.chrynan.sample.model.ChordListViewModel
import com.chrynan.sample.model.ChordViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OpenGuitarChordSource : ChordRepository {

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

    private val minorChords by lazy {
        listOf(
                ChordViewModel(
                        title = "Am",
                        description = "Minor",
                        chord = chordAMinor),
                ChordViewModel(
                        title = "Bm",
                        description = "Minor",
                        chord = chordBMinor),
                ChordViewModel(
                        title = "Dm",
                        description = "Minor",
                        chord = chordDMinor),
                ChordViewModel(
                        title = "Em",
                        description = "Minor",
                        chord = chordEMinor)
        )
    }

    private val majorChords by lazy {
        listOf(
                ChordViewModel(
                        title = "A",
                        description = "Major",
                        chord = chordA),
                ChordViewModel(
                        title = "B",
                        description = "Major",
                        chord = chordB),
                ChordViewModel(
                        title = "C",
                        description = "Major",
                        chord = chordC),
                ChordViewModel(
                        title = "D",
                        description = "Major",
                        chord = chordD),
                ChordViewModel(
                        title = "E",
                        description = "Major",
                        chord = chordE),
                ChordViewModel(
                        title = "F",
                        description = "Major",
                        chord = chordF),
                ChordViewModel(
                        title = "G",
                        description = "Major",
                        chord = chordG)
        )
    }

    override fun getAll(): Flow<List<AdapterItemViewModel>> = flow {
        val majorList = ChordListViewModel(
                title = "Major Chords",
                items = majorChords)
        val minorList = ChordListViewModel(
                title = "Minor Chords",
                items = minorChords)
        val items = mutableListOf<AdapterItemViewModel>()

        items.add(minorList)
        items.add(majorList)

        emit(items)
    }
}