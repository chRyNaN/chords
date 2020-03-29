package com.chrynan.chords.model

import android.os.Parcelable
import com.chrynan.chords.parcel.ChordParceler
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.WriteWith

@Parcelize
data class ParcelableChordWrapper(val chord: @WriteWith<ChordParceler> Chord) : Parcelable