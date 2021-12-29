//[chords-core](../../../index.md)/[com.chrynan.chords.parser](../index.md)/[ChordProParser](index.md)

# ChordProParser

[common]\
class [ChordProParser](index.md) : [ChordParser](../-chord-parser/index.md)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; 

An implementation of a [ChordParser](../-chord-parser/index.md) that parses a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) in the ChordPro "define" and "chord" directives format and returns a [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md). For more information about the ChordPro format, refer to the documentation: https://www.chordpro.org/chordpro/index.html

Examples of supported input formats include:     {define: Bes base-fret 1 frets 1 1 3 3 3 1 fingers 1 1 2 3 4 1}     {define: As  base-fret 4 frets 1 3 3 2 1 1 fingers 1 3 4 2 1 1}     {chord: Am}     {chord: Bes base-fret 1 frets 1 1 3 3 3 1 fingers 1 1 2 3 4 1}     {chord: As  base-fret 4 frets 1 3 3 2 1 1 fingers 1 3 4 2 1 1}

#### Author

chRyNaN

## Constructors

| | |
|---|---|
| [ChordProParser](-chord-pro-parser.md) | [common]<br>fun [ChordProParser](-chord-pro-parser.md)() |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [parse](parse.md) | [common]<br>open suspend override fun [parse](parse.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)<br>Parses the provided input IN and returns the output OUT. If an exception is encountered during the parsing process, then that exception will be thrown. If you would rather catch the exception and have null return, use the [parseOrNull](../../../../chords-core/com.chrynan.chords.parser/-chord-pro-parser/parse-or-null.md) function instead. |
| [parseOrNull](../-json-string-chord-parser/index.md#-1785805895%2FFunctions%2F1723987581) | [common]<br>open suspend fun [parseOrNull](../-json-string-chord-parser/index.md#-1785805895%2FFunctions%2F1723987581)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)?<br>Parses the provided input [IN](../-parser/index.md) and returns the output [OUT](../-parser/index.md). If an exception is encountered during the parsing process, then that exception will be caught and null will be returned. If you would rather handle the exception, then use the [parse](../-parser/parse.md) function instead. |
