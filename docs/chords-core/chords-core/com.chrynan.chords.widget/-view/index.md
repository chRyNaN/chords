//[chords-core](../../../index.md)/[com.chrynan.chords.widget](../index.md)/[View](index.md)

# View

[js]\
abstract class [View](index.md)

A base Widget View for Javascript, mimicking some of the functionality of an Android View.

#### Author

chRyNaN

## Constructors

| | |
|---|---|
| [View](-view.md) | [js]<br>fun [View](-view.md)() |

## Functions

| Name | Summary |
|---|---|
| [render](render.md) | [js]<br>fun [render](render.md)()<br>This function invokes a layout pass to occur. This will invoke the [onMeasure](../../../../chords-core/com.chrynan.chords.widget/-view/on-measure.md) and [onDraw](../../../../chords-core/com.chrynan.chords.widget/-view/on-draw.md) functions. |

## Properties

| Name | Summary |
|---|---|
| [canvas](canvas.md) | [js]<br>abstract val [canvas](canvas.md): [HTMLCanvasElement](https://kotlinlang.org/api/latest/jvm/stdlib/org.w3c.dom/-h-t-m-l-canvas-element/index.html) |
| [paddingBottom](padding-bottom.md) | [js]<br>var [paddingBottom](padding-bottom.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0 |
| [paddingLeft](padding-left.md) | [js]<br>var [paddingLeft](padding-left.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0 |
| [paddingRight](padding-right.md) | [js]<br>var [paddingRight](padding-right.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0 |
| [paddingTop](padding-top.md) | [js]<br>var [paddingTop](padding-top.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0 |

## Inheritors

| Name |
|---|
| [ChordWidget](../[js]-chord-widget/index.md) |
