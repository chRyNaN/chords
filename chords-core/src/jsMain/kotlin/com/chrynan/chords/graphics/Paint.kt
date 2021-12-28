@file:Suppress("unused")

package com.chrynan.chords.graphics

import com.chrynan.colors.Color
import org.w3c.dom.*

/**
 * A convenience class that holds information about how to draw on a [HTMLCanvasElement].
 *
 * @author chRyNaN
 */
@OptIn(ExperimentalUnsignedTypes::class)
data class Paint(
    var style: Style = Style.FILL,
    var fillColor: Color = Color.Black,
    var strokeColor: Color = Color.Black,
    var textAlign: Align = Align.CENTER,
    var textSize: Double = 0.0,
    var fontName: String = DEFAULT_FONT_NAME,
    var fillRule: FillRule = FillRule.EVEN_ODD,
    var strokeWidth: Double = 0.0,
    var strokeCap: Cap = Cap.BUTT
) {

    val font: String
        get() = "${textSize.toInt()}px $validFontName"

    val isFill: Boolean
        get() = (style == Style.FILL) or (style == Style.FILL_AND_STROKE)

    val isStroke: Boolean
        get() = (style == Style.STROKE) or (style == Style.FILL_AND_STROKE)

    private val validFontName: String
        get() = if (fontName.isBlank()) DEFAULT_FONT_NAME else fontName

    enum class Style {
        FILL,
        STROKE,
        FILL_AND_STROKE
    }

    companion object {

        private const val DEFAULT_FONT_NAME = "arial"
    }

    enum class Align(val canvasTextAlign: CanvasTextAlign) {

        START(canvasTextAlign = CanvasTextAlign.START),
        END(canvasTextAlign = CanvasTextAlign.END),
        LEFT(canvasTextAlign = CanvasTextAlign.LEFT),
        RIGHT(canvasTextAlign = CanvasTextAlign.RIGHT),
        CENTER(canvasTextAlign = CanvasTextAlign.CENTER)
    }

    enum class Cap(val canvasLineCap: CanvasLineCap) {

        BUTT(canvasLineCap = CanvasLineCap.BUTT),
        ROUND(canvasLineCap = CanvasLineCap.ROUND),
        SQUARE(canvasLineCap = CanvasLineCap.SQUARE)
    }

    enum class FillRule(val canvasFillRule: CanvasFillRule) {

        EVEN_ODD(canvasFillRule = CanvasFillRule.EVENODD),
        NON_ZERO(canvasFillRule = CanvasFillRule.NONZERO)
    }
}