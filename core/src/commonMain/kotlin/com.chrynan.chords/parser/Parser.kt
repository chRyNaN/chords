package com.chrynan.chords.parser

/**
 * A generic interface to parse an input into an output.
 *
 * @author chRyNaN
 */
interface Parser<IN, OUT> {

    /**
     * Parses the provided input [IN] and returns output [OUT].
     *
     * @author chRyNaN
     */
    suspend fun parse(input: IN): OUT
}