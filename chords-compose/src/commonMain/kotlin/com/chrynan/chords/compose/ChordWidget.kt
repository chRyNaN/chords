@file:Suppress("unused")

package com.chrynan.chords.compose

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import com.chrynan.chords.model.*
import kotlin.math.min
import kotlin.math.round

@ExperimentalUnsignedTypes
@Composable
fun ChordWidget(
    modifier: Modifier = Modifier,
    chord: Chord? = null,
    chart: ChordChart = ChordChart.STANDARD_TUNING_GUITAR_CHART,
    viewModel: ChordViewModel = ChordViewModel()
) {
    BoxWithConstraints(modifier = modifier) {

    }
}

internal data class ChordWidgetSizeConstraints(
    val noteSize: Float,
    val fretLabelTextSize: Float,
    val stringLabelTextSize: Float,
    val noteLabelTextSize: Float,
    val stringDistance: Float,
    val stringSize: Float,
    val fretMarkerSize: Float,
    val fretSize: Float,
    val drawingBounds: Rect,
    val chartBounds: Rect,
    val stringTopLabelBounds: Rect,
    val stringBottomLabelBounds: Rect,
    val fretSideLabelBounds: Rect
)

private fun BoxWithConstraintsScope.calculateSize(
    fitToHeight: Boolean = false,
    showFretNumbers: Boolean = false,
    showBottomStringLabels: Boolean = false,
    stringCount: Int,
    fretCount: Int
): ChordWidgetSizeConstraints {
    val absoluteWidth = constraints.maxWidth.toFloat()
    val absoluteHeight = constraints.maxHeight.toFloat()
    val minSideSize = min(absoluteWidth, absoluteHeight)
    val actualWidth = if (fitToHeight) minSideSize * (2f / 3f) else absoluteWidth
    val actualHeight = if (fitToHeight) minSideSize else absoluteHeight

    // Give some space for the labels
    val horizontalExtraCount = if (showFretNumbers) 1 else 0
    val verticalExtraCount = if (showBottomStringLabels) 2 else 1

    // We add 1 to make room for two halves of notes displayed on the first and last strings. Otherwise, they'll be cut-off.
    val noteSize = min(
        (actualWidth / (stringCount + 1 + horizontalExtraCount)),
        (actualHeight / (fretCount + 1 + verticalExtraCount))
    )

    val textSize = noteSize * .75f

    val stringSize = (noteSize / stringCount).coerceAtLeast(1f)

    val fretSize =
        round((actualHeight - (noteSize * verticalExtraCount) - (fretCount + 1) * stringSize) / fretCount)

    val drawingWidth = noteSize * (stringCount + 1 + horizontalExtraCount)
    val drawingHeight = (fretSize * fretCount) + (noteSize * (1 + verticalExtraCount))

    // Center everything
    val drawingBounds = Rect(
        left = (absoluteWidth - drawingWidth) / 2,
        top = (absoluteHeight - drawingHeight) / 2,
        right = (absoluteWidth - drawingWidth) / 2 + drawingWidth,
        bottom = (absoluteHeight - drawingHeight) / 2 + drawingHeight
    )

    // The actual chart bounds
    val chartBounds = Rect(
        left = drawingBounds.left + (noteSize * horizontalExtraCount) + (noteSize * .5f),
        top = drawingBounds.top + noteSize,
        right = drawingBounds.right - (noteSize * .5f),
        bottom = drawingBounds.bottom - (if (showBottomStringLabels) noteSize else 0f)
    )

    // The open/closed labels for the String above the chart
    val stringTopLabelBounds = Rect(
        left = chartBounds.left,
        top = drawingBounds.top,
        right = chartBounds.right,
        bottom = drawingBounds.top + noteSize
    )

    // The number/note labels for the String below the chart
    val stringBottomLabelBounds = Rect(
        left = chartBounds.left,
        top = chartBounds.bottom,
        right = chartBounds.right,
        bottom = chartBounds.bottom + noteSize
    )

    // The fret number labels on the side of the chart
    val fretSideLabelBounds = Rect(
        left = drawingBounds.left,
        top = chartBounds.top,
        right = drawingBounds.left + noteSize,
        bottom = drawingBounds.bottom
    )

    return ChordWidgetSizeConstraints(
        noteSize = noteSize,
        fretLabelTextSize = textSize,
        stringLabelTextSize = textSize,
        noteLabelTextSize = textSize,
        stringDistance = noteSize,
        stringSize = stringSize,
        fretMarkerSize = stringSize,
        fretSize = fretSize,
        drawingBounds = drawingBounds,
        chartBounds = chartBounds,
        stringTopLabelBounds = stringTopLabelBounds,
        stringBottomLabelBounds = stringBottomLabelBounds,
        fretSideLabelBounds = fretSideLabelBounds
    )
}

