package com.chrynan.chords.parcel

import android.os.Parcel
import com.chrynan.chords.model.ChordChart
import com.chrynan.chords.model.FretNumber
import com.chrynan.chords.model.StringLabel
import kotlinx.android.parcel.Parceler

object ChordChartParceler : Parceler<ChordChart> {

    override fun create(parcel: Parcel): ChordChart {
        val fretStart = parcel.readInt()
        val fretEnd = parcel.readInt()
        val stringCount = parcel.readInt()
        val stringLabels = mutableSetOf<StringLabel>()

        while (parcel.dataPosition() < parcel.dataSize()) {
            stringLabels.add(StringLabel(parcel.readInt(), parcel.readString()))
        }

        return ChordChart(
                fretStart = FretNumber(fretStart),
                fretEnd = FretNumber(fretEnd),
                stringCount = stringCount,
                stringLabels = stringLabels)
    }

    override fun ChordChart.write(parcel: Parcel, flags: Int) {
        parcel.writeInt(fretStart.number)
        parcel.writeInt(fretEnd.number)
        parcel.writeInt(stringCount)

        stringLabels.forEach {
            parcel.writeInt(it.string)
            parcel.writeString(it.label)
        }
    }
}