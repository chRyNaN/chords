package com.chrynan.sample.ui.adapter.core

import com.chrynan.aaaah.DiffResult
import com.chrynan.sample.viewmodel.AdapterItemViewModel
import kotlinx.coroutines.flow.Flow

interface AdapterItemHandler<VM : AdapterItemViewModel> {

    fun Flow<Collection<VM>>.calculateAndDispatchDiff(): Flow<DiffResult<VM>>
}