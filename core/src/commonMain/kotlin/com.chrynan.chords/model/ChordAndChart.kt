package com.chrynan.chords.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A convenience wrapper class around a [Chord] and [ChordChart]. This could be useful if it's
 * needed to couple a [Chord] and it's related [ChordChart] together.
 *
 * @property [chord] The [Chord] this class wraps.
 * @property [chart] The [ChordChart] this class wraps.
 *
 * @author chRyNaN
 */
@Serializable
data class ChordAndChart(
    @SerialName(value = "chord") val chord: Chord,
    @SerialName(value = "chart") val chart: ChordChart
) {

    companion object
}
