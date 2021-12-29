//[chords-core](../../../index.md)/[com.chrynan.chords.parser](../index.md)/[Parser](index.md)/[parse](parse.md)

# parse

[common]\
abstract suspend fun [parse](parse.md)(input: [IN](index.md)): [OUT](index.md)

Parses the provided input [IN](index.md) and returns the output [OUT](index.md). If an exception is encountered during the parsing process, then that exception will be thrown. If you would rather catch the exception and have null return, use the [parseOrNull](parse-or-null.md) function instead.

#### Author

chRyNaN
