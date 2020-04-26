package com.chrynan.chords.util

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import com.chrynan.chords.model.*
import com.chrynan.chords.parcel.ChordAndChartParceler
import com.chrynan.chords.parcel.ChordChartParceler
import com.chrynan.chords.parcel.ChordParceler

// Bundle

fun Bundle.putChord(key: String, chord: Chord) = putParcelable(key, ParcelableChordWrapper(chord))

fun Bundle.putChordChart(key: String, chart: ChordChart) = putParcelable(key, ParcelableChartWrapper(chart))

fun Bundle.putChordAndChart(key: String, chordAndChart: ChordAndChart) = putParcelable(key, ParcelableChordAndChartWrapper(chordAndChart))

fun Bundle.getChord(key: String) = getParcelable<ParcelableChordWrapper>(key)?.chord

fun Bundle.getChordChart(key: String) = getParcelable<ParcelableChartWrapper>(key)?.chart

fun Bundle.getChordAndChart(key: String) = getParcelable<ParcelableChordAndChartWrapper>(key)?.chordAndChart

// Intent

fun Intent.putChordExtra(key: String, chord: Chord) = putExtra(key, ParcelableChordWrapper(chord))

fun Intent.putChordChartExtra(key: String, chart: ChordChart) = putExtra(key, ParcelableChartWrapper(chart))

fun Intent.putChordAndChartExtra(key: String, chordAndChart: ChordAndChart) = putExtra(key, ParcelableChordAndChartWrapper(chordAndChart))

fun Intent.getChordExtra(key: String) = getParcelableExtra<ParcelableChordWrapper>(key)?.chord

fun Intent.getChordChartExtra(key: String) = getParcelableExtra<ParcelableChartWrapper>(key)?.chart

fun Intent.getChordAndChartExtra(key: String) = getParcelableExtra<ParcelableChordAndChartWrapper>(key)?.chordAndChart

// Parcel

fun Parcel.writeChord(chord: Chord, flags: Int) = ChordParceler.apply { chord.write(this@writeChord, flags) }

fun Parcel.writeChordChart(chart: ChordChart, flags: Int) = ChordChartParceler.apply { chart.write(this@writeChordChart, flags) }

fun Parcel.writeChordAndChart(chordAndChart: ChordAndChart, flags: Int) = ChordAndChartParceler.apply { chordAndChart.write(this@writeChordAndChart, flags) }

fun Parcel.readChord(): Chord = ChordParceler.create(this)

fun Parcel.readChordChart(): ChordChart = ChordChartParceler.create(this)

fun Parcel.readChordAndChart(): ChordAndChart = ChordAndChartParceler.create(this)