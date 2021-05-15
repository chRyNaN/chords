@file:Suppress("unused")

package com.chrynan.chords.parser

import com.chrynan.chords.model.Chord
import com.chrynan.chords.model.ChordParseResult
import kotlinx.serialization.json.Json

/**
 * Parses a JSON String representation of a [Chord] model. This uses the [Chord] classes serializer information to
 * parse, or deserialize, the JSON String, along with the provided [json] object (which defaults to the default [Json]
 * instance).
 */
class JsonStringChordParser(private val json: Json = Json) : ChordParser<String> {

    override suspend fun parse(input: String): ChordParseResult {
        val chord = json.decodeFromString(Chord.serializer(), input)

        return ChordParseResult(chord = chord)
    }
}
