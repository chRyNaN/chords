//[chords-core](../../../index.md)/[com.chrynan.chords.view](../index.md)/[ChordView](index.md)

# ChordView

[common]\
interface [ChordView](index.md)

An interface representing a UI Widget that can display a [ChordChart](../../com.chrynan.chords.model/-chord-chart/index.md) for a [Chord](../../com.chrynan.chords.model/-chord/index.md).

#### Author

chRyNaN

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [chart](chart.md) | [common]<br>abstract var [chart](chart.md): [ChordChart](../../com.chrynan.chords.model/-chord-chart/index.md) |
| [chord](chord.md) | [common]<br>abstract var [chord](chord.md): [Chord](../../com.chrynan.chords.model/-chord/index.md)? |
| [fitToHeight](fit-to-height.md) | [common]<br>abstract var [fitToHeight](fit-to-height.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [fretColor](fret-color.md) | [common]<br>abstract var [fretColor](fret-color.md): Color |
| [fretLabelTextColor](fret-label-text-color.md) | [common]<br>abstract var [fretLabelTextColor](fret-label-text-color.md): Color |
| [mutedStringText](muted-string-text.md) | [common]<br>abstract var [mutedStringText](muted-string-text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [noteColor](note-color.md) | [common]<br>abstract var [noteColor](note-color.md): Color |
| [noteLabelTextColor](note-label-text-color.md) | [common]<br>abstract var [noteLabelTextColor](note-label-text-color.md): Color |
| [openStringText](open-string-text.md) | [common]<br>abstract var [openStringText](open-string-text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [showFingerNumbers](show-finger-numbers.md) | [common]<br>abstract var [showFingerNumbers](show-finger-numbers.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [showFretNumbers](show-fret-numbers.md) | [common]<br>abstract var [showFretNumbers](show-fret-numbers.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [stringColor](string-color.md) | [common]<br>abstract var [stringColor](string-color.md): Color |
| [stringLabelState](string-label-state.md) | [common]<br>abstract var [stringLabelState](string-label-state.md): [StringLabelState](../../com.chrynan.chords.model/-string-label-state/index.md) |
| [stringLabelTextColor](string-label-text-color.md) | [common]<br>abstract var [stringLabelTextColor](string-label-text-color.md): Color |

## Inheritors

| Name |
|---|
| [ChordWidget](../../../../chords-core/chords-core/com.chrynan.chords.widget/[js]-chord-widget/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [chordAndChart](../../com.chrynan.chords.util/chord-and-chart.md) | [common]<br>var [ChordView](index.md).[chordAndChart](../../com.chrynan.chords.util/chord-and-chart.md): [ChordAndChart](../../com.chrynan.chords.model/-chord-and-chart/index.md)<br>An alias convenience property on a [ChordView](index.md) for a [ChordAndChart](../../com.chrynan.chords.model/-chord-and-chart/index.md). This property delegates to the [ChordView.chord](chord.md) and [ChordView.chart](chart.md) properties. |
