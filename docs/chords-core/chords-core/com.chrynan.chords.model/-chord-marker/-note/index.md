//[chords-core](../../../../index.md)/[com.chrynan.chords.model](../../index.md)/[ChordMarker](../index.md)/[Note](index.md)

# Note

[common]\
data class [Note](index.md)(fret: [FretNumber](../../-fret-number/index.md), finger: [Finger](../../-finger/index.md), string: [StringNumber](../../-string-number/index.md)) : [ChordMarker](../index.md), [FretMarker](../../-fret-marker/index.md), [FingerMarker](../../-finger-marker/index.md), [StringMarker](../../-string-marker/index.md)

A [ChordMarker](../index.md) representing a single note that is not an open string.

#### Author

chRyNaN

## Constructors

| | |
|---|---|
| [Note](-note.md) | [common]<br>fun [Note](-note.md)(fret: [FretNumber](../../-fret-number/index.md), finger: [Finger](../../-finger/index.md) = Finger.UNKNOWN, string: [StringNumber](../../-string-number/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [finger](finger.md) | [common]<br>open override val [finger](finger.md): [Finger](../../-finger/index.md)<br>The [Finger](../../-finger/index.md) used to play this note. |
| [fret](fret.md) | [common]<br>open override val [fret](fret.md): [FretNumber](../../-fret-number/index.md)<br>The [FretNumber](../../-fret-number/index.md) of this note. |
| [string](string.md) | [common]<br>open override val [string](string.md): [StringNumber](../../-string-number/index.md)<br>The [StringNumber](../../-string-number/index.md) of this note. |
| [type](type.md) | [common]<br>open override val [type](type.md): [MarkerType](../../-marker-type/index.md)<br>The [MarkerType](../../-marker-type/index.md) of this [ChordMarker](../index.md). This is useful for parsing. |
