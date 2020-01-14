package com.chrynan.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.chords.model.Chord
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dialog_chord_bottom_sheet.*

class ChordBottomSheetDialogFragment : BottomSheetDialogFragment() {

    companion object {

        fun newInstance(chord: Chord) = ChordBottomSheetDialogFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }

    private val chord: Chord? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.dialog_chord_bottom_sheet, container)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chordWidget?.chord = chord
    }
}