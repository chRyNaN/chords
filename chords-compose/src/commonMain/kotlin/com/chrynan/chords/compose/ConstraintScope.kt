package com.chrynan.chords.compose

import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.ui.unit.Density

interface ConstraintScope : BoxWithConstraintsScope,
    Density

internal class ConstraintScopeSource(
    boxWithConstraintsScope: BoxWithConstraintsScope,
    density: Density
) : ConstraintScope,
    BoxWithConstraintsScope by boxWithConstraintsScope,
    Density by density
