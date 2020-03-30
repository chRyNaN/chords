package com.chrynan.chords.model

import com.chrynan.chords.view.ChordView

/**
 * A representation of a diagram used to display a fretted string instrument Chord. This contains
 * information related to the visual diagram, such as the [fretStart] and [fretEnd].
 *
 * A chord diagram usually displays the frets as horizontal rows separated by lines (fret markers).
 * This diagram starts with the first being the [fretStart] and ends with the [fretEnd]. And a
 * chord diagram usually displays the strings as vertical columns. This diagram contains
 * [stringCount] as the amount of strings. The [stringLabels] are usually displayed at one of the
 * ends of the strings in the diagram, if they are to be drawn.
 *
 * Note that this does not contain information about the View, such as colors and text. For that
 * information, refer to the [ChordViewModel] and [ChordView] classes.
 *
 * @property [fretStart] The starting [FretNumber] of this diagram.
 * @property [fretEnd] The ending [FretNumber] of this diagram.
 * @property [stringCount] An [Int] specifying the amount of strings in this diagram.
 * @property [stringLabels] A [Set] of [StringLabel]s for each string in this diagram. The amount
 * of labels should match the [stringCount].
 *
 * @author chRyNaN
 */
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
                        StringLabel(string = StringNumber(1), label = "e"),
                        StringLabel(string = StringNumber(2), label = "B"),
                        StringLabel(string = StringNumber(3), label = "G"),
                        StringLabel(string = StringNumber(4), label = "D"),
                        StringLabel(string = StringNumber(5), label = "A"),
                        StringLabel(string = StringNumber(6), label = "E")))

        /**
         * A [ChordChart] representing a four string ukelele in standard tuning (C). This is a
         * convenience property for a common [ChordChart].
         *
         * @author chRyNaN
         */
        val STANDARD_TUNING_UKELELE = ChordChart(
                stringCount = DEFAULT_UKELEL_STRING_COUNT,
                stringLabels = setOf(
                        StringLabel(string = StringNumber(1), label = "A"),
                        StringLabel(string = StringNumber(2), label = "E"),
                        StringLabel(string = StringNumber(3), label = "C"),
                        StringLabel(string = StringNumber(4), label = "G")))

        /**
         * A [ChordChart] representing a five string banjo in standard tuning (G). This is a
         * convenience property for a common [ChordChart].
         *
         * @author chRyNaN
         */
        val STANDARD_TUNING_BANJO = ChordChart(
                stringCount = DEFAULT_BANJO_STRING_COUNT,
                stringLabels = setOf(
                        StringLabel(string = StringNumber(1), label = "d"),
                        StringLabel(string = StringNumber(2), label = "B"),
                        StringLabel(string = StringNumber(3), label = "g"),
                        StringLabel(string = StringNumber(4), label = "D"),
                        StringLabel(string = StringNumber(5), label = "G")))
    }
}