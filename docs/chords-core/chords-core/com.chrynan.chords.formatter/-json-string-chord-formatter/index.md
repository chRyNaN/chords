//[chords-core](../../../index.md)/[com.chrynan.chords.formatter](../index.md)/[JsonStringChordFormatter](index.md)

# JsonStringChordFormatter

[common]\
class [JsonStringChordFormatter](index.md)(json: Json) : [ChordFormatter](../-chord-formatter/index.md)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; 

Formats a [Chord](../../com.chrynan.chords.model/-chord/index.md) model into a JSON String representation. This uses the [Chord](../../com.chrynan.chords.model/-chord/index.md) classes serializer information to format, or serialize, into a JSON String, along with the provided [json](../../../../chords-core/com.chrynan.chords.formatter/-json-string-chord-formatter/json.md) object (which defaults to the default Json instance).

## Constructors

| | |
|---|---|
| [JsonStringChordFormatter](-json-string-chord-formatter.md) | [common]<br>fun [JsonStringChordFormatter](-json-string-chord-formatter.md)(json: Json = Json) |

## Functions

| Name | Summary |
|---|---|
| [format](format.md) | [common]<br>open suspend override fun [format](format.md)(input: [Chord](../../com.chrynan.chords.model/-chord/index.md)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Formats the provided input type of IN and returns the output type of OUT. If an exception is encountered during the formatting process, then that exception will be thrown. If you would rather catch the exception and have null returned, use the [formatOrNull](../../../../chords-core/com.chrynan.chords.formatter/-json-string-chord-formatter/format-or-null.md) function instead. |
| [formatOrNull](index.md#-108630245%2FFunctions%2F1723987581) | [common]<br>open suspend fun [formatOrNull](index.md#-108630245%2FFunctions%2F1723987581)(input: [Chord](../../com.chrynan.chords.model/-chord/index.md)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>Formats the provided input of type [IN](../-formatter/index.md) and returns the output of type [OUT](../-formatter/index.md). If an exception is encountered during the formatting process, then that exception will be caught and null will be returned. If you would rather handle the exception, then use the [format](../-formatter/format.md) function instead. |
