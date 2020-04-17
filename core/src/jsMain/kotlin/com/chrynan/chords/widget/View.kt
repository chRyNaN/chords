package com.chrynan.chords.widget

import com.chrynan.chords.exception.InvalidCanvasContextException
import com.chrynan.chords.graphics.Paint
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement

/**
 * A base Widget View for Javascript, mimicking some of the functionality of an Android View.
 *
 * @author chRyNaN
 */
abstract class View {

    abstract val canvas: HTMLCanvasElement

    var paddingLeft: Double = 0.0
    var paddingTop: Double = 0.0
    var paddingRight: Double = 0.0
    var paddingBottom: Double = 0.0

    val width: Int
        get() = canvas.width

    val height: Int
        get() = canvas.height

    private val context: CanvasRenderingContext2D by lazy {
        canvas.getContext("2d") as? CanvasRenderingContext2D
                ?: throw InvalidCanvasContextException("Invalid Canvas Context Name.")
    }

    protected abstract fun onMeasure(width: Int, height: Int)

    protected abstract fun onDraw(context: CanvasRenderingContext2D)

    /**
     * This function invokes a layout pass to occur. This will invoke the [onMeasure] and [onDraw] functions.
     *
     * Call this function after creating an instance of a [View], when you are ready for the [View] to be rendered.
     *
     * Note that this function is invoked on the calling thread and coroutine.
     *
     * @author chRyNaN
     */
    fun render() {
        requestLayout()
        invalidate()
    }

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

    protected fun getVerticalCenterTextPosition(originalYPosition: Double, text: String?, textPaint: Paint): Double {
        if (text == null) return 0.0

        val currentFont = context.font

        context.font = textPaint.font

        val metrics = context.measureText(text)
        val actualHeight = metrics.actualBoundingBoxAscent + metrics.actualBoundingBoxDescent

        context.font = currentFont

        return originalYPosition + actualHeight / 2
    }
}