package com.chrynan.chords.util

import com.chrynan.chords.model.ChordChart

val ChordChart.fretCount: Int
    get() = fretEnd.number - fretStart.number