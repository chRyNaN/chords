@file:Suppress("unused")

package com.chrynan.chords.util

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import com.chrynan.chords.model.*
import com.chrynan.parcelable.core.Parcelable
import com.chrynan.parcelable.android.putParcelable
import com.chrynan.parcelable.android.getParcelable
import com.chrynan.parcelable.android.putExtra
import com.chrynan.parcelable.android.getParcelableExtra
import com.chrynan.parcelable.android.encodeToParcel
import com.chrynan.parcelable.android.decodeFromParcel
import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(ExperimentalSerializationApi::class)
internal val parcelable: Parcelable = Parcelable {}

// Bundle

@ExperimentalSerializationApi
fun Bundle.putChord(key: String, chord: Chord) = putParcelable(key, chord, parcelable)

@ExperimentalSerializationApi
fun Bundle.putChordChart(key: String, chart: ChordChart) =
    putParcelable(key, chart, parcelable)

@ExperimentalSerializationApi
fun Bundle.putChordAndChart(key: String, chordAndChart: ChordAndChart) =
    putParcelable(key, chordAndChart, parcelable)

@ExperimentalSerializationApi
fun Bundle.getChord(key: String) = getParcelable<Chord>(key, parcelable)

@ExperimentalSerializationApi
fun Bundle.getChordChart(key: String) = getParcelable<ChordChart>(key, parcelable)

@ExperimentalSerializationApi
fun Bundle.getChordAndChart(key: String) = getParcelable<ChordAndChart>(key, parcelable)

// Intent

@ExperimentalSerializationApi
fun Intent.putChordExtra(key: String, chord: Chord) = putExtra(key, chord, parcelable)

@ExperimentalSerializationApi
fun Intent.putChordChartExtra(key: String, chart: ChordChart) = putExtra(key, chart, parcelable)

@ExperimentalSerializationApi
fun Intent.putChordAndChartExtra(key: String, chordAndChart: ChordAndChart) =
    putExtra(key, chordAndChart, parcelable)

@ExperimentalSerializationApi
fun Intent.getChordExtra(key: String) = getParcelableExtra<Chord>(key, parcelable)

@ExperimentalSerializationApi
fun Intent.getChordChartExtra(key: String) = getParcelableExtra<ChordChart>(key, parcelable)

@ExperimentalSerializationApi
fun Intent.getChordAndChartExtra(key: String) = getParcelableExtra<ChordAndChart>(key, parcelable)

// Parcel

@ExperimentalSerializationApi
fun Parcel.writeChord(chord: Chord, flags: Int) = parcelable.encodeToParcel(this, chord)

@ExperimentalSerializationApi
fun Parcel.writeChordChart(chart: ChordChart, flags: Int) = parcelable.encodeToParcel(this, chart)

@ExperimentalSerializationApi
fun Parcel.writeChordAndChart(chordAndChart: ChordAndChart, flags: Int) =
    parcelable.encodeToParcel(this, chordAndChart)

@ExperimentalSerializationApi
fun Parcel.readChord(): Chord = parcelable.decodeFromParcel(this)

@ExperimentalSerializationApi
fun Parcel.readChordChart(): ChordChart = parcelable.decodeFromParcel(this)

@ExperimentalSerializationApi
fun Parcel.readChordAndChart(): ChordAndChart = parcelable.decodeFromParcel(this)
