package com.chrynan.chords.parcel

import android.os.Parcel
import com.chrynan.chords.model.ChordAndChart
import kotlinx.android.parcel.Parceler

object ChordAndChartParceler : Parceler<ChordAndChart> {

    override fun create(parcel: Parcel): ChordAndChart {
        val chord = ChordParceler.create(parcel)
        val chart = ChordChartParceler.create(parcel)

        return ChordAndChart(chord = chord, chart = chart)
    }

    override fun ChordAndChart.write(parcel: Parcel, flags: Int) {
        ChordParceler.apply {
            chord.write(parcel, flags)
        }

        ChordChartParceler.apply {
            chart.write(parcel, flags)
        }
    }
}