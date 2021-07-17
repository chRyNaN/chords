package com.chrynan.sample.ui.adapter

import androidx.recyclerview.widget.DiffUtil

data class AndroidDiffResult<VM : UniqueAdapterItem>(
    override val items: List<VM>,
    val diffUtilResult: DiffUtil.DiffResult
) : DiffResult<VM>
