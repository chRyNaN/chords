@file:Suppress("unused")

package com.chrynan.chords.util

import com.chrynan.chords.model.*
import kotlin.math.max
import kotlin.math.min

/**
 * Retrieves the [ChordMarker.Note]s that make up this [ChordMarker.Bar].
 *
 * @author chRyNaN
 */
val ChordMarker.Bar.notes: Set<ChordMarker.Note>
    get() = (startString.number..endString.number).map {
        ChordMarker.Note(
            finger = finger,
            fret = fret,
            string = StringNumber(number = it)
        )
    }.toSet()

/**
 * Retrieves the [ChordMarker]s that are on the provided [StringNumber] within this [Chord].
 *
 * @author chRyNaN
 */
fun Chord.getMarkersOnString(string: StringNumber): List<ChordMarker> =
    markers.filter {
        when {
            it is ChordMarker.Note && it.string.number == string.number -> true
            it is ChordMarker.Bar && (string.number in it.startString.number..it.endString.number) -> true
            it is ChordMarker.Open && it.string.number == string.number -> true
            it is ChordMarker.Muted && it.string.number == string.number -> true
            else -> false
        }
    }

/**
 * Retrieves the [ChordMarker]s that are on the provided [FretNumber] within this [Chord].
 *
 * @author chRyNaN
 */
fun Chord.getMarkersOnFret(fret: FretNumber): List<ChordMarker> =
    markers.filter {
        when {
            it is FretMarker && it.fret == fret -> true
            else -> false
        }
    }

/**
 * Retrieves the min fret of this Chord, or -1. If there are no markers, -1 will be returned. If there are all muted
 * notes, -1 will be returned. Otherwise, the minimum fret number will be returned. Note that this is different from
 * [ChordChart.fretStart]. This retrieves the minimum fret in this [Chord]. [ChordChart.fretStart] retrieves the
 * minimum fret that will be displayed in the chart.
 *
 * @see [ChordChart]
 * @author chRyNaN
 */
val Chord.minFret: Int
    get() = markers.map {
        when (it) {
            is FretMarker -> it.fret.number
            else -> -1
        }
    }.filter { it > 0 }
        .minOrNull() ?: -1

/**
 * Retrieves the max fret of this chord, or -1. If there are no markers, -1 will be returned. If there are all muted
 * notes, -1 will be returned. Otherwise, the maximum fret number will be returned. Note that this is different from
 * [ChordChart.fretEnd]. This retrieves the maximum fret in this [Chord]. [ChordChart.fretEnd] retrieves the maximum
 * fret that will be displayed in the chart.
 *
 * @see [ChordChart]
 * @author chRyNaN
 */
val Chord.maxFret: Int
    get() = markers.map {
        when (it) {
            is FretMarker -> it.fret.number
            else -> -1
        }
    }.maxOrNull() ?: -1

/**
 * Retrieve the minimum String that is in this [Chord] with a [ChordMarker]. If there are no [ChordMarker]s in this
 * [Chord], then -1 will be returned. Note that this is different from [ChordChart.stringCount]. This retrieves the min
 * String number from this [Chord] that has a [ChordMarker]. [ChordChart.stringCount] retrieves the amount of Strings
 * to display in the chart.
 *
 * @see [ChordChart]
 * @author chRyNaN
 */
val Chord.minString: Int
    get() = markers.map {
        when (it) {
            is ChordMarker.Bar -> min(it.endString.number, it.startString.number)
            is ChordMarker.Note -> it.string.number
            is ChordMarker.Open -> it.string.number
            is ChordMarker.Muted -> it.string.number
        }
    }.minOrNull() ?: -1

/**
 * Retrieves the maximum String that is in this [Chord] with a [ChordMarker]. If there are no [ChordMarker]s in this
 * [Chord], then -1 will be returned. Note that this is different from [ChordChart.stringCount]. This retrieves the max
 * String number from this [Chord] that has a [ChordMarker]. [ChordChart.stringCount] retrieves the amount of Strings
 * to display in the chart.
 *
 * @see [ChordChart]
 * @author chRyNaN
 */
val Chord.maxString: Int
    get() = markers.map {
        when (it) {
            is ChordMarker.Bar -> max(it.endString.number, it.startString.number)
            is ChordMarker.Note -> it.string.number
            is ChordMarker.Open -> it.string.number
            is ChordMarker.Muted -> it.string.number
        }
    }.maxOrNull() ?: -1