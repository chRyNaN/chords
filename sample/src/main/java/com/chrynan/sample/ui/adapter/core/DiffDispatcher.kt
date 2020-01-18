package com.chrynan.sample.ui.adapter.core

import com.chrynan.sample.model.AdapterItemViewModel

interface DiffDispatcher<VM : AdapterItemViewModel> {

    suspend fun dispatchDiff(diff: DiffResult<VM>)
}