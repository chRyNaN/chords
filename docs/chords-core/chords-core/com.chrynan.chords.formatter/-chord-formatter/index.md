//[chords-core](../../../index.md)/[com.chrynan.chords.formatter](../index.md)/[ChordFormatter](index.md)

# ChordFormatter

[common]\
interface [ChordFormatter](index.md)&lt;[T](index.md)&gt; : [Formatter](../-formatter/index.md)&lt;[Chord](../../com.chrynan.chords.model/-chord/index.md), [T](index.md)&gt; 

An interface that formats a [Chord](../../com.chrynan.chords.model/-chord/index.md) into an output of type [T](index.md).

## Functions

| Name | Summary |
|---|---|
| [format](index.md#-1052889211%2FFunctions%2F1723987581) | [common]<br>abstract suspend fun [format](index.md#-1052889211%2FFunctions%2F1723987581)(input: [Chord](../../com.chrynan.chords.model/-chord/index.md)): [T](index.md)<br>Formats the provided input type of [IN](../-formatter/index.md) and returns the output type of [OUT](../-formatter/index.md). If an exception is encountered during the formatting process, then that exception will be thrown. If you would rather catch the exception and have null returned, use the [formatOrNull](../-formatter/format-or-null.md) function instead. |
| [formatOrNull](../-json-string-chord-formatter/index.md#-108630245%2FFunctions%2F1723987581) | [common]<br>open suspend fun [formatOrNull](../-json-string-chord-formatter/index.md#-108630245%2FFunctions%2F1723987581)(input: [Chord](../../com.chrynan.chords.model/-chord/index.md)): [T](index.md)?<br>Formats the provided input of type [IN](../-formatter/index.md) and returns the output of type [OUT](../-formatter/index.md). If an exception is encountered during the formatting process, then that exception will be caught and null will be returned. If you would rather handle the exception, then use the [format](../-formatter/format.md) function instead. |

## Inheritors

| Name |
|---|
| [JsonStringChordFormatter](../-json-string-chord-formatter/index.md) |
