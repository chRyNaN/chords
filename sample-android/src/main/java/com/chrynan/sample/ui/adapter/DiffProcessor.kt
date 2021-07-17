package com.chrynan.sample.ui.adapter

interface DiffProcessor<VM : UniqueAdapterItem> {

    suspend fun processDiff(items: Collection<VM>): DiffResult<VM>
}
