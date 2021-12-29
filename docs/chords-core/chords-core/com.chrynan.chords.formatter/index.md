//[chords-core](../../index.md)/[com.chrynan.chords.formatter](index.md)

# Package com.chrynan.chords.formatter

## Types

| Name | Summary |
|---|---|
| [ChordFormatter](-chord-formatter/index.md) | [common]<br>interface [ChordFormatter](-chord-formatter/index.md)&lt;[T](-chord-formatter/index.md)&gt; : [Formatter](-formatter/index.md)&lt;[Chord](../com.chrynan.chords.model/-chord/index.md), [T](-chord-formatter/index.md)&gt; <br>An interface that formats a [Chord](../com.chrynan.chords.model/-chord/index.md) into an output of type [T](-chord-formatter/index.md). |
| [Formatter](-formatter/index.md) | [common]<br>interface [Formatter](-formatter/index.md)&lt;[IN](-formatter/index.md), [OUT](-formatter/index.md)&gt;<br>A generic interface to format a type of [IN](-formatter/index.md) to an output of type [OUT](-formatter/index.md). This differs from the [Parser](../com.chrynan.chords.parser/-parser/index.md) interface in that this [Formatter](-formatter/index.md) interface is meant to format an object to an output type. Whereas, the [Parser](../com.chrynan.chords.parser/-parser/index.md) interface is meant to parse an input type into a usable object type. |
| [JsonStringChordFormatter](-json-string-chord-formatter/index.md) | [common]<br>class [JsonStringChordFormatter](-json-string-chord-formatter/index.md)(json: Json) : [ChordFormatter](-chord-formatter/index.md)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; <br>Formats a [Chord](../com.chrynan.chords.model/-chord/index.md) model into a JSON String representation. This uses the [Chord](../com.chrynan.chords.model/-chord/index.md) classes serializer information to format, or serialize, into a JSON String, along with the provided [json](../../../chords-core/com.chrynan.chords.formatter/-json-string-chord-formatter/json.md) object (which defaults to the default Json instance). |
