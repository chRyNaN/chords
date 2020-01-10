package com.chrynan.guitarchords.model

data class Chord(
        val name: String? = null,
        val markers: Set<ChordMarker>
) {

    val notes: Set<ChordMarker.Note> by lazy { markers.filterIsInstance<ChordMarker.Note>().toSet() }

    val bars: Set<ChordMarker.Bar> by lazy { markers.filterIsInstance<ChordMarker.Bar>().toSet() }

    val opens: Set<ChordMarker.Open> by lazy { markers.filterIsInstance<ChordMarker.Open>().toSet() }

    val mutes: Set<ChordMarker.Muted> by lazy { markers.filterIsInstance<ChordMarker.Muted>().toSet() }
}