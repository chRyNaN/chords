package com.chrynan.chords.parcel

import android.os.Parcel
import com.chrynan.chords.model.Chord
import com.chrynan.chords.model.ChordMarker
import kotlinx.android.parcel.Parceler

object ChordParceler : Parceler<Chord> {

    override fun create(parcel: Parcel): Chord {
        val name = parcel.readString()
        val markers = mutableSetOf<ChordMarker>()

        while (parcel.dataPosition() < parcel.dataSize()) {
            markers.add(ChordMarkerParceler.create(parcel))
        }

        return Chord(name = name, markers = markers)
    }

    override fun Chord.write(parcel: Parcel, flags: Int) {
        parcel.writeString(name)

        markers.forEach {
            ChordMarkerParceler.apply {
                it.write(parcel, flags)
            }
        }
    }
}