package com.chrynan.chords.model

/**
 * An interface for a [ChordMarker] that contains information about a [string] that a note is
 * played on.
 *
 * @property [string] The [StringNumber] that this [ChordMarker] is on.
 *
 * @author chRyNaN
 */
interface StringMarker {

    val string: StringNumber

    companion object
}
