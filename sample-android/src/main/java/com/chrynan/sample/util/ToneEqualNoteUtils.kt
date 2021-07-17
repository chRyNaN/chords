package com.chrynan.sample.util

import com.chrynan.sample.model.DiatonicScale
import com.chrynan.sample.model.DiatonicScaleMode
import com.chrynan.sample.model.ToneEqualNote

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

fun ToneEqualNote.majorScale(): DiatonicScale = DiatonicScale(tonic = this, mode = DiatonicScaleMode.IONIAN)

fun ToneEqualNote.relativeMinorScale(): DiatonicScale = DiatonicScale(tonic = this, mode = DiatonicScaleMode.AEOLIAN)