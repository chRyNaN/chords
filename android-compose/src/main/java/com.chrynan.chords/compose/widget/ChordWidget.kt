package com.chrynan.chords.compose.widget

import android.graphics.*
import android.text.TextPaint
import androidx.compose.Composable
import androidx.ui.core.Draw
import androidx.ui.core.PxSize
import androidx.ui.tooling.preview.Preview
import com.chrynan.chords.model.*
import kotlin.math.min
import kotlin.math.round

@Preview
@Composable
fun test() {
    val chord = chord("G") {
        +ChordMarker.Note(
                fret = FretNumber(3),
                finger = Finger.MIDDLE,
                string = StringNumber(6)
        )
        +ChordMarker.Note(
                fret = FretNumber(2),
                finger = Finger.INDEX,
                string = StringNumber(5)
        )
        +ChordMarker.Open(string = StringNumber(4))
        +ChordMarker.Open(string = StringNumber(3))
        +ChordMarker.Note(
                fret = FretNumber(3),
                finger = Finger.RING,
                string = StringNumber(2)
        )
        +ChordMarker.Note(
                fret = FretNumber(3),
                finger = Finger.PINKY,
                string = StringNumber(1)
        )
    }

    ChordWidget(chord = chord)
}

@Composable
fun ChordWidget(
        chord: Chord,
        chart: ChordChart = ChordChart.STANDARD_TUNING_GUITAR_CHART,
        viewModel: ChordViewModel = DEFAULT_CHORD_VIEW_MODEL
) {
    val fretPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
    }
    val fretLabelTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
    }
    val stringPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.BUTT
    }
    val stringLabelTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
    }
    val notePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val noteLabelTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
    }
    val barLinePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }

    Draw { canvas: androidx.ui.graphics.Canvas, parentSize: PxSize ->
        val size = calculateSize(
                measuredWidth = parentSize.width.value,
                measuredHeight = parentSize.height.value,
                paddingLeft = 0f,
                paddingTop = 0f,
                paddingRight = 0f,
                paddingBottom = 0f,
                viewModel = viewModel,
                chart = chart)

        val barLinePaths = calculateBarLinePositions(
                chord = chord,
                chart = chart,
                size = size,
                noteLabelTextPaint = noteLabelTextPaint)
        val fretNumberPoints = calculateFretNumberPositions(
                chart = chart,
                size = size,
                fretLabelTextPaint = fretLabelTextPaint)
        val fretLineRects = calculateFretPositions(
                size = size,
                chart = chart)
        val notePositions = calculateNotePositions(
                chord = chord,
                chart = chart,
                size = size,
                noteLabelTextPaint = noteLabelTextPaint)
        val stringBottomLabelPositions = calculateBottomStringLabels(
                chart = chart,
                size = size,
                stringLabelTextPaint = stringLabelTextPaint,
                viewModel = viewModel)
        val stringTopMarkerPositions = calculateTopStringLabels(
                chord = chord,
                chart = chart,
                size = size,
                stringLabelTextPaint = stringLabelTextPaint,
                viewModel = viewModel)
        val stringLineRects = calculateStringPositions(
                chart = chart,
                size = size)

        // First draw the strings and fret markers
        fretLineRects.forEach { canvas.nativeCanvas.drawLine(it, fretPaint) }
        stringLineRects.forEach { canvas.nativeCanvas.drawLine(it, stringPaint) }

        // Next draw the fret numbers and string markers
        drawFretNumbers(
                canvas = canvas,
                showFretNumbers = viewModel.showFretNumbers,
                fretNumberPoints = fretNumberPoints,
                chart = chart,
                fretLabelTextPaint = fretLabelTextPaint)
        drawStringMarkers(
                canvas = canvas,
                stringTopMarkerPositions = stringTopMarkerPositions,
                stringBottomLabelPositions = stringBottomLabelPositions,
                stringLabelTextPaint = stringLabelTextPaint)

        // Finally, draw all the notes and the note text
        drawBars(
                canvas = canvas,
                barLinePaths = barLinePaths,
                barLinePaint = barLinePaint,
                showFingerNumbers = viewModel.showFingerNumbers,
                noteLabelTextPaint = noteLabelTextPaint)
        drawNotes(
                canvas = canvas,
                notePositions = notePositions,
                showFingerNumbers = viewModel.showFingerNumbers,
                noteSize = size.noteSize,
                notePaint = notePaint,
                noteLabelTextPaint = noteLabelTextPaint)
    }
}

