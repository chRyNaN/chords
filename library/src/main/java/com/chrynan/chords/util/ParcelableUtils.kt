package com.chrynan.chords.util

import android.content.Intent
import android.os.Bundle
import com.chrynan.chords.model.Chord
import com.chrynan.chords.model.ChordChart
import com.chrynan.chords.model.ParcelableChartWrapper
import com.chrynan.chords.model.ParcelableChordWrapper

fun Bundle.putChord(key: String, chord: Chord) = putParcelable(key, ParcelableChordWrapper(chord))

fun Bundle.putChordChart(key: String, chart: ChordChart) = putParcelable(key, ParcelableChartWrapper(chart))

fun Bundle.getChord(key: String) = getParcelable<ParcelableChordWrapper>(key)?.chord

fun Bundle.getChordChart(key: String) = getParcelable<ParcelableChartWrapper>(key)?.chart

fun Intent.putChord(key: String, chord: Chord) = putExtra(key, ParcelableChordWrapper(chord))

fun Intent.putChordChart(key: String, chart: ChordChart) = putExtra(key, ParcelableChartWrapper(chart))

fun Intent.getChordExtra(key: String) = getParcelableExtra<ParcelableChordWrapper>(key)?.chord

fun Intent.getChordChartExtra(key: String) = getParcelableExtra<ParcelableChartWrapper>(key)?.chart