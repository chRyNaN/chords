package com.chrynan.sample.model

/**
 * This class represents the interval of semitones in a scale between each successive note. A Whole
 * Step is considered to be two semitones and a Half Step is a single semitone.
 *
 * @author chRyNaN
 */
data class ScaleStep(val value: Int) {

    companion object {

        val WHOLE = ScaleStep(2)
        val HALF = ScaleStep(1)
    }

    operator fun compareTo(other: ScaleStep) = value.compareTo(other.value)
}