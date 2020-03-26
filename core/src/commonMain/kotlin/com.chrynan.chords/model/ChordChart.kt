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

        /**
         * A [ChordChart] representing a six string guitar in standard tuning. This is a
         * convenience property for a common [ChordChart].
         *
         * @author chRyNaN
         */
        val STANDARD_TUNING_GUITAR_CHART = ChordChart(stringLabels = setOf(
                StringLabel(string = 1, label = "e"),
                StringLabel(string = 2, label = "B"),
                StringLabel(string = 3, label = "G"),
                StringLabel(string = 4, label = "D"),
                StringLabel(string = 5, label = "A"),
                StringLabel(string = 6, label = "E")))

        /**
         * A [ChordChart] representing a four string ukelele in standard tuning (C). This is a
         * convenience property for a common [ChordChart].
         *
         * @author chRyNaN
         */
        val STANDARD_TUNING_UKELELE = ChordChart(stringLabels = setOf(
                StringLabel(string = 1, label = "A"),
                StringLabel(string = 2, label = "E"),
                StringLabel(string = 3, label = "C"),
                StringLabel(string = 4, label = "G")))

        /**
         * A [ChordChart] representing a five string banjo in standard tuning (G). This is a
         * convenience property for a common [ChordChart].
         *
         * @author chRyNaN
         */
        val STANDARD_TUNING_BANJO = ChordChart(stringLabels = setOf(
                StringLabel(string = 1, label = "d"),
                StringLabel(string = 2, label = "B"),
                StringLabel(string = 3, label = "g"),
                StringLabel(string = 4, label = "D"),
                StringLabel(string = 5, label = "G")))
    }
}