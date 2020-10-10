package com.chrynan.chords.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An inline class wrapping an [Int] that indicates the number of a string that a note is to be
 * played on.
 *
 * @author chRyNaN
 */
@Serializable
data class StringNumber(@SerialName(value = "number") val number: Int) {

    override fun toString(): String = number.toString()
}