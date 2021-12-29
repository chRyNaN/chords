//[chords-core](../../../index.md)/[com.chrynan.chords.parser](../index.md)/[Parser](index.md)

# Parser

[common]\
interface [Parser](index.md)&lt;[IN](index.md), [OUT](index.md)&gt;

A generic interface to parse an input into an output.

#### Author

chRyNaN

## Functions

| Name | Summary |
|---|---|
| [parse](parse.md) | [common]<br>abstract suspend fun [parse](parse.md)(input: [IN](index.md)): [OUT](index.md)<br>Parses the provided input [IN](index.md) and returns the output [OUT](index.md). If an exception is encountered during the parsing process, then that exception will be thrown. If you would rather catch the exception and have null return, use the [parseOrNull](parse-or-null.md) function instead. |
| [parseOrNull](parse-or-null.md) | [common]<br>open suspend fun [parseOrNull](parse-or-null.md)(input: [IN](index.md)): [OUT](index.md)?<br>Parses the provided input [IN](index.md) and returns the output [OUT](index.md). If an exception is encountered during the parsing process, then that exception will be caught and null will be returned. If you would rather handle the exception, then use the [parse](parse.md) function instead. |

## Inheritors

| Name |
|---|
| [ChordParser](../-chord-parser/index.md) |
