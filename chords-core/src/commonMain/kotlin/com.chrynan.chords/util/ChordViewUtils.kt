@file:Suppress("unused")

package com.chrynan.chords.util

import com.chrynan.chords.model.Chord
import com.chrynan.chords.model.ChordAndChart
import com.chrynan.chords.view.ChordView

/**
 * An alias convenience property on a [ChordView] for a [ChordAndChart]. This property delegates to the
 * [ChordView.chord] and [ChordView.chart] properties.
 *
 * @author chRyNaN
 */
var ChordView.chordAndChart: ChordAndChart
    get() = ChordAndChart(chord = chord ?: Chord.EMPTY, chart = chart)
    set(value) {
        chord = value.chord
        chart = value.chart
    }