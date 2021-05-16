//[chords-core](../../../index.md)/[com.chrynan.chords.parser](../index.md)/[JsonStringChordParser](index.md)



# JsonStringChordParser  
 [common] class [JsonStringChordParser](index.md)(**json**: Json) : [ChordParser](../-chord-parser/index.md)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)> 

Parses a JSON String representation of a [Chord](../../com.chrynan.chords.model/-chord/index.md) model. This uses the [Chord](../../com.chrynan.chords.model/-chord/index.md) classes serializer information to parse, or deserialize, the JSON String, along with the provided [json](../../../../chords-core/com.chrynan.chords.parser/-json-string-chord-parser/json.md) object (which defaults to the default Json instance).

   


## Constructors  
  
| | |
|---|---|
| <a name="com.chrynan.chords.parser/JsonStringChordParser/JsonStringChordParser/#kotlinx.serialization.json.Json/PointingToDeclaration/"></a>[JsonStringChordParser](-json-string-chord-parser.md)| <a name="com.chrynan.chords.parser/JsonStringChordParser/JsonStringChordParser/#kotlinx.serialization.json.Json/PointingToDeclaration/"></a> [common] fun [JsonStringChordParser](-json-string-chord-parser.md)(json: Json = Json)   <br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.parser/JsonStringChordParser/parse/#kotlin.String/PointingToDeclaration/"></a>[parse](parse.md)| <a name="com.chrynan.chords.parser/JsonStringChordParser/parse/#kotlin.String/PointingToDeclaration/"></a>[common]  <br>Content  <br>open suspend override fun [parse](parse.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)  <br>More info  <br>Parses the provided input IN and returns the output OUT.  <br><br><br>|
| <a name="com.chrynan.chords.parser/Parser/parseOrNull/#kotlin.String/PointingToDeclaration/"></a>[parseOrNull](index.md#%5Bcom.chrynan.chords.parser%2FParser%2FparseOrNull%2F%23kotlin.String%2FPointingToDeclaration%2F%5D%2FFunctions%2F2144227643)| <a name="com.chrynan.chords.parser/Parser/parseOrNull/#kotlin.String/PointingToDeclaration/"></a>[common]  <br>Content  <br>open suspend fun [parseOrNull](index.md#%5Bcom.chrynan.chords.parser%2FParser%2FparseOrNull%2F%23kotlin.String%2FPointingToDeclaration%2F%5D%2FFunctions%2F2144227643)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)?  <br>More info  <br>Parses the provided input [IN](../-parser/index.md) and returns the output [OUT](../-parser/index.md).  <br><br><br>|

