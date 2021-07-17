package com.chrynan.chords.compose

import androidx.compose.ui.geometry.Rect

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
