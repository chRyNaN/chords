package com.chrynan.sample.ui.adapter

interface DiffDispatcher<VM : UniqueAdapterItem> {

    suspend fun dispatchDiff(diff: DiffResult<VM>)
}
