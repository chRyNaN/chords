//[chords-core](../../../index.md)/[com.chrynan.chords.parser](../index.md)/[AsciiChordParser](index.md)

# AsciiChordParser

[common]\
class [AsciiChordParser](index.md)(tabDelimiters: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)&gt;) : [ChordParser](../-chord-parser/index.md)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; 

Parses a simple ASCII Chord Diagram String into a [Chord](../../com.chrynan.chords.model/-chord/index.md). This [ChordParser](../-chord-parser/index.md) handles String inputs in the following format:

    C

e |-----0------| B |-----1------| G |-----0------| D |-----2------| A |-----3------| E |------------|

<ul><li>Whitespace will be trimmed.</li><li>The first line may contain an optional chord name. ---- If there is a chord name present, the whole line will be used as the chord name. ---- If there are any [tabDelimiters](../../../../chords-core/com.chrynan.chords.parser/-ascii-chord-parser/tab-delimiters.md) on the chord name line, it will be considered a 'normal'     line.</li><li>Each following line will be processed as a [StringNumber](../../com.chrynan.chords.model/-string-number/index.md). ---- The first line will be the first [StringNumber](../../com.chrynan.chords.model/-string-number/index.md) (1) and the numbers will increase for     subsequent lines. ---- Lines may begin with an optional label before any [tabDelimiters](../../../../chords-core/com.chrynan.chords.parser/-ascii-chord-parser/tab-delimiters.md) or Frets. ---- All [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)s on a line after the first [tabDelimiters](../../../../chords-core/com.chrynan.chords.parser/-ascii-chord-parser/tab-delimiters.md), and separated by [tabDelimiters](../../../../chords-core/com.chrynan.chords.parser/-ascii-chord-parser/tab-delimiters.md),     will be considered the FretNumbers for [ChordMarker.Note](../../com.chrynan.chords.model/-chord-marker/-note/index.md)s. ---- The absence of an [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) on a line, will be considered a muted line or a line that should     not be played. ---- If an [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) value of zero is found on a line, then that String is considered "open". -- If the input [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) is blank, null will be returned. -- If the [tabDelimiters](../../../../chords-core/com.chrynan.chords.parser/-ascii-chord-parser/tab-delimiters.md) is empty, null will be returned.</li></ul>

#### Author

chRyNaN

## Parameters

common

| | |
|---|---|
| tabDelimiters | The [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html) of [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) delimiters used to separate the optional label and     fret numbers (Ex: "|" and "-"). This set cannot be empty. |

## Constructors

| | |
|---|---|
| [AsciiChordParser](-ascii-chord-parser.md) | [common]<br>fun [AsciiChordParser](-ascii-chord-parser.md)(tabDelimiters: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)&gt; = setOf('|', '-')) |

## Functions

| Name | Summary |
|---|---|
| [parse](parse.md) | [common]<br>open suspend override fun [parse](parse.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)<br>Parses the provided input IN and returns the output OUT. If an exception is encountered during the parsing process, then that exception will be thrown. If you would rather catch the exception and have null return, use the [parseOrNull](../../../../chords-core/com.chrynan.chords.parser/-ascii-chord-parser/parse-or-null.md) function instead. |
| [parseOrNull](../-json-string-chord-parser/index.md#-1785805895%2FFunctions%2F1723987581) | [common]<br>open suspend fun [parseOrNull](../-json-string-chord-parser/index.md#-1785805895%2FFunctions%2F1723987581)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)?<br>Parses the provided input [IN](../-parser/index.md) and returns the output [OUT](../-parser/index.md). If an exception is encountered during the parsing process, then that exception will be caught and null will be returned. If you would rather handle the exception, then use the [parse](../-parser/parse.md) function instead. |
