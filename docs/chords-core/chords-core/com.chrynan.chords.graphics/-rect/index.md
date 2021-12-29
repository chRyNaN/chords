//[chords-core](../../../index.md)/[com.chrynan.chords.graphics](../index.md)/[Rect](index.md)

# Rect

[js]\
data class [Rect](index.md)(left: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), top: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), right: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), bottom: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html))

A model of a rectangle for a Javascript [HTMLCanvasElement](https://kotlinlang.org/api/latest/jvm/stdlib/org.w3c.dom/-h-t-m-l-canvas-element/index.html).

Note that this model considers the origin of the quadrant to be in the top left. So, on the x-axis, the values start at zero at the furthest left point and increase positively when moving to the right. And on the y-axis, the values start at zero at the highest top point and increase positively when moving to the bottom. So the Canvas quadrant that this [Rect](index.md) supports would look like the following:

(0, 0)                (x, 0)     +------------------>     |     |     |     | (0, y) |

This is important to consider because some of the properties depend on it. For instance, the [isEmpty](is-empty.md) property will return true if the top is greater than or equal to the bottom).

Also note that this [Rect](index.md) uses values of [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) for the four values. This is consistent with what the [CanvasRenderingContext2D.rect](https://kotlinlang.org/api/latest/jvm/stdlib/org.w3c.dom/-canvas-rendering-context2-d/rect.html) function expects.

#### Author

chRyNaN

## Constructors

| | |
|---|---|
| [Rect](-rect.md) | [js]<br>fun [Rect](-rect.md)(left: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, top: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, right: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, bottom: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0) |

## Functions

| Name | Summary |
|---|---|
| [contains](contains.md) | [js]<br>operator fun [contains](contains.md)(other: [Rect](index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Retrieves a [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) indicating whether the provided [other](index.md) is within this [Rect](index.md)'s bounds.<br>[js]<br>fun [contains](contains.md)(x: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), y: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Retrieves a [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) indicating whether the provided [x](contains.md) and [y](contains.md) coordinates are within this [Rect](index.md)'s bounds. |
| [inset](inset.md) | [js]<br>fun [inset](inset.md)(dx: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), dy: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)): [Rect](index.md)<br>Returns a new [Rect](index.md) by insetting this [Rect](index.md) by subtracting [dx](inset.md) to its [left](left.md) and [right](right.md) coordinates, and adding [dy](inset.md) to its [top](top.md) and [bottom](bottom.md) coordinates. |
| [offset](offset.md) | [js]<br>fun [offset](offset.md)(dx: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), dy: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)): [Rect](index.md)<br>Returns a new [Rect](index.md) by offsetting this [Rect](index.md) by adding [dx](offset.md) to its [left](left.md) and [right](right.md) coordinates, and adding [dy](offset.md) to its [top](top.md) and [bottom](bottom.md) coordinates. |
| [plus](plus.md) | [js]<br>operator fun [plus](plus.md)(other: [Rect](index.md)): [Rect](index.md)<br>Retrieves a new [Rect](index.md) by adding the provided [other](index.md)'s values with this [Rect](index.md). |
| [set](set.md) | [js]<br>fun [set](set.md)(left: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), top: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), right: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), bottom: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html))<br>Sets this [Rect](index.md)'s values as the provided values. |

## Properties

| Name | Summary |
|---|---|
| [bottom](bottom.md) | [js]<br>var [bottom](bottom.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0<br>The bottom coordinate of this [Rect](index.md). |
| [centerX](center-x.md) | [js]<br>val [centerX](center-x.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>The center x value of this [Rect](index.md). This is equivalent to ([left](left.md) + [right](right.md)) * 0.5. |
| [centerY](center-y.md) | [js]<br>val [centerY](center-y.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>The center y value of this [Rect](index.md). This is equivalent to ([top](top.md) + [bottom](bottom.md)) * 0.5. |
| [height](height.md) | [js]<br>val [height](height.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>The height of this [Rect](index.md). This is equivalent to [bottom](bottom.md) - [top](top.md). |
| [isEmpty](is-empty.md) | [js]<br>val [isEmpty](is-empty.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates whether this [Rect](index.md) is empty or not. A [Rect](index.md) is considered empty if either of it's sides have a size of zero or a negative number. |
| [isNotEmpty](is-not-empty.md) | [js]<br>val [isNotEmpty](is-not-empty.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>A convenience property that returns the opposite of [isEmpty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/index.html). |
| [left](left.md) | [js]<br>var [left](left.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0<br>The left coordinate of this [Rect](index.md). |
| [right](right.md) | [js]<br>var [right](right.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0<br>The right coordinate of this [Rect](index.md). |
| [top](top.md) | [js]<br>var [top](top.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0<br>The top coordinate of this [Rect](index.md). |
| [width](width.md) | [js]<br>val [width](width.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>The width of this [Rect](index.md). This is equivalent to [right](right.md) minus [left](left.md). |
