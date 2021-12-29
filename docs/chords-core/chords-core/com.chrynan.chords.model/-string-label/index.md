//[chords-core](../../../index.md)/[com.chrynan.chords.model](../index.md)/[StringLabel](index.md)

# StringLabel

[common]\
data class [StringLabel](index.md)(string: [StringNumber](../-string-number/index.md), label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)

A model containing information about a label for a string in a chord diagram. This model contains the [string](string.md) the label should be displayed for and an optional [label](label.md) for that string. Chord diagrams may choose to either display this label, if it is not null, display the [string](string.md) number, or display no label indicator. Refer to [StringLabelState](../-string-label-state/index.md).

#### Author

chRyNaN

## Constructors

| | |
|---|---|
| [StringLabel](-string-label.md) | [common]<br>fun [StringLabel](-string-label.md)(string: [StringNumber](../-string-number/index.md), label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [label](label.md) | [common]<br>val [label](label.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null<br>The optional label that should be displayed for this string. |
| [string](string.md) | [common]<br>val [string](string.md): [StringNumber](../-string-number/index.md)<br>The [StringNumber](../-string-number/index.md) that this label should be displayed for. |
