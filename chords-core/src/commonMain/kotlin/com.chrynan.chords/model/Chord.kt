package com.chrynan.chords.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A representation of a fretted stringed instrument Chord. This model contains the [name] of the
 * Chord and the [markers] which indicate the strings, frets, and fingers used to make up the
 * Chord.
 *
 * Note that this model represents what makes up the fretted stringed instrument Chord and
 * not the diagram used to display it. For a model that represents the diagram which displays
 * Chords, refer to the [ChordChart] class.
 *
 * Note that this model does not contain frequency information about the notes in a Chord but
 * rather contains information about the position on a fretted stringed instrument to play a Chord.
 * Also, note that this doesn't contain relative container information, such as starting frequency
 * or position.
 *
 * @property [name] The optional name of this [Chord].
 * @property [markers] A [Set] of [ChordMarker]s that make up this [Chord].
 *
 * @author chRyNaN
 */
@Serializable
data class Chord(
    @SerialName(value = "name") val name: String? = null,
    @SerialName(value = "markers") val markers: Set<ChordMarker>
) {

    /**
     * A [Set] of [ChordMarker.Note]s that are a part of this [Chord]. This is a convenience
     * property that filters the [markers] for [ChordMarker.Note]s.
     *
     * @author chRyNaN
     */
    val notes: Set<ChordMarker.Note> by lazy {
        markers.filterIsInstance<ChordMarker.Note>().toSet()
    }

    /**
     * A [Set] of [ChordMarker.Bar]s that are a part of this [Chord]. This is a convenience
     * property that filters the [markers] for [ChordMarker.Bar]s.
     *
     * @author chRyNaN
     */
    val bars: Set<ChordMarker.Bar> by lazy { markers.filterIsInstance<ChordMarker.Bar>().toSet() }

    /**
     * A [Set] of [ChordMarker.Open]s that are a part of this [Chord]. This is a convenience
     * property that filters the [markers] for [ChordMarker.Open]s.
     *
     * @author chRyNaN
     */
    val opens: Set<ChordMarker.Open> by lazy {
        markers.filterIsInstance<ChordMarker.Open>().toSet()
    }

    /**
     * A [Set] of [ChordMarker.Muted]s that are a part of this [Chord]. This is a convenience
     * property that filters the [markers] for [ChordMarker.Muted]s.
     *
     * @author chRyNaN
     */
    val mutes: Set<ChordMarker.Muted> by lazy {
        markers.filterIsInstance<ChordMarker.Muted>().toSet()
    }

    /**
     * An overloaded operator function that determines whether this [Chord] contains the provided
     * [marker].
     *
     * @author chRyNaN
     */
    operator fun contains(marker: ChordMarker) = markers.contains(marker)

    companion object {

        /**
         * A [Chord] that has no [markers] and a null [name].
         *
         * @author chRyNaN
         */
        val EMPTY = Chord(name = null, markers = emptySet())
    }
}
