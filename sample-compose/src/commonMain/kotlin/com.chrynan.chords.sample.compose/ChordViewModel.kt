package com.chrynan.chords.sample.compose

import com.chrynan.chords.model.Chord

data class ChordViewModel(
    val title: String,
    val description: String? = null,
    val chord: Chord
)
