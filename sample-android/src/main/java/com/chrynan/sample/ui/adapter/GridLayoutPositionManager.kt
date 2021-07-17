package com.chrynan.sample.ui.adapter

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager

class GridLayoutPositionManager(override val layoutManager: GridLayoutManager) :
    AdapterPositionManager {

    override fun findFirstVisibleItemPosition(): Int =
        layoutManager.findFirstVisibleItemPosition()

    override fun findLastVisibleItemPosition(): Int =
        layoutManager.findLastVisibleItemPosition()

    override fun findViewByPosition(position: Int): View? =
        layoutManager.findViewByPosition(position)

    override fun getPosition(view: View): Int = layoutManager.getPosition(view)
}
