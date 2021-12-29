//[chords-core](../../../index.md)/[com.chrynan.chords.model](../index.md)/[ChordBuilder](index.md)

# ChordBuilder

[common]\
class [ChordBuilder](index.md)

A DSL Builder class for creating a [Chord](../-chord/index.md). Use the [chord](../chord.md) function to obtain an instance of this class. This allows the creation of a [Chord](../-chord/index.md) using a Kotlin DSL. For example:

chord {     +ChordMarker.Open(StringNumber(1)) }

#### Author

chRyNaN

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [add](add.md) | [common]<br>fun [add](add.md)(marker: [ChordMarker](../-chord-marker/index.md)) |
| [unaryPlus](unary-plus.md) | [common]<br>operator fun [ChordMarker](../-chord-marker/index.md).[unaryPlus](unary-plus.md)() |
