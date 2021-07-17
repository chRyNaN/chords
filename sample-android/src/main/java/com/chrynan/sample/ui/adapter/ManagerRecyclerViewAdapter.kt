package com.chrynan.sample.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

@Suppress("unused")
open class ManagerRecyclerViewAdapter<T : Any>(
    protected val adapters: Set<AnotherAdapter<*>> = emptySet()
) : RecyclerView.Adapter<ManagerRecyclerViewAdapter.ViewHolder>(),
    ItemListUpdater<T> {

    override var items: List<T> = emptyList()

    override fun getItemCount() = items.size

    override fun getItemId(position: Int) =
        items[position].let {
            if (it is UniqueAdapterItem) it.uniqueAdapterId else super.getItemId(
                position
            )
        }

    override fun getItemViewType(position: Int) =
        getAdapterForItem(items[position])?.viewType ?: super.getItemViewType(position)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ViewHolder(
            view = getAdapterForViewType(viewType)!!.onCreateView(
                parent,
                inflater,
                viewType
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        getAdapterForItem(item)?.bindItem(holder.itemView, item, position)
    }

    override fun onChanged(position: Int, count: Int, payload: Any?) =
        notifyItemRangeChanged(position, count, payload)

    override fun onMoved(fromPosition: Int, toPosition: Int) =
        notifyItemMoved(fromPosition, toPosition)

    override fun onInserted(position: Int, count: Int) = notifyItemRangeInserted(position, count)

    override fun onRemoved(position: Int, count: Int) = notifyItemRangeRemoved(position, count)

    private fun getAdapterForItem(item: T) = adapters.firstOrNull { it.onHandlesItem(item) }

    private fun getAdapterForViewType(viewType: ViewType) =
        adapters.firstOrNull { it.viewType == viewType }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
