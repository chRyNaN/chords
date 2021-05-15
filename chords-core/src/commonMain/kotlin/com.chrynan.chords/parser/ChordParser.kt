package com.chrynan.chords.parser

import com.chrynan.chords.model.Chord
import com.chrynan.chords.model.ChordParseResult

/**
 * An interface that parses an input into a [Chord] wrapped in a [ChordParseResult].
 *
 * @author chRyNaN
 */
interface ChordParser<T> : Parser<T, ChordParseResult>