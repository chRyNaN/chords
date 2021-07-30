package com.chrynan.chords.compose

import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.chrynan.chords.model.ChordChart

internal fun ComposableDrawScope.drawFrets(
    fretPositions: List<Rect>,
    color: Color
) {
    fretPositions.forEach {
        drawLine(
            start = Offset(x = it.left, y = it.top),
            end = Offset(x = it.right, y = it.bottom),
            color = color
        )
    }
}

internal fun ComposableDrawScope.drawStrings(
    stringPositions: List<Rect>,
    color: Color
) {
    stringPositions.forEach {
        drawLine(
            start = Offset(x = it.left, y = it.top),
            end = Offset(x = it.right, y = it.bottom),
            color = color
        )
    }
}

internal fun ComposableDrawScope.drawBars(
    barLinePaths: List<BarPosition>,
    barLineBrush: Brush
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
    }
}

internal fun ComposableDrawScope.drawNotes(
    notePositions: List<NotePosition>,
    noteSize: Float,
    noteBrush: Brush
) {
    // Individual notes
    notePositions.forEach {
        drawCircle(
            brush = noteBrush,
            radius = noteSize / 2f,
            center = Offset(x = it.circleX, y = it.circleY)
        )
    }
}

@Composable
internal fun ConstraintScope.DrawBarText(
    showFingerNumbers: Boolean,
    barLinePositions: List<BarPosition>,
    color: Color
) {
    if (showFingerNumbers) {
        barLinePositions.forEach {
            Text(
                modifier = Modifier.offset(x = it.textX.toDp(), y = it.textY.toDp()),
                text = it.text,
                textAlign = TextAlign.Start,
                color = color
            )
        }
    }
}

@Composable
internal fun ConstraintScope.DrawNoteText(
    showFingerNumbers: Boolean,
    notePositions: List<NotePosition>,
    color: Color
) {
    if (showFingerNumbers) {
        notePositions.forEach {
            Text(
                modifier = Modifier.offset(x = it.textX.toDp(), y = it.textY.toDp()),
                text = it.text,
                textAlign = TextAlign.Start,
                color = color
            )
        }
    }
}

@Composable
internal fun ConstraintScope.DrawFretNumbers(
    fretNumberPoints: List<Offset>,
    chart: ChordChart,
    showFretNumbers: Boolean,
    color: Color
) {
    // Fret numbers; check if we are showing them or not
    if (showFretNumbers) {
        fretNumberPoints.forEachIndexed { index, point ->
            Text(
                modifier = Modifier.offset(x = point.x.toDp(), y = point.y.toDp()),
                text = (chart.fretStart.number + index).toString(),
                textAlign = TextAlign.Start,
                color = color
            )
        }
    }
}

@Composable
internal fun ConstraintScope.DrawStringMarkers(
    stringTopMarkerPositions: List<StringPosition>,
    stringBottomLabelPositions: List<StringPosition>,
    color: Color
) {
    // Top String markers (open/muted)
    stringTopMarkerPositions.forEach {
        Text(
            modifier = Modifier.offset(x = it.textX.toDp(), y = it.textY.toDp()),
            text = it.text,
            textAlign = TextAlign.Start,
            color = color
        )
    }

    // Bottom String labels (number/note)
    stringBottomLabelPositions.forEach {
        Text(
            modifier = Modifier.offset(x = it.textX.toDp(), y = it.textY.toDp()),
            text = it.text,
            textAlign = TextAlign.Start,
            color = color
        )
    }
}
