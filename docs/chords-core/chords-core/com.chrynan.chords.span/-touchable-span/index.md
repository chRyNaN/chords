//[chords-core](../../../index.md)/[com.chrynan.chords.span](../index.md)/[TouchableSpan](index.md)

# TouchableSpan

[android]\
abstract class [TouchableSpan](index.md) : [CharacterStyle](https://developer.android.com/reference/kotlin/android/text/style/CharacterStyle.html), [UpdateAppearance](https://developer.android.com/reference/kotlin/android/text/style/UpdateAppearance.html), [TouchableSpanView](../-touchable-span-view/index.md)

References: http://stackoverflow.com/a/7292485/1478764, http://stackoverflow.com/a/20905824/1478764

If an object of this type is attached to the text of a [TextView](https://developer.android.com/reference/kotlin/android/widget/TextView.html) with a movement method of [LinkTouchMovementMethod](../-link-touch-movement-method/index.md), the affected spans of the text can be selected. If touched, the [onTouch](on-touch.md) method will be called.

#### Author

chRyNaN

## Constructors

| | |
|---|---|
| [TouchableSpan](-touchable-span.md) | [android]<br>fun [TouchableSpan](-touchable-span.md)() |

## Functions

| Name | Summary |
|---|---|
| [getUnderlying](index.md#709026833%2FFunctions%2F759375805) | [android]<br>open fun [getUnderlying](index.md#709026833%2FFunctions%2F759375805)(): [CharacterStyle](https://developer.android.com/reference/kotlin/android/text/style/CharacterStyle.html) |
| [onTouch](on-touch.md) | [android]<br>abstract fun [onTouch](on-touch.md)(widget: [View](https://developer.android.com/reference/kotlin/android/view/View.html), m: [MotionEvent](https://developer.android.com/reference/kotlin/android/view/MotionEvent.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Performs the touch action associated with this span. |
| [updateDrawState](update-draw-state.md) | [android]<br>open override fun [updateDrawState](update-draw-state.md)(textPaint: [TextPaint](https://developer.android.com/reference/kotlin/android/text/TextPaint.html))<br>Updates the draw state of the underlying text in this span. |

## Properties

| Name | Summary |
|---|---|
| [backgroundColor](background-color.md) | [android]<br>open override var [backgroundColor](background-color.md): ColorInt<br>The background ColorInt of the touchable text when it is not selected. |
| [isSelected](is-selected.md) | [android]<br>var [isSelected](is-selected.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false<br>Indicates whether this [TouchableSpan](index.md) is selected or not. A value of true means that this [TouchableSpan](index.md) is selected, a value of false means that it is not selected. |
| [isUnderlined](is-underlined.md) | [android]<br>open override var [isUnderlined](is-underlined.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the touchable text is underlined when it is not selected. |
| [isUnderlinedWhenSelected](is-underlined-when-selected.md) | [android]<br>open override var [isUnderlinedWhenSelected](is-underlined-when-selected.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the touchable text is underlined when it is selected. |
| [selectedBackgroundColor](selected-background-color.md) | [android]<br>open override var [selectedBackgroundColor](selected-background-color.md): ColorInt<br>The background ColorInt of the touchable text when it is selected. |
| [selectedTextColor](selected-text-color.md) | [android]<br>open override var [selectedTextColor](selected-text-color.md): ColorInt<br>The text ColorInt of the touchable text when it is selected. |
| [selectedTextTypeface](selected-text-typeface.md) | [android]<br>open override var [selectedTextTypeface](selected-text-typeface.md): [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html)<br>The [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html) for the touchable text when it is selected. |
| [textColor](text-color.md) | [android]<br>open override var [textColor](text-color.md): ColorInt<br>The text ColorInt of the touchable text when it is not selected. |
| [textTypeface](text-typeface.md) | [android]<br>open override var [textTypeface](text-typeface.md): [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html)<br>The [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html) for the touchable text when it is not selected. |
| [viewModel](view-model.md) | [android]<br>var [viewModel](view-model.md): [TouchableSpanViewModel](../-touchable-span-view-model/index.md) |

## Inheritors

| Name |
|---|
| [ChordSpan](../-chord-span/index.md) |
