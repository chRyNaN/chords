@file:Suppress("unused")

package com.chrynan.chords.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawScope

interface ComposableDrawScope : DrawScope {

    fun drawComposable(
        content: @Composable () -> Unit
    )
}

@Composable
fun ComposableCanvas(
    modifier: Modifier = Modifier,
    onDraw: ComposableDrawScope.() -> Unit
) {
    Box(modifier = modifier) {
        val composableOperations = mutableListOf<DrawComposableOperation>()

        Canvas(modifier = Modifier.fillMaxSize()) {
            val drawScope = this

            val scope = object : ComposableDrawScope,
                DrawScope by drawScope {

                override fun drawComposable(content: @Composable () -> Unit) {
                    composableOperations.add(DrawComposableOperation(content = content))
                }
            }

            onDraw(scope)
        }

        composableOperations.forEach {
            it.content.invoke()
        }
    }
}

data class DrawComposableOperation(val content: @Composable () -> Unit)
