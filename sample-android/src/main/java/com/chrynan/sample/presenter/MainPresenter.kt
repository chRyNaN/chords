package com.chrynan.sample.presenter

import com.chrynan.sample.coroutine.CoroutineDispatchers
import com.chrynan.sample.viewmodel.AdapterItemViewModel
import com.chrynan.sample.repository.ChordRepository
import com.chrynan.sample.ui.adapter.core.AdapterItemHandler
import com.chrynan.sample.view.MainView
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

class MainPresenter @Inject constructor(
        dispatchers: CoroutineDispatchers,
        private val view: MainView,
        private val repository: ChordRepository,
        adapterItemHandler: AdapterItemHandler<AdapterItemViewModel>
) : Presenter(dispatchers = dispatchers),
        AdapterItemHandler<AdapterItemViewModel> by adapterItemHandler {

    @UseExperimental(ExperimentalCoroutinesApi::class)
    fun getChords() {
        repository.getAll()
                .calculateAndDispatchDiff()
                .launchIn(this)
    }
}