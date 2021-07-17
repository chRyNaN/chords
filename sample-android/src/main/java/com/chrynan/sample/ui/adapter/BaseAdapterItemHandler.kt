package com.chrynan.sample.ui.adapter

import com.chrynan.dispatchers.dispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class BaseAdapterItemHandler<VM : UniqueAdapterItem>(
    private val diffProcessor: DiffProcessor<VM>,
    private val diffDispatcher: DiffDispatcher<VM>,
    private val processDispatcher: CoroutineDispatcher = dispatchers.io,
    private val uiDispatcher: CoroutineDispatcher = dispatchers.main
) : AdapterItemHandler<VM> {

    @ExperimentalCoroutinesApi
    override fun Flow<Collection<VM>>.calculateAndDispatchDiff(): Flow<DiffResult<VM>> =
        map(diffProcessor::processDiff)
            .flowOn(processDispatcher)
            .onEach { diffDispatcher.dispatchDiff(it) }
            .flowOn(uiDispatcher)
}
