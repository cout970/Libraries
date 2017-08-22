@file:Suppress("NOTHING_TO_INLINE")

package com.cout970.matrix.extensions

import com.cout970.matrix.api.*

/**
 * Created by cout970 on 25/08/2016.
 */

// IMatrix2
inline fun mat2Of(
        m00: Number, m01: Number,
        m10: Number, m11: Number
): IMatrix2 = IMatrixFactory.factory.mat2Of(m00.toDouble(), m01.toDouble(), m10.toDouble(), m11.toDouble())

inline fun mat2Of(i: Number = 1): IMatrix2 = mat2Of(
        i, 0,
        0, i)

inline fun mutableMat2Of(
        m00: Number, m01: Number,
        m10: Number, m11: Number
): IMutableMatrix2 = IMatrixFactory.factory.mutableMat2Of(m00.toDouble(), m01.toDouble(), m10.toDouble(), m11.toDouble())

inline fun mutableMat2Of(i: Number = 1): IMutableMatrix2 = mutableMat2Of(
        i, 0,
        0, i)

// IMatrix3
inline fun mat3Of(
        m00: Number, m01: Number, m02: Number,
        m10: Number, m11: Number, m12: Number,
        m20: Number, m21: Number, m22: Number
): IMatrix3 = IMatrixFactory.factory.mat3Of(m00.toDouble(), m01.toDouble(), m02.toDouble(), m10.toDouble(), m11.toDouble(), m12.toDouble(), m20.toDouble(), m21.toDouble(), m22.toDouble())

inline fun mat3Of(i: Number = 1): IMatrix3 = mat3Of(
        i, 0, 0,
        0, i, 0,
        0, 0, i)

inline fun mutableMat3Of(
        m00: Number, m01: Number, m02: Number,
        m10: Number, m11: Number, m12: Number,
        m20: Number, m21: Number, m22: Number
): IMutableMatrix3 = IMatrixFactory.factory.mutableMat3Of(m00.toDouble(), m01.toDouble(), m02.toDouble(), m10.toDouble(), m11.toDouble(), m12.toDouble(), m20.toDouble(), m21.toDouble(), m22.toDouble())

inline fun mutableMat3Of(i: Number = 1): IMutableMatrix3 = mutableMat3Of(
        i, 0, 0,
        0, i, 0,
        0, 0, i)

// IMatrix4
inline fun mat4Of(
        m00: Number, m01: Number, m02: Number, m03: Number,
        m10: Number, m11: Number, m12: Number, m13: Number,
        m20: Number, m21: Number, m22: Number, m23: Number,
        m30: Number, m31: Number, m32: Number, m33: Number
): IMatrix4 = IMatrixFactory.factory.mat4Of(m00.toDouble(), m01.toDouble(), m02.toDouble(), m03.toDouble(), m10.toDouble(), m11.toDouble(), m12.toDouble(), m13.toDouble(), m20.toDouble(), m21.toDouble(), m22.toDouble(), m23.toDouble(), m30.toDouble(), m31.toDouble(), m32.toDouble(), m33.toDouble())

inline fun mat4Of(i: Number = 1): IMatrix4 = mat4Of(
        i, 0, 0, 0,
        0, i, 0, 0,
        0, 0, i, 0,
        0, 0, 0, i)

inline fun mutableMat4Of(
        m00: Number, m01: Number, m02: Number, m03: Number,
        m10: Number, m11: Number, m12: Number, m13: Number,
        m20: Number, m21: Number, m22: Number, m23: Number,
        m30: Number, m31: Number, m32: Number, m33: Number
): IMutableMatrix4 = IMatrixFactory.factory.mutableMat4Of(m00.toDouble(), m01.toDouble(), m02.toDouble(), m03.toDouble(), m10.toDouble(), m11.toDouble(), m12.toDouble(), m13.toDouble(), m20.toDouble(), m21.toDouble(), m22.toDouble(), m23.toDouble(), m30.toDouble(), m31.toDouble(), m32.toDouble(), m33.toDouble())

inline fun mutableMat4Of(i: Number = 1): IMutableMatrix4 = mutableMat4Of(
        i, 0, 0, 0,
        0, i, 0, 0,
        0, 0, i, 0,
        0, 0, 0, i)