//[chords-core](../../../../index.md)/[com.chrynan.chords.model](../../index.md)/[ChordMarker](../index.md)/[Muted](index.md)

# Muted

[common]\
data class [Muted](index.md)(string: [StringNumber](../../-string-number/index.md)) : [ChordMarker](../index.md), [StringMarker](../../-string-marker/index.md)

A [StringMarker](../../-string-marker/index.md) representing a muted, or un-played, string.

#### Author

chRyNaN

## Constructors

| | |
|---|---|
| [Muted](-muted.md) | [common]<br>fun [Muted](-muted.md)(string: [StringNumber](../../-string-number/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [string](string.md) | [common]<br>open override val [string](string.md): [StringNumber](../../-string-number/index.md)<br>The [StringNumber](../../-string-number/index.md) of the muted string. |
| [type](type.md) | [common]<br>open override val [type](type.md): [MarkerType](../../-marker-type/index.md)<br>The [MarkerType](../../-marker-type/index.md) of this [ChordMarker](../index.md). This is useful for parsing. |
