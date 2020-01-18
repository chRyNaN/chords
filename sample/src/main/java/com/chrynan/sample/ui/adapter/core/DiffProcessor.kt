package com.chrynan.sample.ui.adapter.core

import com.chrynan.sample.model.AdapterItemViewModel

interface DiffProcessor<VM : AdapterItemViewModel> {

    suspend fun processDiff(items: Collection<VM>): DiffResult<VM>
}