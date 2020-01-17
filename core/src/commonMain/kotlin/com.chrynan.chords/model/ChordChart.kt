package com.chrynan.chords.model

data class ChordChart(
        val fretStart: Int = DEFAULT_FRET_START,
        val fretEnd: Int = DEFAULT_FRET_END,
        val stringCount: Int = DEFAULT_STRING_COUNT,
        val stringLabels: Set<StringLabel> = emptySet()
) {

    companion object {

        const val DEFAULT_FRET_START = 1
        const val DEFAULT_FRET_END = 3
        const val DEFAULT_STRING_COUNT = 6
    }
}