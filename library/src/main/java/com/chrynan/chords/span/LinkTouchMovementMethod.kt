package com.chrynan.chords.span

import android.text.Selection
import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.view.MotionEvent
import android.widget.TextView

/*
 * Copyright 2016 chRyNaN
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * References: http://stackoverflow.com/a/7292485/1478764,
 * http://stackoverflow.com/a/20905824/1478764
 */
class LinkTouchMovementMethod : LinkMovementMethod() {

    private var pressedSpan: TouchableSpan? = null

    override fun onTouchEvent(widget: TextView, buffer: Spannable, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                pressedSpan = getPressedSpan(widget, buffer, event)

                if (pressedSpan != null) {
                    pressedSpan!!.isPressed = true
                    Selection.setSelection(buffer, buffer.getSpanStart(pressedSpan),
                            buffer.getSpanEnd(pressedSpan))
                    pressedSpan!!.onTouch(widget, event)
                }
            }
            MotionEvent.ACTION_MOVE -> {
                val touchedSpan = getPressedSpan(widget, buffer, event)

                if (pressedSpan != null && touchedSpan !== pressedSpan) {
                    pressedSpan!!.isPressed = false
                    pressedSpan = null
                    Selection.removeSelection(buffer)
                } else if (pressedSpan != null) {
                    pressedSpan!!.onTouch(widget, event)
                }
            }
            else -> {
                if (pressedSpan != null) {
                    pressedSpan!!.onTouch(widget, event)
                    pressedSpan!!.isPressed = false
                    super.onTouchEvent(widget, buffer, event)
                }

                pressedSpan = null

                Selection.removeSelection(buffer)
            }
        }

        return true
    }

    private fun getPressedSpan(textView: TextView, spannable: Spannable, event: MotionEvent): TouchableSpan? {
        var x = event.x.toInt()
        var y = event.y.toInt()

        x -= textView.totalPaddingLeft
        y -= textView.totalPaddingTop
        x += textView.scrollX
        y += textView.scrollY

        val layout = textView.layout
        val line = layout.getLineForVertical(y)
        val off = layout.getOffsetForHorizontal(line, x.toFloat())
        val link = spannable.getSpans(off, off, TouchableSpan::class.java)
        var touchedSpan: TouchableSpan? = null

        if (link.isNotEmpty()) {
            touchedSpan = link[0]
        }

        return touchedSpan
    }
}