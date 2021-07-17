package com.chrynan.chords.compose

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect

internal data class ChordWidgetConstraints(
    val size: ChordWidgetSizeConstraints,
    val barPositions: List<BarPosition>,
    val fretNumberPositions: List<Offset>,
    val fretPositions: List<Rect>,
    val notePositions: List<NotePosition>,
    val topMarkerPositions: List<StringPosition>,
    val bottomLabelPositions: List<StringPosition>,
    val stringPositions: List<Rect>
)
