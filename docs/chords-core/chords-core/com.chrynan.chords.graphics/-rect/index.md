//[chords-core](../../../index.md)/[com.chrynan.chords.graphics](../index.md)/[Rect](index.md)



# Rect  
 [js] data class [Rect](index.md)(**left**: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), **top**: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), **right**: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), **bottom**: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html))

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
| <a name="com.chrynan.chords.graphics/Rect/Rect/#kotlin.Double#kotlin.Double#kotlin.Double#kotlin.Double/PointingToDeclaration/"></a>[Rect](-rect.md)| <a name="com.chrynan.chords.graphics/Rect/Rect/#kotlin.Double#kotlin.Double#kotlin.Double#kotlin.Double/PointingToDeclaration/"></a> [js] fun [Rect](-rect.md)(left: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, top: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, right: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, bottom: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0)   <br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.graphics/Rect/contains/#com.chrynan.chords.graphics.Rect/PointingToDeclaration/"></a>[contains](contains.md)| <a name="com.chrynan.chords.graphics/Rect/contains/#com.chrynan.chords.graphics.Rect/PointingToDeclaration/"></a>[js]  <br>Content  <br>operator fun [contains](contains.md)(other: [Rect](index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Retrieves a [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) indicating whether the provided [other](index.md) is within this [Rect](index.md)'s bounds.  <br><br><br>[js]  <br>Content  <br>fun [contains](contains.md)(x: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), y: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Retrieves a [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) indicating whether the provided [x](contains.md) and [y](contains.md) coordinates are within this [Rect](index.md)'s bounds.  <br><br><br>|
| <a name="com.chrynan.chords.graphics/Rect/inset/#kotlin.Double#kotlin.Double/PointingToDeclaration/"></a>[inset](inset.md)| <a name="com.chrynan.chords.graphics/Rect/inset/#kotlin.Double#kotlin.Double/PointingToDeclaration/"></a>[js]  <br>Content  <br>fun [inset](inset.md)(dx: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), dy: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)): [Rect](index.md)  <br>More info  <br>Returns a new [Rect](index.md) by insetting this [Rect](index.md) by subtracting [dx](inset.md) to its [left](left.md) and [right](right.md) coordinates, and adding [dy](inset.md) to its [top](top.md) and [bottom](bottom.md) coordinates.  <br><br><br>|
| <a name="com.chrynan.chords.graphics/Rect/offset/#kotlin.Double#kotlin.Double/PointingToDeclaration/"></a>[offset](offset.md)| <a name="com.chrynan.chords.graphics/Rect/offset/#kotlin.Double#kotlin.Double/PointingToDeclaration/"></a>[js]  <br>Content  <br>fun [offset](offset.md)(dx: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), dy: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)): [Rect](index.md)  <br>More info  <br>Returns a new [Rect](index.md) by offsetting this [Rect](index.md) by adding [dx](offset.md) to its [left](left.md) and [right](right.md) coordinates, and adding [dy](offset.md) to its [top](top.md) and [bottom](bottom.md) coordinates.  <br><br><br>|
| <a name="com.chrynan.chords.graphics/Rect/plus/#com.chrynan.chords.graphics.Rect/PointingToDeclaration/"></a>[plus](plus.md)| <a name="com.chrynan.chords.graphics/Rect/plus/#com.chrynan.chords.graphics.Rect/PointingToDeclaration/"></a>[js]  <br>Content  <br>operator fun [plus](plus.md)(other: [Rect](index.md)): [Rect](index.md)  <br>More info  <br>Retrieves a new [Rect](index.md) by adding the provided [other](index.md)'s values with this [Rect](index.md).  <br><br><br>|
| <a name="com.chrynan.chords.graphics/Rect/set/#kotlin.Double#kotlin.Double#kotlin.Double#kotlin.Double/PointingToDeclaration/"></a>[set](set.md)| <a name="com.chrynan.chords.graphics/Rect/set/#kotlin.Double#kotlin.Double#kotlin.Double#kotlin.Double/PointingToDeclaration/"></a>[js]  <br>Content  <br>fun [set](set.md)(left: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), top: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), right: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), bottom: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html))  <br>More info  <br>Sets this [Rect](index.md)'s values as the provided values.  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.graphics/Rect/bottom/#/PointingToDeclaration/"></a>[bottom](bottom.md)| <a name="com.chrynan.chords.graphics/Rect/bottom/#/PointingToDeclaration/"></a> [js] var [bottom](bottom.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0The bottom coordinate of this [Rect](index.md).   <br>|
| <a name="com.chrynan.chords.graphics/Rect/centerX/#/PointingToDeclaration/"></a>[centerX](center-x.md)| <a name="com.chrynan.chords.graphics/Rect/centerX/#/PointingToDeclaration/"></a> [js] val [centerX](center-x.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)The center x value of this [Rect](index.md).   <br>|
| <a name="com.chrynan.chords.graphics/Rect/centerY/#/PointingToDeclaration/"></a>[centerY](center-y.md)| <a name="com.chrynan.chords.graphics/Rect/centerY/#/PointingToDeclaration/"></a> [js] val [centerY](center-y.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)The center y value of this [Rect](index.md).   <br>|
| <a name="com.chrynan.chords.graphics/Rect/height/#/PointingToDeclaration/"></a>[height](height.md)| <a name="com.chrynan.chords.graphics/Rect/height/#/PointingToDeclaration/"></a> [js] val [height](height.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)The height of this [Rect](index.md).   <br>|
| <a name="com.chrynan.chords.graphics/Rect/isEmpty/#/PointingToDeclaration/"></a>[isEmpty](is-empty.md)| <a name="com.chrynan.chords.graphics/Rect/isEmpty/#/PointingToDeclaration/"></a> [js] val [isEmpty](is-empty.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)Indicates whether this [Rect](index.md) is empty or not.   <br>|
| <a name="com.chrynan.chords.graphics/Rect/isNotEmpty/#/PointingToDeclaration/"></a>[isNotEmpty](is-not-empty.md)| <a name="com.chrynan.chords.graphics/Rect/isNotEmpty/#/PointingToDeclaration/"></a> [js] val [isNotEmpty](is-not-empty.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)A convenience property that returns the opposite of [isEmpty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/index.html).   <br>|
| <a name="com.chrynan.chords.graphics/Rect/left/#/PointingToDeclaration/"></a>[left](left.md)| <a name="com.chrynan.chords.graphics/Rect/left/#/PointingToDeclaration/"></a> [js] var [left](left.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0The left coordinate of this [Rect](index.md).   <br>|
| <a name="com.chrynan.chords.graphics/Rect/right/#/PointingToDeclaration/"></a>[right](right.md)| <a name="com.chrynan.chords.graphics/Rect/right/#/PointingToDeclaration/"></a> [js] var [right](right.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0The right coordinate of this [Rect](index.md).   <br>|
| <a name="com.chrynan.chords.graphics/Rect/top/#/PointingToDeclaration/"></a>[top](top.md)| <a name="com.chrynan.chords.graphics/Rect/top/#/PointingToDeclaration/"></a> [js] var [top](top.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0The top coordinate of this [Rect](index.md).   <br>|
| <a name="com.chrynan.chords.graphics/Rect/width/#/PointingToDeclaration/"></a>[width](width.md)| <a name="com.chrynan.chords.graphics/Rect/width/#/PointingToDeclaration/"></a> [js] val [width](width.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)The width of this [Rect](index.md).   <br>|

