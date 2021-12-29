//[chords-core](../../../index.md)/[com.chrynan.chords.model](../index.md)/[ChordParseResult](index.md)

# ChordParseResult

[common]\
data class [ChordParseResult](index.md)(chord: [Chord](../-chord/index.md), stringLabels: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[StringLabel](../-string-label/index.md)&gt;, baseFret: [FretNumber](../-fret-number/index.md)?)

A model containing information about the successful result of a [ChordParser](../../com.chrynan.chords.parser/-chord-parser/index.md).

#### Author

chRyNaN

## Constructors

| | |
|---|---|
| [ChordParseResult](-chord-parse-result.md) | [common]<br>fun [ChordParseResult](-chord-parse-result.md)(chord: [Chord](../-chord/index.md), stringLabels: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[StringLabel](../-string-label/index.md)&gt; = emptySet(), baseFret: [FretNumber](../-fret-number/index.md)? = null) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [baseFret](base-fret.md) | [common]<br>val [baseFret](base-fret.md): [FretNumber](../-fret-number/index.md)? = null |
| [chord](chord.md) | [common]<br>val [chord](chord.md): [Chord](../-chord/index.md) |
| [stringLabels](string-labels.md) | [common]<br>val [stringLabels](string-labels.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[StringLabel](../-string-label/index.md)&gt; |
