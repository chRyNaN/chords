package com.chrynan.chords.util

private val DIGIT_CHARS = setOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

/**
 * Returns true if this character (Unicode code point) is a digit.
 *
 * Note: I had to explicitly create this function because this is not part of the Kotlin Common Standard Utils.
 */
fun Char.isDigit(): Boolean = DIGIT_CHARS.contains(this)