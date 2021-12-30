package com.chrynan.chords.sample.compose

import androidx.compose.runtime.Composable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import com.chrynan.chords.compose.toJetpackComposeColor
import com.chrynan.colors.compose.isSystemInDarkTheme
import com.chrynan.colors.theme.Colors
import com.chrynan.colors.theme.*

/**
 * A Composable function to create a [MaterialTheme] with the provided [Colors] class.
 *
 * @see [MaterialTheme]
 */
@ExperimentalUnsignedTypes
@Composable
fun MaterialTheme(
    colors: Colors,
    typography: Typography = MaterialTheme.typography,
    shapes: Shapes = MaterialTheme.shapes,
    content: @Composable () -> Unit
) = MaterialTheme(
    colors = colors.toComposeColors(),
    typography = typography,
    shapes = shapes,
    content = content
)

/**
 * A Composable function to create a [MaterialTheme] with the provided [Colors] class.
 *
 * @see [MaterialTheme]
 */
@ExperimentalUnsignedTypes
@Composable
fun MaterialTheme(
    colorTheme: ColorTheme,
    typography: Typography = MaterialTheme.typography,
    shapes: Shapes = MaterialTheme.shapes,
    content: @Composable () -> Unit
) = MaterialTheme(
    colors = colorTheme.colors().toComposeColors(),
    typography = typography,
    shapes = shapes,
    content = content
)

/**
 * A Composable function to create a [MaterialTheme] with the provided [Colors] class.
 *
 * @see [MaterialTheme]
 */
@ExperimentalUnsignedTypes
@Composable
fun MaterialTheme(
    colorTheme: LightDarkColorTheme,
    typography: Typography = MaterialTheme.typography,
    shapes: Shapes = MaterialTheme.shapes,
    content: @Composable () -> Unit
) = MaterialTheme(
    colors = colorTheme.systemBasedColors().toComposeColors(),
    typography = typography,
    shapes = shapes,
    content = content
)

/**
 * Obtains the appropriate [Colors] instance of this [LightDarkColorTheme] depending on the result
 * of the [isSystemInDarkTheme] function. If [isSystemInDarkTheme] returns true, then the
 * [LightDarkColorTheme.dark] [Colors] will be returned. Otherwise, the [LightDarkColorTheme.light]
 * [Colors] will be returned.
 */
@Composable
fun LightDarkColorTheme.systemBasedColors(): Colors = if (isSystemInDarkTheme()) dark else light

/**
 * Converts this [Colors] value to a Jetpack Compose [androidx.compose.material.Colors] value.
 */
@ExperimentalUnsignedTypes
fun Colors.toComposeColors(): androidx.compose.material.Colors =
    if (isLight) {
        androidx.compose.material.lightColors(
            primary = primary.toJetpackComposeColor(),
            primaryVariant = primaryVariant.toJetpackComposeColor(),
            secondary = secondary.toJetpackComposeColor(),
            secondaryVariant = secondaryVariant.toJetpackComposeColor(),
            background = backgroundPrimary.toJetpackComposeColor(),
            surface = backgroundSecondary.toJetpackComposeColor(),
            error = error.toJetpackComposeColor(),
            onPrimary = onPrimary.toJetpackComposeColor(),
            onSecondary = onSecondary.toJetpackComposeColor(),
            onBackground = onBackgroundPrimary.toJetpackComposeColor(),
            onSurface = onBackgroundSecondary.toJetpackComposeColor(),
            onError = onError.toJetpackComposeColor()
        )
    } else {
        androidx.compose.material.darkColors(
            primary = primary.toJetpackComposeColor(),
            primaryVariant = primaryVariant.toJetpackComposeColor(),
            secondary = secondary.toJetpackComposeColor(),
            background = backgroundPrimary.toJetpackComposeColor(),
            surface = backgroundSecondary.toJetpackComposeColor(),
            error = error.toJetpackComposeColor(),
            onPrimary = onPrimary.toJetpackComposeColor(),
            onSecondary = onSecondary.toJetpackComposeColor(),
            onBackground = onBackgroundPrimary.toJetpackComposeColor(),
            onSurface = onBackgroundSecondary.toJetpackComposeColor(),
            onError = onError.toJetpackComposeColor()
        )
    }
