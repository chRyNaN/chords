package com.chrynan.chords.model

/**
 * A convenience wrapper class around a [Chord] and [ChordChart]. This could be useful if it's
 * needed to couple a [Chord] and it's related [ChordChart] together.
 *
 * @property [chord] The [Chord] this class wraps.
 * @property [chart] The [ChordChart] this class wraps.
 *
 * @author chRyNaN
 */
data class ChordAndChart(
        val chord: Chord,
        val chart: ChordChart
)