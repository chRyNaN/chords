package com.chrynan.chords.exception

import com.chrynan.chords.parser.ChordProParser

/**
 * An exception that occurred during the parsing of an input in a [ChordProParser].
 *
 * @author chRyNaN
 */
class ChordProParseException(message: String) : RuntimeException(message)