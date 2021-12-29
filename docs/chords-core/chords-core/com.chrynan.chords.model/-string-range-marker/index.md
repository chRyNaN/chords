//[chords-core](../../../index.md)/[com.chrynan.chords.model](../index.md)/[StringRangeMarker](index.md)

# StringRangeMarker

[common]\
interface [StringRangeMarker](index.md) : [StringMarker](../-string-marker/index.md)

An interface for a [ChordMarker](../-chord-marker/index.md) that contains information about a range of strings that are to be played.

#### Author

chRyNaN

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [endString](end-string.md) | [common]<br>abstract val [endString](end-string.md): [StringNumber](../-string-number/index.md)<br>The ending [StringNumber](../-string-number/index.md) in this string range. |
| [startString](start-string.md) | [common]<br>abstract val [startString](start-string.md): [StringNumber](../-string-number/index.md)<br>The starting [StringNumber](../-string-number/index.md) in this string range. |
| [string](../-string-marker/string.md) | [common]<br>abstract val [string](../-string-marker/string.md): [StringNumber](../-string-number/index.md)<br>The [StringNumber](../-string-number/index.md) that this [ChordMarker](../-chord-marker/index.md) is on. |

## Inheritors

| Name |
|---|
| [ChordMarker](../-chord-marker/-bar/index.md) |
