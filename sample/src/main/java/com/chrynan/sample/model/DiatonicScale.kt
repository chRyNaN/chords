package com.chrynan.sample.model

import kotlin.math.abs

class DiatonicScale(
        override val tonic: ToneEqualNote,
        val mode: DiatonicScaleMode
) : Scale {

    private val startIndex = abs((ToneEqualNote.VALUES.indexOf(tonic) + (mode.relativeStartingNote - 1)) % ToneEqualNote.SIZE)

    val startNote = ToneEqualNote.VALUES[startIndex]

    override val semitones by lazy {
        var count = startIndex

        mode.steps.map {
            count = (count + it.value) % ToneEqualNote.SIZE
            SemitoneCount(count)
        }.toSet()
    }

    override val intervalName: String
        get() = mode.modeName

    val name: String
        get() = "${tonic.noteName} $intervalName"
}