//[chords-core](../../../index.md)/[com.chrynan.chords.parser](../index.md)/[ChordParser](index.md)

# ChordParser

[common]\
interface [ChordParser](index.md)&lt;[T](index.md)&gt; : [Parser](../-parser/index.md)&lt;[T](index.md), [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)&gt; 

An interface that parses an input into a [Chord](../../com.chrynan.chords.model/-chord/index.md) wrapped in a [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md).

#### Author

chRyNaN

## Functions

| Name | Summary |
|---|---|
| [parse](../-parser/parse.md) | [common]<br>abstract suspend fun [parse](../-parser/parse.md)(input: [T](index.md)): [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)<br>Parses the provided input [IN](../-parser/index.md) and returns the output [OUT](../-parser/index.md). If an exception is encountered during the parsing process, then that exception will be thrown. If you would rather catch the exception and have null return, use the [parseOrNull](../-parser/parse-or-null.md) function instead. |
| [parseOrNull](../-parser/parse-or-null.md) | [common]<br>open suspend fun [parseOrNull](../-parser/parse-or-null.md)(input: [T](index.md)): [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)?<br>Parses the provided input [IN](../-parser/index.md) and returns the output [OUT](../-parser/index.md). If an exception is encountered during the parsing process, then that exception will be caught and null will be returned. If you would rather handle the exception, then use the [parse](../-parser/parse.md) function instead. |

## Inheritors

| Name |
|---|
| [AsciiChordParser](../-ascii-chord-parser/index.md) |
| [ChordProParser](../-chord-pro-parser/index.md) |
| [JsonStringChordParser](../-json-string-chord-parser/index.md) |
