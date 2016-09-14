[![Kotlin](https://img.shields.io/badge/Kotlin-1.1.0-orange.svg)](https://kotlinlang.org/) 
[![GitHub license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://opensource.org/licenses/MIT)

# Vector Library
This is a 2D, 3D and 4D vector library for kotlin(also works in java)
## Motivations
The reason why I create this library was the annoying problem of dependencies using their own vector libraries different from the library used in the project. Having several vector libraries makes you have to convert vectors from one library to other all the time, and even worse the libraries often have only the important functions for their project, so you have to use other library for specific functions and then convert the result to the other version of the vector. 
##Design Choices
All the vector have an interface: This is usually useless in a normal vector library because there is only one implementation of every vector, but in this case, for example the Interface IVector2 has 3 implementations Vector2i, Vector2f and Vector2d, and you can make you own implementation for other data types for example, Byte, Long, BigDecimal, etc.
The idea behind this is to allow the user to implement this interfaces in subclases of vectors in other libraries and automatically the those classes will work on all your code, well that that's the basic use of an interface, but what is the deal here? This interfaces only have getters and setters, all the operations, utilities and constructors are in separated files using Kotlin extensions functions (see https://kotlinlang.org/docs/reference/extensions.html), this means that if you implement the interface and the getters and setters, automatically all the operations and utilities from the other classes are applied to it, so you don't need to implement them or delegate them to other implementation.
The only downside of this system is that this only works in Kotlin, in java all this functions are static, with the vector as the first parameter.

Written in Kotlin: This allow the user to use the operator overloading in Kotlin that make the syntax very clear
##Content
* Implementations of vectors for primitive types: Int, Float and Double
* Implementations of mutable and immutable vectors
* Vectors for 2D, 3D and 4D
* A lot of Utilities for vectors (if you have any suggestion feel free to create a issue)

##Dependencies
The only dependency of this library is the standard library of Kotlin 