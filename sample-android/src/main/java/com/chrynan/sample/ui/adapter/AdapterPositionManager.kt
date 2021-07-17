package com.chrynan.sample.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

interface AdapterPositionManager {

    val layoutManager: RecyclerView.LayoutManager

    fun findFirstVisibleItemPosition(): Int

    fun findLastVisibleItemPosition(): Int

    fun findViewByPosition(position: Int): View?

    fun getPosition(view: View): Int
}
