//[chords-core](../../../index.md)/[com.chrynan.chords.parser](../index.md)/[ChordProParser](index.md)/[parse](parse.md)

# parse

[common]\
open suspend override fun [parse](parse.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)

Parses the provided input IN and returns the output OUT. If an exception is encountered during the parsing process, then that exception will be thrown. If you would rather catch the exception and have null return, use the [parseOrNull](../../../../chords-core/com.chrynan.chords.parser/-chord-pro-parser/parse-or-null.md) function instead.

#### Author

chRyNaN
