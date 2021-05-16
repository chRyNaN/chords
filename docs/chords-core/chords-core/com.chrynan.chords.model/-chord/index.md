//[chords-core](../../../index.md)/[com.chrynan.chords.model](../index.md)/[Chord](index.md)



# Chord  
 [common] data class [Chord](index.md)(**name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **markers**: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[ChordMarker](../-chord-marker/index.md)>)

A representation of a fretted stringed instrument Chord. This model contains the [name](name.md) of the Chord and the [markers](markers.md) which indicate the strings, frets, and fingers used to make up the Chord.



Note that this model represents what makes up the fretted stringed instrument Chord and not the diagram used to display it. For a model that represents the diagram which displays Chords, refer to the [ChordChart](../-chord-chart/index.md) class.



Note that this model does not contain frequency information about the notes in a Chord but rather contains information about the position on a fretted stringed instrument to play a Chord. Also, note that this doesn't contain relative container information, such as starting frequency or position.



#### Author  


chRyNaN

   


## Constructors  
  
| | |
|---|---|
| <a name="com.chrynan.chords.model/Chord/Chord/#kotlin.String?#kotlin.collections.Set[com.chrynan.chords.model.ChordMarker]/PointingToDeclaration/"></a>[Chord](-chord.md)| <a name="com.chrynan.chords.model/Chord/Chord/#kotlin.String?#kotlin.collections.Set[com.chrynan.chords.model.ChordMarker]/PointingToDeclaration/"></a> [common] fun [Chord](-chord.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, markers: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[ChordMarker](../-chord-marker/index.md)>)   <br>|


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.model/Chord.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.chords.model/Chord.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.model/Chord/contains/#com.chrynan.chords.model.ChordMarker/PointingToDeclaration/"></a>[contains](contains.md)| <a name="com.chrynan.chords.model/Chord/contains/#com.chrynan.chords.model.ChordMarker/PointingToDeclaration/"></a>[common]  <br>Content  <br>operator fun [contains](contains.md)(marker: [ChordMarker](../-chord-marker/index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>An overloaded operator function that determines whether this [Chord](index.md) contains the provided [marker](contains.md).  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.model/Chord/bars/#/PointingToDeclaration/"></a>[bars](bars.md)| <a name="com.chrynan.chords.model/Chord/bars/#/PointingToDeclaration/"></a> [common] val [bars](bars.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[ChordMarker.Bar](../-chord-marker/-bar/index.md)>A [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html) of [ChordMarker.Bar](../-chord-marker/-bar/index.md)s that are a part of this [Chord](index.md).   <br>|
| <a name="com.chrynan.chords.model/Chord/markers/#/PointingToDeclaration/"></a>[markers](markers.md)| <a name="com.chrynan.chords.model/Chord/markers/#/PointingToDeclaration/"></a> [common] val [markers](markers.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[ChordMarker](../-chord-marker/index.md)>A [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html) of [ChordMarker](../-chord-marker/index.md)s that make up this [Chord](index.md).   <br>|
| <a name="com.chrynan.chords.model/Chord/mutes/#/PointingToDeclaration/"></a>[mutes](mutes.md)| <a name="com.chrynan.chords.model/Chord/mutes/#/PointingToDeclaration/"></a> [common] val [mutes](mutes.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[ChordMarker.Muted](../-chord-marker/-muted/index.md)>A [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html) of [ChordMarker.Muted](../-chord-marker/-muted/index.md)s that are a part of this [Chord](index.md).   <br>|
| <a name="com.chrynan.chords.model/Chord/name/#/PointingToDeclaration/"></a>[name](name.md)| <a name="com.chrynan.chords.model/Chord/name/#/PointingToDeclaration/"></a> [common] val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = nullThe optional name of this [Chord](index.md).   <br>|
| <a name="com.chrynan.chords.model/Chord/notes/#/PointingToDeclaration/"></a>[notes](notes.md)| <a name="com.chrynan.chords.model/Chord/notes/#/PointingToDeclaration/"></a> [common] val [notes](notes.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[ChordMarker.Note](../-chord-marker/-note/index.md)>A [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html) of [ChordMarker.Note](../-chord-marker/-note/index.md)s that are a part of this [Chord](index.md).   <br>|
| <a name="com.chrynan.chords.model/Chord/opens/#/PointingToDeclaration/"></a>[opens](opens.md)| <a name="com.chrynan.chords.model/Chord/opens/#/PointingToDeclaration/"></a> [common] val [opens](opens.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[ChordMarker.Open](../-chord-marker/-open/index.md)>A [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html) of [ChordMarker.Open](../-chord-marker/-open/index.md)s that are a part of this [Chord](index.md).   <br>|


## Extensions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.util//getMarkersOnFret/com.chrynan.chords.model.Chord#com.chrynan.chords.model.FretNumber/PointingToDeclaration/"></a>[getMarkersOnFret](../../com.chrynan.chords.util/get-markers-on-fret.md)| <a name="com.chrynan.chords.util//getMarkersOnFret/com.chrynan.chords.model.Chord#com.chrynan.chords.model.FretNumber/PointingToDeclaration/"></a>[common]  <br>Content  <br>fun [Chord](index.md).[getMarkersOnFret](../../com.chrynan.chords.util/get-markers-on-fret.md)(fret: [FretNumber](../-fret-number/index.md)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ChordMarker](../-chord-marker/index.md)>  <br>More info  <br>Retrieves the [ChordMarker](../-chord-marker/index.md)s that are on the provided [FretNumber](../-fret-number/index.md) within this [Chord](index.md).  <br><br><br>|
| <a name="com.chrynan.chords.util//getMarkersOnString/com.chrynan.chords.model.Chord#com.chrynan.chords.model.StringNumber/PointingToDeclaration/"></a>[getMarkersOnString](../../com.chrynan.chords.util/get-markers-on-string.md)| <a name="com.chrynan.chords.util//getMarkersOnString/com.chrynan.chords.model.Chord#com.chrynan.chords.model.StringNumber/PointingToDeclaration/"></a>[common]  <br>Content  <br>fun [Chord](index.md).[getMarkersOnString](../../com.chrynan.chords.util/get-markers-on-string.md)(string: [StringNumber](../-string-number/index.md)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ChordMarker](../-chord-marker/index.md)>  <br>More info  <br>Retrieves the [ChordMarker](../-chord-marker/index.md)s that are on the provided [StringNumber](../-string-number/index.md) within this [Chord](index.md).  <br><br><br>|
| <a name="com.chrynan.chords.util//maxFret/com.chrynan.chords.model.Chord#/PointingToDeclaration/"></a>[maxFret](../../com.chrynan.chords.util/max-fret.md)| <a name="com.chrynan.chords.util//maxFret/com.chrynan.chords.model.Chord#/PointingToDeclaration/"></a>[common]  <br>Content  <br>val [Chord](index.md).[maxFret](../../com.chrynan.chords.util/max-fret.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br>More info  <br>Retrieves the max fret of this chord, or -1.  <br><br><br>|
| <a name="com.chrynan.chords.util//maxString/com.chrynan.chords.model.Chord#/PointingToDeclaration/"></a>[maxString](../../com.chrynan.chords.util/max-string.md)| <a name="com.chrynan.chords.util//maxString/com.chrynan.chords.model.Chord#/PointingToDeclaration/"></a>[common]  <br>Content  <br>val [Chord](index.md).[maxString](../../com.chrynan.chords.util/max-string.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br>More info  <br>Retrieves the maximum String that is in this [Chord](index.md) with a [ChordMarker](../-chord-marker/index.md).  <br><br><br>|
| <a name="com.chrynan.chords.util//minFret/com.chrynan.chords.model.Chord#/PointingToDeclaration/"></a>[minFret](../../com.chrynan.chords.util/min-fret.md)| <a name="com.chrynan.chords.util//minFret/com.chrynan.chords.model.Chord#/PointingToDeclaration/"></a>[common]  <br>Content  <br>val [Chord](index.md).[minFret](../../com.chrynan.chords.util/min-fret.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br>More info  <br>Retrieves the min fret of this Chord, or -1.  <br><br><br>|
| <a name="com.chrynan.chords.util//minString/com.chrynan.chords.model.Chord#/PointingToDeclaration/"></a>[minString](../../com.chrynan.chords.util/min-string.md)| <a name="com.chrynan.chords.util//minString/com.chrynan.chords.model.Chord#/PointingToDeclaration/"></a>[common]  <br>Content  <br>val [Chord](index.md).[minString](../../com.chrynan.chords.util/min-string.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br>More info  <br>Retrieve the minimum String that is in this [Chord](index.md) with a [ChordMarker](../-chord-marker/index.md).  <br><br><br>|

