package com.chrynan.sample.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface AdapterFactory<VM : UniqueAdapterItem> {

    val decorators: List<RecyclerView.ItemDecoration>

    val positionManager: AdapterPositionManager

    val adapter: ManagerRecyclerViewAdapter<VM>

    val diffUtilCalculator: DiffUtilCalculator<VM>

    val diffProcessor: DiffProcessor<VM>

    val diffDispatcher: DiffDispatcher<VM>

    val adapterItemHandler: AdapterItemHandler<VM>
}

fun <VM : UniqueAdapterItem> RecyclerView.bindAdapterFactory(factory: AdapterFactory<VM>) {
    layoutManager = factory.positionManager.layoutManager
    adapter = factory.adapter
    factory.decorators.forEach { addItemDecoration(it) }
}

fun <VM : UniqueAdapterItem> Flow<Collection<VM>>.calculateAndDispatchDiff(adapterFactory: AdapterFactory<VM>): Flow<DiffResult<VM>> =
    adapterFactory.adapterItemHandler.run {
        calculateAndDispatchDiff()
    }

fun <VM : UniqueAdapterItem> AdapterFactory<VM>.calculateAndDispatchDiff(items: Collection<VM>): Flow<DiffResult<VM>> =
    flowOf(items).calculateAndDispatchDiff(this)
