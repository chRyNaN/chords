package com.chrynan.sample.ui.adapter.core

import com.chrynan.sample.coroutine.CoroutineDispatchers
import com.chrynan.sample.model.AdapterItemViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class BaseAdapterItemHandler<VM : AdapterItemViewModel>(
        private val diffProcessor: DiffProcessor<VM>,
        private val diffDispatcher: DiffDispatcher<VM>,
        private val coroutineDispatchers: CoroutineDispatchers
) : AdapterItemHandler<VM> {

    @ExperimentalCoroutinesApi
    override fun Flow<Collection<VM>>.calculateAndDispatchDiff(): Flow<DiffResult<VM>> =
            map(diffProcessor::processDiff)
                    .flowOn(coroutineDispatchers.io)
                    .onEach { diffDispatcher.dispatchDiff(it) }
                    .flowOn(coroutineDispatchers.main)
}