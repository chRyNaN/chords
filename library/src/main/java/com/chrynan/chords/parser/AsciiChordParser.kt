package com.chrynan.chords.parser

import com.chrynan.chords.model.Chord
import com.chrynan.chords.model.ChordMarker
import com.chrynan.chords.model.ChordString
import com.chrynan.chords.model.FretNumber

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
 * - Each following line will be processed as a [ChordString].
 * ---- The first line will be the first [ChordString] (1) and the numbers will increase for
 *      subsequent lines.
 * ---- Lines may begin with an optional label before any [tabDelimiters] or [FretNumber]s.
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
 */
class AsciiChordParser(private val tabDelimiters: Set<Char>) : ChordParser<String> {

    override suspend fun parse(item: String): Chord? {
        if (tabDelimiters.isEmpty()) return null

        val trimmedInput = item.trim()
        if (trimmedInput.isBlank()) return null

        val lines = trimmedInput.lines()

        val firstLine = lines.first()

        val firstLineContainsDelimiters = tabDelimiters.any { it in firstLine }

        val name = if (firstLineContainsDelimiters) null else firstLine

        val linesToParse = if (firstLineContainsDelimiters) lines else lines.subList(1, lines.size)

        val markers =
                linesToParse.asSequence()
                        .mapIndexed { index, line ->
                            line.parseLineAsString(stringNumber = index + 1, tabDelimiters = tabDelimiters)
                        }
                        .flatten()
                        .toSet()

        return Chord(name = name, markers = markers)
    }

    private fun String.parseLineAsString(stringNumber: Int, tabDelimiters: Set<Char>): List<ChordMarker> {
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

        return when {
            frets.isEmpty() -> listOf(ChordMarker.Muted(ChordString(stringNumber, label)))
            frets.contains(0) -> listOf(ChordMarker.Open(ChordString(stringNumber, label)))
            else -> frets.map {
                ChordMarker.Note(fretNumber = FretNumber(it), string = ChordString(stringNumber, label))
            }
        }
    }
}