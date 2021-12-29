//[chords-core](../../../index.md)/[com.chrynan.chords.span](../index.md)/[ChordSpan](index.md)

# ChordSpan

[android]\
class [ChordSpan](index.md)(chord: [Chord](../../../../chords-core/chords-core/com.chrynan.chords.model/-chord/index.md), listener: [ChordSpan.ChordSelectedListener](-chord-selected-listener/index.md), viewModel: [TouchableSpanViewModel](../-touchable-span-view-model/index.md)) : [TouchableSpan](../-touchable-span/index.md)

An implementation of [TouchableSpan](../-touchable-span/index.md) that retains a [Chord](../../../../chords-core/chords-core/com.chrynan.chords.model/-chord/index.md) and calls a [ChordSelectedListener](-chord-selected-listener/index.md) with the [chord](../../../../chords-core/com.chrynan.chords.span/-chord-span/chord.md) when the touchable text is selected. This could be useful to use on the text in a [TextView](https://developer.android.com/reference/kotlin/android/widget/TextView.html) to highlight the name of a [Chord](../../../../chords-core/chords-core/com.chrynan.chords.model/-chord/index.md). Then when the [Chord](../../../../chords-core/chords-core/com.chrynan.chords.model/-chord/index.md) name is selected, the [ChordSelectedListener.onChordSpanSelected](-chord-selected-listener/on-chord-span-selected.md) function will be called and that can open up the [Chord](../../../../chords-core/chords-core/com.chrynan.chords.model/-chord/index.md) diagram.

#### Author

chRyNaN

## Constructors

| | |
|---|---|
| [ChordSpan](-chord-span.md) | [android]<br>fun [ChordSpan](-chord-span.md)(chord: [Chord](../../../../chords-core/chords-core/com.chrynan.chords.model/-chord/index.md), listener: [ChordSpan.ChordSelectedListener](-chord-selected-listener/index.md), viewModel: [TouchableSpanViewModel](../-touchable-span-view-model/index.md) = TouchableSpanViewModel()) |

## Types

| Name | Summary |
|---|---|
| [ChordSelectedListener](-chord-selected-listener/index.md) | [android]<br>interface [ChordSelectedListener](-chord-selected-listener/index.md)<br>A listener interface when a [ChordSpan](index.md) text is selected. This allows the [Chord](../../../../chords-core/chords-core/com.chrynan.chords.model/-chord/index.md) to be passed to the [onChordSpanSelected](-chord-selected-listener/on-chord-span-selected.md) function. |

## Functions

| Name | Summary |
|---|---|
| [getUnderlying](../-touchable-span/index.md#709026833%2FFunctions%2F759375805) | [android]<br>open fun [getUnderlying](../-touchable-span/index.md#709026833%2FFunctions%2F759375805)(): [CharacterStyle](https://developer.android.com/reference/kotlin/android/text/style/CharacterStyle.html) |
| [onTouch](on-touch.md) | [android]<br>open override fun [onTouch](on-touch.md)(widget: [View](https://developer.android.com/reference/kotlin/android/view/View.html), m: [MotionEvent](https://developer.android.com/reference/kotlin/android/view/MotionEvent.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Performs the touch action associated with this span. |
| [updateDrawState](../-touchable-span/update-draw-state.md) | [android]<br>open override fun [updateDrawState](../-touchable-span/update-draw-state.md)(textPaint: [TextPaint](https://developer.android.com/reference/kotlin/android/text/TextPaint.html))<br>Updates the draw state of the underlying text in this span. |

## Properties

| Name | Summary |
|---|---|
| [backgroundColor](../-touchable-span/background-color.md) | [android]<br>open override var [backgroundColor](../-touchable-span/background-color.md): ColorInt<br>The background ColorInt of the touchable text when it is not selected. |
| [isSelected](../-touchable-span/is-selected.md) | [android]<br>var [isSelected](../-touchable-span/is-selected.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false<br>Indicates whether this [TouchableSpan](../-touchable-span/index.md) is selected or not. A value of true means that this [TouchableSpan](../-touchable-span/index.md) is selected, a value of false means that it is not selected. |
| [isUnderlined](../-touchable-span/is-underlined.md) | [android]<br>open override var [isUnderlined](../-touchable-span/is-underlined.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the touchable text is underlined when it is not selected. |
| [isUnderlinedWhenSelected](../-touchable-span/is-underlined-when-selected.md) | [android]<br>open override var [isUnderlinedWhenSelected](../-touchable-span/is-underlined-when-selected.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the touchable text is underlined when it is selected. |
| [selectedBackgroundColor](../-touchable-span/selected-background-color.md) | [android]<br>open override var [selectedBackgroundColor](../-touchable-span/selected-background-color.md): ColorInt<br>The background ColorInt of the touchable text when it is selected. |
| [selectedTextColor](../-touchable-span/selected-text-color.md) | [android]<br>open override var [selectedTextColor](../-touchable-span/selected-text-color.md): ColorInt<br>The text ColorInt of the touchable text when it is selected. |
| [selectedTextTypeface](../-touchable-span/selected-text-typeface.md) | [android]<br>open override var [selectedTextTypeface](../-touchable-span/selected-text-typeface.md): [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html)<br>The [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html) for the touchable text when it is selected. |
| [textColor](../-touchable-span/text-color.md) | [android]<br>open override var [textColor](../-touchable-span/text-color.md): ColorInt<br>The text ColorInt of the touchable text when it is not selected. |
| [textTypeface](../-touchable-span/text-typeface.md) | [android]<br>open override var [textTypeface](../-touchable-span/text-typeface.md): [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html)<br>The [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html) for the touchable text when it is not selected. |
| [viewModel](../-touchable-span/view-model.md) | [android]<br>var [viewModel](../-touchable-span/view-model.md): [TouchableSpanViewModel](../-touchable-span-view-model/index.md) |
