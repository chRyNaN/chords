//[chords-core](../../../index.md)/[com.chrynan.chords.formatter](../index.md)/[Formatter](index.md)/[formatOrNull](format-or-null.md)

# formatOrNull

[common]\
open suspend fun [formatOrNull](format-or-null.md)(input: [IN](index.md)): [OUT](index.md)?

Formats the provided input of type [IN](index.md) and returns the output of type [OUT](index.md). If an exception is encountered during the formatting process, then that exception will be caught and null will be returned. If you would rather handle the exception, then use the [format](format.md) function instead.

#### Author

chRyNaN
