package com.chrynan.sample.model

import com.chrynan.sample.util.mapEvaluate
import kotlin.math.abs

/**
 * Represents a musical scale. Note that I realize this may not be a fool-proof class and there may
 * be instances where this class doesn't sufficiently work for all scales. But this is good enough
 * for a sample application.
 *
 * @property [tonic] The first degree note of the scale. For instance, in a C-Major Scale, the
 * tonic would be C.
 * @property [intervalName] The name of the interval of this scale. For example: major, minor,
 * chromatic, diatonic, etc.
 * @property [semitones] The semitones, relative from the [tonic], representing the notes of the
 * scale. For example, semitones of 0 2 4 5 7 9 11 would represent any major scale, such as, the
 * C-Major Scale, C–D–E–F–G–A–B. These could also be used to derive the interval progression. For
 * example, semitones of 0 2 4 5 7 9 11 would represent an interval pattern of W–W–H–W–W–W–H, or
 * 2 2 1 2 2 2 1. Note that this [Set] of [Semitone] values should always consist of a value of
 * zero, denoting the the [tonic]. No assertion or validation is performed.
 * @property [octaveRepeating] States whether this scale repeats every octave. This is usually, but
 * not always, the case.
 * @property [ascending] States whether the scale is ascending or descending, meaning whether the
 * notes should be calculated going forwards or backwards from the [tonic] with the [semitones].
 *
 * @author chRyNaN
 */
class Scale(
        semitones: Set<Semitone>,
        val tonic: ToneEqualNote,
        val intervalName: String? = null,
        val octaveRepeating: Boolean = true,
        val ascending: Boolean = true
) {

    val semitones: Set<Semitone>

    val name: String
        get() = "${tonic.noteName} ${intervalName ?: ""}"

    val notes: List<ToneEqualNote> by lazy {
        semitones.map {
            if (ascending) {
                ToneEqualNote.VALUES[it.value % ToneEqualNote.SIZE]
            } else {
                ToneEqualNote.VALUES[(ToneEqualNote.SIZE - 1) - (it.value % ToneEqualNote.SIZE)]
            }
        }
    }

    val steps: List<ScaleStep> by lazy {
        semitones.mapEvaluate(initialValue = semitones.first()) { previous, next ->
            val value = next.value - previous.value
            ScaleStep(if (ascending) value else value * -1)
        }
    }

    init {
        val sorted = semitones.map { Semitone(abs(it.value % ToneEqualNote.SIZE)) }
                .sortedBy { it.value }
                .toSet()

        val first = Semitone(0)

        this.semitones = if (sorted.firstOrNull() == first) {
            sorted
        } else {
            setOf(first) + sorted
        }
    }
}