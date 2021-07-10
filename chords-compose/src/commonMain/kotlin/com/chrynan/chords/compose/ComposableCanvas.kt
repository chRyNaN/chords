@file:Suppress("unused")

package com.chrynan.chords.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset

interface ComposableDrawScope : DrawScope {

    @Composable
    fun drawComposable(
        modifier: Modifier = Modifier,
        size: PositionalLayoutSize,
        offset: Offset,
        content: @Composable () -> Unit
    )
}

@Composable
fun ComposableDrawScope.drawComposable(
    modifier: Modifier = Modifier,
    size: Size,
    offset: Offset,
    content: @Composable () -> Unit
) {
    drawComposable(
        modifier = modifier,
        size = PositionalLayoutSize.Exact(size = size),
        offset = offset,
        content = content
    )
}

@Composable
fun ComposableDrawScope.drawComposable(
    modifier: Modifier = Modifier,
    width: Float,
    height: Float,
    offset: Offset,
    content: @Composable () -> Unit
) {
    drawComposable(
        modifier = modifier,
        size = Size(width = width, height = height),
        offset = offset,
        content = content
    )
}

@Composable
fun ComposableDrawScope.drawComposable(
    modifier: Modifier = Modifier,
    width: Dp,
    height: Dp,
    offset: DpOffset,
    content: @Composable () -> Unit
) {
    drawComposable(
        modifier = modifier,
        size = Size(width = width.toPx(), height = height.toPx()),
        offset = Offset(x = offset.x.toPx(), y = offset.y.toPx()),
        content = content
    )
}

internal class ComposableDrawScopeSource(
    private val positionalLayoutScope: PositionalLayoutScope,
    private val drawScope: DrawScope
) : ComposableDrawScope,
    DrawScope by drawScope {

    @Composable
    override fun drawComposable(
        modifier: Modifier,
        size: PositionalLayoutSize,
        offset: Offset,
        content: @Composable () -> Unit
    ) {
        positionalLayoutScope.Layout(
            modifier = modifier,
            size = size,
            offset = offset,
            content = content
        )
    }
}

@Composable
fun ComposableCanvas(modifier: Modifier = Modifier, onDraw: ComposableDrawScope.() -> Unit) {
    PositionalLayout(modifier = modifier) {
        val positionalLayoutScope = this

        Layout(
            modifier = Modifier,
            offset = Offset(0f, 0f),
            size = PositionalLayoutSize.MatchParent
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val drawScope = this

                val scope = ComposableDrawScopeSource(
                    positionalLayoutScope = positionalLayoutScope,
                    drawScope = drawScope
                )

                onDraw(scope)
            }
        }
    }
}
