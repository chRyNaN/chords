package com.chrynan.sample.ui.adapter.core

import com.chrynan.sample.model.AdapterItemViewModel

interface DiffResult<VM : AdapterItemViewModel> {

    val items: List<VM>
}