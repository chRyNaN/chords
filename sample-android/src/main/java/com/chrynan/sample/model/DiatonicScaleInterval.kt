package com.chrynan.sample.model

/**
 * A Diatonic Scale only has Whole and Half interval steps. This is a convenience wrapper around
 * [ScaleStep].
 *
 * @author chRyNaN
 */
enum class DiatonicScaleInterval(step: ScaleStep) {

    WHOLE(step = ScaleStep.WHOLE),
    HALF(step = ScaleStep.HALF)
}