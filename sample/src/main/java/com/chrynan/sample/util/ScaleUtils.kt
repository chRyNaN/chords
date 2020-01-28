package com.chrynan.sample.util

import com.chrynan.sample.model.Scale
import com.chrynan.sample.model.ScaleStep

/**
 * A musical scale that has seven pitches per octave. A Diatonic scale is a Heptatonic scale
 * because it has seven pitches per octave.
 *
 * @author chRyNaN
 */
val Scale.isHeptatonic: Boolean
    get() = octaveRepeating && semitones.size == 7

/**
 * A musical scale that is a heptatonic scale and that includes five whole steps (whole tones) and
 * two half steps (semitones) in each octave, in which the two half steps are separated from each
 * other by either two or three whole steps, depending on their position in the scale.
 *
 * This is a suspending function because the algorithm iterates through the items multiple times.
 * This should probably be optimized but couldn't come up with a better algorithm right now.
 *
 * @author chRyNaN
 */
suspend fun Scale.isDiatonic(): Boolean {
    // A Diatonic scale is a Heptatonic scale
    if (!isHeptatonic) return false

    val scaleSteps = steps
    val areStartEndSame = scaleSteps.firstOrNull() == scaleSteps.lastOrNull()
    var prevStep: ScaleStep? = null
    var count = 0

    // Only a single Half Step between Whole Steps in a Diatonic scale
    if (areStartEndSame && scaleSteps.firstOrNull() == ScaleStep.HALF) return false

    val consecutiveSteps = mutableListOf<Pair<ScaleStep, Int>>()

    scaleSteps.forEach { step ->
        val lastStep = prevStep

        if (lastStep != null && step != prevStep) {
            consecutiveSteps.add(lastStep to count)
            count = 0
            prevStep = step
        } else {
            count += 1
        }
    }

    // If the start and end steps are the same, combine them
    if (areStartEndSame) {
        val first = consecutiveSteps.removeAt(0)
        val last = consecutiveSteps.removeAt(consecutiveSteps.size - 1)
        consecutiveSteps.add(0, first.copy(second = first.second + last.second))
    }

    prevStep = null
    var pastTwoWholes = false
    var pastThreeWholes = false
    consecutiveSteps.forEach { (step, count) ->
        // Something messed up, can't have a consecutive count of zero or less
        if (count <= 0) return false

        // Only Whole and Half Steps are in a Diatonic scale
        if (step < ScaleStep.HALF || step > ScaleStep.WHOLE) return false

        // Only a single Half Step between Whole Steps in a Diatonic scale
        if (step == ScaleStep.HALF && count > 1) return false

        // Only two or three consecutive Whole Steps are in a Diatonic scale
        if (step == ScaleStep.WHOLE && (count > 3 || count < 2)) return false

        // Whole steps are separated by Half steps
        if (prevStep == step) return false

        if (step == ScaleStep.WHOLE && count == 2) {
            // There should only be one grouping of two consecutive Whole steps
            if (pastTwoWholes) return false
            pastTwoWholes = true
        }

        if (step == ScaleStep.WHOLE && count == 3) {
            // There should only be one grouping of three consecutive Whole steps
            if (pastThreeWholes) return false
            pastThreeWholes = true
        }
    }

    return true
}