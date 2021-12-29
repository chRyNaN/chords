//[chords-core](../../../index.md)/[com.chrynan.chords.graphics](../index.md)/[Paint](index.md)

# Paint

[js]\
data class [Paint](index.md)(style: [Paint.Style](-style/index.md), fillColor: Color, strokeColor: Color, textAlign: [Paint.Align](-align/index.md), textSize: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), fontName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), fillRule: [Paint.FillRule](-fill-rule/index.md), strokeWidth: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), strokeCap: [Paint.Cap](-cap/index.md))

A convenience class that holds information about how to draw on a [HTMLCanvasElement](https://kotlinlang.org/api/latest/jvm/stdlib/org.w3c.dom/-h-t-m-l-canvas-element/index.html).

#### Author

chRyNaN

## Constructors

| | |
|---|---|
| [Paint](-paint.md) | [js]<br>fun [Paint](-paint.md)(style: [Paint.Style](-style/index.md) = Style.FILL, fillColor: Color = Color.Black, strokeColor: Color = Color.Black, textAlign: [Paint.Align](-align/index.md) = Align.CENTER, textSize: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, fontName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = DEFAULT_FONT_NAME, fillRule: [Paint.FillRule](-fill-rule/index.md) = FillRule.EVEN_ODD, strokeWidth: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, strokeCap: [Paint.Cap](-cap/index.md) = Cap.BUTT) |

## Types

| Name | Summary |
|---|---|
| [Align](-align/index.md) | [js]<br>enum [Align](-align/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[Paint.Align](-align/index.md)&gt; |
| [Cap](-cap/index.md) | [js]<br>enum [Cap](-cap/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[Paint.Cap](-cap/index.md)&gt; |
| [Companion](-companion/index.md) | [js]<br>object [Companion](-companion/index.md) |
| [FillRule](-fill-rule/index.md) | [js]<br>enum [FillRule](-fill-rule/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[Paint.FillRule](-fill-rule/index.md)&gt; |
| [Style](-style/index.md) | [js]<br>enum [Style](-style/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[Paint.Style](-style/index.md)&gt; |

## Properties

| Name | Summary |
|---|---|
| [fillColor](fill-color.md) | [js]<br>var [fillColor](fill-color.md): Color |
| [fillRule](fill-rule.md) | [js]<br>var [fillRule](fill-rule.md): [Paint.FillRule](-fill-rule/index.md) |
| [font](font.md) | [js]<br>val [font](font.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [fontName](font-name.md) | [js]<br>var [fontName](font-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [isFill](is-fill.md) | [js]<br>val [isFill](is-fill.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isStroke](is-stroke.md) | [js]<br>val [isStroke](is-stroke.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [strokeCap](stroke-cap.md) | [js]<br>var [strokeCap](stroke-cap.md): [Paint.Cap](-cap/index.md) |
| [strokeColor](stroke-color.md) | [js]<br>var [strokeColor](stroke-color.md): Color |
| [strokeWidth](stroke-width.md) | [js]<br>var [strokeWidth](stroke-width.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0 |
| [style](style.md) | [js]<br>var [style](style.md): [Paint.Style](-style/index.md) |
| [textAlign](text-align.md) | [js]<br>var [textAlign](text-align.md): [Paint.Align](-align/index.md) |
| [textSize](text-size.md) | [js]<br>var [textSize](text-size.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0 |