internal fun calculateSize(
        measuredWidth: Float,
        measuredHeight: Float,
        paddingLeft: Float,
        paddingTop: Float,
        paddingRight: Float,
        paddingBottom: Float,
        viewModel: ChordViewModel,
        chart: ChordChart
): ChordWidgetSize {
    val absoluteWidth = measuredWidth - paddingLeft + paddingRight
    val absoluteHeight = measuredHeight - paddingTop + paddingBottom
    val minSideSize = min(absoluteWidth, absoluteHeight)
    val actualWidth = if (viewModel.fitToHeight) minSideSize * (2f / 3f) else absoluteWidth
    val actualHeight = if (viewModel.fitToHeight) minSideSize else absoluteHeight

    // Center everything
    val drawingBounds = RectF(
            (absoluteWidth - actualWidth) / 2,
            (absoluteHeight - actualHeight) / 2,
            (absoluteWidth - actualWidth) / 2 + actualWidth,
            (absoluteHeight - actualHeight) / 2 + actualHeight)

    // Give some space for the labels
    val horizontalExtraCount = if (viewModel.showFretNumbers) 1 else 0
    val verticalExtraCount = if (viewModel.stringLabelState != StringLabelState.HIDE) 2 else 1

    // We add 1 to make room for two halves of notes displayed on the first and last strings. Otherwise, they'll be cut-off.
    val noteSize = min((actualWidth / (chart.stringCount + 1 + horizontalExtraCount)), (actualHeight / (chart.fretCount + 1 + verticalExtraCount)))

    val textSize = noteSize * .75f

    val stringSize = (noteSize / chart.stringCount).coerceAtLeast(1f)

    val fretSize = round((actualHeight - (noteSize * verticalExtraCount) - (chart.fretCount + 1) * stringSize) / chart.fretCount)

    // The actual chart bounds
    val chartBounds = RectF(
            drawingBounds.left + (noteSize * horizontalExtraCount) + (noteSize * .5f),
            drawingBounds.top + noteSize,
            drawingBounds.right - (noteSize * .5f),
            drawingBounds.bottom - (if (viewModel.stringLabelState != StringLabelState.HIDE) noteSize else 0f))

    // The open/closed labels for the String above the chart
    val stringTopLabelBounds = RectF(
            chartBounds.left,
            drawingBounds.top,
            chartBounds.right,
            drawingBounds.top + noteSize)

    // The number/note labels for the String below the chart
    val stringBottomLabelBounds = RectF(
            chartBounds.left,
            chartBounds.bottom,
            chartBounds.right,
            chartBounds.bottom + noteSize)

    // The fret number labels on the side of the chart
    val fretSideLabelBounds = RectF(
            drawingBounds.left,
            chartBounds.top,
            drawingBounds.left + noteSize,
            drawingBounds.bottom)

    return ChordWidgetSize(
            drawingBounds = drawingBounds,
            chartBounds = chartBounds,
            stringTopLabelBounds = stringTopLabelBounds,
            stringBottomLabelBounds = stringBottomLabelBounds,
            fretSideLabelBounds = fretSideLabelBounds,
            fretSize = fretSize,
            fretMarkerSize = stringSize,
            stringSize = stringSize,
            stringDistance = noteSize,
            textSize = textSize,
            noteSize = noteSize)
}

internal fun calculateFretPositions(
        chart: ChordChart,
        size: ChordWidgetSize
): List<RectF> {
    val fretLineRects = mutableListOf<RectF>()

    for (i in 0..chart.fretCount) {
        fretLineRects.add(RectF(
                size.chartBounds.left,
                size.chartBounds.top + i * size.fretSize + i * size.fretMarkerSize,
                size.chartBounds.right - size.stringSize,
                size.chartBounds.top + i * size.fretSize + i * size.fretMarkerSize))
    }

    return fretLineRects
}

internal fun calculateStringPositions(
        chart: ChordChart,
        size: ChordWidgetSize
): List<RectF> {
    val stringLineRects = mutableListOf<RectF>()

    for (i in 0 until chart.stringCount) {
        stringLineRects.add(RectF(
                size.chartBounds.left + i * size.stringDistance + i * size.stringSize,
                size.chartBounds.top,
                size.chartBounds.left + i * size.stringDistance + i * size.stringSize,
                size.chartBounds.top + chart.fretCount * size.fretSize + chart.fretCount * size.fretMarkerSize))
    }

    return stringLineRects
}

