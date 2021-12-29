//[chords-core](../../../index.md)/[com.chrynan.chords.model](../index.md)/[ChordViewData](index.md)

# ChordViewData

[common]\
@[ExperimentalUnsignedTypes](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-unsigned-types/index.html)

data class [ChordViewData](index.md)(fitToHeight: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), showFretNumbers: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), showFingerNumbers: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), stringLabelState: [StringLabelState](../-string-label-state/index.md), mutedStringText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), openStringText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), fretColor: Color, fretLabelTextColor: Color, stringColor: Color, stringLabelTextColor: Color, noteColor: Color, noteLabelTextColor: Color)

A model that represents the visual state of a UI Widget that displays a [ChordChart](../-chord-chart/index.md) for a [Chord](../-chord/index.md). Note that this class does not contain any information about a [ChordChart](../-chord-chart/index.md) or a [Chord](../-chord/index.md) and only contains visual information relating to the UI Widget. This class can be used to explicitly update a [ChordView](../../com.chrynan.chords.view/-chord-view/index.md), or a [ChordViewBinder](../../com.chrynan.chords.view/-chord-view-binder/index.md) can be used to implicitly update the [ChordView](../../com.chrynan.chords.view/-chord-view/index.md).

#### Author

chRyNaN

## Constructors

| | |
|---|---|
| [ChordViewData](-chord-view-data.md) | [common]<br>fun [ChordViewData](-chord-view-data.md)(fitToHeight: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = ChordView.DEFAULT_FIT_TO_HEIGHT, showFretNumbers: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = ChordView.DEFAULT_SHOW_FRET_NUMBERS, showFingerNumbers: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = ChordView.DEFAULT_SHOW_FINGER_NUMBERS, stringLabelState: [StringLabelState](../-string-label-state/index.md) = ChordView.DEFAULT_STRING_LABEL_STATE, mutedStringText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = ChordView.DEFAULT_MUTED_TEXT, openStringText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = ChordView.DEFAULT_OPEN_TEXT, fretColor: Color = Color.Black, fretLabelTextColor: Color = Color.Black, stringColor: Color = Color.Black, stringLabelTextColor: Color = Color.Black, noteColor: Color = Color.Black, noteLabelTextColor: Color = Color.White) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [fitToHeight](fit-to-height.md) | [common]<br>val [fitToHeight](fit-to-height.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the [ChordView](../../com.chrynan.chords.view/-chord-view/index.md) should scale the visual Chord Chart relative to it's height. A value of true indicates that it will be scaled to the height. |
| [fretColor](fret-color.md) | [common]<br>val [fretColor](fret-color.md): Color<br>The ColorInt value that will be used for the fret lines. |
| [fretLabelTextColor](fret-label-text-color.md) | [common]<br>val [fretLabelTextColor](fret-label-text-color.md): Color<br>The ColorInt value that will be used for the fret labels. |
| [mutedStringText](muted-string-text.md) | [common]<br>val [mutedStringText](muted-string-text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value used to indicate that an instrument String should be muted. |
| [noteColor](note-color.md) | [common]<br>val [noteColor](note-color.md): Color<br>The ColorInt value that will be used for the notes and bars. |
| [noteLabelTextColor](note-label-text-color.md) | [common]<br>val [noteLabelTextColor](note-label-text-color.md): Color<br>The ColorInt value that will be used for the note and bar labels. |
| [openStringText](open-string-text.md) | [common]<br>val [openStringText](open-string-text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value used to indicate that an instrument String should be open. |
| [showFingerNumbers](show-finger-numbers.md) | [common]<br>val [showFingerNumbers](show-finger-numbers.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the [ChordView](../../com.chrynan.chords.view/-chord-view/index.md) should display the finger numbers on the notes and bars of the chart. |
| [showFretNumbers](show-fret-numbers.md) | [common]<br>val [showFretNumbers](show-fret-numbers.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the [ChordView](../../com.chrynan.chords.view/-chord-view/index.md) should display the fret numbers to the side of the chart. |
| [stringColor](string-color.md) | [common]<br>val [stringColor](string-color.md): Color<br>The ColorInt value that will be used for the instrument String lines. |
| [stringLabelState](string-label-state.md) | [common]<br>val [stringLabelState](string-label-state.md): [StringLabelState](../-string-label-state/index.md)<br>A [StringLabelState](../-string-label-state/index.md) enum indicating whether the String number or label should be displayed, or if there should be no String label shown. String labels appear on the bottom of the chart. |
| [stringLabelTextColor](string-label-text-color.md) | [common]<br>val [stringLabelTextColor](string-label-text-color.md): Color<br>The ColorInt value that will be used for the String labels. |
