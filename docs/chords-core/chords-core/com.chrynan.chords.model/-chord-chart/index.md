//[chords-core](../../../index.md)/[com.chrynan.chords.model](../index.md)/[ChordChart](index.md)

# ChordChart

[common]\
data class [ChordChart](index.md)(fretStart: [FretNumber](../-fret-number/index.md), fretEnd: [FretNumber](../-fret-number/index.md), stringCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), stringLabels: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[StringLabel](../-string-label/index.md)&gt;)

A representation of a diagram used to display a fretted string instrument Chord. This contains information related to the visual diagram, such as the [fretStart](fret-start.md) and [fretEnd](fret-end.md).

A chord diagram usually displays the frets as horizontal rows separated by lines (fret markers). This diagram starts with the first being the [fretStart](fret-start.md) and ends with the [fretEnd](fret-end.md). And a chord diagram usually displays the strings as vertical columns. This diagram contains [stringCount](string-count.md) as the amount of strings. The [stringLabels](string-labels.md) are usually displayed at one of the ends of the strings in the diagram, if they are to be drawn.

Note that this does not contain information about the View, such as colors and text. For that information, refer to the [ChordViewData](../-chord-view-data/index.md) and [ChordView](../../com.chrynan.chords.view/-chord-view/index.md) classes.

#### Author

chRyNaN

## Constructors

| | |
|---|---|
| [ChordChart](-chord-chart.md) | [common]<br>fun [ChordChart](-chord-chart.md)(fretStart: [FretNumber](../-fret-number/index.md) = DEFAULT_FRET_START, fretEnd: [FretNumber](../-fret-number/index.md) = DEFAULT_FRET_END, stringCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = DEFAULT_GUITAR_STRING_COUNT, stringLabels: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[StringLabel](../-string-label/index.md)&gt; = emptySet()) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [fretEnd](fret-end.md) | [common]<br>val [fretEnd](fret-end.md): [FretNumber](../-fret-number/index.md)<br>The ending [FretNumber](../-fret-number/index.md) of this diagram. |
| [fretStart](fret-start.md) | [common]<br>val [fretStart](fret-start.md): [FretNumber](../-fret-number/index.md)<br>The starting [FretNumber](../-fret-number/index.md) of this diagram. |
| [stringCount](string-count.md) | [common]<br>val [stringCount](string-count.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>An [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) specifying the amount of strings in this diagram. |
| [stringLabels](string-labels.md) | [common]<br>val [stringLabels](string-labels.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[StringLabel](../-string-label/index.md)&gt;<br>A [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html) of [StringLabel](../-string-label/index.md)s for each string in this diagram. The amount of labels should match the [stringCount](string-count.md). |
