@file:Suppress("unused")

package com.chrynan.chords.compose

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import com.chrynan.chords.model.*

@ExperimentalUnsignedTypes
@Composable
fun ChordWidget(
    modifier: Modifier = Modifier,
    chord: Chord? = null,
    chart: ChordChart = ChordChart.STANDARD_TUNING_GUITAR_CHART,
    viewData: ChordViewData = ChordViewData()
) {
    val constraintState = remember { mutableStateOf<ChordWidgetConstraints?>(null) }

    BoxWithConstraints(modifier = modifier.onSizeChanged {
        constraintState.value = calculateChordConstraints(
            maxWidth = it.width.toFloat(),
            maxHeight = it.height.toFloat(),
            chord = chord,
            chart = chart,
            viewModel = viewData
        )
    }) {
        val density = LocalDensity.current
        val scope = ConstraintScopeSource(boxWithConstraintsScope = this, density = density)

        scope.apply {
            constraintState.value?.let { constraints ->
                ComposableCanvas(modifier = Modifier.fillMaxSize()) {
                    // First draw the strings and fret markers
                    drawFrets(
                        fretPositions = constraints.fretPositions,
                        color = viewData.fretColor.toJetpackComposeColor()
                    )
                    drawStrings(
                        stringPositions = constraints.stringPositions,
                        color = viewData.stringColor.toJetpackComposeColor()
                    )

                    drawBars(
                        barLinePaths = constraints.barPositions,
                        barLineBrush = SolidColor(viewData.noteColor.toJetpackComposeColor())
                    )

                    drawNotes(
                        notePositions = constraints.notePositions,
                        noteSize = constraints.size.noteSize,
                        noteBrush = SolidColor(viewData.noteColor.toJetpackComposeColor())
                    )
                }

                DrawFretNumbers(
                    fretNumberPoints = constraints.fretNumberPositions,
                    chart = chart,
                    showFretNumbers = viewData.showFretNumbers,
                    color = viewData.fretLabelTextColor.toJetpackComposeColor()
                )

                DrawStringMarkers(
                    stringTopMarkerPositions = constraints.topMarkerPositions,
                    stringBottomLabelPositions = constraints.bottomLabelPositions,
                    color = viewData.stringLabelTextColor.toJetpackComposeColor()
                )

                DrawBarText(
                    showFingerNumbers = viewData.showFingerNumbers,
                    barLinePositions = constraints.barPositions,
                    color = viewData.noteLabelTextColor.toJetpackComposeColor()
                )

                DrawNoteText(
                    showFingerNumbers = viewData.showFingerNumbers,
                    notePositions = constraints.notePositions,
                    color = viewData.noteLabelTextColor.toJetpackComposeColor()
                )
            }
        }
    }
}
