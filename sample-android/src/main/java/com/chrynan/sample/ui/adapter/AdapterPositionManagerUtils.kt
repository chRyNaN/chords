package com.chrynan.sample.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

@Suppress("FunctionName")
fun VerticalPositionManager(context: Context): LinearLayoutPositionManager =
    LinearLayoutPositionManager(LinearLayoutManager(context))

@Suppress("FunctionName")
fun HorizontalPositionManager(
    context: Context,
    reverseLayout: Boolean = false
): LinearLayoutPositionManager =
    LinearLayoutPositionManager(
        LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            reverseLayout
        )
    )

@Suppress("FunctionName")
fun GridPositionManager(context: Context, spanCount: Int): GridLayoutPositionManager =
    GridLayoutPositionManager(GridLayoutManager(context, spanCount))
