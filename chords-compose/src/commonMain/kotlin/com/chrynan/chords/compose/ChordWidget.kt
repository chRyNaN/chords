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
import com.chrynan.chords.model.Chord
import com.chrynan.chords.model.ChordChart
import com.chrynan.chords.model.ChordViewModel
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
