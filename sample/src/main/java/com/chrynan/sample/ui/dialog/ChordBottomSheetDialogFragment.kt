package com.chrynan.sample.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.aaaah.AndroidDiffDispatcher
import com.chrynan.aaaah.AndroidDiffProcessor
import com.chrynan.aaaah.DiffUtilCalculator
import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.chords.model.Chord
import com.chrynan.chords.model.ChordChart
import com.chrynan.chords.util.*
import com.chrynan.sample.R
import com.chrynan.sample.coroutine.AndroidCoroutineDispatchers
import com.chrynan.sample.viewmodel.AdapterItemViewModel
import com.chrynan.sample.repository.source.OpenGuitarChordSource
import com.chrynan.sample.ui.adapter.core.BaseAdapterItemHandler
import com.chrynan.sample.ui.view.ChordInfoView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dialog_chord_bottom_sheet.*
import kotlin.math.max

class ChordBottomSheetDialogFragment : BottomSheetDialogFragment(),
        ChordInfoView {

    companion object {

        private const val KEY_CHORD = "parcelableChordWrapperKey"
        private const val KEY_CHART = "parcelableChartWrapperKey"
        private const val DEFAULT_PEEK_HEIGHT = 400

        fun newInstance(chord: Chord, chart: ChordChart? = null) = ChordBottomSheetDialogFragment().apply {
            arguments = Bundle().apply {
                putChord(KEY_CHORD, chord)
                chart?.let { putChordChart(KEY_CHART, it) }
            }
        }
    }

    private val chord: Chord by lazy { arguments?.getChord(KEY_CHORD)!! }
    private val chart: ChordChart? by lazy { arguments?.getChordChart(KEY_CHART) }

    private val dispatchers = AndroidCoroutineDispatchers()
    private val adapter: ManagerRecyclerViewAdapter<AdapterItemViewModel> =
            ManagerRecyclerViewAdapter(adapters = setOf())
    private val chordRepository = OpenGuitarChordSource()
    private val diffDispatcher = AndroidDiffDispatcher(adapter)
    private val diffProcessor = AndroidDiffProcessor<AdapterItemViewModel>(DiffUtilCalculator())
    private val adapterItemHandler = BaseAdapterItemHandler(
            coroutineDispatchers = dispatchers,
            diffDispatcher = diffDispatcher,
            diffProcessor = diffProcessor)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.dialog_chord_bottom_sheet, container)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val defaultChordChart = ChordChart.STANDARD_TUNING_GUITAR_CHART

        chordTitleTextView?.text = chord.name
        chordWidget?.chord = chord
        chordWidget?.chart = chart
                ?: defaultChordChart.copy(fretEnd = max(chord.maxFret, defaultChordChart.fretEnd))

        view.addOnLayoutChangeListener(object : View.OnLayoutChangeListener {
            override fun onLayoutChange(v: View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) {
                view.removeOnLayoutChangeListener(this)
                val behavior = (dialog as? BottomSheetDialog)?.behavior
                behavior?.peekHeight = chordWidget?.bottom ?: DEFAULT_PEEK_HEIGHT
            }
        })

        recyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
        }
    }
}