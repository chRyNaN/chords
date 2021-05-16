//[chords-core](../../../index.md)/[com.chrynan.chords.model](../index.md)/[ChordMarker](index.md)



# ChordMarker  
 [common] sealed class [ChordMarker](index.md)

A sealed class containing all the different markers that can be in a [Chord](../-chord/index.md). A chord marker is a visual indicator of what note(s) should be played. A set of chord markers makes up a Chord.



Note that a [ChordMarker](index.md) does not contain any information about the frequency of a note but instead contains positional information about a note, or notes, on a visual diagram.



#### Author  


chRyNaN

   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.model/ChordMarker.Bar///PointingToDeclaration/"></a>[Bar](-bar/index.md)| <a name="com.chrynan.chords.model/ChordMarker.Bar///PointingToDeclaration/"></a>[common]  <br>Content  <br>data class [Bar](-bar/index.md)(**fret**: [FretNumber](../-fret-number/index.md), **finger**: [Finger](../-finger/index.md), **startString**: [StringNumber](../-string-number/index.md), **endString**: [StringNumber](../-string-number/index.md)) : [ChordMarker](index.md), [FretMarker](../-fret-marker/index.md), [FingerMarker](../-finger-marker/index.md), [StringRangeMarker](../-string-range-marker/index.md)  <br>More info  <br>A [ChordMarker](index.md) representing multiple notes spanning across multiple strings on a single fret.  <br><br><br>|
| <a name="com.chrynan.chords.model/ChordMarker.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.chords.model/ChordMarker.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|
| <a name="com.chrynan.chords.model/ChordMarker.Muted///PointingToDeclaration/"></a>[Muted](-muted/index.md)| <a name="com.chrynan.chords.model/ChordMarker.Muted///PointingToDeclaration/"></a>[common]  <br>Content  <br>data class [Muted](-muted/index.md)(**string**: [StringNumber](../-string-number/index.md)) : [ChordMarker](index.md), [StringMarker](../-string-marker/index.md)  <br>More info  <br>A [StringMarker](../-string-marker/index.md) representing a muted, or un-played, string.  <br><br><br>|
| <a name="com.chrynan.chords.model/ChordMarker.Note///PointingToDeclaration/"></a>[Note](-note/index.md)| <a name="com.chrynan.chords.model/ChordMarker.Note///PointingToDeclaration/"></a>[common]  <br>Content  <br>data class [Note](-note/index.md)(**fret**: [FretNumber](../-fret-number/index.md), **finger**: [Finger](../-finger/index.md), **string**: [StringNumber](../-string-number/index.md)) : [ChordMarker](index.md), [FretMarker](../-fret-marker/index.md), [FingerMarker](../-finger-marker/index.md), [StringMarker](../-string-marker/index.md)  <br>More info  <br>A [ChordMarker](index.md) representing a single note that is not an open string.  <br><br><br>|
| <a name="com.chrynan.chords.model/ChordMarker.Open///PointingToDeclaration/"></a>[Open](-open/index.md)| <a name="com.chrynan.chords.model/ChordMarker.Open///PointingToDeclaration/"></a>[common]  <br>Content  <br>data class [Open](-open/index.md)(**string**: [StringNumber](../-string-number/index.md)) : [ChordMarker](index.md), [FretMarker](../-fret-marker/index.md), [StringMarker](../-string-marker/index.md)  <br>More info  <br>A [ChordMarker](index.md) representing a single open note.  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.model/ChordMarker/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.chrynan.chords.model/ChordMarker/type/#/PointingToDeclaration/"></a> [common] abstract val [type](type.md): [MarkerType](../-marker-type/index.md)The [MarkerType](../-marker-type/index.md) of this [ChordMarker](index.md).   <br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.chrynan.chords.model/ChordMarker.Note///PointingToDeclaration/"></a>[ChordMarker](-note/index.md)|
| <a name="com.chrynan.chords.model/ChordMarker.Bar///PointingToDeclaration/"></a>[ChordMarker](-bar/index.md)|
| <a name="com.chrynan.chords.model/ChordMarker.Open///PointingToDeclaration/"></a>[ChordMarker](-open/index.md)|
| <a name="com.chrynan.chords.model/ChordMarker.Muted///PointingToDeclaration/"></a>[ChordMarker](-muted/index.md)|