private fun calculateFretPositions(
    fretCount: Int,
    size: ChordWidgetSizeConstraints
): List<Rect> {
    val fretLineRects = mutableListOf<Rect>()

    for (i in 0..fretCount) {
        fretLineRects.add(
            Rect(
                left = size.chartBounds.left,
                top = size.chartBounds.top + i * size.fretSize + i * size.fretMarkerSize,
                right = size.chartBounds.right - size.stringSize,
                bottom = size.chartBounds.top + i * size.fretSize + i * size.fretMarkerSize
            )
        )
    }

    return fretLineRects
}

private fun calculateStringPositions(
    stringCount: Int,
    fretCount: Int,
    size: ChordWidgetSizeConstraints
): List<Rect> {
    val stringLineRects = mutableListOf<Rect>()

    for (i in 0 until stringCount) {
        stringLineRects.add(
            Rect(
                left = size.chartBounds.left + i * size.stringDistance + i * size.stringSize,
                top = size.chartBounds.top,
                right = size.chartBounds.left + i * size.stringDistance + i * size.stringSize,
                bottom = size.chartBounds.top + fretCount * size.fretSize + fretCount * size.fretMarkerSize
            )
        )
    }

    return stringLineRects
}

private fun calculateFretNumberPositions(
    fretStart: Int,
    fretEnd: Int,
    size: ChordWidgetSizeConstraints
): List<Offset> {
    val fretNumberPoints = mutableListOf<Offset>()

    for (i in 0..(fretEnd - fretStart)) {
        fretNumberPoints.add(
            Offset(
                x = size.drawingBounds.left + size.fretSideLabelBounds.width / 2,
                y = (size.stringTopLabelBounds.bottom + i * size.fretMarkerSize + i * size.fretSize + size.fretSize / 2) + (size.fretLabelTextSize / 2)
            )
        )
    }

    return fretNumberPoints
}

private fun calculateBarLinePositions(
    bars: List<ChordMarker.Bar>,
    fretStart: Int,
    fretEnd: Int,
    stringCount: Int,
    size: ChordWidgetSizeConstraints
): List<BarPosition> {
    val barPositions = mutableListOf<BarPosition>()

    bars.forEach { bar ->
        if (bar.fret.number in fretStart..fretEnd && bar.endString.number < stringCount + 1) {
            val relativeFretNumber = bar.fret.number - (fretStart - 1)
            val left =
                (size.chartBounds.left + (stringCount - bar.endString.number) * size.stringDistance +
                        (stringCount - bar.endString.number) * size.stringSize) - size.noteSize / 2
            val top =
                size.chartBounds.top + (relativeFretNumber * size.fretSize + relativeFretNumber * size.fretMarkerSize - size.fretSize / 2) - (size.noteSize / 2)
            val right =
                (size.chartBounds.left + (stringCount - bar.startString.number) * size.stringDistance +
                        (stringCount - bar.startString.number) * size.stringSize) + (size.noteSize / 2)
            val bottom = top + size.noteSize
            val text = if (bar.finger === Finger.UNKNOWN) "" else bar.finger.toString()
            val textX = left + (right - left) / 2
            val textY = top + (bottom - top) / 2 + (size.noteLabelTextSize / 2)

            barPositions.add(
                BarPosition(
                    text = text,
                    textX = textX,
                    textY = textY,
                    left = left,
                    top = top,
                    right = right,
                    bottom = bottom
                )
            )
        }
    }

    return barPositions
}

private fun calculateNotePositions(
    notes: List<ChordMarker.Note>,
    fretStart: Int,
    fretEnd: Int,
    stringCount: Int,
    size: ChordWidgetSizeConstraints
): List<NotePosition> {
    val notePositions = mutableListOf<NotePosition>()

    notes.forEach { note ->
        if (note.fret.number in fretStart..fretEnd && note.string.number < stringCount + 1) {
            val relativeFretNumber = note.fret.number - (fretStart - 1)
            val startCenterX =
                size.chartBounds.left + (stringCount - note.string.number) * size.stringDistance + (stringCount - note.string.number) * size.stringSize
            val startCenterY =
                size.chartBounds.top + (relativeFretNumber * size.fretSize + relativeFretNumber * size.fretMarkerSize - size.fretSize / 2)
            val text = if (note.finger === Finger.UNKNOWN) "" else note.finger.toString()

            notePositions.add(
                NotePosition(
                    text = text,
                    circleX = startCenterX,
                    circleY = startCenterY,
                    textX = startCenterX,
                    textY = startCenterY + (size.noteLabelTextSize / 2)
                )
            )
        }
    }

    return notePositions
}

