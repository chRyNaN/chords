@file:Suppress("unused")

package com.chrynan.chords.compose

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import com.chrynan.chords.model.*

@ExperimentalUnsignedTypes
@Composable
fun ChordWidget(
    modifier: Modifier = Modifier,
    chord: Chord? = null,
    chart: ChordChart = ChordChart.STANDARD_TUNING_GUITAR_CHART,
    viewModel: ChordViewModel = ChordViewModel()
) {
    BoxWithConstraints(modifier = modifier) {
        val size = calculateSize(
            fitToHeight = viewModel.fitToHeight,
            showFretNumbers = viewModel.showFretNumbers,
            showBottomStringLabels = showBottomStringLabels(
                stringLabelState = viewModel.stringLabelState,
                stringLabels = chart.stringLabels
            ),
            stringCount = chart.stringCount,
            fretCount = chart.fretCount
        )
        val barLinePositions = calculateBarLinePositions(
            bars = chord?.bars ?: emptySet(),
            fretStart = chart.fretStart.number,
            fretEnd = chart.fretEnd.number,
            stringCount = chart.stringCount,
            size = size
        )
        val fretNumberPositions = calculateFretNumberPositions(
            fretStart = chart.fretStart.number,
            fretEnd = chart.fretEnd.number,
            size = size
        )
        val fretPositions = calculateFretPositions(
            fretCount = chart.fretCount,
            size = size
        )
        val notePositions = calculateNotePositions(
            notes = chord?.notes ?: emptySet(),
            fretStart = chart.fretStart.number,
            fretEnd = chart.fretEnd.number,
            stringCount = chart.stringCount,
            size = size
        )
        val topMarkerPositions = calculateStringTopMarkerPositions(
            mutes = chord?.mutes ?: emptySet(),
            opens = chord?.opens ?: emptySet(),
            stringCount = chart.stringCount,
            size = size,
            mutedStringText = viewModel.mutedStringText,
            openStringText = viewModel.openStringText
        )
        val bottomLabelPositions = calculateStringBottomLabelPositions(
            stringLabels = chart.stringLabels,
            showBottomStringLabels = showBottomStringLabels(
                stringLabelState = viewModel.stringLabelState,
                stringLabels = chart.stringLabels
            ),
            stringLabelState = viewModel.stringLabelState,
            stringCount = chart.stringCount,
            size = size
        )
        val stringPositions = calculateStringPositions(
            stringCount = chart.stringCount,
            fretCount = chart.fretCount,
            size = size
        )

        ComposableCanvas(modifier = Modifier.fillMaxSize()) {
            // First draw the strings and fret markers
            fretPositions.forEach {
                drawLine(
                    start = Offset(x = it.left, y = it.top),
                    end = Offset(x = it.right, y = it.bottom),
                    color = Color.Black // TODO update color
                )
            }
            stringPositions.forEach {
                drawLine(
                    start = Offset(x = it.left, y = it.top),
                    end = Offset(x = it.right, y = it.bottom),
                    color = Color.Black // TODO update color
                )
            }

            drawFretNumbers(
                fretNumberPoints = fretNumberPositions,
                chart = chart,
                showFretNumbers = viewModel.showFretNumbers
            )

            drawStringMarkers(
                stringTopMarkerPositions = topMarkerPositions,
                stringBottomLabelPositions = bottomLabelPositions
            )

            drawBars(
                barLinePaths = barLinePositions,
                barLineBrush = SolidColor(Color.Black), // TODO SolidColor(viewModel.noteColor),
                showFingerNumbers = viewModel.showFingerNumbers
            )

            drawNotes(
                notePositions = notePositions,
                noteSize = size.noteSize,
                noteBrush = SolidColor(Color.Companion.Black), // TODO SolidColor(viewModel.noteColor),
                showFingerNumbers = viewModel.showFingerNumbers
            )
        }
    }
}
