//[chords-core](../../../index.md)/[com.chrynan.chords.formatter](../index.md)/[Formatter](index.md)



# Formatter  
 [common] interface [Formatter](index.md)<[IN](index.md), [OUT](index.md)>

A generic interface to format a type of [IN](index.md) to an output of type [OUT](index.md). This differs from the [Parser](../../com.chrynan.chords.parser/-parser/index.md) interface in that this [Formatter](index.md) interface is meant to format an object to an output type. Whereas, the [Parser](../../com.chrynan.chords.parser/-parser/index.md) interface is meant to parse an input type into a usable object type.



#### Author  


chRyNaN

   


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.formatter/Formatter/format/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[format](format.md)| <a name="com.chrynan.chords.formatter/Formatter/format/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract suspend fun [format](format.md)(input: [IN](index.md)): [OUT](index.md)  <br>More info  <br>Formats the provided input type of [IN](index.md) and returns the output type of [OUT](index.md).  <br><br><br>|
| <a name="com.chrynan.chords.formatter/Formatter/formatOrNull/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[formatOrNull](format-or-null.md)| <a name="com.chrynan.chords.formatter/Formatter/formatOrNull/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[common]  <br>Content  <br>open suspend fun [formatOrNull](format-or-null.md)(input: [IN](index.md)): [OUT](index.md)?  <br>More info  <br>Formats the provided input of type [IN](index.md) and returns the output of type [OUT](index.md).  <br><br><br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.chrynan.chords.formatter/ChordFormatter///PointingToDeclaration/"></a>[ChordFormatter](../-chord-formatter/index.md)|

