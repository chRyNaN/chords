//[chords-core](../../../index.md)/[com.chrynan.chords.graphics](../index.md)/[Point](index.md)

# Point

[js]\
data class [Point](index.md)(x: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), y: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html))

A model of two coordinates, x and y, that make up a point. This is useful for referencing a point with a [HTMLCanvasElement](https://kotlinlang.org/api/latest/jvm/stdlib/org.w3c.dom/-h-t-m-l-canvas-element/index.html).

Note that these values are all [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)s.

#### Author

chRyNaN

## Constructors

| | |
|---|---|
| [Point](-point.md) | [js]<br>fun [Point](-point.md)(x: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), y: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [inset](inset.md) | [js]<br>fun [inset](inset.md)(dx: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), dy: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)): [Point](index.md)<br>Retrieves a new [Point](index.md) by insetting this [Point](index.md)'s values by subtracting [dx](inset.md) and [dy](inset.md). |
| [negate](negate.md) | [js]<br>fun [negate](negate.md)(): [Point](index.md)<br>Retrieves a new [Point](index.md) by whose values are the negative of this [Point](index.md)'s values. |
| [offset](offset.md) | [js]<br>fun [offset](offset.md)(dx: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), dy: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)): [Point](index.md)<br>Retrieves a new [Point](index.md) by offsetting this [Point](index.md)'s values by adding [dx](offset.md) and [dy](offset.md). |
| [plus](plus.md) | [js]<br>operator fun [plus](plus.md)(value: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)): [Point](index.md)<br>Retrieves a new [Point](index.md) by adding [value](plus.md) to both [x](x.md) and [y](y.md). |

## Properties

| Name | Summary |
|---|---|
| [x](x.md) | [js]<br>val [x](x.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>The x coordinate value. |
| [y](y.md) | [js]<br>val [y](y.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>The y coordinate value. |
