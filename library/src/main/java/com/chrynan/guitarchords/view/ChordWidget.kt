package com.chrynan.guitarchords.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.chrynan.example.R
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
class ChordWidget @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs),
        ChordView {

    override var chord: Chord? = null
        set(value) {
            field = value
            requestLayout()
            invalidate()
        }

    override var showFretNumbers = false
        set(value) {
            field = value
            invalidate()
        }
    override var showFingerNumbers = false
        set(value) {
            field = value
            invalidate()
        }
    override var stringLabelState: StringLabelState = StringLabelState.HIDE
        set(value) {
            field = value
            invalidate()
        }
    override var stringCount = DEFAULT_STRING_COUNT
        set(value) {
            field = value.coerceAtLeast(0)
            requestLayout()
            invalidate()
        }
    override var fretStart = DEFAULT_FRET_START
        set(value) {
            field = value.coerceAtLeast(1)
            requestLayout()
            invalidate()
        }
    override var fretEnd = DEFAULT_FRET_END
        set(value) {
            field = value.coerceAtLeast(1)
            requestLayout()
            invalidate()
        }
    override var mutedText: String = DEFAULT_MUTED_TEXT
        set(value) {
            field = value
            invalidate()
        }
    override var openStringText: String = DEFAULT_OPEN_TEXT
        set(value) {
            field = value
            invalidate()
        }

    override var bridgeNutColor = 0
        set(value) {
            field = value
            bridgeNutPaint.color = value
            invalidate()
        }
    override var fretMarkerColor = 0
        set(value) {
            field = value
            fretMarkerPaint.color = value
            invalidate()
        }
    override var stringColor = 0
        set(value) {
            field = value
            stringPaint.color = value
            invalidate()
        }
    override var fretNumberColor = 0
        set(value) {
            field = value
            fretNumberPaint.color = value
            invalidate()
        }
    override var stringMarkerColor = 0
        set(value) {
            field = value
            stringMarkerPaint.color = value
            invalidate()
        }
    override var noteColor = 0
        set(value) {
            field = value
            notePaint.color = value
            invalidate()
        }
    override var noteNumberColor = 0
        set(value) {
            field = value
            noteNumberPaint.color = value
            invalidate()
        }
    override var barLineColor = 0
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

    private val fretCount: Int
        get() = fretEnd - fretStart

    private val fretLineRects = mutableListOf<RectF>()
    private val stringLineRects = mutableListOf<RectF>()
    private val fretNumberPoints = mutableListOf<PointF>()
    private val notePositions = mutableListOf<NotePosition>()
    private val barLinePaths = mutableListOf<BarPosition>()
    private val stringLabelPositions = mutableListOf<StringPosition>()
    private val stringMarkerPositions = mutableListOf<StringPosition>()

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
            val a = getContext().theme.obtainStyledAttributes(attrs, R.styleable.ChordWidget, 0, 0)

            try {
                bridgeNutColor = a.getColor(R.styleable.ChordWidget_bridgeNutColor, DEFAULT_COLOR)
                fretMarkerColor = a.getColor(R.styleable.ChordWidget_fretMarkerColor, DEFAULT_COLOR)
                stringColor = a.getColor(R.styleable.ChordWidget_stringColor, DEFAULT_COLOR)
                fretNumberColor = a.getColor(R.styleable.ChordWidget_fretNumberColor, DEFAULT_COLOR)
                stringMarkerColor = a.getColor(R.styleable.ChordWidget_stringMarkerColor, DEFAULT_COLOR)
                noteColor = a.getColor(R.styleable.ChordWidget_noteColor, DEFAULT_COLOR)
                noteNumberColor = a.getColor(R.styleable.ChordWidget_noteNumberColor, WHITE)
                barLineColor = a.getColor(R.styleable.ChordWidget_barLineColor, DEFAULT_COLOR)

                mutedText = a.getString(R.styleable.ChordWidget_mutedText) ?: DEFAULT_MUTED_TEXT
                openStringText = a.getString(R.styleable.ChordWidget_openStringText) ?: DEFAULT_OPEN_TEXT

                stringCount = a.getInt(R.styleable.ChordWidget_stringAmount, DEFAULT_STRING_COUNT)
                stringLabelState = when (a.getInt(R.styleable.ChordWidget_stringLabelState, 0)) {
                    0 -> StringLabelState.SHOW_NUMBER
                    1 -> StringLabelState.SHOW_LABEL
                    else -> StringLabelState.HIDE
                }

                showFingerNumbers = a.getBoolean(R.styleable.ChordWidget_showFingerNumbers, true)
                showFretNumbers = a.getBoolean(R.styleable.ChordWidget_showFretNumbers, true)
            } finally {
                a.recycle()
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        calculateSize()
        calculateBarLinePositions()
        calculateFretNumberPositions()
        calculateFretPositions()
        calculateNotePositions()
        calculateStringMarkers()
        calculateStringPositions()
    }

    private fun calculateSize() {
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
        fretLineRects.forEach { canvas.drawLine(it, fretMarkerPaint) }
        stringLineRects.forEach { canvas.drawLine(it, stringPaint) }

        //Next draw the fret numbers and string markers
        drawFretNumbers(canvas)
        drawStringMarkers(canvas)

        //Finally, draw all the notes and the note text
        drawBars(canvas)
        drawNotes(canvas)
    }

    private fun calculateFretPositions() {
        fretLineRects.clear()

        for (i in 0..fretCount) {
            fretLineRects.add(RectF(
                    drawingBounds.left + fretNumberBounds.width(),
                    drawingBounds.top + stringMarkerBounds.height() + i * fretSize + i * fretMarkerSize,
                    drawingBounds.right - stringSize,
                    drawingBounds.top + stringMarkerBounds.height() + i * fretSize + i * fretMarkerSize))
        }
    }

    private fun calculateStringPositions() {
        stringLineRects.clear()

        for (i in 0 until stringCount) {
            stringLineRects.add(RectF(
                    stringMarkerBounds.left + i * stringDistance + i * stringSize,
                    drawingBounds.top + stringMarkerBounds.height(),
                    stringMarkerBounds.left + i * stringDistance + i * stringSize,
                    drawingBounds.bottom - fretMarkerSize))
        }
    }

    private fun calculateFretNumberPositions() {
        fretNumberPoints.clear()

        for (i in fretStart..fretEnd) {
            fretNumberPoints.add(PointF(
                    drawingBounds.left + fretNumberBounds.width() / 2,
                    getVerticalCenterTextPosition(stringMarkerBounds.bottom + i * fretMarkerSize + i * fretSize + fretSize / 2, (i + 1).toString(), fretNumberPaint)))
        }
    }

    private fun calculateBarLinePositions() {
        barLinePaths.clear()

        chord?.bars?.forEach {
            val left = drawingBounds.left + fretNumberBounds.width() + (stringCount - it.startString.number) * stringDistance +
                    (stringCount - it.startString.number) * stringSize
            val top = stringMarkerBounds.bottom + (it.fretNumber.number * fretSize + it.fretNumber.number * fretMarkerSize - fretSize / 2)
            val right = drawingBounds.left + fretNumberBounds.width() + (stringCount - it.endString.number) * stringDistance +
                    (stringCount - it.endString.number) * stringSize
            val bottom = 0f // TODO
            val textX = 0f // TODO
            val textY = 0f // TODO

            barLinePaths.add(
                    BarPosition(
                            text = it.finger.position.toString(),
                            textX = textX,
                            textY = textY,
                            left = left,
                            top = top,
                            right = right,
                            bottom = bottom))
        }
    }

    private fun calculateNotePositions() {
        notePositions.clear()

        chord?.notes?.forEach {
            val startCenterX = drawingBounds.left + fretNumberBounds.width() + (stringCount - it.string.number) * stringDistance + (stringCount - it.string.number) * stringSize
            val startCenterY = stringMarkerBounds.bottom + (it.fretNumber.number * fretSize + it.fretNumber.number * fretMarkerSize - fretSize / 2)

            notePositions.add(
                    NotePosition(
                            text = it.finger.toString(),
                            circleX = startCenterX,
                            circleY = startCenterY,
                            textX = startCenterX,
                            textY = getVerticalCenterTextPosition(startCenterY, it.finger.toString(), noteNumberPaint)))
        }
    }

    private fun calculateStringMarkers() {
        stringLabelPositions.clear()
        stringMarkerPositions.clear()

        chord?.mutes?.forEach {
            val x = drawingBounds.left + fretNumberBounds.width() + (stringCount - it.stringNumber.number) * stringDistance + (stringCount - it.stringNumber.number) * stringSize
            val y = getVerticalCenterTextPosition(drawingBounds.top + stringMarkerBounds.height() / 2, mutedText, stringMarkerPaint)

            stringMarkerPositions.add(
                    StringPosition(
                            text = mutedText,
                            textX = x,
                            textY = y))
        }

        chord?.opens?.forEach {
            val x = drawingBounds.left + fretNumberBounds.width() + (stringCount - it.stringNumber.number) * stringDistance + (stringCount - it.stringNumber.number) * stringSize
            val y = getVerticalCenterTextPosition(drawingBounds.top + stringMarkerBounds.height() / 2, openStringText, stringMarkerPaint)

            stringMarkerPositions.add(
                    StringPosition(
                            text = openStringText,
                            textX = x,
                            textY = y))
        }

        // TODO calculate string labels
    }

    private fun drawFretNumbers(canvas: Canvas) {
        //Fret numbers; check if we are showing them or not
        if (showFretNumbers) {
            fretNumberPoints.forEachIndexed { index, point ->
                canvas.drawText((fretStart + index).toString(), point.x, point.y, fretNumberPaint)
            }
        }
    }

    private fun drawStringMarkers(canvas: Canvas) {
        //String markers
        stringMarkerPositions.forEach { canvas.drawText(it.text, it.textX, it.textY, stringMarkerPaint) }

        // TODO draw String labels/numbers
    }

    private fun drawBars(canvas: Canvas) {
        //Bars
        barLinePaths.forEach {
            // Draw Bar
            canvas.drawRect(it.left, it.top, it.right, it.bottom, barLinePaint)

            // Text
            if (showFingerNumbers) {
                canvas.drawText(it.text, it.textX, it.textY, noteNumberPaint)
            }
        }
    }

    private fun drawNotes(canvas: Canvas) {
        //Individual notes
        notePositions.forEach {
            canvas.drawCircle(it.circleX, it.circleY, noteSize / 2f, notePaint)

            if (showFingerNumbers) {
                canvas.drawText(it.text, it.textX, it.textY, noteNumberPaint)
            }
        }
    }

    private fun getVerticalCenterTextPosition(originalYPosition: Float, text: String?, textPaint: Paint): Float {
        val bounds = Rect()
        textPaint.getTextBounds(text, 0, text?.length ?: 0, bounds)

        return originalYPosition + bounds.height() / 2
    }

    private fun Canvas.drawLine(rectF: RectF, paint: Paint) =
            drawLine(rectF.left, rectF.top, rectF.right, rectF.bottom, paint)

    companion object {

        private const val DEFAULT_COLOR = Color.BLACK
        private const val WHITE = Color.WHITE

        private const val DEFAULT_MUTED_TEXT = "X"
        private const val DEFAULT_OPEN_TEXT = "O"
        private const val DEFAULT_FRET_START = 1
        private const val DEFAULT_FRET_END = 4
        private const val DEFAULT_STRING_COUNT = 6
    }

    private data class NotePosition(
            val text: String,
            val circleX: Float,
            val circleY: Float,
            val textX: Float,
            val textY: Float
    )

    private data class StringPosition(
            val text: String,
            val textX: Float,
            val textY: Float
    )

    private data class BarPosition(
            val text: String,
            val left: Float,
            val top: Float,
            val right: Float,
            val bottom: Float,
            val textX: Float,
            val textY: Float
    )
}
