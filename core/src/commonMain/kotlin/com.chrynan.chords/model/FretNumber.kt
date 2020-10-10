package com.chrynan.chords.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An inline class wrapping an [Int] that indicates the number of a fret played.
 *
 * @author chRyNaN
 */
@Serializable
data class FretNumber(@SerialName(value = "number") val number: Int) {

    override fun toString(): String = number.toString()
}