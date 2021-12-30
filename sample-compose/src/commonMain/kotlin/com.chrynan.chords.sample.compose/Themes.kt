@file:Suppress("unused")

package com.chrynan.chords.sample.compose

import com.chrynan.colors.theme.*
import com.chrynan.colors.Color

private object DefaultColorTheme : LightDarkColorTheme {

    override val light: Colors = lightColors(
        primary = Color("#008dd5"),
        primaryVariant = Color("#373f51"),
        secondary = Color("#f56476"),
        secondaryVariant = Color("#e43f6f"),
        background = Color.White,
        backgroundSecondary = Color("#dfbbb1"),
        textPrimary = Color.Black,
        textSecondary = Color.Black.copy(alpha = 0.5f),
        textTertiary = Color.White
    )

    override val dark: Colors = darkColors()
}

val ColorThemes.default: LightDarkColorTheme
    get() = DefaultColorTheme
