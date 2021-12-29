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
internal val defaultParcelable: Parcelable = Parcelable {}

// Bundle

@ExperimentalSerializationApi
fun Bundle.putChord(key: String, chord: Chord, parcelable: Parcelable = defaultParcelable) =
    putParcelable(key, chord, parcelable)

@ExperimentalSerializationApi
fun Bundle.putChordChart(key: String, chart: ChordChart, parcelable: Parcelable = defaultParcelable) =
    putParcelable(key, chart, parcelable)

@ExperimentalSerializationApi
fun Bundle.putChordAndChart(key: String, chordAndChart: ChordAndChart, parcelable: Parcelable = defaultParcelable) =
    putParcelable(key, chordAndChart, parcelable)

@ExperimentalSerializationApi
fun Bundle.getChord(key: String, parcelable: Parcelable = defaultParcelable) = getParcelable<Chord>(key, parcelable)

@ExperimentalSerializationApi
fun Bundle.getChordChart(key: String, parcelable: Parcelable = defaultParcelable) =
    getParcelable<ChordChart>(key, parcelable)

@ExperimentalSerializationApi
fun Bundle.getChordAndChart(key: String, parcelable: Parcelable = defaultParcelable) =
    getParcelable<ChordAndChart>(key, parcelable)

// Intent

@ExperimentalSerializationApi
fun Intent.putChordExtra(key: String, chord: Chord, parcelable: Parcelable = defaultParcelable) =
    putExtra(key, chord, parcelable)

@ExperimentalSerializationApi
fun Intent.putChordChartExtra(key: String, chart: ChordChart, parcelable: Parcelable = defaultParcelable) =
    putExtra(key, chart, parcelable)

@ExperimentalSerializationApi
fun Intent.putChordAndChartExtra(
    key: String,
    chordAndChart: ChordAndChart,
    parcelable: Parcelable = defaultParcelable
) =
    putExtra(key, chordAndChart, parcelable)

@ExperimentalSerializationApi
fun Intent.getChordExtra(key: String, parcelable: Parcelable = defaultParcelable) =
    getParcelableExtra<Chord>(key, parcelable)

@ExperimentalSerializationApi
fun Intent.getChordChartExtra(key: String, parcelable: Parcelable = defaultParcelable) =
    getParcelableExtra<ChordChart>(key, parcelable)

@ExperimentalSerializationApi
fun Intent.getChordAndChartExtra(key: String, parcelable: Parcelable = defaultParcelable) =
    getParcelableExtra<ChordAndChart>(key, parcelable)

// Parcel

@Suppress("UNUSED_PARAMETER")
@ExperimentalSerializationApi
fun Parcel.writeChord(chord: Chord, flags: Int, parcelable: Parcelable = defaultParcelable) =
    parcelable.encodeToParcel(this, chord)

@Suppress("UNUSED_PARAMETER")
@ExperimentalSerializationApi
fun Parcel.writeChordChart(chart: ChordChart, flags: Int, parcelable: Parcelable = defaultParcelable) =
    parcelable.encodeToParcel(this, chart)

@Suppress("UNUSED_PARAMETER")
@ExperimentalSerializationApi
fun Parcel.writeChordAndChart(chordAndChart: ChordAndChart, flags: Int, parcelable: Parcelable = defaultParcelable) =
    parcelable.encodeToParcel(this, chordAndChart)

@ExperimentalSerializationApi
fun Parcel.readChord(parcelable: Parcelable = defaultParcelable): Chord = parcelable.decodeFromParcel(this)

@ExperimentalSerializationApi
fun Parcel.readChordChart(parcelable: Parcelable = defaultParcelable): ChordChart = parcelable.decodeFromParcel(this)

@ExperimentalSerializationApi
fun Parcel.readChordAndChart(parcelable: Parcelable = defaultParcelable): ChordAndChart =
    parcelable.decodeFromParcel(this)
