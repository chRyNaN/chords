package com.chrynan.chords.widget

import com.chrynan.chords.graphics.Point
import com.chrynan.chords.graphics.Rect
import com.chrynan.chords.model.Chord
import com.chrynan.chords.model.ChordChart
import com.chrynan.chords.model.ColorInt
import com.chrynan.chords.model.StringLabelState
import com.chrynan.chords.view.ChordView
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement

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

    private var fretSize = 0f //y value = 0
    private var stringDistance = 0f //x value = 0f

    override fun onMeasure(width: Int, height: Int) {

    }

    override fun onDraw(context: CanvasRenderingContext2D) {
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