@file:Suppress("unused")

package com.chrynan.chords.compose

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset

interface PositionalLayoutScope : BoxWithConstraintsScope {

    val density: Density

    @Composable
    fun Layout(
        modifier: Modifier = Modifier,
        size: PositionalLayoutSize,
        offset: Offset,
        content: @Composable () -> Unit
    )
}

@Composable
fun PositionalLayoutScope.Layout(
    modifier: Modifier = Modifier,
    size: Size,
    offset: Offset,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        size = PositionalLayoutSize.Exact(size = size),
        offset = offset,
        content = content
    )
}

@Composable
fun PositionalLayoutScope.Layout(
    modifier: Modifier = Modifier,
    width: Float,
    height: Float,
    offset: Offset,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        size = Size(width = width, height = height),
        offset = offset,
        content = content
    )
}

@Composable
fun PositionalLayoutScope.Layout(
    modifier: Modifier = Modifier,
    width: Dp,
    height: Dp,
    offset: DpOffset,
    content: @Composable () -> Unit
) {
    density.apply {
        Layout(
            modifier = modifier,
            size = Size(width = width.toPx(), height = height.toPx()),
            offset = Offset(x = offset.x.toPx(), y = offset.y.toPx()),
            content = content
        )
    }
}

internal class PositionalLayoutScopeSource(
    boxWithConstraintsScope: BoxWithConstraintsScope,
    override val density: Density
) : PositionalLayoutScope,
    BoxWithConstraintsScope by boxWithConstraintsScope {

    private val items = mutableListOf<PositionalItem>()

    @Composable
    override fun Layout(
        modifier: Modifier,
        size: PositionalLayoutSize,
        offset: Offset,
        content: @Composable () -> Unit
    ) {
        items.add(
            PositionalItem(
                modifier = modifier,
                size = size,
                offset = offset,
                content = content
            )
        )
    }

    fun build(): List<PositionalItem> = items.toList()
}

sealed class PositionalLayoutSize {

    data class Exact(val size: Size) : PositionalLayoutSize()

    object MatchParent : PositionalLayoutSize()

    object WrapContent : PositionalLayoutSize()
}

internal data class PositionalItem(
    val modifier: Modifier,
    val size: PositionalLayoutSize,
    val offset: Offset,
    val content: @Composable () -> Unit
)

@Composable
fun PositionalLayout(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    propagateMinConstraints: Boolean = false,
    builder: @Composable PositionalLayoutScope.() -> Unit
) {
    BoxWithConstraints(
        modifier = modifier,
        contentAlignment = contentAlignment,
        propagateMinConstraints = propagateMinConstraints
    ) {
        val density = LocalDensity.current

        val scope = PositionalLayoutScopeSource(boxWithConstraintsScope = this, density = density)

        builder.invoke(scope)

        val items = scope.build()

        items.forEach { item ->
            density.apply {
                val m = when (item.size) {
                    is PositionalLayoutSize.Exact -> item.modifier
                        .width(width = item.size.size.width.toDp())
                        .height(height = item.size.size.height.toDp())
                    is PositionalLayoutSize.MatchParent -> item.modifier.fillMaxSize()
                    is PositionalLayoutSize.WrapContent -> item.modifier.wrapContentSize()
                }

                Box(
                    modifier = m.offset(
                        x = item.offset.x.toDp(),
                        y = item.offset.y.toDp()
                    )
                ) {
                    item.content.invoke()
                }
            }
        }
    }
}
