//[chords-core](../../../index.md)/[com.chrynan.chords.widget](../index.md)/[[js]ChordWidget](index.md)

# ChordWidget

[js]\
class [ChordWidget](index.md)(canvas: [HTMLCanvasElement](https://kotlinlang.org/api/latest/jvm/stdlib/org.w3c.dom/-h-t-m-l-canvas-element/index.html)) : [View](../-view/index.md), [ChordView](../../../../chords-core/chords-core/com.chrynan.chords.view/-chord-view/index.md)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [js]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [render](../-view/render.md) | [js]<br>fun [render](../-view/render.md)()<br>This function invokes a layout pass to occur. This will invoke the [onMeasure](../../../../chords-core/com.chrynan.chords.widget/-view/on-measure.md) and [onDraw](../../../../chords-core/com.chrynan.chords.widget/-view/on-draw.md) functions. |

## Properties

| Name | Summary |
|---|---|
| [canvas](canvas.md) | [js]<br>open override val [canvas](canvas.md): [HTMLCanvasElement](https://kotlinlang.org/api/latest/jvm/stdlib/org.w3c.dom/-h-t-m-l-canvas-element/index.html) |
| [chart](chart.md) | [js]<br>open override var [chart](chart.md): [ChordChart](../../../../chords-core/chords-core/com.chrynan.chords.model/-chord-chart/index.md) |
| [chord](chord.md) | [js]<br>open override var [chord](chord.md): [Chord](../../../../chords-core/chords-core/com.chrynan.chords.model/-chord/index.md)? = null |
| [fitToHeight](fit-to-height.md) | [js]<br>open override var [fitToHeight](fit-to-height.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [fretColor](fret-color.md) | [js]<br>open override var [fretColor](fret-color.md): Color |
| [fretLabelTextColor](fret-label-text-color.md) | [js]<br>open override var [fretLabelTextColor](fret-label-text-color.md): Color |
| [mutedStringText](muted-string-text.md) | [js]<br>open override var [mutedStringText](muted-string-text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [noteColor](note-color.md) | [js]<br>open override var [noteColor](note-color.md): Color |
| [noteLabelTextColor](note-label-text-color.md) | [js]<br>open override var [noteLabelTextColor](note-label-text-color.md): Color |
| [openStringText](open-string-text.md) | [js]<br>open override var [openStringText](open-string-text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [paddingBottom](../-view/padding-bottom.md) | [js]<br>var [paddingBottom](../-view/padding-bottom.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0 |
| [paddingLeft](../-view/padding-left.md) | [js]<br>var [paddingLeft](../-view/padding-left.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0 |
| [paddingRight](../-view/padding-right.md) | [js]<br>var [paddingRight](../-view/padding-right.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0 |
| [paddingTop](../-view/padding-top.md) | [js]<br>var [paddingTop](../-view/padding-top.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0 |
| [showFingerNumbers](show-finger-numbers.md) | [js]<br>open override var [showFingerNumbers](show-finger-numbers.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [showFretNumbers](show-fret-numbers.md) | [js]<br>open override var [showFretNumbers](show-fret-numbers.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [stringColor](string-color.md) | [js]<br>open override var [stringColor](string-color.md): Color |
| [stringLabelState](string-label-state.md) | [js]<br>open override var [stringLabelState](string-label-state.md): [StringLabelState](../../../../chords-core/chords-core/com.chrynan.chords.model/-string-label-state/index.md) |
| [stringLabelTextColor](string-label-text-color.md) | [js]<br>open override var [stringLabelTextColor](string-label-text-color.md): Color |
