package com.chrynan.sample.ui.adapter

import androidx.recyclerview.widget.ListUpdateCallback

interface ItemListUpdater<T : Any> : ListUpdateCallback {

    var items: List<T>
}
