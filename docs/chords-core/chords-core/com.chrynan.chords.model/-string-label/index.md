//[chords-core](../../../index.md)/[com.chrynan.chords.model](../index.md)/[StringLabel](index.md)



# StringLabel  
 [common] data class [StringLabel](index.md)(**string**: [StringNumber](../-string-number/index.md), **label**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)

A model containing information about a label for a string in a chord diagram. This model contains the [string](string.md) the label should be displayed for and an optional [label](label.md) for that string. Chord diagrams may choose to either display this label, if it is not null, display the [string](string.md) number, or display no label indicator. Refer to [StringLabelState](../-string-label-state/index.md).



#### Author  


chRyNaN

   


## Constructors  
  
| | |
|---|---|
| <a name="com.chrynan.chords.model/StringLabel/StringLabel/#com.chrynan.chords.model.StringNumber#kotlin.String?/PointingToDeclaration/"></a>[StringLabel](-string-label.md)| <a name="com.chrynan.chords.model/StringLabel/StringLabel/#com.chrynan.chords.model.StringNumber#kotlin.String?/PointingToDeclaration/"></a> [common] fun [StringLabel](-string-label.md)(string: [StringNumber](../-string-number/index.md), label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null)   <br>|


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.model/StringLabel.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.chords.model/StringLabel.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.model/StringLabel/label/#/PointingToDeclaration/"></a>[label](label.md)| <a name="com.chrynan.chords.model/StringLabel/label/#/PointingToDeclaration/"></a> [common] val [label](label.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = nullThe optional label that should be displayed for this string.   <br>|
| <a name="com.chrynan.chords.model/StringLabel/string/#/PointingToDeclaration/"></a>[string](string.md)| <a name="com.chrynan.chords.model/StringLabel/string/#/PointingToDeclaration/"></a> [common] val [string](string.md): [StringNumber](../-string-number/index.md)The [StringNumber](../-string-number/index.md) that this label should be displayed for.   <br>|

