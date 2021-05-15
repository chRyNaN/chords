@file:Suppress("unused")

package com.chrynan.chords.formatter

import com.chrynan.chords.model.Chord
import kotlinx.serialization.json.Json

/**
 * Formats a [Chord] model into a JSON String representation. This uses the [Chord] classes serializer information to
 * format, or serialize, into a JSON String, along with the provided [json] object (which defaults to the default
 * [Json] instance).
 */
class JsonStringChordFormatter(private val json: Json = Json) : ChordFormatter<String> {

    override suspend fun format(input: Chord): String = json.encodeToString(Chord.serializer(), input)
}
