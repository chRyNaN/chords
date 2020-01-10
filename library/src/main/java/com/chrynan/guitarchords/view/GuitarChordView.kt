package com.chrynan.guitarchords.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.chrynan.chords.R
import com.chrynan.guitarchords.model.Chord
import kotlin.math.round

/*
 * Copyright 2020 chRyNaN
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
 * A View class to display guitar (or other stringed fretted instruments) chords as a chart.
 */
open class GuitarChordView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    var chord: Chord? = null

    var showFretNumbers = false
        set(value) {
            field = value
            invalidate()
        }
    var showFingerNumbers = false
        set(value) {
            field = value
            invalidate()
        }
    var stringCount = 6
        set(value) {
            field = value.coerceAtLeast(0)
            invalidate()
        }
    var fretStart = 0
        set(value) {
            field = value.coerceAtLeast(0)
            invalidate()
        }
    var fretEnd = 4
        set(value) {
            field = value.coerceAtLeast(0)
            invalidate()
        }
    var mutedText: String = MUTED_TEXT
        set(value) {
            field = value
            invalidate()
        }
    var openStringText: String = OPEN_STRING_TEXT
        set(value) {
            field = value
            invalidate()
        }

    var bridgeNutColor = 0
        set(value) {
            field = value
            bridgeNutPaint.color = value
            invalidate()
        }
    var fretMarkerColor = 0
        set(value) {
            field = value
            fretMarkerPaint.color = value
            invalidate()
        }
    var stringColor = 0
        set(value) {
            field = value
            stringPaint.color = value
            invalidate()
        }
    var fretNumberColor = 0
        set(value) {
            field = value
            fretNumberPaint.color = value
            invalidate()
        }
    var stringMarkerColor = 0
        set(value) {
            field = value
            stringMarkerPaint.color = value
            invalidate()
        }
    var noteColor = 0
        set(value) {
            field = value
            notePaint.color = value
            invalidate()
        }
    var noteNumberColor = 0
        set(value) {
            field = value
            noteNumberPaint.color = value
            invalidate()
        }
    var barLineColor = 0
        set(value) {
            field = value
            barLinePaint.color = value
            invalidate()
        }

    private val bridgeNutPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.BUTT
    }
    private val fretMarkerPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
    }
    private val stringPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.BUTT
    }
    private val fretNumberPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
    }
    private val stringMarkerPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
    }
    private val notePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val noteNumberPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
    }
    private val barLinePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
    }

    private val drawingBounds = RectF()
    private val stringMarkerBounds = RectF()
    private val fretNumberBounds = RectF()

    private val barLinePath = Path()

    private var fretSize = 0f //y value = 0
    private var stringDistance = 0f //x value = 0f

    private var bridgeNutSize = 0f
        set(value) {
            field = value
            bridgeNutPaint.strokeWidth = value
        }
    private var fretMarkerSize = 0f
        set(value) {
            field = value
            fretMarkerPaint.strokeWidth = value
        }
    private var stringSize = 0f
        set(value) {
            field = value
            stringPaint.strokeWidth = value
            barLinePaint.strokeWidth = 2 * value
        }
    private var fretNumberSize = 0f
        set(value) {
            field = value
            fretNumberPaint.textSize = value
        }
    private var stringMarkerSize = 0f
        set(value) {
            field = value
            stringMarkerPaint.textSize = value
        }
    private var noteSize = 0f
        set(value) {
            field = value
            notePaint.strokeWidth = value
        }
    private var noteNumberSize = 0f
        set(value) {
            field = value
            noteNumberPaint.textSize = value
        }

    init {
        if (attrs != null) {
            val a = getContext().theme.obtainStyledAttributes(attrs, R.styleable.GuitarChordView, 0, 0)

            try {
                bridgeNutColor = a.getColor(R.styleable.GuitarChordView_bridgeNutColor, DEFAULT_COLOR)
                fretMarkerColor = a.getColor(R.styleable.GuitarChordView_fretMarkerColor, DEFAULT_COLOR)
                stringColor = a.getColor(R.styleable.GuitarChordView_stringColor, DEFAULT_COLOR)
                fretNumberColor = a.getColor(R.styleable.GuitarChordView_fretNumberColor, DEFAULT_COLOR)
                stringMarkerColor = a.getColor(R.styleable.GuitarChordView_stringMarkerColor, DEFAULT_COLOR)
                noteColor = a.getColor(R.styleable.GuitarChordView_noteColor, DEFAULT_COLOR)
                noteNumberColor = a.getColor(R.styleable.GuitarChordView_noteNumberColor, WHITE)
                barLineColor = a.getColor(R.styleable.GuitarChordView_barLineColor, DEFAULT_COLOR)

                mutedText = a.getString(R.styleable.GuitarChordView_mutedText) ?: MUTED_TEXT

                openStringText = a.getString(R.styleable.GuitarChordView_openStringText) ?: OPEN_STRING_TEXT

                stringCount = a.getInt(R.styleable.GuitarChordView_stringAmount, 6)

                showFingerNumbers = a.getBoolean(R.styleable.GuitarChordView_showFingerNumbers, true)
                showFretNumbers = a.getBoolean(R.styleable.GuitarChordView_showFretNumbers, true)
            } finally {
                a.recycle()
            }
        }
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) { //TODO adjust lowest and highest notes to be within the draw bounds (notes on 1st and 6th string exceed draw bounds by half
//the note size)
        var aWidth = width.toFloat() - (paddingLeft + paddingRight).toFloat()
        var aHeight = width.toFloat() - (paddingTop + paddingBottom).toFloat()
        val pWidth = aWidth
        val pHeight = aHeight
        val w = aHeight * (2f / 3f)

        if (w <= aWidth) {
            aWidth = w
        } else {
            aHeight = 3 * (aWidth / 2)
        }

        //Center everything
        drawingBounds.set(
                (pWidth - aWidth) / 2,
                (pHeight - aHeight) / 2,
                (pWidth - aWidth) / 2 + aWidth,
                (pHeight - aHeight) / 2 + aHeight)

        if (showFretNumbers) {
            fretNumberSize = (aWidth / (stringCount + 1) * (3f / 4f))
            stringMarkerSize = fretNumberSize
            stringDistance = (aWidth - (fretNumberSize + fretNumberSize / 2)) / stringCount
        } else {
            fretNumberSize = 0f
            stringMarkerSize = (aWidth / (stringCount + 1) * (3f / 4f))
            stringDistance = aWidth / stringCount
        }

        stringSize = stringDistance / stringCount
        stringSize = if (stringSize < 1f) 1f else stringSize
        fretMarkerSize = stringSize
        bridgeNutSize = 3 * stringSize
        noteSize = stringDistance
        noteNumberSize = (noteSize * (3f / 4f))

        //TODO need to take into account whether or not to show bridgeNut
        val fretCount = fretEnd - fretStart
        fretSize = round(((aHeight - (fretNumberSize + fretNumberSize / 2) - (fretCount + 1) * fretMarkerSize) / fretCount))

        if (showFretNumbers) {
            stringMarkerBounds.set(
                    drawingBounds.left + (fretNumberSize + fretNumberSize / 2),
                    drawingBounds.top,
                    drawingBounds.right,
                    drawingBounds.top + (stringMarkerSize + stringMarkerSize / 2))

            fretNumberBounds.set(
                    drawingBounds.left,
                    stringMarkerBounds.bottom,
                    drawingBounds.left + (fretNumberSize + fretNumberSize / 2),
                    drawingBounds.bottom)
        } else {
            stringMarkerBounds.set(
                    drawingBounds.left,
                    drawingBounds.top,
                    drawingBounds.right,
                    drawingBounds.top + (stringMarkerSize + stringMarkerSize / 2))

            fretNumberBounds.set(0f, 0f, 0f, 0f)
        }
    }

    override fun onDraw(canvas: Canvas) {
        //This method handles a lot of work, possibly too much for an onDraw method, but since I'm not animating
        //or updating the view often, it should be capable of performing the tasks without too much effort.
        //I can optimize this later.

        //First draw the strings and fret markers
        drawFrets(canvas)
        drawStrings(canvas)

        //Next draw the fret numbers and string markers
        drawFretNumbers(canvas)
        drawStringMarkers(canvas)

        //Finally, draw all the notes and the note text
        drawBars(canvas)
        drawNotes(canvas)
    }

    private fun drawFrets(canvas: Canvas) {
        //Fret markers; not worrying about whether or not to show the bridge nut now (since that wasn't calculated
        //in to the drawing size)
        //TODO need to take into account whether or not to show bridgeNut
        val fretCount = fretEnd - fretStart

        for (i in 0 until fretCount + 1) {
            canvas.drawLine(drawingBounds.left + fretNumberBounds.width(),
                    drawingBounds.top + stringMarkerBounds.height() + i * fretSize + i * fretMarkerSize,
                    drawingBounds.right - stringSize,
                    drawingBounds.top + stringMarkerBounds.height() + i * fretSize + i * fretMarkerSize,
                    fretMarkerPaint)
        }
    }

    private fun drawStrings(canvas: Canvas) {
        //Strings
        for (i in 0 until stringCount) {
            canvas.drawLine(stringMarkerBounds.left + i * stringDistance + i * stringSize,
                    drawingBounds.top + stringMarkerBounds.height(),
                    stringMarkerBounds.left + i * stringDistance + i * stringSize,
                    drawingBounds.bottom - fretMarkerSize,
                    stringPaint)
        }
    }

    private fun drawFretNumbers(canvas: Canvas) {
        //Fret numbers; check if we are showing them or not
        if (showFretNumbers) {
            val fretCount = fretEnd - fretStart

            for (i in 0 until fretCount) {
                canvas.drawText((i + 1).toString(),
                        drawingBounds.left + fretNumberBounds.width() / 2,
                        getVerticalCenterTextPosition(stringMarkerBounds.bottom + i * fretMarkerSize + i * fretSize + fretSize / 2, (i + 1).toString(), fretNumberPaint),
                        fretNumberPaint)
            }
        }
    }

    private fun drawStringMarkers(canvas: Canvas) {
        //String markers
        chord?.mutes?.forEachIndexed { i, _ ->
            val x = drawingBounds.left + fretNumberBounds.width() + (stringCount - i) * stringDistance + (stringCount - i) * stringSize
            val y = getVerticalCenterTextPosition(drawingBounds.top + stringMarkerBounds.height() / 2,
                    mutedText,
                    stringMarkerPaint)

            canvas.drawText(mutedText, x, y, stringMarkerPaint)
        }

        chord?.opens?.forEachIndexed { i, _ ->
            val x = drawingBounds.left + fretNumberBounds.width() + (stringCount - i) * stringDistance + (stringCount - i) * stringSize
            val y = getVerticalCenterTextPosition(drawingBounds.top + stringMarkerBounds.height() / 2, openStringText, stringMarkerPaint)

            canvas.drawText(openStringText, x, y, stringMarkerPaint)
        }
    }

    private fun drawBars(canvas: Canvas) {
        //Bars
        chord?.bars?.forEach { bar ->
            val startCenterX = drawingBounds.left + fretNumberBounds.width() + (stringCount - bar.startString.number) * stringDistance +
                    (stringCount - bar.startString.number) * stringSize
            val startCenterY = stringMarkerBounds.bottom + (bar.fretNumber.number * fretSize + bar.fretNumber.number * fretMarkerSize - fretSize / 2)

            val endCenterX = drawingBounds.left + fretNumberBounds.width() + (stringCount - bar.endString.number) * stringDistance +
                    (stringCount - bar.endString.number) * stringSize

            canvas.drawCircle(startCenterX, startCenterY, noteSize / 2.toFloat(), notePaint)
            canvas.drawCircle(endCenterX, startCenterY, noteSize / 2.toFloat(), notePaint)

            if (showFingerNumbers) {
                canvas.drawText(bar.finger.toString(), startCenterX,
                        getVerticalCenterTextPosition(startCenterY, bar.finger.toString(), noteNumberPaint), noteNumberPaint)
                canvas.drawText(bar.finger.toString(), endCenterX,
                        getVerticalCenterTextPosition(startCenterY, bar.finger.toString(), noteNumberPaint), noteNumberPaint)
            }

            barLinePath.reset()
            barLinePath.moveTo(startCenterX, startCenterY - noteSize / 2)
            barLinePath.quadTo((startCenterX + endCenterX) / 2,
                    (startCenterY + startCenterY - noteSize / 2) / 4,
                    endCenterX, startCenterY - noteSize / 2)

            canvas.drawPath(barLinePath, barLinePaint)
        }
    }

    private fun drawNotes(canvas: Canvas) {
        //Individual notes
        chord?.notes?.forEach {
            val startCenterX = drawingBounds.left + fretNumberBounds.width() + (stringCount - it.string.number) * stringDistance +
                    (stringCount - it.string.number) * stringSize
            val startCenterY = stringMarkerBounds.bottom + (it.fretNumber.number * fretSize + it.fretNumber.number * fretMarkerSize - fretSize / 2)

            canvas.drawCircle(startCenterX, startCenterY, noteSize / 2.toFloat(), notePaint)

            if (showFingerNumbers) {
                canvas.drawText(it.finger.toString(), startCenterX,
                        getVerticalCenterTextPosition(startCenterY, it.finger.toString(), noteNumberPaint), noteNumberPaint)
            }
        }
    }

    private fun getVerticalCenterTextPosition(originalYPosition: Float, text: String?, textPaint: Paint): Float {
        val bounds = Rect()
        textPaint.getTextBounds(text, 0, text!!.length, bounds)

        return originalYPosition + bounds.height() / 2
    }

    companion object {

        private const val DEFAULT_COLOR = Color.BLACK
        private const val WHITE = Color.WHITE

        private const val MUTED_TEXT = "X"
        private const val OPEN_STRING_TEXT = "O"
    }
}
