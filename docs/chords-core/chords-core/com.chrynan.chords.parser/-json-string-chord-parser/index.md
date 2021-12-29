//[chords-core](../../../index.md)/[com.chrynan.chords.parser](../index.md)/[JsonStringChordParser](index.md)

# JsonStringChordParser

[common]\
class [JsonStringChordParser](index.md)(json: Json) : [ChordParser](../-chord-parser/index.md)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; 

Parses a JSON String representation of a [Chord](../../com.chrynan.chords.model/-chord/index.md) model. This uses the [Chord](../../com.chrynan.chords.model/-chord/index.md) classes serializer information to parse, or deserialize, the JSON String, along with the provided [json](../../../../chords-core/com.chrynan.chords.parser/-json-string-chord-parser/json.md) object (which defaults to the default Json instance).

## Constructors

| | |
|---|---|
| [JsonStringChordParser](-json-string-chord-parser.md) | [common]<br>fun [JsonStringChordParser](-json-string-chord-parser.md)(json: Json = Json) |

## Functions

| Name | Summary |
|---|---|
| [parse](parse.md) | [common]<br>open suspend override fun [parse](parse.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)<br>Parses the provided input IN and returns the output OUT. If an exception is encountered during the parsing process, then that exception will be thrown. If you would rather catch the exception and have null return, use the [parseOrNull](../../../../chords-core/com.chrynan.chords.parser/-json-string-chord-parser/parse-or-null.md) function instead. |
| [parseOrNull](index.md#-1785805895%2FFunctions%2F1723987581) | [common]<br>open suspend fun [parseOrNull](index.md#-1785805895%2FFunctions%2F1723987581)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)?<br>Parses the provided input [IN](../-parser/index.md) and returns the output [OUT](../-parser/index.md). If an exception is encountered during the parsing process, then that exception will be caught and null will be returned. If you would rather handle the exception, then use the [parse](../-parser/parse.md) function instead. |
