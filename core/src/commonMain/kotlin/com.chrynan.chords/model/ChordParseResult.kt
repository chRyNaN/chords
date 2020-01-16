package com.chrynan.chords.model

data class ChordParseResult(
        val stringLabels: Set<StringLabel> = emptySet(),
        val chord: Chord? = null
)