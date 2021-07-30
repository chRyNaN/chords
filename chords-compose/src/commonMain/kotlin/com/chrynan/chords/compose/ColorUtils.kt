package com.chrynan.chords.compose

import com.chrynan.colors.*

/**
 * Converts this [Color] to a Jetpack Compose compatible [androidx.compose.ui.graphics.Color].
 */
@ExperimentalUnsignedTypes
fun Color.toJetpackComposeColor(): androidx.compose.ui.graphics.Color =
    androidx.compose.ui.graphics.Color(colorLong.value.toULong())

/**
 * Converts this [androidx.compose.ui.graphics.Color] to a Kotlin Multiplatform compatible [Color].
 */
@ExperimentalUnsignedTypes
fun androidx.compose.ui.graphics.Color.toMultiplatformColor(): Color =
    Color(colorLong = ColorLong(value = value))
