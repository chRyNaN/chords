package com.chrynan.chords.widget

import com.chrynan.chords.exception.InvalidCanvasContextException
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement

/**
 * A base Widget View for Javascript, mimicking some of the functionality of an Android View.
 *
 * @author chRyNaN
 */
abstract class View {

    abstract val canvas: HTMLCanvasElement

    private val width: Int
        get() = canvas.width

    private val height: Int
        get() = canvas.height

    private val context: CanvasRenderingContext2D by lazy {
        canvas.getContext("2d") as? CanvasRenderingContext2D
                ?: throw InvalidCanvasContextException("Invalid Canvas Context Name.")
    }

    protected abstract fun onMeasure(width: Int, height: Int)

    protected abstract fun onDraw(context: CanvasRenderingContext2D)

    /**
     * Forces a layout pass to occur again.
     *
     * @author chRyNaN
     */
    protected fun requestLayout() {
        onMeasure(width = width, height = height)
    }

    /**
     * Forces a draw pass to occur again.
     *
     * @author chRyNaN
     */
    protected fun invalidate() {
        onDraw(context = context)
    }
}