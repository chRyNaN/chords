package com.chrynan.chords.parser

import com.chrynan.chords.exception.AsciiChordParseException
import com.chrynan.chords.model.*
import com.chrynan.chords.util.isDigit

/**
 * Parses a simple ASCII Chord Diagram String into a [Chord]. This [ChordParser] handles String
 * inputs in the following format:
 *
 *         C
 * e |-----0------|
 * B |-----1------|
 * G |-----0------|
 * D |-----2------|
 * A |-----3------|
 * E |------------|
 *
 * - Whitespace will be trimmed.
 * - The first line may contain an optional chord name.
 * ---- If there is a chord name present, the whole line will be used as the chord name.
 * ---- If there are any [tabDelimiters] on the chord name line, it will be considered a 'normal'
 *      line.
 * - Each following line will be processed as a [StringNumber].
 * ---- The first line will be the first [StringNumber] (1) and the numbers will increase for
 *      subsequent lines.
 * ---- Lines may begin with an optional label before any [tabDelimiters] or Frets.
 * ---- All [Int]s on a line after the first [tabDelimiters], and separated by [tabDelimiters],
 *      will be considered the [FretNumbers] for [ChordMarker.Note]s.
 * ---- The absence of an [Int] on a line, will be considered a muted line or a line that should
 *      not be played.
 * ---- If an [Int] value of zero is found on a line, then that String is considered "open".
 * -- If the input [String] is blank, null will be returned.
 * -- If the [tabDelimiters] is empty, null will be returned.
 *
 * @param [tabDelimiters] The [Set] of [String] delimiters used to separate the optional label and
 *        fret numbers (Ex: "|" and "-"). This set cannot be empty.
 *
 * @author chRyNaN
 */
class AsciiChordParser(private val tabDelimiters: Set<Char> = setOf('|', '-')) : ChordParser<String> {

    override suspend fun parse(input: String): ChordParseResult {
        if (tabDelimiters.isEmpty()) throw AsciiChordParseException(message = "Tab delimiters must not be empty for ${AsciiChordParser::class.simpleName}.")

        val trimmedInput = input.trim()
        if (trimmedInput.isBlank()) throw AsciiChordParseException(message = "Input must not be empty or blank for ${AsciiChordParser::class.simpleName}.")

        val lines = trimmedInput.lines()

        val firstLine = lines.first()

        val firstLineContainsDelimiters = tabDelimiters.any { it in firstLine }

        val name = if (firstLineContainsDelimiters) null else firstLine

        val linesToParse = if (firstLineContainsDelimiters) lines else lines.subList(1, lines.size)

        val chordStringMarkers =
                linesToParse.asSequence()
                        .mapIndexed { index, line ->
                            line.parseLineAsString(stringNumber = index + 1, tabDelimiters = tabDelimiters)
                        }

        val markers = chordStringMarkers.map { it.markers }
                .flatten()
                .toSet()

        val labels = chordStringMarkers.map { it.label }
                .toSet()

        return ChordParseResult(chord = Chord(name = name, markers = markers), stringLabels = labels)
    }

    private fun String.parseLineAsString(stringNumber: Int, tabDelimiters: Set<Char>): ChordStringMarker {
        val labelStringBuilder = StringBuilder()
        val fretStringBuilder = StringBuilder()
        val frets = mutableSetOf<Int>()

        var reachedFirstTabDelimiter = false

        for (char in this) {
            val isTabDelimiter = tabDelimiters.contains(char)

            when {
                !reachedFirstTabDelimiter and !isTabDelimiter -> labelStringBuilder.append(char)
                !reachedFirstTabDelimiter and isTabDelimiter -> reachedFirstTabDelimiter = true
                reachedFirstTabDelimiter and fretStringBuilder.isNotBlank() and !char.isDigit() -> {
                    frets.add(fretStringBuilder.toString().toInt())
                    fretStringBuilder.clear()
                }
                reachedFirstTabDelimiter and char.isDigit() -> fretStringBuilder.append(char)
            }
        }

        val label = if (labelStringBuilder.isBlank()) null else labelStringBuilder.toString()

        val markers: List<ChordMarker> = when {
            frets.isEmpty() -> listOf(ChordMarker.Muted(StringNumber(stringNumber)))
            frets.contains(0) -> listOf(ChordMarker.Open(StringNumber(stringNumber)))
            else -> frets.map {
                ChordMarker.Note(fret = FretNumber(it), string = StringNumber(stringNumber))
            }
        }

        return ChordStringMarker(
                label = StringLabel(string = StringNumber(stringNumber), label = label),
                markers = markers)
    }

    private data class ChordStringMarker(
            val label: StringLabel,
            val markers: List<ChordMarker>
    )
}