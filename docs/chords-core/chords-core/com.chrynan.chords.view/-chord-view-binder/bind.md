//[chords-core](../../../index.md)/[com.chrynan.chords.view](../index.md)/[ChordViewBinder](index.md)/[bind](bind.md)

# bind

[common]\
fun [bind](bind.md)(viewModel: [ChordViewData](../../com.chrynan.chords.model/-chord-view-data/index.md))

Binds the [ChordViewData](../../com.chrynan.chords.model/-chord-view-data/index.md) to the associated [ChordView](../-chord-view/index.md) to this [ChordViewBinder](index.md) by calling the appropriate [ChordView](../-chord-view/index.md) functions with the values from the [ChordViewData](../../com.chrynan.chords.model/-chord-view-data/index.md). After this function is called, the [ChordView](../-chord-view/index.md) should reflect the values from the [ChordViewData](../../com.chrynan.chords.model/-chord-view-data/index.md). Note that there are some properties and functions that the [ChordView](../-chord-view/index.md) may have that are not present on the [ChordViewData](../../com.chrynan.chords.model/-chord-view-data/index.md). Only values present on the [ChordViewData](../../com.chrynan.chords.model/-chord-view-data/index.md) will be applied to the [ChordView](../-chord-view/index.md).

#### Author

chRyNaN
