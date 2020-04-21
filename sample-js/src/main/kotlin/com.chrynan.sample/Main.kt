package com.chrynan.sample

import com.chrynan.chords.model.*
import com.chrynan.chords.widget.ChordWidget
import org.w3c.dom.HTMLCanvasElement
import kotlin.browser.document

fun main() {
    val canvas = document.getElementById("canvas") as HTMLCanvasElement

    canvas.width = 300
    canvas.height = 600

    val widget = ChordWidget(canvas)

    widget.fitToHeight = true
    widget.showFingerNumbers = true
    widget.stringLabelState = StringLabelState.SHOW_LABEL

    val chord = chord {
        +ChordMarker.Muted(string = StringNumber(6))
        +ChordMarker.Open(string = StringNumber(5))
        +ChordMarker.Note(fret = FretNumber(2), string = StringNumber(4), finger = Finger.MIDDLE)
        +ChordMarker.Note(fret = FretNumber(2), string = StringNumber(3), finger = Finger.RING)
        +ChordMarker.Bar(fret = FretNumber(1), startString = StringNumber(1), endString = StringNumber(2), finger = Finger.INDEX)
    }

    widget.chord = chord

    widget.render()
}