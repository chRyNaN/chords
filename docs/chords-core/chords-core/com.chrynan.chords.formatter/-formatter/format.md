//[chords-core](../../../index.md)/[com.chrynan.chords.formatter](../index.md)/[Formatter](index.md)/[format](format.md)

# format

[common]\
abstract suspend fun [format](format.md)(input: [IN](index.md)): [OUT](index.md)

Formats the provided input type of [IN](index.md) and returns the output type of [OUT](index.md). If an exception is encountered during the formatting process, then that exception will be thrown. If you would rather catch the exception and have null returned, use the [formatOrNull](format-or-null.md) function instead.

#### Author

chRyNaN
