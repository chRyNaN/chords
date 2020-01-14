package com.chrynan.chords.parser

import com.chrynan.chords.model.Chord
import com.chrynan.chords.model.ChordChart
import com.chrynan.chords.model.ChordResult

/**
 * An interface that parses an input into a [Chord] wrapped in a [ChordResult].
 *
 * @author chRyNaN
 */
interface ChordParser<T> {

    /**
     * Parses the provided input [item] and returns a [ChordResult] which contains a [Chord] and a [ChordChart].
     *
     * @see [ChordResult]
     * @author chRyNaN
     */
    suspend fun parse(item: T): ChordResult?
}