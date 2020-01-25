package com.chrynan.sample.model

data class ScaleStep(val value: Int) {

    companion object {

        val WHOLE = ScaleStep(2)
        val HALF = ScaleStep(1)
    }
}