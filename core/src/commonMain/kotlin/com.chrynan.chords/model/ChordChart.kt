package com.chrynan.chords.model

data class ChordChart(
        val fretStart: FretNumber = DEFAULT_FRET_START,
        val fretEnd: FretNumber = DEFAULT_FRET_END,
        val stringCount: Int = DEFAULT_GUITAR_STRING_COUNT,
        val stringLabels: Set<StringLabel> = emptySet()
) {

    companion object {

        const val DEFAULT_GUITAR_STRING_COUNT = 6
        const val DEFAULT_UKELEL_STRING_COUNT = 4
        const val DEFAULT_BANJO_STRING_COUNT = 5

        val DEFAULT_FRET_START = FretNumber(1)
        val DEFAULT_FRET_END = FretNumber(3)

        /**
         * A [ChordChart] representing a six string guitar in standard tuning. This is a
         * convenience property for a common [ChordChart].
         *
         * @author chRyNaN
         */
        val STANDARD_TUNING_GUITAR_CHART = ChordChart(
                stringCount = DEFAULT_GUITAR_STRING_COUNT,
                stringLabels = setOf(
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
        val STANDARD_TUNING_UKELELE = ChordChart(
                stringCount = DEFAULT_UKELEL_STRING_COUNT,
                stringLabels = setOf(
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
        val STANDARD_TUNING_BANJO = ChordChart(
                stringCount = DEFAULT_BANJO_STRING_COUNT,
                stringLabels = setOf(
                        StringLabel(string = 1, label = "d"),
                        StringLabel(string = 2, label = "B"),
                        StringLabel(string = 3, label = "g"),
                        StringLabel(string = 4, label = "D"),
                        StringLabel(string = 5, label = "G")))
    }
}