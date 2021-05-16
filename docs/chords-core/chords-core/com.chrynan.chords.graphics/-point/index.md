//[chords-core](../../../index.md)/[com.chrynan.chords.graphics](../index.md)/[Point](index.md)



# Point  
 [js] data class [Point](index.md)(**x**: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), **y**: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html))

A model of two coordinates, x and y, that make up a point. This is useful for referencing a point with a [HTMLCanvasElement](https://kotlinlang.org/api/latest/jvm/stdlib/org.w3c.dom/-h-t-m-l-canvas-element/index.html).



Note that these values are all [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)s.



#### Author  


chRyNaN

   


## Constructors  
  
| | |
|---|---|
| <a name="com.chrynan.chords.graphics/Point/Point/#kotlin.Double#kotlin.Double/PointingToDeclaration/"></a>[Point](-point.md)| <a name="com.chrynan.chords.graphics/Point/Point/#kotlin.Double#kotlin.Double/PointingToDeclaration/"></a> [js] fun [Point](-point.md)(x: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), y: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html))   <br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.graphics/Point/inset/#kotlin.Double#kotlin.Double/PointingToDeclaration/"></a>[inset](inset.md)| <a name="com.chrynan.chords.graphics/Point/inset/#kotlin.Double#kotlin.Double/PointingToDeclaration/"></a>[js]  <br>Content  <br>fun [inset](inset.md)(dx: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), dy: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)): [Point](index.md)  <br>More info  <br>Retrieves a new [Point](index.md) by insetting this [Point](index.md)'s values by subtracting [dx](inset.md) and [dy](inset.md).  <br><br><br>|
| <a name="com.chrynan.chords.graphics/Point/negate/#/PointingToDeclaration/"></a>[negate](negate.md)| <a name="com.chrynan.chords.graphics/Point/negate/#/PointingToDeclaration/"></a>[js]  <br>Content  <br>fun [negate](negate.md)(): [Point](index.md)  <br>More info  <br>Retrieves a new [Point](index.md) by whose values are the negative of this [Point](index.md)'s values.  <br><br><br>|
| <a name="com.chrynan.chords.graphics/Point/offset/#kotlin.Double#kotlin.Double/PointingToDeclaration/"></a>[offset](offset.md)| <a name="com.chrynan.chords.graphics/Point/offset/#kotlin.Double#kotlin.Double/PointingToDeclaration/"></a>[js]  <br>Content  <br>fun [offset](offset.md)(dx: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), dy: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)): [Point](index.md)  <br>More info  <br>Retrieves a new [Point](index.md) by offsetting this [Point](index.md)'s values by adding [dx](offset.md) and [dy](offset.md).  <br><br><br>|
| <a name="com.chrynan.chords.graphics/Point/plus/#kotlin.Double/PointingToDeclaration/"></a>[plus](plus.md)| <a name="com.chrynan.chords.graphics/Point/plus/#kotlin.Double/PointingToDeclaration/"></a>[js]  <br>Content  <br>operator fun [plus](plus.md)(value: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)): [Point](index.md)  <br>More info  <br>Retrieves a new [Point](index.md) by adding [value](plus.md) to both [x](x.md) and [y](y.md).  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.graphics/Point/x/#/PointingToDeclaration/"></a>[x](x.md)| <a name="com.chrynan.chords.graphics/Point/x/#/PointingToDeclaration/"></a> [js] val [x](x.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)The x coordinate value.   <br>|
| <a name="com.chrynan.chords.graphics/Point/y/#/PointingToDeclaration/"></a>[y](y.md)| <a name="com.chrynan.chords.graphics/Point/y/#/PointingToDeclaration/"></a> [js] val [y](y.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)The y coordinate value.   <br>|

