package com.chrynan.chords.model

/**
 * A DSL Builder class for creating a [Chord]. Use the [chord] function to obtain an instance of
 * this class. This allows the creation of a [Chord] using a Kotlin DSL. For example:
 *
 * chord {
 *     +ChordMarker.Open(StringNumber(1))
 * }
 *
 * @author chRyNaN
 */
class ChordBuilder internal constructor(private val name: String? = null) {

    private val markers = mutableSetOf<ChordMarker>()

    operator fun ChordMarker.unaryPlus() {
        markers.add(this)
    }

    fun add(marker: ChordMarker) {
        markers.add(marker)
    }

    internal fun build(): Chord = Chord(
        name = name,
        markers = markers
    )

    companion object
}

/**
 * The entry point into the [Chord] Kotlin DSL. This function creates a [Chord] using the
 * [ChordBuilder] class.
 *
 * @param [name] The name of the [Chord] being created.
 * @param [builder] The scoped Kotlin DSL builder used to create the [Chord].
 *
 * @author chRyNaN
 */
fun chord(name: String? = null, builder: ChordBuilder.() -> Unit): Chord {
    val chordBuilder = ChordBuilder(name = name)
    builder.invoke(chordBuilder)
    return chordBuilder.build()
}
