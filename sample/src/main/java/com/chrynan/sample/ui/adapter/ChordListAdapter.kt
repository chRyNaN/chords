package com.chrynan.sample.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chrynan.aaaah.*
import com.chrynan.sample.R
import com.chrynan.sample.viewmodel.AdapterItemViewModel
import com.chrynan.sample.viewmodel.ChordListViewModel
import kotlinx.android.synthetic.main.adapter_chord_list.view.*
import javax.inject.Inject
import javax.inject.Named

@Adapter
class ChordListAdapter @Inject constructor(
        @Named("NestedChordListAdapter") private val adapter: ManagerRecyclerViewAdapter<AdapterItemViewModel>,
        private val viewPool: RecyclerView.RecycledViewPool
) : AnotherAdapter<ChordListViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is ChordListViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_chord_list, parent, false)

    override fun onBindItem(view: View, item: ChordListViewModel) {
        view.apply {
            titleTextView?.text = item.title
            recyclerView?.adapter = adapter
            recyclerView?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView?.setRecycledViewPool(viewPool)
            adapter.items = item.items
        }
    }
}