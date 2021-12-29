//[chords-core](../../../index.md)/[com.chrynan.chords.view](../index.md)/[ChordViewBinder](index.md)

# ChordViewBinder

[common]\
@[ExperimentalUnsignedTypes](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-unsigned-types/index.html)

class [ChordViewBinder](index.md)(view: [ChordView](../-chord-view/index.md))

A class that can bind a [ChordViewData](../../com.chrynan.chords.model/-chord-view-data/index.md) to a [ChordView](../-chord-view/index.md) by calling the appropriate functions with their related values.

#### Author

chRyNaN

## Constructors

| | |
|---|---|
| [ChordViewBinder](-chord-view-binder.md) | [common]<br>fun [ChordViewBinder](-chord-view-binder.md)(view: [ChordView](../-chord-view/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [bind](bind.md) | [common]<br>fun [bind](bind.md)(viewModel: [ChordViewData](../../com.chrynan.chords.model/-chord-view-data/index.md))<br>Binds the [ChordViewData](../../com.chrynan.chords.model/-chord-view-data/index.md) to the associated [ChordView](../-chord-view/index.md) to this [ChordViewBinder](index.md) by calling the appropriate [ChordView](../-chord-view/index.md) functions with the values from the [ChordViewData](../../com.chrynan.chords.model/-chord-view-data/index.md). After this function is called, the [ChordView](../-chord-view/index.md) should reflect the values from the [ChordViewData](../../com.chrynan.chords.model/-chord-view-data/index.md). Note that there are some properties and functions that the [ChordView](../-chord-view/index.md) may have that are not present on the [ChordViewData](../../com.chrynan.chords.model/-chord-view-data/index.md). Only values present on the [ChordViewData](../../com.chrynan.chords.model/-chord-view-data/index.md) will be applied to the [ChordView](../-chord-view/index.md). |

## Properties

| Name | Summary |
|---|---|
| [view](view.md) | [common]<br>val [view](view.md): [ChordView](../-chord-view/index.md)<br>The [ChordView](../-chord-view/index.md) that will be updated with the values from the [ChordViewData](../../com.chrynan.chords.model/-chord-view-data/index.md) in the [bind](bind.md) function. |

## Extensions

| Name | Summary |
|---|---|
| [bindAndRender](../../com.chrynan.chords.util/bind-and-render.md) | [js]<br>@[ExperimentalUnsignedTypes](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-unsigned-types/index.html)<br>fun [ChordViewBinder](index.md#1598985797%2FExtensions%2F-844443233).[bindAndRender](../../com.chrynan.chords.util/bind-and-render.md)(viewModel: [ChordViewData](../../../../chords-core/chords-core/com.chrynan.chords.model/-chord-view-data/index.md))<br>This [ChordViewBinder.bind](../../../../chords-core/chords-core/com.chrynan.chords.view/-chord-view-binder/bind.md)s the provided [viewModel](../../com.chrynan.chords.util/bind-and-render.md) to the [ChordViewBinder.view](../../../../chords-core/chords-core/com.chrynan.chords.view/-chord-view-binder/view.md) and calls [ChordWidget.render](../../../../chords-core/com.chrynan.chords.widget/-chord-widget/render.md) if the underlying [ChordViewBinder.view](../../../../chords-core/chords-core/com.chrynan.chords.view/-chord-view-binder/view.md) is an instance of [ChordWidget](../../com.chrynan.chords.widget/[js]-chord-widget/index.md). |
