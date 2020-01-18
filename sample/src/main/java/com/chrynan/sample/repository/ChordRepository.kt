package com.chrynan.sample.repository

import com.chrynan.sample.model.AdapterItemViewModel
import kotlinx.coroutines.flow.Flow

interface ChordRepository {

    fun getAll(): Flow<List<AdapterItemViewModel>>
}