package com.chrynan.chords.model

import android.os.Parcelable
import com.chrynan.chords.parcel.ChordChartParceler
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.WriteWith

@Parcelize
data class ParcelableChartWrapper(val chart: @WriteWith<ChordChartParceler> ChordChart) : Parcelable