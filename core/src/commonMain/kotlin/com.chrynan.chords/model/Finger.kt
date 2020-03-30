package com.chrynan.chords.model

/**
 * An enum used to indicate which finger on a hand should be used to play a note.
 *
 * @property [position] A value indicating the finger position.
 *
 * @author chRyNaN
 */
enum class Finger(val position: Int) {

    UNKNOWN(position = -1),
    INDEX(position = 1),
    MIDDLE(position = 2),
    RING(position = 3),
    PINKY(position = 4),
    THUMB(position = 5);

    override fun toString() = "$position"

    companion object {

        /**
         * Retrieves a [Finger] from the provided [position].
         *
         * @author chRyNaN
         */
        fun fromPosition(position: Int) = values().firstOrNull { it.position == position }
                ?: UNKNOWN
    }
}