//[chords-core](../../../../index.md)/[com.chrynan.chords.model](../../index.md)/[ChordMarker](../index.md)/[Open](index.md)

# Open

[common]\
data class [Open](index.md)(string: [StringNumber](../../-string-number/index.md)) : [ChordMarker](../index.md), [FretMarker](../../-fret-marker/index.md), [StringMarker](../../-string-marker/index.md)

A [ChordMarker](../index.md) representing a single open note.

#### Author

chRyNaN

## Constructors

| | |
|---|---|
| [Open](-open.md) | [common]<br>fun [Open](-open.md)(string: [StringNumber](../../-string-number/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [fret](fret.md) | [common]<br>open override val [fret](fret.md): [FretNumber](../../-fret-number/index.md)<br>The [FretNumber](../../-fret-number/index.md) that this [ChordMarker](../index.md) is on. |
| [string](string.md) | [common]<br>open override val [string](string.md): [StringNumber](../../-string-number/index.md)<br>The [StringNumber](../../-string-number/index.md) of this open note. |
| [type](type.md) | [common]<br>open override val [type](type.md): [MarkerType](../../-marker-type/index.md)<br>The [MarkerType](../../-marker-type/index.md) of this [ChordMarker](../index.md). This is useful for parsing. |
