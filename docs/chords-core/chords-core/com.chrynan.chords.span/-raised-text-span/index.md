//[chords-core](../../../index.md)/[com.chrynan.chords.span](../index.md)/[RaisedTextSpan](index.md)

# RaisedTextSpan

[android]\
class [RaisedTextSpan](index.md) : [ReplacementSpan](https://developer.android.com/reference/kotlin/android/text/style/ReplacementSpan.html)

Raises the spanned text and removes the width so that the following text can be drawn underneath it.

For example, consider the following text: "Example". If we were to raise the letter 'p', then the output would look like the following:

        p\
    Examle

## Constructors

| | |
|---|---|
| [RaisedTextSpan](-raised-text-span.md) | [android]<br>fun [RaisedTextSpan](-raised-text-span.md)() |

## Functions

| Name | Summary |
|---|---|
| [draw](draw.md) | [android]<br>open override fun [draw](draw.md)(canvas: [Canvas](https://developer.android.com/reference/kotlin/android/graphics/Canvas.html), text: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), x: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), top: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), y: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), bottom: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), paint: [Paint](https://developer.android.com/reference/kotlin/android/graphics/Paint.html)) |
| [getContentDescription](index.md#1850017719%2FFunctions%2F759375805) | [android]<br>open fun [getContentDescription](index.md#1850017719%2FFunctions%2F759375805)(): [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)? |
| [getSize](get-size.md) | [android]<br>open override fun [getSize](get-size.md)(paint: [Paint](https://developer.android.com/reference/kotlin/android/graphics/Paint.html), text: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), fm: [Paint.FontMetricsInt](https://developer.android.com/reference/kotlin/android/graphics/Paint.FontMetricsInt.html)?): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getUnderlying](index.md#969998514%2FFunctions%2F759375805) | [android]<br>open override fun [getUnderlying](index.md#969998514%2FFunctions%2F759375805)(): [MetricAffectingSpan](https://developer.android.com/reference/kotlin/android/text/style/MetricAffectingSpan.html) |
| [setContentDescription](index.md#-2092785616%2FFunctions%2F759375805) | [android]<br>open fun [setContentDescription](index.md#-2092785616%2FFunctions%2F759375805)(p0: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?) |
| [updateDrawState](index.md#-1711153891%2FFunctions%2F759375805) | [android]<br>open override fun [updateDrawState](index.md#-1711153891%2FFunctions%2F759375805)(p0: [TextPaint](https://developer.android.com/reference/kotlin/android/text/TextPaint.html)) |
| [updateMeasureState](index.md#-104669249%2FFunctions%2F759375805) | [android]<br>open override fun [updateMeasureState](index.md#-104669249%2FFunctions%2F759375805)(p0: [TextPaint](https://developer.android.com/reference/kotlin/android/text/TextPaint.html)) |
