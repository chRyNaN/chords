//[chords-core](../../../index.md)/[com.chrynan.chords.formatter](../index.md)/[JsonStringChordFormatter](index.md)



# JsonStringChordFormatter  
 [common] class [JsonStringChordFormatter](index.md)(**json**: Json) : [ChordFormatter](../-chord-formatter/index.md)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)> 

Formats a [Chord](../../com.chrynan.chords.model/-chord/index.md) model into a JSON String representation. This uses the [Chord](../../com.chrynan.chords.model/-chord/index.md) classes serializer information to format, or serialize, into a JSON String, along with the provided [json](../../../../chords-core/com.chrynan.chords.formatter/-json-string-chord-formatter/json.md) object (which defaults to the default Json instance).

   


## Constructors  
  
| | |
|---|---|
| <a name="com.chrynan.chords.formatter/JsonStringChordFormatter/JsonStringChordFormatter/#kotlinx.serialization.json.Json/PointingToDeclaration/"></a>[JsonStringChordFormatter](-json-string-chord-formatter.md)| <a name="com.chrynan.chords.formatter/JsonStringChordFormatter/JsonStringChordFormatter/#kotlinx.serialization.json.Json/PointingToDeclaration/"></a> [common] fun [JsonStringChordFormatter](-json-string-chord-formatter.md)(json: Json = Json)   <br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.formatter/JsonStringChordFormatter/format/#com.chrynan.chords.model.Chord/PointingToDeclaration/"></a>[format](format.md)| <a name="com.chrynan.chords.formatter/JsonStringChordFormatter/format/#com.chrynan.chords.model.Chord/PointingToDeclaration/"></a>[common]  <br>Content  <br>open suspend override fun [format](format.md)(input: [Chord](../../com.chrynan.chords.model/-chord/index.md)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br>More info  <br>Formats the provided input type of IN and returns the output type of OUT.  <br><br><br>|
| <a name="com.chrynan.chords.formatter/Formatter/formatOrNull/#com.chrynan.chords.model.Chord/PointingToDeclaration/"></a>[formatOrNull](index.md#%5Bcom.chrynan.chords.formatter%2FFormatter%2FformatOrNull%2F%23com.chrynan.chords.model.Chord%2FPointingToDeclaration%2F%5D%2FFunctions%2F2144227643)| <a name="com.chrynan.chords.formatter/Formatter/formatOrNull/#com.chrynan.chords.model.Chord/PointingToDeclaration/"></a>[common]  <br>Content  <br>open suspend fun [formatOrNull](index.md#%5Bcom.chrynan.chords.formatter%2FFormatter%2FformatOrNull%2F%23com.chrynan.chords.model.Chord%2FPointingToDeclaration%2F%5D%2FFunctions%2F2144227643)(input: [Chord](../../com.chrynan.chords.model/-chord/index.md)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?  <br>More info  <br>Formats the provided input of type [IN](../-formatter/index.md) and returns the output of type [OUT](../-formatter/index.md).  <br><br><br>|

