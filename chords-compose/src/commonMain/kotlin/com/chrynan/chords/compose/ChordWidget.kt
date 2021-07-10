@file:Suppress("unused")

package com.chrynan.chords.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.SubcomposeLayout
import com.chrynan.chords.model.Chord
import com.chrynan.chords.model.ChordChart
import com.chrynan.chords.model.ChordViewModel

@ExperimentalUnsignedTypes
@Composable
fun ChordWidget(
    modifier: Modifier = Modifier,
    chord: Chord? = null,
    chart: ChordChart = ChordChart.STANDARD_TUNING_GUITAR_CHART,
    viewModel: ChordViewModel = ChordViewModel()
) {
    Text(modifier = modifier.offset(), text = "")
    BoxWithConstraints {
    }
    Canvas(modifier = modifier) {

    }
    Layout(content = { }, modifier = Modifier.then()) { measurables, constraints ->
        measurables.forEach { it.measure() }
        measurables.forEach { it.parentData }
        layout(0, 0) {

        }
    }
    PositionalLayout {

    }
}

@Composable
private fun ComposableDrawScope.drawFretNumbers(
    modifier: Modifier,
    fretNumberPoints: List<Offset>,
    chart: ChordChart,
    fretLabelTextBrush: Brush,
    showFretNumbers: Boolean
) {
    // Fret numbers; check if we are showing them or not
    if (showFretNumbers) {
        fretNumberPoints.forEachIndexed { index, point ->
            drawComposable(width = , height = , offset = ) {

            }
            // TODO drawText((chart.fretStart.number + index).toString(), point.x, point.y, fretLabelTextPaint)
        }
    }
}

private fun DrawScope.drawStringMarkers(
    stringTopMarkerPositions: List<StringPosition>,
    stringBottomLabelPositions: List<StringPosition>,
    stringLabelTextBrush: Brush
) {
    // Top String markers (open/muted)
    stringTopMarkerPositions.forEach {
        // TODO drawText(it.text, it.textX, it.textY, stringLabelTextPaint)
    }

    // Bottom String labels (number/note)
    stringBottomLabelPositions.forEach {
        // TODO drawText(it.text, it.textX, it.textY, stringLabelTextPaint)
    }
}

private fun DrawScope.drawBars(
    barLinePaths: List<BarPosition>,
    barLineBrush: Brush,
    noteLabelTextBrush: Brush,
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
            // TODO canvas.drawText(it.text, it.textX, it.textY, noteLabelTextPaint)
        }
    }
}

private fun DrawScope.drawNotes(
    notePositions: List<NotePosition>,
    noteSize: Float,
    noteBrush: Brush,
    noteLabelTextBrush: Brush,
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
            // TODO drawText(it.text, it.textX, it.textY, noteLabelTextBrush)
        }
    }
}
