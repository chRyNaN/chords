//[chords-core](../../../index.md)/[com.chrynan.chords.parser](../index.md)/[ChordParser](index.md)



# ChordParser  
 [common] interface [ChordParser](index.md)<[T](index.md)> : [Parser](../-parser/index.md)<[T](index.md), [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)> 

An interface that parses an input into a [Chord](../../com.chrynan.chords.model/-chord/index.md) wrapped in a [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md).



#### Author  


chRyNaN

   


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.parser/Parser/parse/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[parse](../-parser/parse.md)| <a name="com.chrynan.chords.parser/Parser/parse/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract suspend fun [parse](../-parser/parse.md)(input: [T](index.md)): [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)  <br>More info  <br>Parses the provided input [IN](../-parser/index.md) and returns the output [OUT](../-parser/index.md).  <br><br><br>|
| <a name="com.chrynan.chords.parser/Parser/parseOrNull/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[parseOrNull](../-parser/parse-or-null.md)| <a name="com.chrynan.chords.parser/Parser/parseOrNull/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[common]  <br>Content  <br>open suspend fun [parseOrNull](../-parser/parse-or-null.md)(input: [T](index.md)): [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)?  <br>More info  <br>Parses the provided input [IN](../-parser/index.md) and returns the output [OUT](../-parser/index.md).  <br><br><br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.chrynan.chords.parser/AsciiChordParser///PointingToDeclaration/"></a>[AsciiChordParser](../-ascii-chord-parser/index.md)|
| <a name="com.chrynan.chords.parser/ChordProParser///PointingToDeclaration/"></a>[ChordProParser](../-chord-pro-parser/index.md)|
| <a name="com.chrynan.chords.parser/JsonStringChordParser///PointingToDeclaration/"></a>[JsonStringChordParser](../-json-string-chord-parser/index.md)|

