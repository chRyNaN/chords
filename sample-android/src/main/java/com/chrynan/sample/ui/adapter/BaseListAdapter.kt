package com.chrynan.sample.ui.adapter

import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filterable
import android.widget.ListAdapter

/**
 * A version of [ManagerRecyclerViewAdapter] that is also a [ListAdapter] and [Filterable].
 *
 * Note that this is an abstract class and the implementing class must implement the [Filterable] interface.
 *
 * Note that this class is experimental and hasn't been fully tested yet.
 */
abstract class BaseListAdapter<T : Any, M : UniqueAdapterItem>(
    adapters: Set<AnotherAdapter<out M>> = emptySet()
) : ManagerRecyclerViewAdapter<T>(adapters = adapters),
    ListAdapter,
    Filterable {

    private val adapterMap = adapters.mapIndexed { index, adapter -> adapter to index }.toMap()

    private val viewTypeCount = adapters.map { it.viewType }.toSet().size

    private val dataSetObservers = mutableSetOf<DataSetObserver>()

    override fun registerDataSetObserver(observer: DataSetObserver) {
        dataSetObservers.add(observer)
    }

    override fun unregisterDataSetObserver(observer: DataSetObserver) {
        dataSetObservers.remove(observer)
    }

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    @Suppress("UNCHECKED_CAST")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = items[position] as M
        val adapter: AnotherAdapter<M> =
            adapters.first { it.onHandlesItem(item) } as AnotherAdapter<M>

        val view = if (convertView != null && convertView.tag == adapter.viewType) {
            convertView
        } else {
            adapter.onCreateView(parent!!, LayoutInflater.from(parent.context), adapter.viewType)
        }

        view.tag = adapter.viewType

        view.apply {
            adapter.apply {
                onBindItem(item, position)
            }
        }

        return view
    }

    @Suppress("UNCHECKED_CAST")
    override fun getItemViewType(position: Int): ViewType {
        val item = items[position]
        val adapter = adapters.first { it.onHandlesItem(item) }

        return adapterMap.getValue(adapter as AnotherAdapter<M>)
    }

    override fun getViewTypeCount(): Int = viewTypeCount

    override fun isEmpty(): Boolean = items.isEmpty()

    override fun areAllItemsEnabled(): Boolean = true

    override fun isEnabled(position: Int): Boolean = true

    override fun onChanged(position: Int, count: Int, payload: Any?) {
        super.onChanged(position, count, payload)

        dataSetObservers.forEach { it.onChanged() }
    }

    override fun onMoved(fromPosition: Int, toPosition: Int) {
        super.onMoved(fromPosition, toPosition)

        dataSetObservers.forEach { it.onChanged() }
    }

    override fun onInserted(position: Int, count: Int) {
        super.onInserted(position, count)

        dataSetObservers.forEach { it.onChanged() }
    }

    override fun onRemoved(position: Int, count: Int) {
        super.onRemoved(position, count)

        dataSetObservers.forEach { it.onChanged() }
    }
}
