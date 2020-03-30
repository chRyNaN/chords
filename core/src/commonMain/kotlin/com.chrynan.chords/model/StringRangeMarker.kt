package com.chrynan.chords.model

/**
 * An interface for a [ChordMarker] that contains information about a range of strings that are to
 * be played.
 *
 * @property [startString] The starting [StringNumber] in this string range.
 * @property [endString] The ending [StringNumber] in this string range.
 *
 * @author chRyNaN
 */
interface StringRangeMarker : StringMarker {

    val startString: StringNumber

    val endString: StringNumber
}