package com.chrynan.chords.compose

import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import com.chrynan.chords.model.ChordChart

internal fun ComposableDrawScope.drawFretNumbers(
    fretNumberPoints: List<Offset>,
    chart: ChordChart,
    showFretNumbers: Boolean
) {
    // Fret numbers; check if we are showing them or not
    if (showFretNumbers) {
        fretNumberPoints.forEachIndexed { index, point ->
            drawComposable {
                Text(
                    modifier = Modifier.offset(x = point.x.toDp(), y = point.y.toDp()),
                    text = (chart.fretStart.number + index).toString()
                )
            }
        }
    }
}

internal fun ComposableDrawScope.drawStringMarkers(
    stringTopMarkerPositions: List<StringPosition>,
    stringBottomLabelPositions: List<StringPosition>,
) {
    // Top String markers (open/muted)
    stringTopMarkerPositions.forEach {
        drawComposable {
            Text(
                modifier = Modifier.offset(x = it.textX.toDp(), y = it.textY.toDp()),
                text = it.text
            )
        }
    }

    // Bottom String labels (number/note)
    stringBottomLabelPositions.forEach {
        drawComposable {
            Text(
                modifier = Modifier.offset(x = it.textX.toDp(), y = it.textY.toDp()),
                text = it.text
            )
        }
    }
}

internal fun ComposableDrawScope.drawBars(
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
            drawComposable {
                Text(
                    modifier = Modifier.offset(x = it.textX.toDp(), y = it.textY.toDp()),
                    text = it.text
                )
            }
        }
    }
}

internal fun ComposableDrawScope.drawNotes(
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
            drawComposable {
                Text(
                    modifier = Modifier.offset(x = it.textX.toDp(), y = it.textY.toDp()),
                    text = it.text
                )
            }
        }
    }
}
