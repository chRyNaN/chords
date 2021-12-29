//[chords-compose](../../../index.md)/[com.chrynan.chords.compose](../index.md)/[ConstraintScope](index.md)

# ConstraintScope

[common]\
interface [ConstraintScope](index.md) : BoxWithConstraintsScope, Density

## Functions

| Name | Summary |
|---|---|
| [align](index.md#-1313122955%2FFunctions%2F767310422) | [common]<br>abstract fun Modifier.[align](index.md#-1313122955%2FFunctions%2F767310422)(alignment: Alignment): Modifier |
| [matchParentSize](index.md#-1048661832%2FFunctions%2F767310422) | [common]<br>abstract fun Modifier.[matchParentSize](index.md#-1048661832%2FFunctions%2F767310422)(): Modifier |
| [roundToPx](index.md#1857482676%2FFunctions%2F767310422) | [common]<br>open fun Dp.[roundToPx](index.md#1857482676%2FFunctions%2F767310422)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>open fun TextUnit.[roundToPx](index.md#-12681991%2FFunctions%2F767310422)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toDp](index.md#-874800607%2FFunctions%2F767310422) | [common]<br>open fun TextUnit.[toDp](index.md#-874800607%2FFunctions%2F767310422)(): Dp<br>open fun [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html).[toDp](index.md#923339116%2FFunctions%2F767310422)(): Dp<br>open fun [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html).[toDp](index.md#1576562303%2FFunctions%2F767310422)(): Dp |
| [toDpSize](index.md#589124484%2FFunctions%2F767310422) | [common]<br>open fun Size.[toDpSize](index.md#589124484%2FFunctions%2F767310422)(): DpSize |
| [toPx](index.md#1832552024%2FFunctions%2F767310422) | [common]<br>open fun Dp.[toPx](index.md#1832552024%2FFunctions%2F767310422)(): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>open fun TextUnit.[toPx](index.md#-1716025187%2FFunctions%2F767310422)(): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [toRect](index.md#1563203128%2FFunctions%2F767310422) | [common]<br>open fun DpRect.[toRect](index.md#1563203128%2FFunctions%2F767310422)(): Rect |
| [toSize](index.md#1567580274%2FFunctions%2F767310422) | [common]<br>open fun DpSize.[toSize](index.md#1567580274%2FFunctions%2F767310422)(): Size |
| [toSp](index.md#1370977837%2FFunctions%2F767310422) | [common]<br>open fun Dp.[toSp](index.md#1370977837%2FFunctions%2F767310422)(): TextUnit<br>open fun [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html).[toSp](index.md#-32012741%2FFunctions%2F767310422)(): TextUnit<br>open fun [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html).[toSp](index.md#-2066885874%2FFunctions%2F767310422)(): TextUnit |

## Properties

| Name | Summary |
|---|---|
| [constraints](index.md#382459890%2FProperties%2F767310422) | [common]<br>abstract val [constraints](index.md#382459890%2FProperties%2F767310422): Constraints |
| [density](index.md#-1902924338%2FProperties%2F767310422) | [common]<br>abstract val [density](index.md#-1902924338%2FProperties%2F767310422): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [fontScale](index.md#1367496091%2FProperties%2F767310422) | [common]<br>abstract val [fontScale](index.md#1367496091%2FProperties%2F767310422): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [maxHeight](index.md#2047576797%2FProperties%2F767310422) | [common]<br>abstract val [maxHeight](index.md#2047576797%2FProperties%2F767310422): Dp |
| [maxWidth](index.md#-864171664%2FProperties%2F767310422) | [common]<br>abstract val [maxWidth](index.md#-864171664%2FProperties%2F767310422): Dp |
| [minHeight](index.md#384232495%2FProperties%2F767310422) | [common]<br>abstract val [minHeight](index.md#384232495%2FProperties%2F767310422): Dp |
| [minWidth](index.md#1021834718%2FProperties%2F767310422) | [common]<br>abstract val [minWidth](index.md#1021834718%2FProperties%2F767310422): Dp |
