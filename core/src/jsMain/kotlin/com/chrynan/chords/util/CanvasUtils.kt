package com.chrynan.chords.util

import com.chrynan.chords.graphics.Paint
import com.chrynan.chords.graphics.Rect
import org.w3c.dom.CanvasRenderingContext2D

fun CanvasRenderingContext2D.drawText(text: String, x: Double, y: Double, paint: Paint) {
    this.font = paint.font
    this.textAlign = paint.textAlign.canvasTextAlign

    if (paint.isFill) {
        this.fillStyle = paint.fillColor
        this.fillText(text, x, y)
    }

    if (paint.isStroke) {
        this.strokeStyle = paint.strokeColor
        this.lineWidth = paint.strokeWidth
        this.lineCap = paint.strokeCap.canvasLineCap
        this.strokeText(text, x, y)
    }
}

fun CanvasRenderingContext2D.drawCircle(cx: Double, cy: Double, radius: Double, paint: Paint) {
    if (paint.isFill) {
        this.beginPath()
        this.arc(cx, cy, radius, 0.0, 2 * kotlin.math.PI)
        this.fillStyle = paint.fillColor
        this.closePath()
        this.fill(paint.fillRule.canvasFillRule)
    }

    if (paint.isStroke) {
        this.beginPath()
        this.arc(cx, cy, radius, 0.0, 2 * kotlin.math.PI)
        this.strokeStyle = paint.strokeColor
        this.lineWidth = paint.strokeWidth
        this.lineCap = paint.strokeCap.canvasLineCap
        this.closePath()
        this.stroke()
    }
}

fun CanvasRenderingContext2D.drawRoundRect(left: Double, top: Double, right: Double, bottom: Double, cornerRadius: Double, paint: Paint) {
    this.beginPath()

    // Top
    this.moveTo(left + cornerRadius, top)
    this.lineTo(right - cornerRadius, top)
    this.quadraticCurveTo(right, top, right, top + cornerRadius)

    // Right
    this.lineTo(right, bottom - cornerRadius)
    this.quadraticCurveTo(right, bottom, right - cornerRadius, bottom)

    // Bottom
    this.lineTo(left + cornerRadius, bottom)
    this.quadraticCurveTo(left, bottom, left, bottom - cornerRadius)

    // Left
    this.lineTo(left, top + cornerRadius)
    this.quadraticCurveTo(left, top, left + cornerRadius, top)

    this.closePath()

    if (paint.isFill) {
        this.fillStyle = paint.fillColor
        this.fill(paint.fillRule.canvasFillRule)
    }

    if (paint.isStroke) {
        this.strokeStyle = paint.strokeColor
        this.lineWidth = paint.strokeWidth
        this.lineCap = paint.strokeCap.canvasLineCap
        this.stroke()
    }
}

fun CanvasRenderingContext2D.drawLine(rect: Rect, paint: Paint) {
    this.beginPath()
    this.moveTo(rect.left, rect.top)
    this.lineTo(rect.right, rect.bottom)
    this.closePath()

    if (paint.isFill) {
        this.fillStyle = paint.fillColor
        this.fill(paint.fillRule.canvasFillRule)
    }

    if (paint.isStroke) {
        this.strokeStyle = paint.strokeColor
        this.lineWidth = paint.strokeWidth
        this.lineCap = paint.strokeCap.canvasLineCap
        this.stroke()
    }
}

/**
 * Clears the canvas.
 *
 * Note that this does not take into account transformations that may be applied.
 *
 * @author chRyNaN
 */
fun CanvasRenderingContext2D.clear() {
    this.clearRect(0.0, 0.0, this.canvas.width.toDouble(), this.canvas.height.toDouble())
}