private fun calculateStringTopMarkerPositions(
    mutes: List<ChordMarker.Muted>,
    opens: List<ChordMarker.Open>,
    stringCount: Int,
    size: ChordWidgetSizeConstraints,
    mutedStringText: String,
    openStringText: String
): List<StringPosition> {
    val stringTopMarkerPositions = mutableListOf<StringPosition>()

    // Top string mute labels
    mutes.forEach { muted ->
        if (muted.string.number < stringCount + 1) {
            val x =
                size.chartBounds.left + (stringCount - muted.string.number) * size.stringDistance + (stringCount - muted.string.number) * size.stringSize
            val y =
                (size.drawingBounds.top + size.stringTopLabelBounds.height / 2) + (size.stringLabelTextSize / 2)

            stringTopMarkerPositions.add(
                StringPosition(
                    text = mutedStringText,
                    textX = x,
                    textY = y
                )
            )
        }
    }

    // Top string open labels
    opens.forEach { open ->
        if (open.string.number < stringCount + 1) {
            val x =
                size.chartBounds.left + (stringCount - open.string.number) * size.stringDistance + (stringCount - open.string.number) * size.stringSize
            val y =
                (size.drawingBounds.top + size.stringTopLabelBounds.height / 2) + (size.stringLabelTextSize / 2)

            stringTopMarkerPositions.add(
                StringPosition(
                    text = openStringText,
                    textX = x,
                    textY = y
                )
            )
        }
    }

    return stringTopMarkerPositions
}

private fun calculateStringBottomLabelPositions(
    stringLabels: List<StringLabel>,
    showBottomStringLabels: Boolean,
    stringLabelState: StringLabelState,
    stringCount: Int,
    size: ChordWidgetSizeConstraints
): List<StringPosition> {
    val stringBottomLabelPositions = mutableListOf<StringPosition>()

    if (showBottomStringLabels) {
        stringLabels.forEach { stringLabel ->
            if (stringLabel.string.number < stringCount + 1) {
                val label =
                    if (stringLabelState == StringLabelState.SHOW_NUMBER) stringLabel.string.toString() else stringLabel.label

                if (label != null) {
                    val x =
                        size.chartBounds.left + (stringCount - stringLabel.string.number) * size.stringDistance + (stringCount - stringLabel.string.number) * size.stringSize
                    val y =
                        (size.chartBounds.bottom + size.stringBottomLabelBounds.height / 2) + (size.stringLabelTextSize / 2)

                    stringBottomLabelPositions.add(
                        StringPosition(
                            text = label,
                            textX = x,
                            textY = y
                        )
                    )
                }
            }
        }
    }

    return stringBottomLabelPositions
}

@Composable
private fun ComposableDrawScope.drawFretNumbers(
    fretNumberPoints: List<Offset>,
    chart: ChordChart,
    showFretNumbers: Boolean
) {
    // Fret numbers; check if we are showing them or not
    if (showFretNumbers) {
        fretNumberPoints.forEachIndexed { index, point ->
            drawComposable(
                size = PositionalLayoutSize.WrapContent,
                offset = Offset(x = point.x, y = point.y)
            ) {
                Text(text = (chart.fretStart.number + index).toString())
            }
        }
    }
}

@Composable
private fun ComposableDrawScope.drawStringMarkers(
    stringTopMarkerPositions: List<StringPosition>,
    stringBottomLabelPositions: List<StringPosition>,
) {
    // Top String markers (open/muted)
    stringTopMarkerPositions.forEach {
        drawComposable(
            size = PositionalLayoutSize.WrapContent,
            offset = Offset(x = it.textX, y = it.textY)
        ) {
            Text(text = it.text)
        }
    }

    // Bottom String labels (number/note)
    stringBottomLabelPositions.forEach {
        drawComposable(
            size = PositionalLayoutSize.WrapContent,
            offset = Offset(x = it.textX, y = it.textY)
        ) {
            Text(text = it.text)
        }
    }
}

@Composable
private fun ComposableDrawScope.drawBars(
    barLinePaths: List<BarPosition>,
    barLineBrush: Brush,
    showFingerNumbers: Boolean
) {
    // Bars
    barLinePaths.forEach {
        // Draw Bar
        drawRoundRect(
            topLeft = Offset(x = it.left, y = it.top),
            size = Size(width = it.right - it.left, height = it.bottom - it.top),
            cornerRadius = CornerRadius(x = (it.bottom - it.top), y = (it.bottom - it.top)),
            brush = barLineBrush
        )

        // Text
        if (showFingerNumbers) {
            drawComposable(
                size = PositionalLayoutSize.WrapContent,
                offset = Offset(x = it.textX, y = it.textY)
            ) {
                Text(text = it.text)
            }
        }
    }
}

@Composable
private fun ComposableDrawScope.drawNotes(
    notePositions: List<NotePosition>,
    noteSize: Float,
    noteBrush: Brush,
    showFingerNumbers: Boolean
) {
    // Individual notes
    notePositions.forEach {
        drawCircle(
            brush = noteBrush,
            radius = noteSize / 2f,
            center = Offset(x = it.circleX, y = it.circleY)
        )

        if (showFingerNumbers) {
            drawComposable(
                size = PositionalLayoutSize.WrapContent,
                offset = Offset(x = it.textX, y = it.textY)
            ) {
                Text(text = it.text)
            }
        }
    }
}
