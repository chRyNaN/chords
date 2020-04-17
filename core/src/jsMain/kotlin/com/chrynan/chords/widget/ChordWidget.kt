package com.chrynan.chords.widget

import com.chrynan.chords.graphics.Paint
import com.chrynan.chords.graphics.Point
import com.chrynan.chords.graphics.Rect
import com.chrynan.chords.model.Chord
import com.chrynan.chords.model.ChordChart
import com.chrynan.chords.model.ColorInt
import com.chrynan.chords.model.StringLabelState
import com.chrynan.chords.util.Color
import com.chrynan.chords.view.ChordView
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import kotlin.math.min
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

class ChordWidget(override val canvas: HTMLCanvasElement) : View(),
        ChordView {

    override var chord: Chord?
        get() = TODO("Not yet implemented")
        set(value) {}

    override var chart: ChordChart
        get() = TODO("Not yet implemented")
        set(value) {}

    override var fitToHeight: Boolean
        get() = TODO("Not yet implemented")
        set(value) {}

    override var showFretNumbers: Boolean
        get() = TODO("Not yet implemented")
        set(value) {}

    override var showFingerNumbers: Boolean
        get() = TODO("Not yet implemented")
        set(value) {}

    override var stringLabelState: StringLabelState
        get() = TODO("Not yet implemented")
        set(value) {}

    override var mutedStringText: String
        get() = TODO("Not yet implemented")
        set(value) {}

    override var openStringText: String
        get() = TODO("Not yet implemented")
        set(value) {}

    override var fretColor: ColorInt
        get() = TODO("Not yet implemented")
        set(value) {}

    override var fretLabelTextColor: ColorInt
        get() = TODO("Not yet implemented")
        set(value) {}

    override var stringColor: ColorInt
        get() = TODO("Not yet implemented")
        set(value) {}

    override var stringLabelTextColor: ColorInt
        get() = TODO("Not yet implemented")
        set(value) {}

    override var noteColor: ColorInt
        get() = TODO("Not yet implemented")
        set(value) {}

    override var noteLabelTextColor: ColorInt
        get() = TODO("Not yet implemented")
        set(value) {}

    private val fretPaint = Paint().apply {
        style = Paint.Style.STROKE
    }
    private val fretLabelTextPaint = Paint().apply {
        textAlign = Paint.Align.CENTER
    }
    private val stringPaint = Paint().apply {
        style = Paint.Style.STROKE
    }
    private val stringLabelTextPaint = Paint().apply {
        textAlign = Paint.Align.CENTER
    }
    private val notePaint = Paint()
    private val noteLabelTextPaint = Paint().apply {
        textAlign = Paint.Align.CENTER
    }
    private val barLinePaint = Paint().apply {
        style = Paint.Style.FILL
    }

    private var drawingBounds = Rect.EMPTY
    private var chartBounds = Rect.EMPTY
    private var stringTopLabelBounds = Rect.EMPTY
    private var stringBottomLabelBounds = Rect.EMPTY
    private var fretSideLabelBounds = Rect.EMPTY

    private val fretCount: Int
        get() = chart.fretEnd.number - chart.fretStart.number + 1

    private val showBottomStringLabels: Boolean
        get() = stringLabelState != StringLabelState.HIDE && chart.stringLabels.isNotEmpty()

    private val fretLineRects = mutableListOf<Rect>()
    private val stringLineRects = mutableListOf<Rect>()
    private val fretNumberPoints = mutableListOf<Point>()
    private val notePositions = mutableListOf<NotePosition>()
    private val barLinePaths = mutableListOf<BarPosition>()
    private val stringBottomLabelPositions = mutableListOf<StringPosition>()
    private val stringTopMarkerPositions = mutableListOf<StringPosition>()

    private var fretSize = 0.0
    private var stringDistance = 0.0

    private var fretMarkerSize = 0.0
        set(value) {
            field = value
            fretPaint.strokeWidth = value
        }
    private var fretLabelTextSize = 0.0
        set(value) {
            field = value
            fretLabelTextPaint.textSize = value
        }
    private var stringSize = 0.0
        set(value) {
            field = value
            stringPaint.strokeWidth = value
            barLinePaint.strokeWidth = 2 * value
        }
    private var stringLabelTextSize = 0.0
        set(value) {
            field = value
            stringLabelTextPaint.textSize = value
        }
    private var noteSize = 0.0
        set(value) {
            field = value
            notePaint.strokeWidth = value
        }
    private var noteLabelTextSize = 0.0
        set(value) {
            field = value
            noteLabelTextPaint.textSize = value
        }

    override fun onMeasure(width: Int, height: Int) {
        calculateSize()
        calculateBarLinePositions()
        calculateFretNumberPositions()
        calculateFretPositions()
        calculateNotePositions()
        calculateStringMarkers()
        calculateStringPositions()
    }

    override fun onDraw(context: CanvasRenderingContext2D) {

    }

    private fun calculateSize() {
        val absoluteWidth = width - (paddingLeft + paddingRight)
        val absoluteHeight = height - (paddingTop + paddingBottom)
        val minSideSize = min(absoluteWidth, absoluteHeight)
        val actualWidth = if (fitToHeight) minSideSize * (2f / 3f) else absoluteWidth
        val actualHeight = if (fitToHeight) minSideSize else absoluteHeight

        // Center everything
        drawingBounds.set(
                left = (absoluteWidth - actualWidth) / 2,
                top = (absoluteHeight - actualHeight) / 2,
                right = (absoluteWidth - actualWidth) / 2 + actualWidth,
                bottom = (absoluteHeight - actualHeight) / 2 + actualHeight)

        // Give some space for the labels
        val horizontalExtraCount = if (showFretNumbers) 1 else 0
        val verticalExtraCount = if (showBottomStringLabels) 2 else 1

        // We add 1 to make room for two halves of notes displayed on the first and last strings. Otherwise, they'll be cut-off.
        noteSize = min((actualWidth / (chart.stringCount + 1 + horizontalExtraCount)), (actualHeight / (fretCount + 1 + verticalExtraCount)))

        val textSize = noteSize * .75f
        fretLabelTextSize = textSize
        stringLabelTextSize = textSize
        noteLabelTextSize = textSize

        stringDistance = noteSize

        stringSize = (stringDistance / chart.stringCount).coerceAtLeast(1.0)
        fretMarkerSize = stringSize

        fretSize = round((actualHeight - (noteSize * verticalExtraCount) - (fretCount + 1) * fretMarkerSize) / fretCount)

        // The actual chart bounds
        chartBounds.set(
                left = drawingBounds.left + (noteSize * horizontalExtraCount) + (noteSize * 0.5),
                top = drawingBounds.top + noteSize,
                right = drawingBounds.right - (noteSize * 0.5),
                bottom = drawingBounds.bottom - (if (showBottomStringLabels) noteSize else 0.0))

        // The open/closed labels for the String above the chart
        stringTopLabelBounds.set(
                left = chartBounds.left,
                top = drawingBounds.top,
                right = chartBounds.right,
                bottom = drawingBounds.top + noteSize)

        // The number/note labels for the String below the chart
        stringBottomLabelBounds.set(
                left = chartBounds.left,
                top = chartBounds.bottom,
                right = chartBounds.right,
                bottom = chartBounds.bottom + noteSize)

        // The fret number labels on the side of the chart
        fretSideLabelBounds.set(
                left = drawingBounds.left,
                top = chartBounds.top,
                right = drawingBounds.left + noteSize,
                bottom = drawingBounds.bottom)
    }

    private fun calculateFretPositions() {
        fretLineRects.clear()

        for (i in 0..fretCount) {
            fretLineRects.add(Rect(
                    left = chartBounds.left,
                    top = chartBounds.top + i * fretSize + i * fretMarkerSize,
                    right = chartBounds.right - stringSize,
                    bottom = chartBounds.top + i * fretSize + i * fretMarkerSize))
        }
    }

    private fun calculateStringPositions() {
        stringLineRects.clear()

        for (i in 0 until chart.stringCount) {
            stringLineRects.add(Rect(
                    left = chartBounds.left + i * stringDistance + i * stringSize,
                    top = chartBounds.top,
                    right = chartBounds.left + i * stringDistance + i * stringSize,
                    bottom = chartBounds.top + fretCount * fretSize + fretCount * fretMarkerSize))
        }
    }

    private fun calculateFretNumberPositions() {
        fretNumberPoints.clear()

        for (i in 0..(chart.fretEnd.number - chart.fretStart.number)) {
            fretNumberPoints.add(Point(
                    x = drawingBounds.left + fretSideLabelBounds.width / 2,
                    y = getVerticalCenterTextPosition(stringTopLabelBounds.bottom + i * fretMarkerSize + i * fretSize + fretSize / 2, (i + 1).toString(), fretLabelTextPaint)))
        }
    }

    private fun calculateBarLinePositions() {
        barLinePaths.clear()

        chord?.bars?.forEach { bar ->
            if (bar.fret.number in chart.fretStart.number..chart.fretEnd.number && bar.endString.number < chart.stringCount + 1) {
                val relativeFretNumber = bar.fret.number - (chart.fretStart.number - 1)
                val left = (chartBounds.left + (chart.stringCount - bar.endString.number) * stringDistance +
                        (chart.stringCount - bar.endString.number) * stringSize) - noteSize / 2
                val top = chartBounds.top + (relativeFretNumber * fretSize + relativeFretNumber * fretMarkerSize - fretSize / 2) - (noteSize / 2)
                val right = (chartBounds.left + (chart.stringCount - bar.startString.number) * stringDistance +
                        (chart.stringCount - bar.startString.number) * stringSize) + (noteSize / 2)
                val bottom = top + noteSize
                val textX = left + (right - left) / 2
                val textY = getVerticalCenterTextPosition(top + (bottom - top) / 2, bar.finger.name, noteLabelTextPaint)

                barLinePaths.add(
                        BarPosition(
                                text = bar.finger.position.toString(),
                                textX = textX,
                                textY = textY,
                                left = left,
                                top = top,
                                right = right,
                                bottom = bottom))
            }
        }
    }

    private fun calculateNotePositions() {
        notePositions.clear()

        chord?.notes?.forEach { note ->
            if (note.fret.number in chart.fretStart.number..chart.fretEnd.number && note.string.number < chart.stringCount + 1) {
                val relativeFretNumber = note.fret.number - (chart.fretStart.number - 1)
                val startCenterX = chartBounds.left + (chart.stringCount - note.string.number) * stringDistance + (chart.stringCount - note.string.number) * stringSize
                val startCenterY = chartBounds.top + (relativeFretNumber * fretSize + relativeFretNumber * fretMarkerSize - fretSize / 2)

                notePositions.add(
                        NotePosition(
                                text = note.finger.toString(),
                                circleX = startCenterX,
                                circleY = startCenterY,
                                textX = startCenterX,
                                textY = getVerticalCenterTextPosition(startCenterY, note.finger.toString(), noteLabelTextPaint)))
            }
        }
    }

    private fun calculateStringMarkers() {
        stringBottomLabelPositions.clear()
        stringTopMarkerPositions.clear()

        // Top string mute labels
        chord?.mutes?.forEach { muted ->
            if (muted.string.number < chart.stringCount + 1) {
                val x = chartBounds.left + (chart.stringCount - muted.string.number) * stringDistance + (chart.stringCount - muted.string.number) * stringSize
                val y = getVerticalCenterTextPosition(drawingBounds.top + stringTopLabelBounds.height / 2, mutedStringText, stringLabelTextPaint)

                stringTopMarkerPositions.add(
                        StringPosition(
                                text = mutedStringText,
                                textX = x,
                                textY = y))
            }
        }

        // Top string open labels
        chord?.opens?.forEach { open ->
            if (open.string.number < chart.stringCount + 1) {
                val x = chartBounds.left + (chart.stringCount - open.string.number) * stringDistance + (chart.stringCount - open.string.number) * stringSize
                val y = getVerticalCenterTextPosition(drawingBounds.top + stringTopLabelBounds.height / 2, openStringText, stringLabelTextPaint)

                stringTopMarkerPositions.add(
                        StringPosition(
                                text = openStringText,
                                textX = x,
                                textY = y))
            }
        }

        if (showBottomStringLabels) {
            chart.stringLabels.forEach { stringLabel ->
                if (stringLabel.string.number < chart.stringCount + 1) {
                    val label = if (stringLabelState == StringLabelState.SHOW_NUMBER) stringLabel.string.toString() else stringLabel.label

                    if (label != null) {
                        val x = chartBounds.left + (chart.stringCount - stringLabel.string.number) * stringDistance + (chart.stringCount - stringLabel.string.number) * stringSize
                        val y = getVerticalCenterTextPosition(chartBounds.bottom + stringBottomLabelBounds.height / 2, label, stringLabelTextPaint)

                        stringBottomLabelPositions.add(
                                StringPosition(
                                        text = label,
                                        textX = x,
                                        textY = y))
                    }
                }
            }
        }
    }





    companion object {

        val DEFAULT_COLOR = Color.BLACK
        val DEFAULT_TEXT_COLOR = Color.WHITE
    }

    private data class NotePosition(
            val text: String,
            val circleX: Double,
            val circleY: Double,
            val textX: Double,
            val textY: Double
    )

    private data class StringPosition(
            val text: String,
            val textX: Double,
            val textY: Double
    )

    private data class BarPosition(
            val text: String,
            val left: Double,
            val top: Double,
            val right: Double,
            val bottom: Double,
            val textX: Double,
            val textY: Double
    )
}