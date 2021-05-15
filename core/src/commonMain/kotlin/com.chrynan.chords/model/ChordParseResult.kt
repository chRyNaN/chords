package com.chrynan.chords.model

import com.chrynan.chords.parser.ChordParser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A model containing information about the successful result of a [ChordParser].
 *
 * @author chRyNaN
 */
@Serializable
data class ChordParseResult(
    @SerialName(value = "chord") val chord: Chord,
    @SerialName(value = "string_labels") val stringLabels: Set<StringLabel> = emptySet(),
    @SerialName(value = "base_fret") val baseFret: FretNumber? = null
) {

    companion object
}
