package com.chrynan.chords.exception

import org.w3c.dom.RenderingContext

/**
 * An exception that is thrown when a [RenderingContext] was not able to be obtained due to an invalid context name.
 *
 * @author chRyNaN
 */
class InvalidCanvasContextException(message: String) : RuntimeException(message)