internal fun calculateFretNumberPositions(
        chart: ChordChart,
        size: ChordWidgetSize,
        fretLabelTextPaint: TextPaint
): List<PointF> {
    val fretNumberPoints = mutableListOf<PointF>()

    for (i in (chart.fretStart.number - 1) until chart.fretEnd.number) {
        fretNumberPoints.add(PointF(
                size.drawingBounds.left + size.fretSideLabelBounds.width() / 2,
                getVerticalCenterTextPosition(size.stringTopLabelBounds.bottom + i * size.fretMarkerSize + i * size.fretSize + size.fretSize / 2, (i + 1).toString(), fretLabelTextPaint)))
    }

    return fretNumberPoints
}

internal fun calculateBarLinePositions(
        chord: Chord,
        chart: ChordChart,
        size: ChordWidgetSize,
        noteLabelTextPaint: TextPaint
): List<BarPosition> {
    val barLinePaths = mutableListOf<BarPosition>()

    chord.bars.forEach {
        val left = (size.chartBounds.left + (chart.stringCount - it.endString.number) * size.stringDistance +
                (chart.stringCount - it.endString.number) * size.stringSize) - size.noteSize / 2
        val top = size.chartBounds.top + (it.fret.number * size.fretSize + it.fret.number * size.fretMarkerSize - size.fretSize / 2) - (size.noteSize / 2)
        val right = (size.chartBounds.left + (chart.stringCount - it.startString.number) * size.stringDistance +
                (chart.stringCount - it.startString.number) * size.stringSize) + (size.noteSize / 2)
        val bottom = top + size.noteSize
        val textX = left + (right - left) / 2
        val textY = getVerticalCenterTextPosition(top + (bottom - top) / 2, it.finger.name, noteLabelTextPaint)

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

    return barLinePaths
}

internal fun calculateNotePositions(
        chord: Chord,
        chart: ChordChart,
        size: ChordWidgetSize,
        noteLabelTextPaint: TextPaint
): List<NotePosition> {
    val notePositions = mutableListOf<NotePosition>()

    chord.notes.forEach {
        val startCenterX = size.chartBounds.left + (chart.stringCount - it.string.number) * size.stringDistance + (chart.stringCount - it.string.number) * size.stringSize
        val startCenterY = size.chartBounds.top + (it.fret.number * size.fretSize + it.fret.number * size.fretMarkerSize - size.fretSize / 2)

        notePositions.add(
                NotePosition(
                        text = it.finger.toString(),
                        circleX = startCenterX,
                        circleY = startCenterY,
                        textX = startCenterX,
                        textY = getVerticalCenterTextPosition(startCenterY, it.finger.toString(), noteLabelTextPaint)))
    }

    return notePositions
}

internal fun calculateTopStringLabels(
        chord: Chord,
        chart: ChordChart,
        size: ChordWidgetSize,
        stringLabelTextPaint: TextPaint,
        viewModel: ChordViewModel
): List<StringPosition> {
    val stringTopMarkerPositions = mutableListOf<StringPosition>()

    // Top string mute labels
    chord.mutes.forEach {
        val x = size.chartBounds.left + (chart.stringCount - it.string.number) * size.stringDistance + (chart.stringCount - it.string.number) * size.stringSize
        val y = getVerticalCenterTextPosition(size.drawingBounds.top + size.stringTopLabelBounds.height() / 2, viewModel.mutedStringText, stringLabelTextPaint)

        stringTopMarkerPositions.add(
                StringPosition(
                        text = viewModel.mutedStringText,
                        textX = x,
                        textY = y))
    }

    // Top string open labels
    chord.opens.forEach {
        val x = size.chartBounds.left + (chart.stringCount - it.string.number) * size.stringDistance + (chart.stringCount - it.string.number) * size.stringSize
        val y = getVerticalCenterTextPosition(size.drawingBounds.top + size.stringTopLabelBounds.height() / 2, viewModel.openStringText, stringLabelTextPaint)

        stringTopMarkerPositions.add(
                StringPosition(
                        text = viewModel.openStringText,
                        textX = x,
                        textY = y))
    }

    return stringTopMarkerPositions
}

internal fun calculateBottomStringLabels(
        chart: ChordChart,
        size: ChordWidgetSize,
        stringLabelTextPaint: TextPaint,
        viewModel: ChordViewModel
): List<StringPosition> {
    val stringBottomLabelPositions = mutableListOf<StringPosition>()

    if (viewModel.stringLabelState != StringLabelState.HIDE) {
        chart.stringLabels.forEach {
            val label = if (viewModel.stringLabelState == StringLabelState.SHOW_NUMBER) it.string.toString() else it.label

            if (label != null) {
                val x = size.chartBounds.left + (chart.stringCount - it.string.number) * size.stringDistance + (chart.stringCount - it.string.number) * size.stringSize
                val y = getVerticalCenterTextPosition(size.chartBounds.bottom + size.stringBottomLabelBounds.height() / 2, label, stringLabelTextPaint)

                stringBottomLabelPositions.add(
                        StringPosition(
                                text = label,
                                textX = x,
                                textY = y))
            }
        }
    }

    return stringBottomLabelPositions
}

internal fun drawFretNumbers(
        canvas: androidx.ui.graphics.Canvas,
        showFretNumbers: Boolean,
        fretNumberPoints: List<PointF>,
        chart: ChordChart,
        fretLabelTextPaint: TextPaint
) {
    // Fret numbers; check if we are showing them or not
    if (showFretNumbers) {
        fretNumberPoints.forEachIndexed { index, point ->
            canvas.nativeCanvas.drawText((chart.fretStart.number + index).toString(), point.x, point.y, fretLabelTextPaint)
        }
    }
}

internal fun drawStringMarkers(
        canvas: androidx.ui.graphics.Canvas,
        stringTopMarkerPositions: List<StringPosition>,
        stringBottomLabelPositions: List<StringPosition>,
        stringLabelTextPaint: TextPaint
) {
    // Top String markers (open/muted)
    stringTopMarkerPositions.forEach { canvas.nativeCanvas.drawText(it.text, it.textX, it.textY, stringLabelTextPaint) }

    // Bottom String labels (number/note)
    stringBottomLabelPositions.forEach { canvas.nativeCanvas.drawText(it.text, it.textX, it.textY, stringLabelTextPaint) }
}

internal fun drawBars(
        canvas: androidx.ui.graphics.Canvas,
        barLinePaths: List<BarPosition>,
        barLinePaint: Paint,
        showFingerNumbers: Boolean,
        noteLabelTextPaint: TextPaint
) {
    // Bars
    barLinePaths.forEach {
        // Draw Bar
        canvas.nativeCanvas.drawRoundRect(it.left, it.top, it.right, it.bottom, (it.bottom - it.top), (it.bottom - it.top), barLinePaint)

        // Text
        if (showFingerNumbers) {
            canvas.nativeCanvas.drawText(it.text, it.textX, it.textY, noteLabelTextPaint)
        }
    }
}

internal fun drawNotes(
        canvas: androidx.ui.graphics.Canvas,
        notePositions: List<NotePosition>,
        showFingerNumbers: Boolean,
        noteSize: Float,
        notePaint: Paint,
        noteLabelTextPaint: TextPaint
) {
    //Individual notes
    notePositions.forEach {
        canvas.nativeCanvas.drawCircle(it.circleX, it.circleY, noteSize / 2f, notePaint)

        if (showFingerNumbers) {
            canvas.nativeCanvas.drawText(it.text, it.textX, it.textY, noteLabelTextPaint)
        }
    }
}

internal fun getVerticalCenterTextPosition(originalYPosition: Float, text: String?, textPaint: Paint): Float {
    val bounds = Rect()
    textPaint.getTextBounds(text, 0, text?.length ?: 0, bounds)

    return originalYPosition + bounds.height() / 2
}

internal fun Canvas.drawLine(rectF: RectF, paint: Paint) =
        drawLine(rectF.left, rectF.top, rectF.right, rectF.bottom, paint)

internal val ChordChart.fretCount: Int
    get() = fretEnd.number - fretStart.number

val DEFAULT_CHORD_VIEW_MODEL = ChordViewModel(
        fretColor = Color.BLACK,
        fretLabelTextColor = Color.BLACK,
        noteColor = Color.BLACK,
        noteLabelTextColor = Color.WHITE,
        stringColor = Color.BLACK,
        stringLabelTextColor = Color.BLACK
)

internal data class ChordWidgetSize(
        val drawingBounds: RectF,
        val chartBounds: RectF,
        val stringTopLabelBounds: RectF,
        val stringBottomLabelBounds: RectF,
        val fretSideLabelBounds: RectF,
        val fretSize: Float,
        val fretMarkerSize: Float,
        val stringSize: Float,
        val stringDistance: Float,
        val textSize: Float,
        val noteSize: Float
)

internal data class NotePosition(
        val text: String,
        val circleX: Float,
        val circleY: Float,
        val textX: Float,
        val textY: Float
)

internal data class StringPosition(
        val text: String,
        val textX: Float,
        val textY: Float
)

internal data class BarPosition(
        val text: String,
        val left: Float,
        val top: Float,
        val right: Float,
        val bottom: Float,
        val textX: Float,
        val textY: Float
)