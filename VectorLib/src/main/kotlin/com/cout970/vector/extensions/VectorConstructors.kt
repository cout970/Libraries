@file:Suppress("unused", "NOTHING_TO_INLINE")
@file:JvmName("Vec")

package com.cout970.vector.extensions

import com.cout970.vector.api.*
import com.cout970.vector.impl.*

/**
 * Created by cout970 on 17/08/2016.
 */

inline fun vec2Of(x: Number, y: Number): IVector2 =
        Vector2d(x.toDouble(), y.toDouble())

inline fun vec2Of(x: Number): IVector2 =
        Vector2d(x.toDouble(), x.toDouble())

inline fun mutableVec2Of(x: Number, y: Number): IMutableVector2 =
        MutableVector2d(x.toDouble(), y.toDouble())

inline fun mutableVec2Of(): IMutableVector2 =
        MutableVector2d(0.0, 0.0)


inline fun vec3Of(x: Number, y: Number, z: Number): IVector3 =
        Vector3d(x.toDouble(), y.toDouble(), z.toDouble())

inline fun vec3Of(x: Number): IVector3 =
        Vector3d(x.toDouble(), x.toDouble(), x.toDouble())

inline fun mutableVec3Of(x: Number, y: Number, z: Number): IMutableVector3 =
        MutableVector3d(x.toDouble(), y.toDouble(), z.toDouble())

inline fun mutableVec3Of(): IMutableVector3 =
        MutableVector3d(0.0, 0.0, 0.0)


inline fun vec4Of(x: Number, y: Number, z: Number, w: Number): IVector4 =
        Vector4d(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())

inline fun vec4Of(x: Number): IVector4 =
        Vector4d(x.toDouble(), x.toDouble(), x.toDouble(), x.toDouble())

inline fun mutableVec4Of(x: Number, y: Number, z: Number, w: Number): IMutableVector4 =
        MutableVector4d(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())

inline fun mutableVec4Of(): IMutableVector4 =
        MutableVector4d(0.0, 0.0, 0.0, 0.0)


inline fun quatOf(x: Number, y: Number, z: Number, w: Number): IQuaternion =
        Quaterniond(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())

inline fun mutableQuatOf(x: Number, y: Number, z: Number, w: Number): IMutableQuaternion =
        MutableQuaterniond(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())

inline fun quatOfAxisAngledDeg(angle: Number, x: Number, y: Number, z: Number): IQuaternion =
    quatOfAxisAngled(Math.toRadians(angle.toDouble()), x.toDouble(), y.toDouble(), z.toDouble())

inline fun quatOfAxisAngled(angle: Number, x: Number, y: Number, z: Number): IQuaternion =
    quatOfAxisAngled(angle.toDouble(), x.toDouble(), y.toDouble(), z.toDouble())

fun quatOfAxisAngled(angle: Double, x: Double, y: Double, z: Double): IQuaternion {
    val rad = angle * 0.5
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
