@file:Suppress("unused")

package com.chrynan.chords.formatter

import com.chrynan.chords.model.Chord

/**
 * An interface that formats a [Chord] into an output of type [T].
 */
interface ChordFormatter<T> : Formatter<Chord, T>
