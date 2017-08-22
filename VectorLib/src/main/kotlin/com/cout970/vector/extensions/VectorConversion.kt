@file:Suppress("unused", "NOTHING_TO_INLINE")
@file:JvmName("Conv")


package com.cout970.vector.extensions

import com.cout970.vector.api.*

/**
 * Created by cout970 on 17/08/2016.
 */

fun Pair<Number, Number>.toIVector2(): IVector2 = vec2Of(first, second)
fun Triple<Number, Number, Number>.toIVector3(): IVector3 = vec3Of(first, second, third)

inline fun IVector2.toVector3(z: Number): IVector3 = vec3Of(x, y, z)
inline fun IVector2.toVector4(z: Number, w: Number): IVector4 = vec4Of(x, y, z, w)
inline fun IVector3.toVector4(w: Number): IVector4 = vec4Of(x, y, z, w)

inline fun IMutableVector2.toVector3(z: Number): IMutableVector3 = mutableVec3Of(x, y, z)
inline fun IMutableVector2.toVector4(z: Number, w: Number): IMutableVector4 = mutableVec4Of(x, y, z, w)
inline fun IMutableVector3.toVector4(w: Number): IMutableVector4 = mutableVec4Of(x, y, z, w)

fun IVector2.toMutable(): IMutableVector2 = mutableVec2Of(x, y)
fun IVector3.toMutable(): IMutableVector3 = mutableVec3Of(x, y, z)
fun IVector4.toMutable(): IMutableVector4 = mutableVec4Of(x, y, z, w)

fun IMutableVector2.copy(): IMutableVector2 = mutableVec2Of(x, y)
fun IMutableVector3.copy(): IMutableVector3 = mutableVec3Of(x, y, z)
fun IMutableVector4.copy(): IMutableVector4 = mutableVec4Of(x, y, z, w)

fun IVector2.asImmutable() = if(this is IMutableVector2) vec2Of(x, y) else this
fun IVector3.asImmutable() = if(this is IMutableVector3) vec3Of(x, y, z) else this
fun IVector4.asImmutable() = if(this is IMutableVector4) vec4Of(x, y, z, w) else this
fun IQuaternion.asImmutable() = if(this is IMutableQuaternion) quatOf(x, y, z, w) else this

fun IMutableVector2.asImmutable() = vec2Of(x, y)
fun IMutableVector3.asImmutable() = vec3Of(x, y, z)
fun IMutableVector4.asImmutable() = vec4Of(x, y, z, w)
fun IMutableQuaternion.asImmutable() = quatOf(x, y, z, w)
