package com.chrynan.chords.parser

import com.chrynan.chords.exception.ChordProParseException
import com.chrynan.chords.model.Chord
import com.chrynan.chords.model.ChordParseResult

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
    }

    override suspend fun parse(input: String): ChordParseResult {
        val containsDefine = input.contains(DEFINE, true)
        val containsChord = input.contains(CHORD, true)

        if (!containsDefine && !containsChord) throw ChordProParseException(message = "Expecting \'$DEFINE\' or \'$CHORD\' in input for ${ChordProParser::class.simpleName}.")

        val colonIndex = input.indexOf(COLON)
        val baseFretIndex = input.indexOf(BASE_FRET)
        val fretsIndex = input.indexOf(FRETS)
        val fingersIndex = input.indexOf(FINGERS)

        if (colonIndex == -1) throw ChordProParseException(message = "Expecting \':\' before Chord name in input for ${ChordProParser::class.simpleName}.")

        val name = getName(colonIndex = colonIndex, baseFretIndex = baseFretIndex, input = input)

        val chord = if (baseFretIndex != -1 && fretsIndex != -1) {
            TODO()
        } else {
            Chord(name = name, markers = emptySet())
        }

        return ChordParseResult(chord = chord)
    }

    private fun getName(colonIndex: Int, baseFretIndex: Int, input: String): String =
            if (baseFretIndex == -1) {
                input.substring(colonIndex).trim()
            } else {
                input.substring(colonIndex, baseFretIndex).trim()
            }

    private fun getBaseFret(baseFretIndex: Int, fingersIndex: Int, input: String): String {
        TODO()
    }
}