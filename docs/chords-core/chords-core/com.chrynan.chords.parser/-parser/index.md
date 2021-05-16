//[chords-core](../../../index.md)/[com.chrynan.chords.parser](../index.md)/[Parser](index.md)



# Parser  
 [common] interface [Parser](index.md)<[IN](index.md), [OUT](index.md)>

A generic interface to parse an input into an output.



#### Author  


chRyNaN

   


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.parser/Parser/parse/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[parse](parse.md)| <a name="com.chrynan.chords.parser/Parser/parse/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract suspend fun [parse](parse.md)(input: [IN](index.md)): [OUT](index.md)  <br>More info  <br>Parses the provided input [IN](index.md) and returns the output [OUT](index.md).  <br><br><br>|
| <a name="com.chrynan.chords.parser/Parser/parseOrNull/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[parseOrNull](parse-or-null.md)| <a name="com.chrynan.chords.parser/Parser/parseOrNull/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[common]  <br>Content  <br>open suspend fun [parseOrNull](parse-or-null.md)(input: [IN](index.md)): [OUT](index.md)?  <br>More info  <br>Parses the provided input [IN](index.md) and returns the output [OUT](index.md).  <br><br><br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.chrynan.chords.parser/ChordParser///PointingToDeclaration/"></a>[ChordParser](../-chord-parser/index.md)|

