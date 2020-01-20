package com.chrynan.chords.model

data class ChordChart(
        val fretStart: Int = DEFAULT_FRET_START,
        val fretEnd: Int = DEFAULT_FRET_END,
        val stringCount: Int = DEFAULT_STRING_COUNT,
        val stringLabels: Set<StringLabel> = emptySet()
) {

    val fretCount: Int
        get() = fretEnd - fretStart + 1

    companion object {

        const val DEFAULT_FRET_START = 1
        const val DEFAULT_FRET_END = 3
        const val DEFAULT_STRING_COUNT = 6

        val STANDARD_TUNING_GUITAR_CHART = ChordChart(stringLabels = setOf(
                StringLabel(string = 1, label = "e"),
                StringLabel(string = 2, label = "B"),
                StringLabel(string = 3, label = "G"),
                StringLabel(string = 4, label = "D"),
                StringLabel(string = 5, label = "A"),
                StringLabel(string = 6, label = "E")))
    }
}