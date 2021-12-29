package com.chrynan.chords.compose

import com.chrynan.colors.*

/**
 * Converts this [Color] to a Jetpack Compose compatible [androidx.compose.ui.graphics.Color].
 */
@ExperimentalUnsignedTypes
fun Color.toJetpackComposeColor(): androidx.compose.ui.graphics.Color =
    androidx.compose.ui.graphics.Color(colorLong.value.toULong())
