@file:Suppress("unused")

package com.chrynan.chords.formatter

import com.chrynan.chords.parser.Parser

/**
 * A generic interface to format a type of [IN] to an output of type [OUT]. This differs from the [Parser] interface in
 * that this [Formatter] interface is meant to format an object to an output type. Whereas, the [Parser] interface is
 * meant to parse an input type into a usable object type.
 *
 * @author chRyNaN
 */
interface Formatter<IN, OUT> {

    /**
     * Formats the provided input type of [IN] and returns the output type of [OUT]. If an exception is encountered
     * during the formatting process, then that exception will be thrown. If you would rather catch the exception and
     * have null returned, use the [formatOrNull] function instead.
     *
     * @author chRyNaN
     */
    suspend fun format(input: IN): OUT

    /**
     * Formats the provided input of type [IN] and returns the output of type [OUT]. If an exception is encountered
     * during the formatting process, then that exception will be caught and null will be returned. If you would rather
     * handle the exception, then use the [format] function instead.
     *
     * @author chRyNaN
     */
    suspend fun formatOrNull(input: IN): OUT? = try {
        format(input)
    } catch (throwable: Throwable) {
        null
    }
}
