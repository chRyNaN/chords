//[chords-core](../../../index.md)/[com.chrynan.chords.model](../index.md)/[Chord](index.md)

# Chord

[common]\
data class [Chord](index.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, markers: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[ChordMarker](../-chord-marker/index.md)&gt;)

A representation of a fretted stringed instrument Chord. This model contains the [name](name.md) of the Chord and the [markers](markers.md) which indicate the strings, frets, and fingers used to make up the Chord.

Note that this model represents what makes up the fretted stringed instrument Chord and not the diagram used to display it. For a model that represents the diagram which displays Chords, refer to the [ChordChart](../-chord-chart/index.md) class.

Note that this model does not contain frequency information about the notes in a Chord but rather contains information about the position on a fretted stringed instrument to play a Chord. Also, note that this doesn't contain relative container information, such as starting frequency or position.

#### Author

chRyNaN

## Constructors

| | |
|---|---|
| [Chord](-chord.md) | [common]<br>fun [Chord](-chord.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, markers: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[ChordMarker](../-chord-marker/index.md)&gt;) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [contains](contains.md) | [common]<br>operator fun [contains](contains.md)(marker: [ChordMarker](../-chord-marker/index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>An overloaded operator function that determines whether this [Chord](index.md) contains the provided [marker](contains.md). |

## Properties

| Name | Summary |
|---|---|
| [bars](bars.md) | [common]<br>val [bars](bars.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[ChordMarker.Bar](../-chord-marker/-bar/index.md)&gt;<br>A [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html) of [ChordMarker.Bar](../-chord-marker/-bar/index.md)s that are a part of this [Chord](index.md). This is a convenience property that filters the [markers](markers.md) for [ChordMarker.Bar](../-chord-marker/-bar/index.md)s. |
| [markers](markers.md) | [common]<br>val [markers](markers.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[ChordMarker](../-chord-marker/index.md)&gt;<br>A [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html) of [ChordMarker](../-chord-marker/index.md)s that make up this [Chord](index.md). |
| [mutes](mutes.md) | [common]<br>val [mutes](mutes.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[ChordMarker.Muted](../-chord-marker/-muted/index.md)&gt;<br>A [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html) of [ChordMarker.Muted](../-chord-marker/-muted/index.md)s that are a part of this [Chord](index.md). This is a convenience property that filters the [markers](markers.md) for [ChordMarker.Muted](../-chord-marker/-muted/index.md)s. |
| [name](name.md) | [common]<br>val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null<br>The optional name of this [Chord](index.md). |
| [notes](notes.md) | [common]<br>val [notes](notes.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[ChordMarker.Note](../-chord-marker/-note/index.md)&gt;<br>A [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html) of [ChordMarker.Note](../-chord-marker/-note/index.md)s that are a part of this [Chord](index.md). This is a convenience property that filters the [markers](markers.md) for [ChordMarker.Note](../-chord-marker/-note/index.md)s. |
| [opens](opens.md) | [common]<br>val [opens](opens.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[ChordMarker.Open](../-chord-marker/-open/index.md)&gt;<br>A [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html) of [ChordMarker.Open](../-chord-marker/-open/index.md)s that are a part of this [Chord](index.md). This is a convenience property that filters the [markers](markers.md) for [ChordMarker.Open](../-chord-marker/-open/index.md)s. |

## Extensions

| Name | Summary |
|---|---|
| [getMarkersOnFret](../../com.chrynan.chords.util/get-markers-on-fret.md) | [common]<br>fun [Chord](index.md).[getMarkersOnFret](../../com.chrynan.chords.util/get-markers-on-fret.md)(fret: [FretNumber](../-fret-number/index.md)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ChordMarker](../-chord-marker/index.md)&gt;<br>Retrieves the [ChordMarker](../-chord-marker/index.md)s that are on the provided [FretNumber](../-fret-number/index.md) within this [Chord](index.md). |
| [getMarkersOnString](../../com.chrynan.chords.util/get-markers-on-string.md) | [common]<br>fun [Chord](index.md).[getMarkersOnString](../../com.chrynan.chords.util/get-markers-on-string.md)(string: [StringNumber](../-string-number/index.md)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ChordMarker](../-chord-marker/index.md)&gt;<br>Retrieves the [ChordMarker](../-chord-marker/index.md)s that are on the provided [StringNumber](../-string-number/index.md) within this [Chord](index.md). |
| [maxFret](../../com.chrynan.chords.util/max-fret.md) | [common]<br>val [Chord](index.md).[maxFret](../../com.chrynan.chords.util/max-fret.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Retrieves the max fret of this chord, or -1. If there are no markers, -1 will be returned. If there are all muted notes, -1 will be returned. Otherwise, the maximum fret number will be returned. Note that this is different from [ChordChart.fretEnd](../-chord-chart/fret-end.md). This retrieves the maximum fret in this [Chord](index.md). [ChordChart.fretEnd](../-chord-chart/fret-end.md) retrieves the maximum fret that will be displayed in the chart. |
| [maxString](../../com.chrynan.chords.util/max-string.md) | [common]<br>val [Chord](index.md).[maxString](../../com.chrynan.chords.util/max-string.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Retrieves the maximum String that is in this [Chord](index.md) with a [ChordMarker](../-chord-marker/index.md). If there are no [ChordMarker](../-chord-marker/index.md)s in this [Chord](index.md), then -1 will be returned. Note that this is different from [ChordChart.stringCount](../-chord-chart/string-count.md). This retrieves the max String number from this [Chord](index.md) that has a [ChordMarker](../-chord-marker/index.md). [ChordChart.stringCount](../-chord-chart/string-count.md) retrieves the amount of Strings to display in the chart. |
| [minFret](../../com.chrynan.chords.util/min-fret.md) | [common]<br>val [Chord](index.md).[minFret](../../com.chrynan.chords.util/min-fret.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Retrieves the min fret of this Chord, or -1. If there are no markers, -1 will be returned. If there are all muted notes, -1 will be returned. Otherwise, the minimum fret number will be returned. Note that this is different from [ChordChart.fretStart](../-chord-chart/fret-start.md). This retrieves the minimum fret in this [Chord](index.md). [ChordChart.fretStart](../-chord-chart/fret-start.md) retrieves the minimum fret that will be displayed in the chart. |
| [minString](../../com.chrynan.chords.util/min-string.md) | [common]<br>val [Chord](index.md).[minString](../../com.chrynan.chords.util/min-string.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Retrieve the minimum String that is in this [Chord](index.md) with a [ChordMarker](../-chord-marker/index.md). If there are no [ChordMarker](../-chord-marker/index.md)s in this [Chord](index.md), then -1 will be returned. Note that this is different from [ChordChart.stringCount](../-chord-chart/string-count.md). This retrieves the min String number from this [Chord](index.md) that has a [ChordMarker](../-chord-marker/index.md). [ChordChart.stringCount](../-chord-chart/string-count.md) retrieves the amount of Strings to display in the chart. |
