//[chords-core](../../../index.md)/[com.chrynan.chords.parser](../index.md)/[ChordProParser](index.md)



# ChordProParser  
 [common] class [ChordProParser](index.md) : [ChordParser](../-chord-parser/index.md)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)> 

An implementation of a [ChordParser](../-chord-parser/index.md) that parses a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) in the ChordPro "define" and "chord" directives format and returns a [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md). For more information about the ChordPro format, refer to the documentation: https://www.chordpro.org/chordpro/index.html



Examples of supported input formats include:     {define: Bes base-fret 1 frets 1 1 3 3 3 1 fingers 1 1 2 3 4 1}     {define: As  base-fret 4 frets 1 3 3 2 1 1 fingers 1 3 4 2 1 1}     {chord: Am}     {chord: Bes base-fret 1 frets 1 1 3 3 3 1 fingers 1 1 2 3 4 1}     {chord: As  base-fret 4 frets 1 3 3 2 1 1 fingers 1 3 4 2 1 1}



#### Author  


chRyNaN

   


## Constructors  
  
| | |
|---|---|
| <a name="com.chrynan.chords.parser/ChordProParser/ChordProParser/#/PointingToDeclaration/"></a>[ChordProParser](-chord-pro-parser.md)| <a name="com.chrynan.chords.parser/ChordProParser/ChordProParser/#/PointingToDeclaration/"></a> [common] fun [ChordProParser](-chord-pro-parser.md)()   <br>|


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.parser/ChordProParser.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.chords.parser/ChordProParser.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.parser/ChordProParser/parse/#kotlin.String/PointingToDeclaration/"></a>[parse](parse.md)| <a name="com.chrynan.chords.parser/ChordProParser/parse/#kotlin.String/PointingToDeclaration/"></a>[common]  <br>Content  <br>open suspend override fun [parse](parse.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)  <br>More info  <br>Parses the provided input IN and returns the output OUT.  <br><br><br>|
| <a name="com.chrynan.chords.parser/Parser/parseOrNull/#kotlin.String/PointingToDeclaration/"></a>[parseOrNull](../-json-string-chord-parser/index.md#%5Bcom.chrynan.chords.parser%2FParser%2FparseOrNull%2F%23kotlin.String%2FPointingToDeclaration%2F%5D%2FFunctions%2F2144227643)| <a name="com.chrynan.chords.parser/Parser/parseOrNull/#kotlin.String/PointingToDeclaration/"></a>[common]  <br>Content  <br>open suspend fun [parseOrNull](../-json-string-chord-parser/index.md#%5Bcom.chrynan.chords.parser%2FParser%2FparseOrNull%2F%23kotlin.String%2FPointingToDeclaration%2F%5D%2FFunctions%2F2144227643)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)?  <br>More info  <br>Parses the provided input [IN](../-parser/index.md) and returns the output [OUT](../-parser/index.md).  <br><br><br>|

