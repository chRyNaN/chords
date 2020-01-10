package com.chrynan.guitarchords.model

interface ChordParser<T> {

    fun parse(item: T): Chord
}