package com.chrynan.sample.ui.adapter.core

import com.chrynan.sample.model.AdapterItemViewModel
import kotlinx.coroutines.flow.Flow

interface AdapterItemHandler<VM : AdapterItemViewModel> {

    fun Flow<Collection<VM>>.calculateAndDispatchDiff(): Flow<DiffResult<VM>>
}