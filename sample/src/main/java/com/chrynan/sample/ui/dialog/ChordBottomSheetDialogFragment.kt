package com.chrynan.sample.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.chords.model.Chord
import com.chrynan.chords.model.ChordChart
import com.chrynan.chords.model.ParcelableChartWrapper
import com.chrynan.chords.model.ParcelableChordWrapper
import com.chrynan.sample.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dialog_chord_bottom_sheet.*

class ChordBottomSheetDialogFragment : BottomSheetDialogFragment() {

    companion object {

        private const val KEY_CHORD = "parcelableChordWrapperKey"
        private const val KEY_CHART = "parcelableChartWrapperKey"

        fun newInstance(chord: Chord, chart: ChordChart? = null) = ChordBottomSheetDialogFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY_CHORD, ParcelableChordWrapper(chord))
                chart?.let { putParcelable(KEY_CHART, ParcelableChartWrapper(it)) }
            }
        }
    }

    private val chordWrapper: ParcelableChordWrapper by lazy { arguments?.getParcelable<ParcelableChordWrapper>(KEY_CHORD)!! }
    private val chartWrapper: ParcelableChartWrapper? by lazy { arguments?.getParcelable<ParcelableChartWrapper>(KEY_CHART) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.dialog_chord_bottom_sheet, container)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chordTitleTextView?.text = chordWrapper.chord.name
        chordWidget?.chord = chordWrapper.chord
        chordWidget?.chart = chartWrapper?.chart ?: ChordChart()

        view.addOnLayoutChangeListener(object : View.OnLayoutChangeListener {
            override fun onLayoutChange(v: View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) {
                view.removeOnLayoutChangeListener(this)
                val behavior = (dialog as? BottomSheetDialog)?.behavior
                behavior?.peekHeight = chordWidget?.bottom ?: 400
            }
        })
    }
}