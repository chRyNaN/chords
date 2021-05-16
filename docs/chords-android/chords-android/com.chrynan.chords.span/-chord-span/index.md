//[chords-android](../../../index.md)/[com.chrynan.chords.span](../index.md)/[ChordSpan](index.md)



# ChordSpan  
 [androidJvm] class [ChordSpan](index.md)(**chord**: [Chord](../../../../chords-core/chords-core/com.chrynan.chords.model/-chord/index.md), **listener**: [ChordSpan.ChordSelectedListener](-chord-selected-listener/index.md), **viewModel**: [TouchableSpanViewModel](../-touchable-span-view-model/index.md)) : [TouchableSpan](../-touchable-span/index.md)

An implementation of [TouchableSpan](../-touchable-span/index.md) that retains a [Chord](../../../../chords-core/chords-core/com.chrynan.chords.model/-chord/index.md) and calls a [ChordSelectedListener](-chord-selected-listener/index.md) with the [chord](../../../../chords-android/com.chrynan.chords.span/-chord-span/chord.md) when the touchable text is selected. This could be useful to use on the text in a [TextView](https://developer.android.com/reference/kotlin/android/widget/TextView.html) to highlight the name of a [Chord](../../../../chords-core/chords-core/com.chrynan.chords.model/-chord/index.md). Then when the [Chord](../../../../chords-core/chords-core/com.chrynan.chords.model/-chord/index.md) name is selected, the [ChordSelectedListener.onChordSpanSelected](-chord-selected-listener/on-chord-span-selected.md) function will be called and that can open up the [Chord](../../../../chords-core/chords-core/com.chrynan.chords.model/-chord/index.md) diagram.



#### Author  


chRyNaN

   


## Constructors  
  
| | |
|---|---|
| <a name="com.chrynan.chords.span/ChordSpan/ChordSpan/#com.chrynan.chords.model.Chord#com.chrynan.chords.span.ChordSpan.ChordSelectedListener#com.chrynan.chords.span.TouchableSpanViewModel/PointingToDeclaration/"></a>[ChordSpan](-chord-span.md)| <a name="com.chrynan.chords.span/ChordSpan/ChordSpan/#com.chrynan.chords.model.Chord#com.chrynan.chords.span.ChordSpan.ChordSelectedListener#com.chrynan.chords.span.TouchableSpanViewModel/PointingToDeclaration/"></a> [androidJvm] fun [ChordSpan](-chord-span.md)(chord: [Chord](../../../../chords-core/chords-core/com.chrynan.chords.model/-chord/index.md), listener: [ChordSpan.ChordSelectedListener](-chord-selected-listener/index.md), viewModel: [TouchableSpanViewModel](../-touchable-span-view-model/index.md) = TouchableSpanViewModel())   <br>|


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.span/ChordSpan.ChordSelectedListener///PointingToDeclaration/"></a>[ChordSelectedListener](-chord-selected-listener/index.md)| <a name="com.chrynan.chords.span/ChordSpan.ChordSelectedListener///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>interface [ChordSelectedListener](-chord-selected-listener/index.md)  <br>More info  <br>A listener interface when a [ChordSpan](index.md) text is selected.  <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="android.text.style/CharacterStyle/getUnderlying/#/PointingToDeclaration/"></a>[getUnderlying](../-touchable-span/index.md#%5Bandroid.text.style%2FCharacterStyle%2FgetUnderlying%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1126605923)| <a name="android.text.style/CharacterStyle/getUnderlying/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [getUnderlying](../-touchable-span/index.md#%5Bandroid.text.style%2FCharacterStyle%2FgetUnderlying%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1126605923)(): [CharacterStyle](https://developer.android.com/reference/kotlin/android/text/style/CharacterStyle.html)  <br><br><br>|
| <a name="com.chrynan.chords.span/ChordSpan/onTouch/#android.view.View#android.view.MotionEvent/PointingToDeclaration/"></a>[onTouch](on-touch.md)| <a name="com.chrynan.chords.span/ChordSpan/onTouch/#android.view.View#android.view.MotionEvent/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [onTouch](on-touch.md)(widget: [View](https://developer.android.com/reference/kotlin/android/view/View.html), m: [MotionEvent](https://developer.android.com/reference/kotlin/android/view/MotionEvent.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Performs the touch action associated with this span.  <br><br><br>|
| <a name="com.chrynan.chords.span/TouchableSpan/updateDrawState/#android.text.TextPaint/PointingToDeclaration/"></a>[updateDrawState](../-touchable-span/update-draw-state.md)| <a name="com.chrynan.chords.span/TouchableSpan/updateDrawState/#android.text.TextPaint/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [updateDrawState](../-touchable-span/update-draw-state.md)(textPaint: [TextPaint](https://developer.android.com/reference/kotlin/android/text/TextPaint.html))  <br>More info  <br>Updates the draw state of the underlying text in this span.  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.span/ChordSpan/backgroundColor/#/PointingToDeclaration/"></a>[backgroundColor](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FbackgroundColor%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923)| <a name="com.chrynan.chords.span/ChordSpan/backgroundColor/#/PointingToDeclaration/"></a> [androidJvm] open override var [backgroundColor](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FbackgroundColor%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923): ColorIntThe background ColorInt of the touchable text when it is not selected.   <br>|
| <a name="com.chrynan.chords.span/ChordSpan/isSelected/#/PointingToDeclaration/"></a>[isSelected](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FisSelected%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923)| <a name="com.chrynan.chords.span/ChordSpan/isSelected/#/PointingToDeclaration/"></a> [androidJvm] var [isSelected](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FisSelected%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = falseIndicates whether this [TouchableSpan](../-touchable-span/index.md) is selected or not.   <br>|
| <a name="com.chrynan.chords.span/ChordSpan/isUnderlined/#/PointingToDeclaration/"></a>[isUnderlined](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FisUnderlined%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923)| <a name="com.chrynan.chords.span/ChordSpan/isUnderlined/#/PointingToDeclaration/"></a> [androidJvm] open override var [isUnderlined](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FisUnderlined%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)Whether the touchable text is underlined when it is not selected.   <br>|
| <a name="com.chrynan.chords.span/ChordSpan/isUnderlinedWhenSelected/#/PointingToDeclaration/"></a>[isUnderlinedWhenSelected](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FisUnderlinedWhenSelected%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923)| <a name="com.chrynan.chords.span/ChordSpan/isUnderlinedWhenSelected/#/PointingToDeclaration/"></a> [androidJvm] open override var [isUnderlinedWhenSelected](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FisUnderlinedWhenSelected%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)Whether the touchable text is underlined when it is selected.   <br>|
| <a name="com.chrynan.chords.span/ChordSpan/selectedBackgroundColor/#/PointingToDeclaration/"></a>[selectedBackgroundColor](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FselectedBackgroundColor%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923)| <a name="com.chrynan.chords.span/ChordSpan/selectedBackgroundColor/#/PointingToDeclaration/"></a> [androidJvm] open override var [selectedBackgroundColor](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FselectedBackgroundColor%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923): ColorIntThe background ColorInt of the touchable text when it is selected.   <br>|
| <a name="com.chrynan.chords.span/ChordSpan/selectedTextColor/#/PointingToDeclaration/"></a>[selectedTextColor](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FselectedTextColor%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923)| <a name="com.chrynan.chords.span/ChordSpan/selectedTextColor/#/PointingToDeclaration/"></a> [androidJvm] open override var [selectedTextColor](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FselectedTextColor%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923): ColorIntThe text ColorInt of the touchable text when it is selected.   <br>|
| <a name="com.chrynan.chords.span/ChordSpan/selectedTextTypeface/#/PointingToDeclaration/"></a>[selectedTextTypeface](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FselectedTextTypeface%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923)| <a name="com.chrynan.chords.span/ChordSpan/selectedTextTypeface/#/PointingToDeclaration/"></a> [androidJvm] open override var [selectedTextTypeface](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FselectedTextTypeface%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923): [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html)The [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html) for the touchable text when it is selected.   <br>|
| <a name="com.chrynan.chords.span/ChordSpan/textColor/#/PointingToDeclaration/"></a>[textColor](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FtextColor%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923)| <a name="com.chrynan.chords.span/ChordSpan/textColor/#/PointingToDeclaration/"></a> [androidJvm] open override var [textColor](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FtextColor%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923): ColorIntThe text ColorInt of the touchable text when it is not selected.   <br>|
| <a name="com.chrynan.chords.span/ChordSpan/textTypeface/#/PointingToDeclaration/"></a>[textTypeface](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FtextTypeface%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923)| <a name="com.chrynan.chords.span/ChordSpan/textTypeface/#/PointingToDeclaration/"></a> [androidJvm] open override var [textTypeface](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FtextTypeface%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923): [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html)The [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html) for the touchable text when it is not selected.   <br>|
| <a name="com.chrynan.chords.span/ChordSpan/viewModel/#/PointingToDeclaration/"></a>[viewModel](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FviewModel%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923)| <a name="com.chrynan.chords.span/ChordSpan/viewModel/#/PointingToDeclaration/"></a> [androidJvm] var [viewModel](index.md#%5Bcom.chrynan.chords.span%2FChordSpan%2FviewModel%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1126605923): [TouchableSpanViewModel](../-touchable-span-view-model/index.md)   <br>|

