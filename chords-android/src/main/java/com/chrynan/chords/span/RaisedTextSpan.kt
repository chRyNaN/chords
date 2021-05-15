@file:Suppress("unused")

package com.chrynan.chords.span

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.text.style.ReplacementSpan

/**
 * Raises the spanned text and removes the width so that the following text can be drawn underneath it.
 *
 * For example, consider the following text: "Example". If we were to raise the letter 'p', then the output would look
 * like the following:
 * ```
 *     p
 * Examle
 * ```
 */
class RaisedTextSpan : ReplacementSpan() {

    private val textBounds = Rect()

    override fun getSize(paint: Paint, text: CharSequence?, start: Int, end: Int, fm: Paint.FontMetricsInt?): Int {
        if (fm != null && text != null) {
            paint.getTextBounds(text.toString(), start, end, textBounds)

            fm.top = fm.top - textBounds.height()
        }

        return 0
    }

    override fun draw(
        canvas: Canvas,
        text: CharSequence?,
        start: Int,
        end: Int,
        x: Float,
        top: Int,
        y: Int,
        bottom: Int,
        paint: Paint
    ) {
        if (text != null) {
            val spannedText = text.substring(start, end)
            canvas.drawText(spannedText, x, top.toFloat() + (textBounds.height() * 1.5f), paint)
        }
    }
}
