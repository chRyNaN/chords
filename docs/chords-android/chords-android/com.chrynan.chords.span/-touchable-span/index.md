//[chords-android](../../../index.md)/[com.chrynan.chords.span](../index.md)/[TouchableSpan](index.md)



# TouchableSpan  
 [androidJvm] abstract class [TouchableSpan](index.md) : [CharacterStyle](https://developer.android.com/reference/kotlin/android/text/style/CharacterStyle.html), [UpdateAppearance](https://developer.android.com/reference/kotlin/android/text/style/UpdateAppearance.html), [TouchableSpanView](../-touchable-span-view/index.md)

References: http://stackoverflow.com/a/7292485/1478764, http://stackoverflow.com/a/20905824/1478764



If an object of this type is attached to the text of a [TextView](https://developer.android.com/reference/kotlin/android/widget/TextView.html) with a movement method of [LinkTouchMovementMethod](../-link-touch-movement-method/index.md), the affected spans of the text can be selected. If touched, the [onTouch](on-touch.md) method will be called.



#### Author  


chRyNaN

   


## Constructors  
  
| | |
|---|---|
| <a name="com.chrynan.chords.span/TouchableSpan/TouchableSpan/#/PointingToDeclaration/"></a>[TouchableSpan](-touchable-span.md)| <a name="com.chrynan.chords.span/TouchableSpan/TouchableSpan/#/PointingToDeclaration/"></a> [androidJvm] fun [TouchableSpan](-touchable-span.md)()   <br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="android.text.style/CharacterStyle/getUnderlying/#/PointingToDeclaration/"></a>[getUnderlying](index.md#%5Bandroid.text.style%2FCharacterStyle%2FgetUnderlying%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1126605923)| <a name="android.text.style/CharacterStyle/getUnderlying/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [getUnderlying](index.md#%5Bandroid.text.style%2FCharacterStyle%2FgetUnderlying%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1126605923)(): [CharacterStyle](https://developer.android.com/reference/kotlin/android/text/style/CharacterStyle.html)  <br><br><br>|
| <a name="com.chrynan.chords.span/TouchableSpan/onTouch/#android.view.View#android.view.MotionEvent/PointingToDeclaration/"></a>[onTouch](on-touch.md)| <a name="com.chrynan.chords.span/TouchableSpan/onTouch/#android.view.View#android.view.MotionEvent/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>abstract fun [onTouch](on-touch.md)(widget: [View](https://developer.android.com/reference/kotlin/android/view/View.html), m: [MotionEvent](https://developer.android.com/reference/kotlin/android/view/MotionEvent.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Performs the touch action associated with this span.  <br><br><br>|
| <a name="com.chrynan.chords.span/TouchableSpan/updateDrawState/#android.text.TextPaint/PointingToDeclaration/"></a>[updateDrawState](update-draw-state.md)| <a name="com.chrynan.chords.span/TouchableSpan/updateDrawState/#android.text.TextPaint/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [updateDrawState](update-draw-state.md)(textPaint: [TextPaint](https://developer.android.com/reference/kotlin/android/text/TextPaint.html))  <br>More info  <br>Updates the draw state of the underlying text in this span.  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.span/TouchableSpan/backgroundColor/#/PointingToDeclaration/"></a>[backgroundColor](background-color.md)| <a name="com.chrynan.chords.span/TouchableSpan/backgroundColor/#/PointingToDeclaration/"></a> [androidJvm] open override var [backgroundColor](background-color.md): ColorIntThe background ColorInt of the touchable text when it is not selected.   <br>|
| <a name="com.chrynan.chords.span/TouchableSpan/isSelected/#/PointingToDeclaration/"></a>[isSelected](is-selected.md)| <a name="com.chrynan.chords.span/TouchableSpan/isSelected/#/PointingToDeclaration/"></a> [androidJvm] var [isSelected](is-selected.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = falseIndicates whether this [TouchableSpan](index.md) is selected or not.   <br>|
| <a name="com.chrynan.chords.span/TouchableSpan/isUnderlined/#/PointingToDeclaration/"></a>[isUnderlined](is-underlined.md)| <a name="com.chrynan.chords.span/TouchableSpan/isUnderlined/#/PointingToDeclaration/"></a> [androidJvm] open override var [isUnderlined](is-underlined.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)Whether the touchable text is underlined when it is not selected.   <br>|
| <a name="com.chrynan.chords.span/TouchableSpan/isUnderlinedWhenSelected/#/PointingToDeclaration/"></a>[isUnderlinedWhenSelected](is-underlined-when-selected.md)| <a name="com.chrynan.chords.span/TouchableSpan/isUnderlinedWhenSelected/#/PointingToDeclaration/"></a> [androidJvm] open override var [isUnderlinedWhenSelected](is-underlined-when-selected.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)Whether the touchable text is underlined when it is selected.   <br>|
| <a name="com.chrynan.chords.span/TouchableSpan/selectedBackgroundColor/#/PointingToDeclaration/"></a>[selectedBackgroundColor](selected-background-color.md)| <a name="com.chrynan.chords.span/TouchableSpan/selectedBackgroundColor/#/PointingToDeclaration/"></a> [androidJvm] open override var [selectedBackgroundColor](selected-background-color.md): ColorIntThe background ColorInt of the touchable text when it is selected.   <br>|
| <a name="com.chrynan.chords.span/TouchableSpan/selectedTextColor/#/PointingToDeclaration/"></a>[selectedTextColor](selected-text-color.md)| <a name="com.chrynan.chords.span/TouchableSpan/selectedTextColor/#/PointingToDeclaration/"></a> [androidJvm] open override var [selectedTextColor](selected-text-color.md): ColorIntThe text ColorInt of the touchable text when it is selected.   <br>|
| <a name="com.chrynan.chords.span/TouchableSpan/selectedTextTypeface/#/PointingToDeclaration/"></a>[selectedTextTypeface](selected-text-typeface.md)| <a name="com.chrynan.chords.span/TouchableSpan/selectedTextTypeface/#/PointingToDeclaration/"></a> [androidJvm] open override var [selectedTextTypeface](selected-text-typeface.md): [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html)The [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html) for the touchable text when it is selected.   <br>|
| <a name="com.chrynan.chords.span/TouchableSpan/textColor/#/PointingToDeclaration/"></a>[textColor](text-color.md)| <a name="com.chrynan.chords.span/TouchableSpan/textColor/#/PointingToDeclaration/"></a> [androidJvm] open override var [textColor](text-color.md): ColorIntThe text ColorInt of the touchable text when it is not selected.   <br>|
| <a name="com.chrynan.chords.span/TouchableSpan/textTypeface/#/PointingToDeclaration/"></a>[textTypeface](text-typeface.md)| <a name="com.chrynan.chords.span/TouchableSpan/textTypeface/#/PointingToDeclaration/"></a> [androidJvm] open override var [textTypeface](text-typeface.md): [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html)The [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html) for the touchable text when it is not selected.   <br>|
| <a name="com.chrynan.chords.span/TouchableSpan/viewModel/#/PointingToDeclaration/"></a>[viewModel](view-model.md)| <a name="com.chrynan.chords.span/TouchableSpan/viewModel/#/PointingToDeclaration/"></a> [androidJvm] var [viewModel](view-model.md): [TouchableSpanViewModel](../-touchable-span-view-model/index.md)   <br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.chrynan.chords.span/ChordSpan///PointingToDeclaration/"></a>[ChordSpan](../-chord-span/index.md)|

