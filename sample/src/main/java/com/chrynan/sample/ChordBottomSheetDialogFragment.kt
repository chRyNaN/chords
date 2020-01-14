package com.chrynan.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.chords.model.ParcelableChartWrapper
import com.chrynan.chords.model.ParcelableChordWrapper
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dialog_chord_bottom_sheet.*

class ChordBottomSheetDialogFragment : BottomSheetDialogFragment() {

    companion object {

        private const val KEY_CHORD = "parcelableChordWrapperKey"
        private const val KEY_CHART = "parcelableChartWrapperKey"

        fun newInstance(chord: ParcelableChordWrapper, chart: ParcelableChartWrapper) = ChordBottomSheetDialogFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY_CHORD, chord)
                putParcelable(KEY_CHART, chart)
            }
        }
    }

    private val chordWrapper: ParcelableChordWrapper by lazy { arguments?.getParcelable<ParcelableChordWrapper>(KEY_CHORD)!! }
    private val chartWrapper: ParcelableChartWrapper by lazy { arguments?.getParcelable<ParcelableChartWrapper>(KEY_CHART)!! }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.dialog_chord_bottom_sheet, container)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chordWidget?.chord = chordWrapper.chord
        chordWidget?.chart = chartWrapper.chart
    }
}