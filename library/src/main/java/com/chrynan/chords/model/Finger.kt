package com.chrynan.chords.model

enum class Finger(val position: Int) {

    INDEX(position = 1),
    MIDDLE(position = 2),
    RING(position = 3),
    PINKY(position = 4),
    THUMB(position = 5);

    override fun toString() = "$position"
}