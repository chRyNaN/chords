package com.chrynan.sample.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.chords.model.Chord
import com.chrynan.sample.R
import com.chrynan.sample.model.AdapterItemViewModel
import com.chrynan.sample.presenter.MainPresenter
import com.chrynan.sample.ui.adapter.ChordAdapter
import com.chrynan.sample.ui.dialog.ChordBottomSheetDialogFragment
import com.chrynan.sample.view.MainView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(),
        MainView,
        ChordAdapter.ChordSelectedListener {

    @Inject
    lateinit var adapter: ManagerRecyclerViewAdapter<AdapterItemViewModel>

    @Inject
    lateinit var layoutManager: LinearLayoutManager

    @Inject
    override lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        collapsingToolbarLayout?.title = "Chords"

        setSupportActionBar(toolbar)

        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = layoutManager

        presenter.getChords()
    }

    override fun onChordSelected(chord: Chord) {
        ChordBottomSheetDialogFragment.newInstance(chord)
                .show(supportFragmentManager, null)
    }
}
