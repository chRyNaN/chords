//[chords-core](../../index.md)/[com.chrynan.chords.util](index.md)/[maxFret](max-fret.md)

# maxFret

[common]\
val [Chord](../com.chrynan.chords.model/-chord/index.md).[maxFret](max-fret.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Retrieves the max fret of this chord, or -1. If there are no markers, -1 will be returned. If there are all muted notes, -1 will be returned. Otherwise, the maximum fret number will be returned. Note that this is different from [ChordChart.fretEnd](../com.chrynan.chords.model/-chord-chart/fret-end.md). This retrieves the maximum fret in this [Chord](../com.chrynan.chords.model/-chord/index.md). [ChordChart.fretEnd](../com.chrynan.chords.model/-chord-chart/fret-end.md) retrieves the maximum fret that will be displayed in the chart.

#### Author

chRyNaN

## See also

common

| | |
|---|---|
| [com.chrynan.chords.model.ChordChart](../com.chrynan.chords.model/-chord-chart/index.md) |  |
