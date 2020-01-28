package com.chrynan.sample.model

enum class ToneEqualNote(val noteName: String) {
    A(noteName = "A"),
    A_SHARP(noteName = "A#"),
    B(noteName = "B"),
    C(noteName = "C"),
    C_SHARP(noteName = "C#"),
    D(noteName = "D"),
    D_SHARP(noteName = "D#"),
    E(noteName = "E"),
    F(noteName = "F"),
    F_SHARP(noteName = "F#"),
    G(noteName = "G"),
    G_SHARP(noteName = "G#");

    companion object {

        const val SIZE = 12
        val VALUES = values().toList()
    }
}