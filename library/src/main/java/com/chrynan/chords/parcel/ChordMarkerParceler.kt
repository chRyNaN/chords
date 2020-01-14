package com.chrynan.chords.parcel

import android.os.Parcel
import com.chrynan.chords.model.*
import kotlinx.android.parcel.Parceler

object ChordMarkerParceler : Parceler<ChordMarker> {

    override fun create(parcel: Parcel): ChordMarker {
        val type = parcel.readString()?.let { MarkerType.fromTypeName(it) }
                ?: throw UnexpectedParcelValueException(null)

        return when (type) {
            MarkerType.NOTE -> createNote(parcel)
            MarkerType.BAR -> createBar(parcel)
            MarkerType.MUTED -> createMuted(parcel)
            MarkerType.OPEN -> createOpen(parcel)
        }
    }

    override fun ChordMarker.write(parcel: Parcel, flags: Int) {
        parcel.writeString(type.typeName)

        when (this) {
            is ChordMarker.Note -> writeNote(this, parcel)
            is ChordMarker.Bar -> writeBar(this, parcel)
            is ChordMarker.Open -> writeOpen(this, parcel)
            is ChordMarker.Muted -> writeMuted(this, parcel)
        }
    }

    private fun createNote(parcel: Parcel): ChordMarker.Note =
            ChordMarker.Note(
                    fret = FretNumber(parcel.readInt()),
                    finger = Finger.fromPosition(parcel.readInt()),
                    string = StringNumber(parcel.readInt()))

    private fun createBar(parcel: Parcel): ChordMarker.Bar =
            ChordMarker.Bar(
                    fret = FretNumber(parcel.readInt()),
                    finger = Finger.fromPosition(parcel.readInt()),
                    startString = StringNumber(parcel.readInt()),
                    endString = StringNumber(parcel.readInt()))

    private fun createOpen(parcel: Parcel): ChordMarker.Open =
            ChordMarker.Open(string = StringNumber(parcel.readInt()))

    private fun createMuted(parcel: Parcel): ChordMarker.Muted =
            ChordMarker.Muted(string = StringNumber(parcel.readInt()))

    private fun writeNote(note: ChordMarker.Note, parcel: Parcel) {
        parcel.writeInt(note.fret.number)
        parcel.writeInt(note.finger.position)
        parcel.writeInt(note.string.number)
    }

    private fun writeBar(bar: ChordMarker.Bar, parcel: Parcel) {
        parcel.writeInt(bar.fret.number)
        parcel.writeInt(bar.finger.position)
        parcel.writeInt(bar.startString.number)
        parcel.writeInt(bar.endString.number)
    }

    private fun writeOpen(open: ChordMarker.Open, parcel: Parcel) {
        parcel.writeInt(open.string.number)
    }

    private fun writeMuted(muted: ChordMarker.Muted, parcel: Parcel) {
        parcel.writeInt(muted.string.number)
    }
}