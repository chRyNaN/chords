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

val ToneEqualNote.Companion.A_FLAT
    get() = ToneEqualNote.G_SHARP

val ToneEqualNote.Companion.B_FLAT
    get() = ToneEqualNote.A_SHARP

val ToneEqualNote.Companion.D_FLAT
    get() = ToneEqualNote.C_SHARP

val ToneEqualNote.Companion.E_FLAT
    get() = ToneEqualNote.D_SHARP

val ToneEqualNote.Companion.G_FLAT
    get() = ToneEqualNote.F_SHARP