package com.chrynan.sample.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.chrynan.dispatchers.dispatchers
import kotlinx.coroutines.CoroutineDispatcher

abstract class BaseAdapterFactory<VM : UniqueAdapterItem> : AdapterFactory<VM> {

    abstract val adapters: Set<AnotherAdapter<*>>

    open val processDispatcher: CoroutineDispatcher = dispatchers.io
    open val uiDispatcher: CoroutineDispatcher = dispatchers.main

    @Suppress("RemoveExplicitTypeArguments") // For some reason the build fails without the explicit type parameter
    override val decorators: List<RecyclerView.ItemDecoration> by lazy { emptyList<RecyclerView.ItemDecoration>() }

    @Suppress("RemoveExplicitTypeArguments") // For some reason the build fails without the explicit type parameter
    override val diffUtilCalculator: DiffUtilCalculator<VM> by lazy { DiffUtilCalculator<VM>() }

    override val diffProcessor: DiffProcessor<VM> by lazy {
        AndroidDiffProcessor(
            diffUtilCalculator
        )
    }

    override val diffDispatcher: DiffDispatcher<VM> by lazy { AndroidDiffDispatcher(adapter) }

    @Suppress("RemoveExplicitTypeArguments")
    override val adapter: ManagerRecyclerViewAdapter<VM> by lazy {
        ManagerRecyclerViewAdapter<VM>(adapters = adapters)
    }

    override val adapterItemHandler: AdapterItemHandler<VM> by lazy {
        BaseAdapterItemHandler(
            diffProcessor = diffProcessor,
            diffDispatcher = diffDispatcher,
            processDispatcher = processDispatcher,
            uiDispatcher = uiDispatcher
        )
    }
}
