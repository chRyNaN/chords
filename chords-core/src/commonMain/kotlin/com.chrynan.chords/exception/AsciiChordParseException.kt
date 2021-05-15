package com.chrynan.chords.exception

import com.chrynan.chords.parser.AsciiChordParser

/**
 * An exception that occurred during the parsing of an input in a [AsciiChordParser].
 *
 * @author chRyNaN
 */
class AsciiChordParseException(message: String) : RuntimeException(message)