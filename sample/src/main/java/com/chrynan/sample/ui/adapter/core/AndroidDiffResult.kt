package com.chrynan.sample.ui.adapter.core

import androidx.recyclerview.widget.DiffUtil
import com.chrynan.sample.model.AdapterItemViewModel

data class AndroidDiffResult<VM : AdapterItemViewModel>(
        override val items: List<VM>,
        val diffUtilResult: DiffUtil.DiffResult
) : DiffResult<VM>