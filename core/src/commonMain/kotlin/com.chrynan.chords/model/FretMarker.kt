package com.chrynan.chords.model

/**
 * An interface for a [ChordMarker] that contains information about a [FretNumber] that is used to
 * play a note.
 *
 * @property [fret] The [FretNumber] that this [ChordMarker] is on.
 *
 * @author chRyNaN
 */
interface FretMarker {

    val fret: FretNumber

    companion object
}
