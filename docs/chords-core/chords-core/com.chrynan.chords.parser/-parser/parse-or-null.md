//[chords-core](../../../index.md)/[com.chrynan.chords.parser](../index.md)/[Parser](index.md)/[parseOrNull](parse-or-null.md)



# parseOrNull  
[common]  
Content  
open suspend fun [parseOrNull](parse-or-null.md)(input: [IN](index.md)): [OUT](index.md)?  
More info  


Parses the provided input [IN](index.md) and returns the output [OUT](index.md). If an exception is encountered during the parsing process, then that exception will be caught and null will be returned. If you would rather handle the exception, then use the [parse](parse.md) function instead.



#### Author  


chRyNaN

  



