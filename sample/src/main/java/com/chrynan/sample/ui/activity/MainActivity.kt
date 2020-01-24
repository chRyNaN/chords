package com.chrynan.sample.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.aaaah.AndroidDiffDispatcher
import com.chrynan.aaaah.AndroidDiffProcessor
import com.chrynan.aaaah.DiffUtilCalculator
import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.chords.model.Chord
import com.chrynan.chords.model.ChordChart
import com.chrynan.sample.R
import com.chrynan.sample.model.AdapterItemViewModel
import com.chrynan.sample.presenter.MainPresenter
import com.chrynan.sample.repository.OpenGuitarChordSource
import com.chrynan.sample.ui.adapter.ChordAdapter
import com.chrynan.sample.ui.adapter.ChordListAdapter
import com.chrynan.sample.ui.adapter.core.BaseAdapterItemHandler
import com.chrynan.sample.ui.dialog.ChordBottomSheetDialogFragment
import com.chrynan.sample.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),
        MainView,
        ChordAdapter.ChordSelectedListener {

    private val adapter: ManagerRecyclerViewAdapter<AdapterItemViewModel> =
            ManagerRecyclerViewAdapter(adapters = setOf(ChordListAdapter(this)))
    private val chordRepository = OpenGuitarChordSource()
    private val diffDispatcher = AndroidDiffDispatcher(adapter)
    private val diffProcessor = AndroidDiffProcessor<AdapterItemViewModel>(DiffUtilCalculator())
    private val adapterItemHandler = BaseAdapterItemHandler(
            coroutineDispatchers = dispatchers,
            diffDispatcher = diffDispatcher,
            diffProcessor = diffProcessor)

    override val presenter = MainPresenter(
            dispatchers = dispatchers,
            view = this,
            repository = chordRepository,
            adapterItemHandler = adapterItemHandler)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        collapsingToolbarLayout?.title = "Open Guitar Chords"

        setSupportActionBar(toolbar)

        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        presenter.getChords()
    }

    override fun onChordSelected(chord: Chord) {
        ChordBottomSheetDialogFragment.newInstance(chord, ChordChart.STANDARD_TUNING_GUITAR_CHART)
                .show(supportFragmentManager, null)
    }
}
