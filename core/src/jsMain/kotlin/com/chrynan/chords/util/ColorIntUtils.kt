package com.chrynan.chords.util

import com.chrynan.colors.ColorInt

interface Color {

    companion object {

        val BLACK = rgba(red = 0, green = 0, blue = 0, alpha = 255)
        val WHITE = rgba(red = 255, green = 255, blue = 255, alpha = 255)
    }

    val colorInt: ColorInt

    val value: String
}

inline class RgbaColor(override val colorInt: ColorInt) : Color {

    override val value: String
        get() = toString()

    private val alpha: Int
        get() = (colorInt shr 24) and 0xff

    private val red: Int
        get() = (colorInt shr 16) and 0xff

    private val green: Int
        get() = (colorInt shr 8) and 0xff

    private val blue: Int
        get() = colorInt and 0xff

    override fun toString(): String = "rgba($red, $green, $blue, $alpha)"
}

inline class HexString(val value: String) {

    companion object {

        const val BIT_COUNT = 16
        const val HEX_CHAR = '#'
        const val HEX_CHAR_LOCATION = 0
        const val LENGTH_WITHOUT_ALPHA = 7
        const val LENGTH_WITH_ALPHA = 9
        private const val REGEX_PATTERN = "^#?[0-9A-Fa-f]+\$"

        val REGEX = Regex(REGEX_PATTERN)
    }

    override fun toString(): String = if (value.startsWith(HEX_CHAR)) value else "#$value"
}

fun ColorInt.toRgbaColor(): RgbaColor = RgbaColor(colorInt = this)

fun Int.coerceInSRGBColorRange(): Int = this.coerceIn(0, 255)

fun rgba(red: Int, green: Int, blue: Int, alpha: Int = -0x1000000): RgbaColor {
    val a = alpha.coerceInSRGBColorRange()
    val r = red.coerceInSRGBColorRange()
    val g = green.coerceInSRGBColorRange()
    val b = blue.coerceInSRGBColorRange()

    val colorInt = ((a and 0xff) shl 24) or
            ((r and 0xff) shl 16) or
            ((g and 0xff) shl 8) or
            (b and 0xff)

    return RgbaColor(colorInt)
}

fun hex(hexString: HexString): RgbaColor {
    require(HexString.REGEX.matches(hexString.value))

    val hexValue = hexString.value

    val hexStringInt = if (hexValue[HexString.HEX_CHAR_LOCATION] == HexString.HEX_CHAR) {
        hexValue.subSequence(
            startIndex = 1,
            endIndex = hexValue.length
        ).toString()
    } else {
        hexValue
    }

    var colorInt = hexStringInt.toInt(radix = HexString.BIT_COUNT)

    if (hexStringInt.length == HexString.LENGTH_WITHOUT_ALPHA) {
        // Set the alpha value
        colorInt = colorInt or -0x1000000
    } else if (hexStringInt.length != HexString.LENGTH_WITH_ALPHA) {
        throw IllegalArgumentException("Unknown color from hex value.")
    }

    return RgbaColor(colorInt)
}