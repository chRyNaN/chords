//[chords-core](../../../index.md)/[com.chrynan.chords.model](../index.md)/[ChordMarker](index.md)

# ChordMarker

[common]\
sealed class [ChordMarker](index.md)

A sealed class containing all the different markers that can be in a [Chord](../-chord/index.md). A chord marker is a visual indicator of what note(s) should be played. A set of chord markers makes up a Chord.

Note that a [ChordMarker](index.md) does not contain any information about the frequency of a note but instead contains positional information about a note, or notes, on a visual diagram.

#### Author

chRyNaN

## Types

| Name | Summary |
|---|---|
| [Bar](-bar/index.md) | [common]<br>data class [Bar](-bar/index.md)(fret: [FretNumber](../-fret-number/index.md), finger: [Finger](../-finger/index.md), startString: [StringNumber](../-string-number/index.md), endString: [StringNumber](../-string-number/index.md)) : [ChordMarker](index.md), [FretMarker](../-fret-marker/index.md), [FingerMarker](../-finger-marker/index.md), [StringRangeMarker](../-string-range-marker/index.md)<br>A [ChordMarker](index.md) representing multiple notes spanning across multiple strings on a single fret. |
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |
| [Muted](-muted/index.md) | [common]<br>data class [Muted](-muted/index.md)(string: [StringNumber](../-string-number/index.md)) : [ChordMarker](index.md), [StringMarker](../-string-marker/index.md)<br>A [StringMarker](../-string-marker/index.md) representing a muted, or un-played, string. |
| [Note](-note/index.md) | [common]<br>data class [Note](-note/index.md)(fret: [FretNumber](../-fret-number/index.md), finger: [Finger](../-finger/index.md), string: [StringNumber](../-string-number/index.md)) : [ChordMarker](index.md), [FretMarker](../-fret-marker/index.md), [FingerMarker](../-finger-marker/index.md), [StringMarker](../-string-marker/index.md)<br>A [ChordMarker](index.md) representing a single note that is not an open string. |
| [Open](-open/index.md) | [common]<br>data class [Open](-open/index.md)(string: [StringNumber](../-string-number/index.md)) : [ChordMarker](index.md), [FretMarker](../-fret-marker/index.md), [StringMarker](../-string-marker/index.md)<br>A [ChordMarker](index.md) representing a single open note. |

## Properties

| Name | Summary |
|---|---|
| [type](type.md) | [common]<br>abstract val [type](type.md): [MarkerType](../-marker-type/index.md)<br>The [MarkerType](../-marker-type/index.md) of this [ChordMarker](index.md). This is useful for parsing. |

## Inheritors

| Name |
|---|
| [ChordMarker](-note/index.md) |
| [ChordMarker](-bar/index.md) |
| [ChordMarker](-open/index.md) |
| [ChordMarker](-muted/index.md) |
