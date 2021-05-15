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

    @SerialName(value = "unknown")
    UNKNOWN(position = -1, fingerName = null),

    @SerialName(value = "index")
    INDEX(position = 1, fingerName = "index"),

    @SerialName(value = "middle")
    MIDDLE(position = 2, fingerName = "middle"),

    @SerialName(value = "ring")
    RING(position = 3, fingerName = "ring"),

    @SerialName(value = "pinky")
    PINKY(position = 4, fingerName = "pinky"),

    @SerialName(value = "thumb")
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
            it.fingerName.equals(name, ignoreCase = ignoreCase)
        } ?: UNKNOWN
    }
}
