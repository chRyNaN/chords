//[chords-core](../../../index.md)/[com.chrynan.chords.model](../index.md)/[ChordViewModel](index.md)



# ChordViewModel  
 [common] @[ExperimentalUnsignedTypes](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-unsigned-types/index.html)()  
  
data class [ChordViewModel](index.md)(**fitToHeight**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **showFretNumbers**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **showFingerNumbers**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **stringLabelState**: [StringLabelState](../-string-label-state/index.md), **mutedStringText**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **openStringText**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **fretColor**: Color, **fretLabelTextColor**: Color, **stringColor**: Color, **stringLabelTextColor**: Color, **noteColor**: Color, **noteLabelTextColor**: Color)

A model that represents the visual state of a UI Widget that displays a [ChordChart](../-chord-chart/index.md) for a [Chord](../-chord/index.md). Note that this class does not contain any information about a [ChordChart](../-chord-chart/index.md) or a [Chord](../-chord/index.md) and only contains visual information relating to the UI Widget. This class can be used to explicitly update a [ChordView](../../com.chrynan.chords.view/-chord-view/index.md), or a [ChordViewBinder](../../com.chrynan.chords.view/-chord-view-binder/index.md) can be used to implicitly update the [ChordView](../../com.chrynan.chords.view/-chord-view/index.md).



#### Author  


chRyNaN

   


## Constructors  
  
