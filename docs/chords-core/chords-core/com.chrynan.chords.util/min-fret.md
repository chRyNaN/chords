//[chords-core](../../index.md)/[com.chrynan.chords.util](index.md)/[minFret](min-fret.md)

# minFret

[common]\
val [Chord](../com.chrynan.chords.model/-chord/index.md).[minFret](min-fret.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Retrieves the min fret of this Chord, or -1. If there are no markers, -1 will be returned. If there are all muted notes, -1 will be returned. Otherwise, the minimum fret number will be returned. Note that this is different from [ChordChart.fretStart](../com.chrynan.chords.model/-chord-chart/fret-start.md). This retrieves the minimum fret in this [Chord](../com.chrynan.chords.model/-chord/index.md). [ChordChart.fretStart](../com.chrynan.chords.model/-chord-chart/fret-start.md) retrieves the minimum fret that will be displayed in the chart.

#### Author

chRyNaN

## See also

common

| | |
|---|---|
| [com.chrynan.chords.model.ChordChart](../com.chrynan.chords.model/-chord-chart/index.md) |  |
