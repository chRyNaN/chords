//[chords-core](../../../../index.md)/[com.chrynan.chords.model](../../index.md)/[ChordMarker](../index.md)/[Bar](index.md)



# Bar  
 [common] data class [Bar](index.md)(**fret**: [FretNumber](../../-fret-number/index.md), **finger**: [Finger](../../-finger/index.md), **startString**: [StringNumber](../../-string-number/index.md), **endString**: [StringNumber](../../-string-number/index.md)) : [ChordMarker](../index.md), [FretMarker](../../-fret-marker/index.md), [FingerMarker](../../-finger-marker/index.md), [StringRangeMarker](../../-string-range-marker/index.md)

A [ChordMarker](../index.md) representing multiple notes spanning across multiple strings on a single fret.



#### Author  


chRyNaN

   


## Constructors  
  
| | |
|---|---|
| <a name="com.chrynan.chords.model/ChordMarker.Bar/Bar/#com.chrynan.chords.model.FretNumber#com.chrynan.chords.model.Finger#com.chrynan.chords.model.StringNumber#com.chrynan.chords.model.StringNumber/PointingToDeclaration/"></a>[Bar](-bar.md)| <a name="com.chrynan.chords.model/ChordMarker.Bar/Bar/#com.chrynan.chords.model.FretNumber#com.chrynan.chords.model.Finger#com.chrynan.chords.model.StringNumber#com.chrynan.chords.model.StringNumber/PointingToDeclaration/"></a> [common] fun [Bar](-bar.md)(fret: [FretNumber](../../-fret-number/index.md), finger: [Finger](../../-finger/index.md) = Finger.UNKNOWN, startString: [StringNumber](../../-string-number/index.md), endString: [StringNumber](../../-string-number/index.md))   <br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.model/ChordMarker.Bar/endString/#/PointingToDeclaration/"></a>[endString](end-string.md)| <a name="com.chrynan.chords.model/ChordMarker.Bar/endString/#/PointingToDeclaration/"></a> [common] open override val [endString](end-string.md): [StringNumber](../../-string-number/index.md)The [StringNumber](../../-string-number/index.md) of the last string this bar ends.   <br>|
| <a name="com.chrynan.chords.model/ChordMarker.Bar/finger/#/PointingToDeclaration/"></a>[finger](finger.md)| <a name="com.chrynan.chords.model/ChordMarker.Bar/finger/#/PointingToDeclaration/"></a> [common] open override val [finger](finger.md): [Finger](../../-finger/index.md)The finger used to bar these notes.   <br>|
| <a name="com.chrynan.chords.model/ChordMarker.Bar/fret/#/PointingToDeclaration/"></a>[fret](fret.md)| <a name="com.chrynan.chords.model/ChordMarker.Bar/fret/#/PointingToDeclaration/"></a> [common] open override val [fret](fret.md): [FretNumber](../../-fret-number/index.md)The [FretNumber](../../-fret-number/index.md) of the notes in this bar.   <br>|
| <a name="com.chrynan.chords.model/ChordMarker.Bar/startString/#/PointingToDeclaration/"></a>[startString](start-string.md)| <a name="com.chrynan.chords.model/ChordMarker.Bar/startString/#/PointingToDeclaration/"></a> [common] open override val [startString](start-string.md): [StringNumber](../../-string-number/index.md)The [StringNumber](../../-string-number/index.md) of the first string this bar starts.   <br>|
| <a name="com.chrynan.chords.model/ChordMarker.Bar/string/#/PointingToDeclaration/"></a>[string](string.md)| <a name="com.chrynan.chords.model/ChordMarker.Bar/string/#/PointingToDeclaration/"></a> [common] open override val [string](string.md): [StringNumber](../../-string-number/index.md)The [StringNumber](../../-string-number/index.md) that this [ChordMarker](../index.md) is on.   <br>|
| <a name="com.chrynan.chords.model/ChordMarker.Bar/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.chrynan.chords.model/ChordMarker.Bar/type/#/PointingToDeclaration/"></a> [common] open override val [type](type.md): [MarkerType](../../-marker-type/index.md)The [MarkerType](../../-marker-type/index.md) of this [ChordMarker](../index.md).   <br>|


## Extensions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.util//notes/com.chrynan.chords.model.ChordMarker.Bar#/PointingToDeclaration/"></a>[notes](../../../com.chrynan.chords.util/notes.md)| <a name="com.chrynan.chords.util//notes/com.chrynan.chords.model.ChordMarker.Bar#/PointingToDeclaration/"></a>[common]  <br>Content  <br>val [ChordMarker.Bar](index.md).[notes](../../../com.chrynan.chords.util/notes.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[ChordMarker.Note](../-note/index.md)>  <br>More info  <br>Retrieves the [ChordMarker.Note](../-note/index.md)s that make up this [ChordMarker.Bar](index.md).  <br><br><br>|

