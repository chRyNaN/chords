package com.chrynan.chords.model

import com.chrynan.chords.parser.ChordParser

/**
 * A model containing information about the successful result of a [ChordParser].
 *
 * @author chRyNaN
 */
data class ChordParseResult(
        val stringLabels: Set<StringLabel> = emptySet(),
        val chord: Chord? = null
)