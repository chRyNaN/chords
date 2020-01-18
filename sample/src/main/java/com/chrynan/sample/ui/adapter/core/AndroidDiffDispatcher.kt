package com.chrynan.sample.ui.adapter.core

import com.chrynan.aaaah.ItemListUpdater
import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.sample.model.AdapterItemViewModel

class AndroidDiffDispatcher<VM : AdapterItemViewModel>(private val listener: ItemListUpdater<VM>) :
        DiffDispatcher<VM> {

    override suspend fun dispatchDiff(diff: DiffResult<VM>) {
        listener.items = diff.items
        // TODO NOTE that this might not call notifyDataSetChanged() possibly causing issues
        if (diff is AndroidDiffResult) {
            diff.diffUtilResult.dispatchUpdatesTo(listener)
        } else if (listener is ManagerRecyclerViewAdapter) {
            listener.notifyDataSetChanged()
        }
    }
}