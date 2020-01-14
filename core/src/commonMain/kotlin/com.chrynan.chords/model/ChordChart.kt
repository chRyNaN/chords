package com.chrynan.chords.model

data class ChordChart(
        val fretStart: Int,
        val fretEnd: Int,
        val stringCount: Int,
        val stringLabels: Set<StringLabel> = emptySet()
)