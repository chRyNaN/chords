//[chords-core](../../../../index.md)/[com.chrynan.chords.model](../../index.md)/[ChordMarker](../index.md)/[Bar](index.md)

# Bar

[common]\
data class [Bar](index.md)(fret: [FretNumber](../../-fret-number/index.md), finger: [Finger](../../-finger/index.md), startString: [StringNumber](../../-string-number/index.md), endString: [StringNumber](../../-string-number/index.md)) : [ChordMarker](../index.md), [FretMarker](../../-fret-marker/index.md), [FingerMarker](../../-finger-marker/index.md), [StringRangeMarker](../../-string-range-marker/index.md)

A [ChordMarker](../index.md) representing multiple notes spanning across multiple strings on a single fret.

#### Author

chRyNaN

## Constructors

| | |
|---|---|
| [Bar](-bar.md) | [common]<br>fun [Bar](-bar.md)(fret: [FretNumber](../../-fret-number/index.md), finger: [Finger](../../-finger/index.md) = Finger.UNKNOWN, startString: [StringNumber](../../-string-number/index.md), endString: [StringNumber](../../-string-number/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [endString](end-string.md) | [common]<br>open override val [endString](end-string.md): [StringNumber](../../-string-number/index.md)<br>The [StringNumber](../../-string-number/index.md) of the last string this bar ends. |
| [finger](finger.md) | [common]<br>open override val [finger](finger.md): [Finger](../../-finger/index.md)<br>The finger used to bar these notes. |
| [fret](fret.md) | [common]<br>open override val [fret](fret.md): [FretNumber](../../-fret-number/index.md)<br>The [FretNumber](../../-fret-number/index.md) of the notes in this bar. |
| [startString](start-string.md) | [common]<br>open override val [startString](start-string.md): [StringNumber](../../-string-number/index.md)<br>The [StringNumber](../../-string-number/index.md) of the first string this bar starts. |
| [string](string.md) | [common]<br>open override val [string](string.md): [StringNumber](../../-string-number/index.md)<br>The [StringNumber](../../-string-number/index.md) that this [ChordMarker](../index.md) is on. |
| [type](type.md) | [common]<br>open override val [type](type.md): [MarkerType](../../-marker-type/index.md)<br>The [MarkerType](../../-marker-type/index.md) of this [ChordMarker](../index.md). This is useful for parsing. |

## Extensions

| Name | Summary |
|---|---|
| [notes](../../../com.chrynan.chords.util/notes.md) | [common]<br>val [ChordMarker.Bar](index.md).[notes](../../../com.chrynan.chords.util/notes.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[ChordMarker.Note](../-note/index.md)&gt;<br>Retrieves the [ChordMarker.Note](../-note/index.md)s that make up this [ChordMarker.Bar](index.md). |
