package com.chrynan.sample

import com.chrynan.chords.widget.ChordWidget
import org.w3c.dom.HTMLCanvasElement
import kotlin.browser.document

fun main() {
    val canvas = document.getElementById("canvas") as HTMLCanvasElement

    val widget = ChordWidget(canvas)

    widget.render()
}