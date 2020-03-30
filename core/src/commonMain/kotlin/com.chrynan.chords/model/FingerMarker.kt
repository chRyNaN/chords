package com.chrynan.chords.model

/**
 * An interface for a [ChordMarker] that contains information about a [Finger] that plays a note.
 *
 * @property [finger] The [Finger] used to play a note.
 *
 * @author chRyNaN
 */
interface FingerMarker {

    val finger: Finger
}