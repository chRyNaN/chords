package com.chrynan.sample.model

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
 * 2 2 1 2 2 2 1. Note that this [Set] of [SemitoneCount] values will not always consist of a value of
 * zero, denoting the the [tonic], because it may be a mode that begins at a different position
 * other than the tonic. No assertion or validation is performed.
 *
 * @author chRyNaN
 */
interface Scale {

    val semitones: Set<SemitoneCount>
    val tonic: ToneEqualNote
    val intervalName: String?
}