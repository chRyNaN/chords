package com.chrynan.sample.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.*
import com.chrynan.chords.model.Chord
import com.chrynan.sample.R
import com.chrynan.sample.model.ChordViewModel
import kotlinx.android.synthetic.main.adapter_chord.view.*

@Adapter
class ChordAdapter(private val listener: ChordSelectedListener) : AnotherAdapter<ChordViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is ChordViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_chord, parent, false)

    override fun onBindItem(view: View, item: ChordViewModel) {
        view.apply {
            titleTextView?.text = item.title
            descriptionTextView?.text = item.description
            descriptionTextView?.visibility = if (item.description == null) View.GONE else View.VISIBLE
            setOnClickListener { listener.onChordSelected(item.chord) }
        }
    }

    interface ChordSelectedListener {

        fun onChordSelected(chord: Chord)
    }
}