| | |
|---|---|
| <a name="com.chrynan.chords.model/ChordViewModel/ChordViewModel/#kotlin.Boolean#kotlin.Boolean#kotlin.Boolean#com.chrynan.chords.model.StringLabelState#kotlin.String#kotlin.String#com.chrynan.colors.Color#com.chrynan.colors.Color#com.chrynan.colors.Color#com.chrynan.colors.Color#com.chrynan.colors.Color#com.chrynan.colors.Color/PointingToDeclaration/"></a>[ChordViewModel](-chord-view-model.md)| <a name="com.chrynan.chords.model/ChordViewModel/ChordViewModel/#kotlin.Boolean#kotlin.Boolean#kotlin.Boolean#com.chrynan.chords.model.StringLabelState#kotlin.String#kotlin.String#com.chrynan.colors.Color#com.chrynan.colors.Color#com.chrynan.colors.Color#com.chrynan.colors.Color#com.chrynan.colors.Color#com.chrynan.colors.Color/PointingToDeclaration/"></a> [common] fun [ChordViewModel](-chord-view-model.md)(fitToHeight: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = ChordView.DEFAULT_FIT_TO_HEIGHT, showFretNumbers: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = ChordView.DEFAULT_SHOW_FRET_NUMBERS, showFingerNumbers: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = ChordView.DEFAULT_SHOW_FINGER_NUMBERS, stringLabelState: [StringLabelState](../-string-label-state/index.md) = ChordView.DEFAULT_STRING_LABEL_STATE, mutedStringText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = ChordView.DEFAULT_MUTED_TEXT, openStringText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = ChordView.DEFAULT_OPEN_TEXT, fretColor: Color = Color.BLACK, fretLabelTextColor: Color = Color.BLACK, stringColor: Color = Color.BLACK, stringLabelTextColor: Color = Color.BLACK, noteColor: Color = Color.BLACK, noteLabelTextColor: Color = Color.WHITE)   <br>|


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.model/ChordViewModel.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.chords.model/ChordViewModel.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.model/ChordViewModel/fitToHeight/#/PointingToDeclaration/"></a>[fitToHeight](fit-to-height.md)| <a name="com.chrynan.chords.model/ChordViewModel/fitToHeight/#/PointingToDeclaration/"></a> [common] val [fitToHeight](fit-to-height.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)Whether the [ChordView](../../com.chrynan.chords.view/-chord-view/index.md) should scale the visual Chord Chart relative to it's height.   <br>|
| <a name="com.chrynan.chords.model/ChordViewModel/fretColor/#/PointingToDeclaration/"></a>[fretColor](fret-color.md)| <a name="com.chrynan.chords.model/ChordViewModel/fretColor/#/PointingToDeclaration/"></a> [common] val [fretColor](fret-color.md): ColorThe ColorInt value that will be used for the fret lines.   <br>|
| <a name="com.chrynan.chords.model/ChordViewModel/fretLabelTextColor/#/PointingToDeclaration/"></a>[fretLabelTextColor](fret-label-text-color.md)| <a name="com.chrynan.chords.model/ChordViewModel/fretLabelTextColor/#/PointingToDeclaration/"></a> [common] val [fretLabelTextColor](fret-label-text-color.md): ColorThe ColorInt value that will be used for the fret labels.   <br>|
| <a name="com.chrynan.chords.model/ChordViewModel/mutedStringText/#/PointingToDeclaration/"></a>[mutedStringText](muted-string-text.md)| <a name="com.chrynan.chords.model/ChordViewModel/mutedStringText/#/PointingToDeclaration/"></a> [common] val [mutedStringText](muted-string-text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)A [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value used to indicate that an instrument String should be muted.   <br>|
| <a name="com.chrynan.chords.model/ChordViewModel/noteColor/#/PointingToDeclaration/"></a>[noteColor](note-color.md)| <a name="com.chrynan.chords.model/ChordViewModel/noteColor/#/PointingToDeclaration/"></a> [common] val [noteColor](note-color.md): ColorThe ColorInt value that will be used for the notes and bars.   <br>|
| <a name="com.chrynan.chords.model/ChordViewModel/noteLabelTextColor/#/PointingToDeclaration/"></a>[noteLabelTextColor](note-label-text-color.md)| <a name="com.chrynan.chords.model/ChordViewModel/noteLabelTextColor/#/PointingToDeclaration/"></a> [common] val [noteLabelTextColor](note-label-text-color.md): ColorThe ColorInt value that will be used for the note and bar labels.   <br>|
| <a name="com.chrynan.chords.model/ChordViewModel/openStringText/#/PointingToDeclaration/"></a>[openStringText](open-string-text.md)| <a name="com.chrynan.chords.model/ChordViewModel/openStringText/#/PointingToDeclaration/"></a> [common] val [openStringText](open-string-text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)A [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value used to indicate that an instrument String should be open.   <br>|
| <a name="com.chrynan.chords.model/ChordViewModel/showFingerNumbers/#/PointingToDeclaration/"></a>[showFingerNumbers](show-finger-numbers.md)| <a name="com.chrynan.chords.model/ChordViewModel/showFingerNumbers/#/PointingToDeclaration/"></a> [common] val [showFingerNumbers](show-finger-numbers.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)Whether the [ChordView](../../com.chrynan.chords.view/-chord-view/index.md) should display the finger numbers on the notes and bars of the chart.   <br>|
| <a name="com.chrynan.chords.model/ChordViewModel/showFretNumbers/#/PointingToDeclaration/"></a>[showFretNumbers](show-fret-numbers.md)| <a name="com.chrynan.chords.model/ChordViewModel/showFretNumbers/#/PointingToDeclaration/"></a> [common] val [showFretNumbers](show-fret-numbers.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)Whether the [ChordView](../../com.chrynan.chords.view/-chord-view/index.md) should display the fret numbers to the side of the chart.   <br>|
| <a name="com.chrynan.chords.model/ChordViewModel/stringColor/#/PointingToDeclaration/"></a>[stringColor](string-color.md)| <a name="com.chrynan.chords.model/ChordViewModel/stringColor/#/PointingToDeclaration/"></a> [common] val [stringColor](string-color.md): ColorThe ColorInt value that will be used for the instrument String lines.   <br>|
| <a name="com.chrynan.chords.model/ChordViewModel/stringLabelState/#/PointingToDeclaration/"></a>[stringLabelState](string-label-state.md)| <a name="com.chrynan.chords.model/ChordViewModel/stringLabelState/#/PointingToDeclaration/"></a> [common] val [stringLabelState](string-label-state.md): [StringLabelState](../-string-label-state/index.md)A [StringLabelState](../-string-label-state/index.md) enum indicating whether the String number or label should be displayed, or if there should be no String label shown.   <br>|
| <a name="com.chrynan.chords.model/ChordViewModel/stringLabelTextColor/#/PointingToDeclaration/"></a>[stringLabelTextColor](string-label-text-color.md)| <a name="com.chrynan.chords.model/ChordViewModel/stringLabelTextColor/#/PointingToDeclaration/"></a> [common] val [stringLabelTextColor](string-label-text-color.md): ColorThe ColorInt value that will be used for the String labels.   <br>|

