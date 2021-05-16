//[chords-core](../../index.md)/[com.chrynan.chords.parser](index.md)



# Package com.chrynan.chords.parser  


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.parser/AsciiChordParser///PointingToDeclaration/"></a>[AsciiChordParser](-ascii-chord-parser/index.md)| <a name="com.chrynan.chords.parser/AsciiChordParser///PointingToDeclaration/"></a>[common]  <br>Content  <br>class [AsciiChordParser](-ascii-chord-parser/index.md)(**tabDelimiters**: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)>) : [ChordParser](-chord-parser/index.md)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>   <br>More info  <br>Parses a simple ASCII Chord Diagram String into a [Chord](../com.chrynan.chords.model/-chord/index.md).  <br><br><br>|
| <a name="com.chrynan.chords.parser/ChordParser///PointingToDeclaration/"></a>[ChordParser](-chord-parser/index.md)| <a name="com.chrynan.chords.parser/ChordParser///PointingToDeclaration/"></a>[common]  <br>Content  <br>interface [ChordParser](-chord-parser/index.md)<[T](-chord-parser/index.md)> : [Parser](-parser/index.md)<[T](-chord-parser/index.md), [ChordParseResult](../com.chrynan.chords.model/-chord-parse-result/index.md)>   <br>More info  <br>An interface that parses an input into a [Chord](../com.chrynan.chords.model/-chord/index.md) wrapped in a [ChordParseResult](../com.chrynan.chords.model/-chord-parse-result/index.md).  <br><br><br>|
| <a name="com.chrynan.chords.parser/ChordProParser///PointingToDeclaration/"></a>[ChordProParser](-chord-pro-parser/index.md)| <a name="com.chrynan.chords.parser/ChordProParser///PointingToDeclaration/"></a>[common]  <br>Content  <br>class [ChordProParser](-chord-pro-parser/index.md) : [ChordParser](-chord-parser/index.md)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>   <br>More info  <br>An implementation of a [ChordParser](-chord-parser/index.md) that parses a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) in the ChordPro "define" and "chord" directives format and returns a [ChordParseResult](../com.chrynan.chords.model/-chord-parse-result/index.md).  <br><br><br>|
| <a name="com.chrynan.chords.parser/JsonStringChordParser///PointingToDeclaration/"></a>[JsonStringChordParser](-json-string-chord-parser/index.md)| <a name="com.chrynan.chords.parser/JsonStringChordParser///PointingToDeclaration/"></a>[common]  <br>Content  <br>class [JsonStringChordParser](-json-string-chord-parser/index.md)(**json**: Json) : [ChordParser](-chord-parser/index.md)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>   <br>More info  <br>Parses a JSON String representation of a [Chord](../com.chrynan.chords.model/-chord/index.md) model.  <br><br><br>|
| <a name="com.chrynan.chords.parser/Parser///PointingToDeclaration/"></a>[Parser](-parser/index.md)| <a name="com.chrynan.chords.parser/Parser///PointingToDeclaration/"></a>[common]  <br>Content  <br>interface [Parser](-parser/index.md)<[IN](-parser/index.md), [OUT](-parser/index.md)>  <br>More info  <br>A generic interface to parse an input into an output.  <br><br><br>|

