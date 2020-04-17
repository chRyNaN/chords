package com.chrynan.chords.graphics

import com.chrynan.chords.util.Color
import org.w3c.dom.*

/**
 * A convenience class that holds information about how to draw on a [HTMLCanvasElement].
 *
 * @author chRyNaN
 */
data class Paint(
        var style: Style = Style.FILL,
        var color: Color = Color.BLACK,
        var textAlign: Align = Align.CENTER,
        var textSize: Double = 0.0,
        var fontName: String = "",
        var strokeWidth: Double = 0.0
) {

    val font: String
        get() = "${textSize}px $fontName"

    enum class Style {
        FILL,
        STROKE,
        FILL_AND_STROKE
    }

    enum class Align(val canvasTextAlign: CanvasTextAlign) {

        START(canvasTextAlign = CanvasTextAlign.START),
        END(canvasTextAlign = CanvasTextAlign.END),
        LEFT(canvasTextAlign = CanvasTextAlign.LEFT),
        RIGHT(canvasTextAlign = CanvasTextAlign.RIGHT),
        CENTER(canvasTextAlign = CanvasTextAlign.CENTER)
    }
}