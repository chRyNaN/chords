package com.chrynan.chords.parser

import com.chrynan.chords.exception.ChordProParseException
import com.chrynan.chords.model.*

/**
 * An implementation of a [ChordParser] that parses a [String] in the ChordPro "define" and "chord"
 * directives format and returns a [ChordParseResult]. For more information about the ChordPro
 * format, refer to the documentation:
 * https://www.chordpro.org/chordpro/index.html
 *
 * Examples of supported input formats include:
 *     {define: Bes base-fret 1 frets 1 1 3 3 3 1 fingers 1 1 2 3 4 1}
 *     {define: As  base-fret 4 frets 1 3 3 2 1 1 fingers 1 3 4 2 1 1}
 *     {chord: Am}
 *     {chord: Bes base-fret 1 frets 1 1 3 3 3 1 fingers 1 1 2 3 4 1}
 *     {chord: As  base-fret 4 frets 1 3 3 2 1 1 fingers 1 3 4 2 1 1}
 *
 * @author chRyNaN
 */
class ChordProParser : ChordParser<String> {

    companion object {

        private const val COLON = ':'
        private const val DEFINE = "define"
        private const val CHORD = "chord"
        private const val BASE_FRET = "base-fret"
        private const val FRETS = "frets"
        private const val FINGERS = "fingers"

        private val OPEN_STRING_DELIMITERS = setOf("0", "o", "O")
        private val MUTED_STRING_DELIMITERS = setOf("N", "n", "X", "x")
    }

    // This is probably not the most optimized implementation
    override suspend fun parse(input: String): ChordParseResult {
        val formattedInput = input.removeSurrounding(prefix = "{", suffix = "}").removeSurrounding(prefix = "[", suffix = "]")
        val containsDefine = formattedInput.contains(DEFINE, true)
        val containsChord = formattedInput.contains(CHORD, true)

        if (!containsDefine && !containsChord) throw ChordProParseException(message = "Expecting \'$DEFINE\' or \'$CHORD\' in input for ${ChordProParser::class.simpleName}.")

        val colonIndex = formattedInput.indexOf(COLON)
        val baseFretIndex = formattedInput.indexOf(BASE_FRET)
        val fretsIndex = formattedInput.indexOf(FRETS)
        val fingersIndex = formattedInput.indexOf(FINGERS)

        if (colonIndex == -1) throw ChordProParseException(message = "Expecting \':\' before Chord name in input for ${ChordProParser::class.simpleName}.")

        val name = getName(colonIndex = colonIndex, baseFretIndex = baseFretIndex, input = formattedInput)

        val stringLabels = mutableSetOf<StringLabel>()

        var baseFret: FretNumber? = null

        val chord = if (baseFretIndex != -1 && fretsIndex != -1) {
            baseFret = getBaseFret(startIndex = baseFretIndex + BASE_FRET.length, endIndex = fretsIndex, input = formattedInput)
            val fretNumbers = getFretNumbers(startIndex = fretsIndex + FRETS.length, endIndex = if (fingersIndex == -1) null else fingersIndex, input = formattedInput, baseFret = baseFret)
            val fingers = getFingers(startIndex = fingersIndex + FINGERS.length, input = formattedInput)

            if (fretNumbers.isEmpty()) throw ChordProParseException(message = "Expecting fret numbers in input for ${ChordProParser::class.simpleName}.")
            if (fingers.isNotEmpty() && fretNumbers.size != fingers.size) throw ChordProParseException(message = "Expecting included finger positions to be the same size as the fret positions for input in ${ChordProParser::class.simpleName}.")

            fretNumbers.forEachIndexed { index, _ ->
                stringLabels.add(StringLabel(string = StringNumber(index + 1), label = null))
            }

            val markers = getMarkers(frets = fretNumbers, fingers = fingers)

            Chord(name = name, markers = markers)
        } else {
            Chord(name = name, markers = emptySet())
        }

        return ChordParseResult(chord = chord, stringLabels = stringLabels, baseFret = baseFret)
    }

    private fun getName(colonIndex: Int, baseFretIndex: Int, input: String): String =
            if (baseFretIndex == -1) {
                input.substring(colonIndex).trim()
            } else {
                input.substring(colonIndex, baseFretIndex).trim()
            }

    private fun getBaseFret(startIndex: Int, endIndex: Int? = null, input: String): FretNumber {
        val end = endIndex ?: input.length

        if (startIndex >= end) throw ChordProParseException(message = "Expecting base fret in input for ${ChordProParser::class.simpleName}. End index was less than or equal to start index.")

        val baseFret = input.substring(startIndex = startIndex, endIndex = end).trim().toIntOrNull()
                ?: throw ChordProParseException(message = "Expecting base fret in input for ${ChordProParser::class.simpleName}. Base fret was not an integer.")

        return FretNumber(baseFret)
    }

    private fun getFretNumbers(startIndex: Int, endIndex: Int? = null, input: String, baseFret: FretNumber): List<FretNumber> {
        val end = endIndex ?: input.length

        if (startIndex >= end) throw ChordProParseException(message = "Expecting fret numbers in input for ${ChordProParser::class.simpleName}. End index was less than or equal to start index.")

        val stringValues = input.substring(startIndex, end).trim().split(' ')

        return stringValues.map { s ->
            // A fret number is relative to the base fret with a value of zero meaning an open string.
            // We need to convert it to an absolute value here.
            val fretInt = s.toIntOrNull()?.let { baseFret.number + (it - 1) }

            when {
                MUTED_STRING_DELIMITERS.contains(s) -> FretNumber(-1) // Using a value of -1 to indicate a muted string here
                OPEN_STRING_DELIMITERS.contains(s) -> FretNumber(0) // Using a value of 0 to indicate an open string here
                fretInt == null -> throw ChordProParseException(message = "Invalid fret number found in input for ${ChordProParser::class.simpleName}. Fret number = $fretInt")
                else -> FretNumber(fretInt)
            }
        }
    }

    private fun getFingers(startIndex: Int, endIndex: Int? = null, input: String): List<Finger> {
        val end = endIndex ?: input.length

        if (startIndex >= end) return emptyList()

        val stringValues = input.substring(startIndex, end).trim().split(' ')

        return stringValues.map {
            val fingerInt = it.toIntOrNull() ?: -1

            Finger.fromPosition(fingerInt)
        }
    }

    private fun getMarkers(frets: List<FretNumber>, fingers: List<Finger>): Set<ChordMarker> =
            frets.mapIndexed { index, fretNumber ->
                // Frets are in order starting from the lowest String in tone to the highest. This means it's opposite of
                // the actual String value.
                val stringInt = frets.size - index
                val finger = fingers.getOrNull(index) ?: Finger.UNKNOWN

                when (fretNumber.number) {
                    -1 -> ChordMarker.Muted(string = StringNumber(stringInt))
                    0 -> ChordMarker.Open(string = StringNumber(stringInt))
                    else -> ChordMarker.Note(fret = fretNumber, string = StringNumber(stringInt), finger = finger)
                }
            }.toSet()
}