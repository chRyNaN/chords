package com.chrynan.sample.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.aaaah.*
import com.chrynan.sample.R
import com.chrynan.sample.model.AdapterItemViewModel
import com.chrynan.sample.model.ChordListViewModel
import kotlinx.android.synthetic.main.adapter_chord_list.view.*
import javax.inject.Inject
import javax.inject.Named

@Adapter
class ChordListAdapter @Inject constructor(@Named("NestedChordListAdapter") private val adapter: ManagerRecyclerViewAdapter<AdapterItemViewModel>) : AnotherAdapter<ChordListViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is ChordListViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_chord_list, parent, false)

    override fun onBindItem(view: View, item: ChordListViewModel) {
        view.apply {
            titleTextView?.text = item.title
            recyclerView?.adapter = adapter
            recyclerView?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter.items = item.items
        }
    }
}