package com.chrynan.guitarchords.parser

import com.chrynan.guitarchords.model.Chord

interface ChordParser<T> {

    fun parse(item: T): Chord
}