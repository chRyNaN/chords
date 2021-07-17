package com.chrynan.sample.model

/**
 * This class is a wrapper around an [Int] count of musical semitones. This is useful for
 * determining positions in a musical scale. For example, relative from the "tonic"
 * (or "root note"), a sequence of semitones could be: [0, 2, 4, 5, 7, 9, 11], which would
 * represent any major scale, such as, the C-Major Scale, C–D–E–F–G–A–B. Where [SemitoneCount]s
 * would represent the value relative to the root, [ScaleStep] represents the absolute amount of
 * steps.
 *
 * @author chRyNaN
 */
data class SemitoneCount(val value: Int)