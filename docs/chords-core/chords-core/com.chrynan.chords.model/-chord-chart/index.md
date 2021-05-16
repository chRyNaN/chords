//[chords-core](../../../index.md)/[com.chrynan.chords.model](../index.md)/[ChordChart](index.md)



# ChordChart  
 [common] data class [ChordChart](index.md)(**fretStart**: [FretNumber](../-fret-number/index.md), **fretEnd**: [FretNumber](../-fret-number/index.md), **stringCount**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **stringLabels**: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[StringLabel](../-string-label/index.md)>)

A representation of a diagram used to display a fretted string instrument Chord. This contains information related to the visual diagram, such as the [fretStart](fret-start.md) and [fretEnd](fret-end.md).



A chord diagram usually displays the frets as horizontal rows separated by lines (fret markers). This diagram starts with the first being the [fretStart](fret-start.md) and ends with the [fretEnd](fret-end.md). And a chord diagram usually displays the strings as vertical columns. This diagram contains [stringCount](string-count.md) as the amount of strings. The [stringLabels](string-labels.md) are usually displayed at one of the ends of the strings in the diagram, if they are to be drawn.



Note that this does not contain information about the View, such as colors and text. For that information, refer to the [ChordViewModel](../-chord-view-model/index.md) and [ChordView](../../com.chrynan.chords.view/-chord-view/index.md) classes.



#### Author  


chRyNaN

   


## Constructors  
  
| | |
|---|---|
| <a name="com.chrynan.chords.model/ChordChart/ChordChart/#com.chrynan.chords.model.FretNumber#com.chrynan.chords.model.FretNumber#kotlin.Int#kotlin.collections.Set[com.chrynan.chords.model.StringLabel]/PointingToDeclaration/"></a>[ChordChart](-chord-chart.md)| <a name="com.chrynan.chords.model/ChordChart/ChordChart/#com.chrynan.chords.model.FretNumber#com.chrynan.chords.model.FretNumber#kotlin.Int#kotlin.collections.Set[com.chrynan.chords.model.StringLabel]/PointingToDeclaration/"></a> [common] fun [ChordChart](-chord-chart.md)(fretStart: [FretNumber](../-fret-number/index.md) = DEFAULT_FRET_START, fretEnd: [FretNumber](../-fret-number/index.md) = DEFAULT_FRET_END, stringCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = DEFAULT_GUITAR_STRING_COUNT, stringLabels: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[StringLabel](../-string-label/index.md)> = emptySet())   <br>|


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.model/ChordChart.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.chords.model/ChordChart.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.model/ChordChart/fretEnd/#/PointingToDeclaration/"></a>[fretEnd](fret-end.md)| <a name="com.chrynan.chords.model/ChordChart/fretEnd/#/PointingToDeclaration/"></a> [common] val [fretEnd](fret-end.md): [FretNumber](../-fret-number/index.md)The ending [FretNumber](../-fret-number/index.md) of this diagram.   <br>|
| <a name="com.chrynan.chords.model/ChordChart/fretStart/#/PointingToDeclaration/"></a>[fretStart](fret-start.md)| <a name="com.chrynan.chords.model/ChordChart/fretStart/#/PointingToDeclaration/"></a> [common] val [fretStart](fret-start.md): [FretNumber](../-fret-number/index.md)The starting [FretNumber](../-fret-number/index.md) of this diagram.   <br>|
| <a name="com.chrynan.chords.model/ChordChart/stringCount/#/PointingToDeclaration/"></a>[stringCount](string-count.md)| <a name="com.chrynan.chords.model/ChordChart/stringCount/#/PointingToDeclaration/"></a> [common] val [stringCount](string-count.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)An [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) specifying the amount of strings in this diagram.   <br>|
| <a name="com.chrynan.chords.model/ChordChart/stringLabels/#/PointingToDeclaration/"></a>[stringLabels](string-labels.md)| <a name="com.chrynan.chords.model/ChordChart/stringLabels/#/PointingToDeclaration/"></a> [common] val [stringLabels](string-labels.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[StringLabel](../-string-label/index.md)>A [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html) of [StringLabel](../-string-label/index.md)s for each string in this diagram.   <br>|

