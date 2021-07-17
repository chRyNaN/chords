package com.chrynan.sample.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

typealias HandlesItem = (item: Any) -> Boolean
typealias CreateView = (parent: ViewGroup, inflater: LayoutInflater, viewType: ViewType) -> View
typealias BindItem<M> = View.(item: M, position: Int) -> Unit

inline fun <reified M : Any> anotherAdapter(
    viewType: ViewType,
    crossinline onCreateView: CreateView,
    crossinline onHandlesItem: HandlesItem,
    crossinline onBindItem: BindItem<M>
): AnotherAdapter<M> =
    object : AnotherAdapter<M>() {

        override val viewType = viewType

        override fun onHandlesItem(item: Any) = onHandlesItem(item)

        override fun onCreateView(parent: ViewGroup, inflater: LayoutInflater, viewType: ViewType) =
            onCreateView(parent, inflater, viewType)

        override fun View.onBindItem(item: M, position: Int) = onBindItem(item, position)
    }

inline fun <reified M : Any> anotherAdapterManager(vararg adapters: AnotherAdapter<*>) =
    ManagerRecyclerViewAdapter<M>(adapters = adapters.toSet())

inline fun <reified M : Any> adapters(vararg adapters: AnotherAdapter<*>) =
    ManagerRecyclerViewAdapter<M>(adapters = adapters.toSet())

inline fun <reified M : Any> anotherAdapter(
    viewType: ViewType,
    viewResId: Int,
    crossinline bind: View.(M, Int) -> Unit
) =
    object : AnotherAdapter<M>() {

        override val viewType = viewType

        override fun onHandlesItem(item: Any) = item is M

        override fun onCreateView(
            parent: ViewGroup,
            inflater: LayoutInflater,
            viewType: ViewType
        ): View =
            inflater.inflate(viewResId, parent, false)

        override fun View.onBindItem(item: M, position: Int) = bind(item, position)
    }

inline fun <reified M : Any> RecyclerView.adapter(anotherAdapter: AnotherAdapter<M>) {
    this.adapter = anotherAdapterManager<M>(anotherAdapter)
}
