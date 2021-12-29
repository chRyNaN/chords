//[chords-core](../../../index.md)/[com.chrynan.chords.formatter](../index.md)/[Formatter](index.md)

# Formatter

[common]\
interface [Formatter](index.md)&lt;[IN](index.md), [OUT](index.md)&gt;

A generic interface to format a type of [IN](index.md) to an output of type [OUT](index.md). This differs from the [Parser](../../com.chrynan.chords.parser/-parser/index.md) interface in that this [Formatter](index.md) interface is meant to format an object to an output type. Whereas, the [Parser](../../com.chrynan.chords.parser/-parser/index.md) interface is meant to parse an input type into a usable object type.

#### Author

chRyNaN

## Functions

| Name | Summary |
|---|---|
| [format](format.md) | [common]<br>abstract suspend fun [format](format.md)(input: [IN](index.md)): [OUT](index.md)<br>Formats the provided input type of [IN](index.md) and returns the output type of [OUT](index.md). If an exception is encountered during the formatting process, then that exception will be thrown. If you would rather catch the exception and have null returned, use the [formatOrNull](format-or-null.md) function instead. |
| [formatOrNull](format-or-null.md) | [common]<br>open suspend fun [formatOrNull](format-or-null.md)(input: [IN](index.md)): [OUT](index.md)?<br>Formats the provided input of type [IN](index.md) and returns the output of type [OUT](index.md). If an exception is encountered during the formatting process, then that exception will be caught and null will be returned. If you would rather handle the exception, then use the [format](format.md) function instead. |

## Inheritors

| Name |
|---|
| [ChordFormatter](../-chord-formatter/index.md) |
