@file:Suppress("unused")

package com.chrynan.chords.compose

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalDensity
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
        val density = LocalDensity.current
        val scope = ConstraintScopeSource(boxWithConstraintsScope = this, density = density)

        scope.apply {
            val constraints = calculateChordConstraints(
                chord = chord,
                chart = chart,
                viewModel = viewModel
            )

            ComposableCanvas(modifier = Modifier.fillMaxSize()) {
                // First draw the strings and fret markers
                drawFrets(fretPositions = constraints.fretPositions)
                drawStrings(stringPositions = constraints.stringPositions)

                drawBars(
                    barLinePaths = constraints.barPositions,
                    barLineBrush = SolidColor(Color.Black) // TODO SolidColor(viewModel.noteColor),
                )

                drawNotes(
                    notePositions = constraints.notePositions,
                    noteSize = constraints.size.noteSize,
                    noteBrush = SolidColor(Color.Companion.Black) // TODO SolidColor(viewModel.noteColor),
                )
            }

            DrawFretNumbers(
                fretNumberPoints = constraints.fretNumberPositions,
                chart = chart,
                showFretNumbers = viewModel.showFretNumbers
            )

            DrawStringMarkers(
                stringTopMarkerPositions = constraints.topMarkerPositions,
                stringBottomLabelPositions = constraints.bottomLabelPositions
            )

            DrawBarText(
                showFingerNumbers = viewModel.showFingerNumbers,
                barLinePositions = constraints.barPositions
            )

            DrawNoteText(
                showFingerNumbers = viewModel.showFingerNumbers,
                notePositions = constraints.notePositions
            )
        }
    }
}
