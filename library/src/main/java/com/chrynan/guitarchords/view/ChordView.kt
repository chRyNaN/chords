package com.chrynan.guitarchords.view

import com.chrynan.guitarchords.model.Chord
import com.chrynan.guitarchords.model.ColorInt

interface ChordView {

    var chord: Chord?

    var showFretNumbers: Boolean

    var showFingerNumbers: Boolean

    var stringLabelState: StringLabelState

    var stringCount: Int

    var fretStart: Int

    var fretEnd: Int

    var mutedText: String

    var openStringText: String

    var bridgeNutColor: ColorInt

    var fretMarkerColor: ColorInt

    var stringColor: ColorInt

    var fretNumberColor: ColorInt

    var stringMarkerColor: ColorInt

    var noteColor: ColorInt

    var noteNumberColor: ColorInt

    var barLineColor: ColorInt
}