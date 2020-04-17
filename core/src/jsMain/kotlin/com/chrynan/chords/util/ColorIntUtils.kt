package com.chrynan.chords.util

import com.chrynan.chords.model.ColorInt

interface Color {

    companion object {

        val BLACK = HexColor(colorInt = -0x1000000)
        val WHITE = HexColor(colorInt = -0x1)
    }

    val colorInt: ColorInt

    val value: String
}

inline class RgbaColor(override val colorInt: ColorInt) : Color {

    override val value: String
        get() = toString()

    override fun toString(): String = "rgba(${colorInt.red}, ${colorInt.green}, ${colorInt.blue}, ${colorInt.alpha})"
}

inline class HexColor(override val colorInt: ColorInt) : Color {

    override val value: String
        get() = toString()

    override fun toString(): String = colorInt.toString(16).padStart(6, '0')
}

val ColorInt.alpha: Int
    get() = (this shr 24) and 0xff

val ColorInt.red: Int
    get() = (this shr 16) and 0xff

val ColorInt.green: Int
    get() = (this shr 8) and 0xff

val ColorInt.blue: Int
    get() = this and 0xff

fun ColorInt.toRgbaColor(): RgbaColor = RgbaColor(colorInt = this)

fun ColorInt.toHexColor(): HexColor = HexColor(colorInt = this)