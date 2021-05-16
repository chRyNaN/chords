//[chords-core](../../../index.md)/[com.chrynan.chords.graphics](../index.md)/[Paint](index.md)



# Paint  
 [js] data class [Paint](index.md)(**style**: [Paint.Style](-style/index.md), **fillColor**: Color, **strokeColor**: Color, **textAlign**: [Paint.Align](-align/index.md), **textSize**: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), **fontName**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **fillRule**: [Paint.FillRule](-fill-rule/index.md), **strokeWidth**: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), **strokeCap**: [Paint.Cap](-cap/index.md))

A convenience class that holds information about how to draw on a [HTMLCanvasElement](https://kotlinlang.org/api/latest/jvm/stdlib/org.w3c.dom/-h-t-m-l-canvas-element/index.html).



#### Author  


chRyNaN

   


## Constructors  
  
| | |
|---|---|
| <a name="com.chrynan.chords.graphics/Paint/Paint/#com.chrynan.chords.graphics.Paint.Style#com.chrynan.colors.Color#com.chrynan.colors.Color#com.chrynan.chords.graphics.Paint.Align#kotlin.Double#kotlin.String#com.chrynan.chords.graphics.Paint.FillRule#kotlin.Double#com.chrynan.chords.graphics.Paint.Cap/PointingToDeclaration/"></a>[Paint](-paint.md)| <a name="com.chrynan.chords.graphics/Paint/Paint/#com.chrynan.chords.graphics.Paint.Style#com.chrynan.colors.Color#com.chrynan.colors.Color#com.chrynan.chords.graphics.Paint.Align#kotlin.Double#kotlin.String#com.chrynan.chords.graphics.Paint.FillRule#kotlin.Double#com.chrynan.chords.graphics.Paint.Cap/PointingToDeclaration/"></a> [js] fun [Paint](-paint.md)(style: [Paint.Style](-style/index.md) = Style.FILL, fillColor: Color = Color.BLACK, strokeColor: Color = Color.BLACK, textAlign: [Paint.Align](-align/index.md) = Align.CENTER, textSize: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, fontName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = DEFAULT_FONT_NAME, fillRule: [Paint.FillRule](-fill-rule/index.md) = FillRule.EVEN_ODD, strokeWidth: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, strokeCap: [Paint.Cap](-cap/index.md) = Cap.BUTT)   <br>|


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.graphics/Paint.Align///PointingToDeclaration/"></a>[Align](-align/index.md)| <a name="com.chrynan.chords.graphics/Paint.Align///PointingToDeclaration/"></a>[js]  <br>Content  <br>enum [Align](-align/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[Paint.Align](-align/index.md)>   <br><br><br>|
| <a name="com.chrynan.chords.graphics/Paint.Cap///PointingToDeclaration/"></a>[Cap](-cap/index.md)| <a name="com.chrynan.chords.graphics/Paint.Cap///PointingToDeclaration/"></a>[js]  <br>Content  <br>enum [Cap](-cap/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[Paint.Cap](-cap/index.md)>   <br><br><br>|
| <a name="com.chrynan.chords.graphics/Paint.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.chords.graphics/Paint.Companion///PointingToDeclaration/"></a>[js]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|
| <a name="com.chrynan.chords.graphics/Paint.FillRule///PointingToDeclaration/"></a>[FillRule](-fill-rule/index.md)| <a name="com.chrynan.chords.graphics/Paint.FillRule///PointingToDeclaration/"></a>[js]  <br>Content  <br>enum [FillRule](-fill-rule/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[Paint.FillRule](-fill-rule/index.md)>   <br><br><br>|
| <a name="com.chrynan.chords.graphics/Paint.Style///PointingToDeclaration/"></a>[Style](-style/index.md)| <a name="com.chrynan.chords.graphics/Paint.Style///PointingToDeclaration/"></a>[js]  <br>Content  <br>enum [Style](-style/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[Paint.Style](-style/index.md)>   <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.graphics/Paint/fillColor/#/PointingToDeclaration/"></a>[fillColor](fill-color.md)| <a name="com.chrynan.chords.graphics/Paint/fillColor/#/PointingToDeclaration/"></a> [js] var [fillColor](fill-color.md): Color   <br>|
| <a name="com.chrynan.chords.graphics/Paint/fillRule/#/PointingToDeclaration/"></a>[fillRule](fill-rule.md)| <a name="com.chrynan.chords.graphics/Paint/fillRule/#/PointingToDeclaration/"></a> [js] var [fillRule](fill-rule.md): [Paint.FillRule](-fill-rule/index.md)   <br>|
| <a name="com.chrynan.chords.graphics/Paint/font/#/PointingToDeclaration/"></a>[font](font.md)| <a name="com.chrynan.chords.graphics/Paint/font/#/PointingToDeclaration/"></a> [js] val [font](font.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)   <br>|
| <a name="com.chrynan.chords.graphics/Paint/fontName/#/PointingToDeclaration/"></a>[fontName](font-name.md)| <a name="com.chrynan.chords.graphics/Paint/fontName/#/PointingToDeclaration/"></a> [js] var [fontName](font-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)   <br>|
| <a name="com.chrynan.chords.graphics/Paint/isFill/#/PointingToDeclaration/"></a>[isFill](is-fill.md)| <a name="com.chrynan.chords.graphics/Paint/isFill/#/PointingToDeclaration/"></a> [js] val [isFill](is-fill.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>|
| <a name="com.chrynan.chords.graphics/Paint/isStroke/#/PointingToDeclaration/"></a>[isStroke](is-stroke.md)| <a name="com.chrynan.chords.graphics/Paint/isStroke/#/PointingToDeclaration/"></a> [js] val [isStroke](is-stroke.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>|
| <a name="com.chrynan.chords.graphics/Paint/strokeCap/#/PointingToDeclaration/"></a>[strokeCap](stroke-cap.md)| <a name="com.chrynan.chords.graphics/Paint/strokeCap/#/PointingToDeclaration/"></a> [js] var [strokeCap](stroke-cap.md): [Paint.Cap](-cap/index.md)   <br>|
| <a name="com.chrynan.chords.graphics/Paint/strokeColor/#/PointingToDeclaration/"></a>[strokeColor](stroke-color.md)| <a name="com.chrynan.chords.graphics/Paint/strokeColor/#/PointingToDeclaration/"></a> [js] var [strokeColor](stroke-color.md): Color   <br>|
| <a name="com.chrynan.chords.graphics/Paint/strokeWidth/#/PointingToDeclaration/"></a>[strokeWidth](stroke-width.md)| <a name="com.chrynan.chords.graphics/Paint/strokeWidth/#/PointingToDeclaration/"></a> [js] var [strokeWidth](stroke-width.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0   <br>|
| <a name="com.chrynan.chords.graphics/Paint/style/#/PointingToDeclaration/"></a>[style](style.md)| <a name="com.chrynan.chords.graphics/Paint/style/#/PointingToDeclaration/"></a> [js] var [style](style.md): [Paint.Style](-style/index.md)   <br>|
| <a name="com.chrynan.chords.graphics/Paint/textAlign/#/PointingToDeclaration/"></a>[textAlign](text-align.md)| <a name="com.chrynan.chords.graphics/Paint/textAlign/#/PointingToDeclaration/"></a> [js] var [textAlign](text-align.md): [Paint.Align](-align/index.md)   <br>|
| <a name="com.chrynan.chords.graphics/Paint/textSize/#/PointingToDeclaration/"></a>[textSize](text-size.md)| <a name="com.chrynan.chords.graphics/Paint/textSize/#/PointingToDeclaration/"></a> [js] var [textSize](text-size.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0   <br>|

