//[chords-android](../../../index.md)/[com.chrynan.chords.span](../index.md)/[RaisedTextSpan](index.md)



# RaisedTextSpan  
 [androidJvm] class [RaisedTextSpan](index.md) : [ReplacementSpan](https://developer.android.com/reference/kotlin/android/text/style/ReplacementSpan.html)

Raises the spanned text and removes the width so that the following text can be drawn underneath it.



For example, consider the following text: "Example". If we were to raise the letter 'p', then the output would look like the following:

        p  
    Examle   


## Constructors  
  
| | |
|---|---|
| <a name="com.chrynan.chords.span/RaisedTextSpan/RaisedTextSpan/#/PointingToDeclaration/"></a>[RaisedTextSpan](-raised-text-span.md)| <a name="com.chrynan.chords.span/RaisedTextSpan/RaisedTextSpan/#/PointingToDeclaration/"></a> [androidJvm] fun [RaisedTextSpan](-raised-text-span.md)()   <br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.span/RaisedTextSpan/draw/#android.graphics.Canvas#kotlin.CharSequence?#kotlin.Int#kotlin.Int#kotlin.Float#kotlin.Int#kotlin.Int#kotlin.Int#android.graphics.Paint/PointingToDeclaration/"></a>[draw](draw.md)| <a name="com.chrynan.chords.span/RaisedTextSpan/draw/#android.graphics.Canvas#kotlin.CharSequence?#kotlin.Int#kotlin.Int#kotlin.Float#kotlin.Int#kotlin.Int#kotlin.Int#android.graphics.Paint/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [draw](draw.md)(canvas: [Canvas](https://developer.android.com/reference/kotlin/android/graphics/Canvas.html), text: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), x: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), top: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), y: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), bottom: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), paint: [Paint](https://developer.android.com/reference/kotlin/android/graphics/Paint.html))  <br><br><br>|
| <a name="com.chrynan.chords.span/RaisedTextSpan/getSize/#android.graphics.Paint#kotlin.CharSequence?#kotlin.Int#kotlin.Int#android.graphics.Paint.FontMetricsInt?/PointingToDeclaration/"></a>[getSize](get-size.md)| <a name="com.chrynan.chords.span/RaisedTextSpan/getSize/#android.graphics.Paint#kotlin.CharSequence?#kotlin.Int#kotlin.Int#android.graphics.Paint.FontMetricsInt?/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [getSize](get-size.md)(paint: [Paint](https://developer.android.com/reference/kotlin/android/graphics/Paint.html), text: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), fm: [Paint.FontMetricsInt](https://developer.android.com/reference/kotlin/android/graphics/Paint.FontMetricsInt.html)?): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>|
| <a name="android.text.style/MetricAffectingSpan/getUnderlying/#/PointingToDeclaration/"></a>[getUnderlying](index.md#%5Bandroid.text.style%2FMetricAffectingSpan%2FgetUnderlying%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1126605923)| <a name="android.text.style/MetricAffectingSpan/getUnderlying/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [getUnderlying](index.md#%5Bandroid.text.style%2FMetricAffectingSpan%2FgetUnderlying%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1126605923)(): [MetricAffectingSpan](https://developer.android.com/reference/kotlin/android/text/style/MetricAffectingSpan.html)  <br><br><br>|
| <a name="android.text.style/ReplacementSpan/updateDrawState/#android.text.TextPaint/PointingToDeclaration/"></a>[updateDrawState](index.md#%5Bandroid.text.style%2FReplacementSpan%2FupdateDrawState%2F%23android.text.TextPaint%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1126605923)| <a name="android.text.style/ReplacementSpan/updateDrawState/#android.text.TextPaint/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [updateDrawState](index.md#%5Bandroid.text.style%2FReplacementSpan%2FupdateDrawState%2F%23android.text.TextPaint%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1126605923)(p0: [TextPaint](https://developer.android.com/reference/kotlin/android/text/TextPaint.html))  <br><br><br>|
| <a name="android.text.style/ReplacementSpan/updateMeasureState/#android.text.TextPaint/PointingToDeclaration/"></a>[updateMeasureState](index.md#%5Bandroid.text.style%2FReplacementSpan%2FupdateMeasureState%2F%23android.text.TextPaint%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1126605923)| <a name="android.text.style/ReplacementSpan/updateMeasureState/#android.text.TextPaint/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [updateMeasureState](index.md#%5Bandroid.text.style%2FReplacementSpan%2FupdateMeasureState%2F%23android.text.TextPaint%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1126605923)(p0: [TextPaint](https://developer.android.com/reference/kotlin/android/text/TextPaint.html))  <br><br><br>|

