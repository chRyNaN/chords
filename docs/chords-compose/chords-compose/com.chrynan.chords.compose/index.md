//[chords-compose](../../index.md)/[com.chrynan.chords.compose](index.md)

# Package com.chrynan.chords.compose

## Types

| Name | Summary |
|---|---|
| [ComposableDrawScope](-composable-draw-scope/index.md) | [common]<br>interface [ComposableDrawScope](-composable-draw-scope/index.md) : DrawScope |
| [ConstraintScope](-constraint-scope/index.md) | [common]<br>interface [ConstraintScope](-constraint-scope/index.md) : BoxWithConstraintsScope, Density |
| [DrawComposableOperation](-draw-composable-operation/index.md) | [common]<br>data class [DrawComposableOperation](-draw-composable-operation/index.md)(content: @Composable() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [ChordWidget](-chord-widget.md) | [common]<br>@[ExperimentalUnsignedTypes](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-unsigned-types/index.html)<br>@Composable<br>fun [ChordWidget](-chord-widget.md)(modifier: Modifier = Modifier, chord: [Chord](../../../chords-core/chords-core/com.chrynan.chords.model/-chord/index.md)? = null, chart: [ChordChart](../../../chords-core/chords-core/com.chrynan.chords.model/-chord-chart/index.md) = ChordChart.STANDARD_TUNING_GUITAR_CHART, viewData: [ChordViewData](../../../chords-core/chords-core/com.chrynan.chords.model/-chord-view-data/index.md) = ChordViewData()) |
| [ComposableCanvas](-composable-canvas.md) | [common]<br>@Composable<br>fun [ComposableCanvas](-composable-canvas.md)(modifier: Modifier = Modifier, onDraw: [ComposableDrawScope](-composable-draw-scope/index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [toJetpackComposeColor](to-jetpack-compose-color.md) | [common]<br>@[ExperimentalUnsignedTypes](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-unsigned-types/index.html)<br>fun Color.[toJetpackComposeColor](to-jetpack-compose-color.md)(): Color<br>Converts this Color to a Jetpack Compose compatible androidx.compose.ui.graphics.Color. |
