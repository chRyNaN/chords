package com.chrynan.chords.parser

/**
 * A generic interface to parse an input into an output.
 *
 * @author chRyNaN
 */
interface Parser<IN, OUT> {

    /**
     * Parses the provided input [IN] and returns the output [OUT]. If an exception is encountered
     * during the parsing process, then that exception will be thrown. If you would rather catch
     * the exception and have null return, use the [parseOrNull] function instead.
     *
     * @author chRyNaN
     */
    suspend fun parse(input: IN): OUT

    /**
     * Parses the provided input [IN] and returns the output [OUT]. If an exception is encountered
     * during the parsing process, then that exception will be caught and null will be returned. If
     * you would rather handle the exception, then use the [parse] function instead.
     *
     * @author chRyNaN
     */
    suspend fun parseOrNull(input: IN): OUT? = try {
        parse(input = input)
    } catch (throwable: Throwable) {
        null
    }
}