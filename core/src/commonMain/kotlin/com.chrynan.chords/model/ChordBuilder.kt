package com.chrynan.chords.model

class ChordBuilder(private val name: String? = null) {

    private val markers = mutableSetOf<ChordMarker>()

    operator fun ChordMarker.unaryPlus() {
        markers.add(this)
    }

    internal fun build(): com.chrynan.chords.model.Chord = com.chrynan.chords.model.Chord(
            name = name,
            markers = markers)
}


fun chord(name: String? = null, builder: ChordBuilder.() -> Unit): com.chrynan.chords.model.Chord {
    val chordBuilder = ChordBuilder(name = name)
    builder.invoke(chordBuilder)
    return chordBuilder.build()
}