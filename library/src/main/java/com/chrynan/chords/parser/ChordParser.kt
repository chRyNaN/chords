package com.chrynan.chords.parser

import com.chrynan.chords.model.Chord

interface ChordParser<T> {

    fun parse(item: T): Chord
}