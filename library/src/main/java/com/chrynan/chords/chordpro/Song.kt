package com.chrynan.chords.chordpro

data class Song(
        val title: String? = null,
        val subtitle: String? = null,
        val artists: List<String> = emptyList(),
        val composers: List<String> = emptyList(),
        val lyricists: List<String> = emptyList(),
        val copyright: String? = null,
        val albums: List<String> = emptyList(),
        val year: Long? = null,
        val key: String? = null,
        val tempo: Long? = null,
        val duration: String? = null,
        val capo: Int? = null
)