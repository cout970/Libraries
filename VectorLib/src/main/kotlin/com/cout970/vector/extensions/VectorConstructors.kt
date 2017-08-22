@file:Suppress("unused", "NOTHING_TO_INLINE")
@file:JvmName("Vec")

package com.cout970.vector.extensions

import com.cout970.vector.api.*

/**
 * Created by cout970 on 17/08/2016.
 */

//@formatter:off
// IVector2
inline fun vec2Of(x: Number, y: Number): IVector2 = IVectorFactory.factory.vec2Of(x.toDouble(), y.toDouble())
inline fun mutableVec2Of(x: Number, y: Number): IMutableVector2 = IVectorFactory.factory.mutableVec2Of(x.toDouble(), y.toDouble())

inline fun vec2Of(n: Number): IVector2 = IVectorFactory.factory.vec2Of(n.toDouble(), n.toDouble())
inline fun mutableVec2Of(n: Number = 0.0): IMutableVector2 = IVectorFactory.factory.mutableVec2Of(n.toDouble(), n.toDouble())

// IVector3
inline fun vec3Of(x: Number, y: Number, z: Number): IVector3 = IVectorFactory.factory.vec3Of(x.toDouble(), y.toDouble(), z.toDouble())
inline fun mutableVec3Of(x: Number, y: Number, z: Number): IMutableVector3 = IVectorFactory.factory.mutableVec3Of(x.toDouble(), y.toDouble(), z.toDouble())

inline fun vec3Of(n: Number): IVector3 = IVectorFactory.factory.vec3Of(n.toDouble(), n.toDouble(), n.toDouble())
inline fun mutableVec3Of(n: Number = 0.0): IMutableVector3 = IVectorFactory.factory.mutableVec3Of(n.toDouble(), n.toDouble(), n.toDouble())

// IVector4
inline fun vec4Of(x: Number, y: Number, z: Number, w: Number): IVector4 = IVectorFactory.factory.vec4Of(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())
inline fun mutableVec4Of(x: Number, y: Number, z: Number, w: Number): IMutableVector4 = IVectorFactory.factory.mutableVec4Of(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())

inline fun vec4Of(n: Number): IVector4 = IVectorFactory.factory.vec4Of(n.toDouble(), n.toDouble(), n.toDouble(), n.toDouble())
inline fun mutableVec4Of(n: Number = 0.0): IMutableVector4 = IVectorFactory.factory.mutableVec4Of(n.toDouble(), n.toDouble(), n.toDouble(), n.toDouble())

//IQuaternion
inline fun quatOf(x: Number, y: Number, z: Number, w: Number): IQuaternion = IVectorFactory.factory.quatOf(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())
inline fun mutableQuatOf(x: Number, y: Number, z: Number, w: Number): IMutableQuaternion = IVectorFactory.factory.mutableQuatOf(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())
//@formatter:on

/**
 * Angle in degrees
 */
inline fun quatOfAxisAngled(angle: Number, x: Number, y: Number, z: Number): IQuaternion =
        quatOfAxisAngled(angle.toDouble(), x.toDouble(), y.toDouble(), z.toDouble())

fun quatOfAxisAngled(angle: Double, x: Double, y: Double, z: Double): IQuaternion {
    val rad = Math.toRadians(angle) * 0.5
    val length = Math.sqrt(x * x + y * y + z * z)
    val norm = 1.0 / (if (length == 0.0) 1.0 else length)
    val sin = Math.sin(rad)
    val cos = Math.cos(rad)

    return quatOf(
            x = x * norm * sin,
            y = y * norm * sin,
            z = z * norm * sin,
            w = cos
    )
}

/**
 * Angle in degrees
 */
inline fun mutableQuatOfAxisAngled(angle: Number, x: Number, y: Number, z: Number): IMutableQuaternion =
        mutableQuatOfAxisAngled(angle.toDouble(), x.toDouble(), y.toDouble(), z.toDouble())

fun mutableQuatOfAxisAngled(angle: Double, x: Double, y: Double, z: Double): IMutableQuaternion {
    val rad = Math.toRadians(angle) * 0.5
    val length = Math.sqrt(x * x + y * y + z * z)
    val norm = 1.0 / (if (length == 0.0) 1.0 else length)
    val sin = Math.sin(rad)
    val cos = Math.cos(rad)

    return mutableQuatOf(
            x = x * norm * sin,
            y = y * norm * sin,
            z = z * norm * sin,
            w = cos
    )
}
