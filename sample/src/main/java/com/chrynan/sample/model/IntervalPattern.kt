package com.chrynan.sample.model

data class IntervalPattern(
        val name: String? = null,
        val semitones: Set<Semitone>
)