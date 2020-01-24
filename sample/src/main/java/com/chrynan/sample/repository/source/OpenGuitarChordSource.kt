package com.chrynan.sample.repository.source

import com.chrynan.sample.model.AdapterItemViewModel
import com.chrynan.sample.model.ChordListViewModel
import com.chrynan.sample.model.ChordViewModel
import com.chrynan.sample.repository.ChordRepository
import com.chrynan.sample.repository.values.openStandardGuitarChords
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OpenGuitarChordSource @Inject constructor() : ChordRepository {

    override fun getAll(): Flow<List<AdapterItemViewModel>> = flow {
        val openChords = ChordListViewModel(
                title = "Open Standard Guitar Chords",
                items = openStandardGuitarChords.map {
                    ChordViewModel(title = it.name ?: "", chord = it)
                })
        val items = mutableListOf<AdapterItemViewModel>()

        items.add(openChords)

        emit(items)
    }
}