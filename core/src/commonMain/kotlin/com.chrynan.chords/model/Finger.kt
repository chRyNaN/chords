@file:Suppress("unused")

package com.chrynan.chords.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An enum used to indicate which finger on a hand should be used to play a note.
 *
 * @property [position] A value indicating the finger position.
 *
 * @author chRyNaN
 */
@Serializable
enum class Finger(
    @SerialName(value = "position") val position: Int,
    @SerialName(value = "name") val fingerName: String? = null
) {

    UNKNOWN(position = -1, fingerName = null),
    INDEX(position = 1, fingerName = "index"),
    MIDDLE(position = 2, fingerName = "middle"),
    RING(position = 3, fingerName = "ring"),
    PINKY(position = 4, fingerName = "pinky"),
    THUMB(position = 5, fingerName = "thumb");

    override fun toString() = "$position"

    companion object {

        /**
         * Retrieves a [Finger] from the provided [position].
         *
         * @author chRyNaN
         */
        fun fromPosition(position: Int) = values().firstOrNull { it.position == position }
            ?: UNKNOWN

        fun fromFingerName(name: String, ignoreCase: Boolean = false) = values().firstOrNull {
            if (ignoreCase) {
                it.fingerName?.toLowerCase() == name.toLowerCase()
            } else {
                it.fingerName == name
            }
        } ?: UNKNOWN
    }
}