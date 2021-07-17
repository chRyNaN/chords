package com.chrynan.sample.model

import com.chrynan.sample.model.ScaleStep.Companion.HALF
import com.chrynan.sample.model.ScaleStep.Companion.WHOLE

enum class DiatonicScaleMode(
        val modeName: String,
        val numeralName: String,
        val relativeStartingNote: Int,
        val steps: Set<ScaleStep>
) {

    IONIAN(modeName = "Ionian", numeralName = "I", relativeStartingNote = 1, steps = setOf(WHOLE, WHOLE, HALF, WHOLE, WHOLE, WHOLE, HALF)),
    DORIAN(modeName = "Dorian", numeralName = "II", relativeStartingNote = 2, steps = setOf(WHOLE, HALF, WHOLE, WHOLE, WHOLE, HALF, WHOLE)),
    PHRYGIAN(modeName = "Phyrgian", numeralName = "III", relativeStartingNote = 3, steps = setOf(HALF, WHOLE, WHOLE, WHOLE, HALF, WHOLE, WHOLE)),
    LYDIAN(modeName = "Lydian", numeralName = "IV", relativeStartingNote = 4, steps = setOf(WHOLE, WHOLE, WHOLE, HALF, WHOLE, WHOLE, HALF)),
    MIXOLYDIAN(modeName = "Mixolydian", numeralName = "V", relativeStartingNote = 5, steps = setOf(WHOLE, WHOLE, HALF, WHOLE, WHOLE, HALF, WHOLE)),
    AEOLIAN(modeName = "Aeolian", numeralName = "VI", relativeStartingNote = 6, steps = setOf(WHOLE, HALF, WHOLE, WHOLE, HALF, WHOLE, WHOLE)),
    LOCRIAN(modeName = "Locrian", numeralName = "VII", relativeStartingNote = 7, steps = setOf(HALF, WHOLE, WHOLE, HALF, WHOLE, WHOLE, WHOLE))
}