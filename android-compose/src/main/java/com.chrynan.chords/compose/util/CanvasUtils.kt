package com.chrynan.chords.compose.util

import androidx.ui.engine.geometry.Offset
import androidx.ui.engine.geometry.RRect
import androidx.ui.engine.geometry.Rect
import androidx.ui.graphics.Canvas
import androidx.ui.graphics.Paint

fun Canvas.drawLine(rect: Rect, paint: Paint) {
    val start = Offset(rect.left, rect.top)
    val stop = Offset(rect.right, rect.bottom)

    drawLine(p1 = start, p2 = stop, paint = paint)
}

fun Canvas.drawCircle(x: Float, y: Float, radius: Float, paint: Paint) {
    val offset = Offset(x, y)

    drawCircle(center = offset, radius = radius, paint = paint)
}

fun Canvas.drawRoundRect(left: Float, top: Float, right: Float, bottom: Float, rx: Float, ry: Float, paint: Paint) {
    val rect = RRect(left = left, top = top, right = right, bottom = bottom, radiusX = rx, radiusY = ry)

    drawRRect(rrect = rect, paint = paint)
}