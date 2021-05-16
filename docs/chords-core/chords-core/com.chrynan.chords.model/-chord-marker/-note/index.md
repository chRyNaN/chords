//[chords-core](../../../../index.md)/[com.chrynan.chords.model](../../index.md)/[ChordMarker](../index.md)/[Note](index.md)



# Note  
 [common] data class [Note](index.md)(**fret**: [FretNumber](../../-fret-number/index.md), **finger**: [Finger](../../-finger/index.md), **string**: [StringNumber](../../-string-number/index.md)) : [ChordMarker](../index.md), [FretMarker](../../-fret-marker/index.md), [FingerMarker](../../-finger-marker/index.md), [StringMarker](../../-string-marker/index.md)

A [ChordMarker](../index.md) representing a single note that is not an open string.



#### Author  


chRyNaN

   


## Constructors  
  
| | |
|---|---|
| <a name="com.chrynan.chords.model/ChordMarker.Note/Note/#com.chrynan.chords.model.FretNumber#com.chrynan.chords.model.Finger#com.chrynan.chords.model.StringNumber/PointingToDeclaration/"></a>[Note](-note.md)| <a name="com.chrynan.chords.model/ChordMarker.Note/Note/#com.chrynan.chords.model.FretNumber#com.chrynan.chords.model.Finger#com.chrynan.chords.model.StringNumber/PointingToDeclaration/"></a> [common] fun [Note](-note.md)(fret: [FretNumber](../../-fret-number/index.md), finger: [Finger](../../-finger/index.md) = Finger.UNKNOWN, string: [StringNumber](../../-string-number/index.md))   <br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.model/ChordMarker.Note/finger/#/PointingToDeclaration/"></a>[finger](finger.md)| <a name="com.chrynan.chords.model/ChordMarker.Note/finger/#/PointingToDeclaration/"></a> [common] open override val [finger](finger.md): [Finger](../../-finger/index.md)The [Finger](../../-finger/index.md) used to play this note.   <br>|
| <a name="com.chrynan.chords.model/ChordMarker.Note/fret/#/PointingToDeclaration/"></a>[fret](fret.md)| <a name="com.chrynan.chords.model/ChordMarker.Note/fret/#/PointingToDeclaration/"></a> [common] open override val [fret](fret.md): [FretNumber](../../-fret-number/index.md)The [FretNumber](../../-fret-number/index.md) of this note.   <br>|
| <a name="com.chrynan.chords.model/ChordMarker.Note/string/#/PointingToDeclaration/"></a>[string](string.md)| <a name="com.chrynan.chords.model/ChordMarker.Note/string/#/PointingToDeclaration/"></a> [common] open override val [string](string.md): [StringNumber](../../-string-number/index.md)The [StringNumber](../../-string-number/index.md) of this note.   <br>|
| <a name="com.chrynan.chords.model/ChordMarker.Note/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.chrynan.chords.model/ChordMarker.Note/type/#/PointingToDeclaration/"></a> [common] open override val [type](type.md): [MarkerType](../../-marker-type/index.md)The [MarkerType](../../-marker-type/index.md) of this [ChordMarker](../index.md).   <br>|

