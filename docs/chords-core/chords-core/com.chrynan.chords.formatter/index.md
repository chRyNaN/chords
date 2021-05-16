//[chords-core](../../index.md)/[com.chrynan.chords.formatter](index.md)



# Package com.chrynan.chords.formatter  


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.formatter/ChordFormatter///PointingToDeclaration/"></a>[ChordFormatter](-chord-formatter/index.md)| <a name="com.chrynan.chords.formatter/ChordFormatter///PointingToDeclaration/"></a>[common]  <br>Content  <br>interface [ChordFormatter](-chord-formatter/index.md)<[T](-chord-formatter/index.md)> : [Formatter](-formatter/index.md)<[Chord](../com.chrynan.chords.model/-chord/index.md), [T](-chord-formatter/index.md)>   <br>More info  <br>An interface that formats a [Chord](../com.chrynan.chords.model/-chord/index.md) into an output of type [T](-chord-formatter/index.md).  <br><br><br>|
| <a name="com.chrynan.chords.formatter/Formatter///PointingToDeclaration/"></a>[Formatter](-formatter/index.md)| <a name="com.chrynan.chords.formatter/Formatter///PointingToDeclaration/"></a>[common]  <br>Content  <br>interface [Formatter](-formatter/index.md)<[IN](-formatter/index.md), [OUT](-formatter/index.md)>  <br>More info  <br>A generic interface to format a type of [IN](-formatter/index.md) to an output of type [OUT](-formatter/index.md).  <br><br><br>|
| <a name="com.chrynan.chords.formatter/JsonStringChordFormatter///PointingToDeclaration/"></a>[JsonStringChordFormatter](-json-string-chord-formatter/index.md)| <a name="com.chrynan.chords.formatter/JsonStringChordFormatter///PointingToDeclaration/"></a>[common]  <br>Content  <br>class [JsonStringChordFormatter](-json-string-chord-formatter/index.md)(**json**: Json) : [ChordFormatter](-chord-formatter/index.md)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>   <br>More info  <br>Formats a [Chord](../com.chrynan.chords.model/-chord/index.md) model into a JSON String representation.  <br><br><br>|

