package com.chrynan.sample.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chrynan.chords.model.Chord
import com.chrynan.sample.R
import com.chrynan.sample.viewmodel.ChordViewModel
import javax.inject.Inject

@Adapter
class ChordAdapter @Inject constructor(private val listener: ChordSelectedListener) :
    AnotherAdapter<ChordViewModel>() {

    private val titleTextView: TextView by lazy { TODO() }
    private val descriptionTextView: TextView by lazy { TODO() }

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is ChordViewModel

    override fun onCreateView(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: ViewType
    ): View =
        inflater.inflate(R.layout.adapter_chord, parent, false)

    override fun View.onBindItem(item: ChordViewModel, position: Int) {
        titleTextView?.text = item.title
        descriptionTextView?.text = item.description
        descriptionTextView?.visibility = if (item.description == null) View.GONE else View.VISIBLE
        setOnClickListener { listener.onChordSelected(item.chord) }
    }

    interface ChordSelectedListener {

        fun onChordSelected(chord: Chord)
    }
}
