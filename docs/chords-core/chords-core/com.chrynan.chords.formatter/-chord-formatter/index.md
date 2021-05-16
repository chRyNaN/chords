//[chords-core](../../../index.md)/[com.chrynan.chords.formatter](../index.md)/[ChordFormatter](index.md)



# ChordFormatter  
 [common] interface [ChordFormatter](index.md)<[T](index.md)> : [Formatter](../-formatter/index.md)<[Chord](../../com.chrynan.chords.model/-chord/index.md), [T](index.md)> 

An interface that formats a [Chord](../../com.chrynan.chords.model/-chord/index.md) into an output of type [T](index.md).

   


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.formatter/Formatter/format/#com.chrynan.chords.model.Chord/PointingToDeclaration/"></a>[format](index.md#%5Bcom.chrynan.chords.formatter%2FFormatter%2Fformat%2F%23com.chrynan.chords.model.Chord%2FPointingToDeclaration%2F%5D%2FFunctions%2F2144227643)| <a name="com.chrynan.chords.formatter/Formatter/format/#com.chrynan.chords.model.Chord/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract suspend fun [format](index.md#%5Bcom.chrynan.chords.formatter%2FFormatter%2Fformat%2F%23com.chrynan.chords.model.Chord%2FPointingToDeclaration%2F%5D%2FFunctions%2F2144227643)(input: [Chord](../../com.chrynan.chords.model/-chord/index.md)): [T](index.md)  <br>More info  <br>Formats the provided input type of [IN](../-formatter/index.md) and returns the output type of [OUT](../-formatter/index.md).  <br><br><br>|
| <a name="com.chrynan.chords.formatter/Formatter/formatOrNull/#com.chrynan.chords.model.Chord/PointingToDeclaration/"></a>[formatOrNull](../-json-string-chord-formatter/index.md#%5Bcom.chrynan.chords.formatter%2FFormatter%2FformatOrNull%2F%23com.chrynan.chords.model.Chord%2FPointingToDeclaration%2F%5D%2FFunctions%2F2144227643)| <a name="com.chrynan.chords.formatter/Formatter/formatOrNull/#com.chrynan.chords.model.Chord/PointingToDeclaration/"></a>[common]  <br>Content  <br>open suspend fun [formatOrNull](../-json-string-chord-formatter/index.md#%5Bcom.chrynan.chords.formatter%2FFormatter%2FformatOrNull%2F%23com.chrynan.chords.model.Chord%2FPointingToDeclaration%2F%5D%2FFunctions%2F2144227643)(input: [Chord](../../com.chrynan.chords.model/-chord/index.md)): [T](index.md)?  <br>More info  <br>Formats the provided input of type [IN](../-formatter/index.md) and returns the output of type [OUT](../-formatter/index.md).  <br><br><br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.chrynan.chords.formatter/JsonStringChordFormatter///PointingToDeclaration/"></a>[JsonStringChordFormatter](../-json-string-chord-formatter/index.md)|

