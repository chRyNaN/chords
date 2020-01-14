package com.chrynan.chords.parser

import com.chrynan.chords.model.Chord

/**
 * An interface that parses an input into a [Chord].
 */
interface ChordParser<T> {

    suspend fun parse(item: T): Chord?
}