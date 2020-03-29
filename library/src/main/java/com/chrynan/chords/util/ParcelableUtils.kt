package com.chrynan.chords.util

import android.content.Intent
import android.os.Bundle
import com.chrynan.chords.model.*

fun Bundle.putChord(key: String, chord: Chord) = putParcelable(key, ParcelableChordWrapper(chord))

fun Bundle.putChordChart(key: String, chart: ChordChart) = putParcelable(key, ParcelableChartWrapper(chart))

fun Bundle.putChordAndChart(key: String, chordAndChart: ChordAndChart) = putParcelable(key, ParcelableChordAndChartWrapper(chordAndChart))

fun Bundle.getChord(key: String) = getParcelable<ParcelableChordWrapper>(key)?.chord

fun Bundle.getChordChart(key: String) = getParcelable<ParcelableChartWrapper>(key)?.chart

fun Bundle.getChordAndChart(key: String) = getParcelable<ParcelableChordAndChartWrapper>(key)?.chordAndChart

fun Intent.putChordExtra(key: String, chord: Chord) = putExtra(key, ParcelableChordWrapper(chord))

fun Intent.putChordChartExtra(key: String, chart: ChordChart) = putExtra(key, ParcelableChartWrapper(chart))

fun Intent.putChordAndChartExtra(key: String, chordAndChart: ChordAndChart) = putExtra(key, ParcelableChordAndChartWrapper(chordAndChart))

fun Intent.getChordExtra(key: String) = getParcelableExtra<ParcelableChordWrapper>(key)?.chord

fun Intent.getChordChartExtra(key: String) = getParcelableExtra<ParcelableChartWrapper>(key)?.chart

fun Intent.getChordAndChartExtra(key: String) = getParcelableExtra<ParcelableChordAndChartWrapper>(key)?.chordAndChart