package com.chrynan.sample.ui.adapter.core

import com.chrynan.sample.model.AdapterItemViewModel

class AndroidDiffProcessor<VM : AdapterItemViewModel>(private val processor: com.chrynan.aaaah.DiffProcessor<VM>) :
        DiffProcessor<VM> {

    override suspend fun processDiff(items: Collection<VM>): AndroidDiffResult<VM> {
        val result = processor.calculateDiff(items.toList())

        return AndroidDiffResult(
                items = processor.currentList,
                diffUtilResult = result
        )
    }
}