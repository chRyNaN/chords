//[chords-core](../../../index.md)/[com.chrynan.chords.view](../index.md)/[ChordViewBinder](index.md)



# ChordViewBinder  
 [common] @[ExperimentalUnsignedTypes](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-unsigned-types/index.html)()  
  
class [ChordViewBinder](index.md)(**view**: [ChordView](../-chord-view/index.md))

A class that can bind a [ChordViewModel](../../com.chrynan.chords.model/-chord-view-model/index.md) to a [ChordView](../-chord-view/index.md) by calling the appropriate functions with their related values.



#### Author  


chRyNaN

   


## Constructors  
  
| | |
|---|---|
| <a name="com.chrynan.chords.view/ChordViewBinder/ChordViewBinder/#com.chrynan.chords.view.ChordView/PointingToDeclaration/"></a>[ChordViewBinder](-chord-view-binder.md)| <a name="com.chrynan.chords.view/ChordViewBinder/ChordViewBinder/#com.chrynan.chords.view.ChordView/PointingToDeclaration/"></a> [common] fun [ChordViewBinder](-chord-view-binder.md)(view: [ChordView](../-chord-view/index.md))   <br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.view/ChordViewBinder/bind/#com.chrynan.chords.model.ChordViewModel/PointingToDeclaration/"></a>[bind](bind.md)| <a name="com.chrynan.chords.view/ChordViewBinder/bind/#com.chrynan.chords.model.ChordViewModel/PointingToDeclaration/"></a>[common]  <br>Content  <br>fun [bind](bind.md)(viewModel: [ChordViewModel](../../com.chrynan.chords.model/-chord-view-model/index.md))  <br>More info  <br>Binds the [ChordViewModel](../../com.chrynan.chords.model/-chord-view-model/index.md) to the associated [ChordView](../-chord-view/index.md) to this [ChordViewBinder](index.md) by calling the appropriate [ChordView](../-chord-view/index.md) functions with the values from the [ChordViewModel](../../com.chrynan.chords.model/-chord-view-model/index.md).  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.view/ChordViewBinder/view/#/PointingToDeclaration/"></a>[view](view.md)| <a name="com.chrynan.chords.view/ChordViewBinder/view/#/PointingToDeclaration/"></a> [common] val [view](view.md): [ChordView](../-chord-view/index.md)The [ChordView](../-chord-view/index.md) that will be updated with the values from the [ChordViewModel](../../com.chrynan.chords.model/-chord-view-model/index.md) in the [bind](bind.md) function.   <br>|


## Extensions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.util//bindAndRender/com.chrynan.chords.view.ChordViewBinder#com.chrynan.chords.model.ChordViewModel/PointingToDeclaration/"></a>[bindAndRender](../../com.chrynan.chords.util/bind-and-render.md)| <a name="com.chrynan.chords.util//bindAndRender/com.chrynan.chords.view.ChordViewBinder#com.chrynan.chords.model.ChordViewModel/PointingToDeclaration/"></a>[js]  <br>Content  <br>@[ExperimentalUnsignedTypes](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-unsigned-types/index.html)()  <br>  <br>fun [ChordViewBinder](index.md#%5Bcom.chrynan.chords.view%2FChordViewBinder%2F%2F%2FPointingToDeclaration%2F%5D%2FExtensions%2F-2072960283).[bindAndRender](../../com.chrynan.chords.util/bind-and-render.md)(viewModel: [ChordViewModel](../../com.chrynan.chords.model/-chord-view-model/index.md))  <br>More info  <br>This [ChordViewBinder.bind](bind.md)s the provided [viewModel](../../com.chrynan.chords.util/bind-and-render.md) to the [ChordViewBinder.view](view.md) and calls [ChordWidget.render](../../../../chords-android/com.chrynan.chords.widget/-chord-widget/render.md) if the underlying [ChordViewBinder.view](view.md) is an instance of [ChordWidget](../../com.chrynan.chords.widget/-chord-widget/index.md).  <br><br><br>|

