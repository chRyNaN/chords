package com.chrynan.chords.model

import android.os.Parcelable
import com.chrynan.chords.parcel.ChordAndChartParceler
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.WriteWith

@Parcelize
data class ParcelableChordAndChartWrapper(val chordAndChart: @WriteWith<ChordAndChartParceler> ChordAndChart) : Parcelable