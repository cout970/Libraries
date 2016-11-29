package com.cout970.matrix.extensions

import com.cout970.matrix.api.*

/**
 * Created by cout970 on 25/08/2016.
 */

// IMatrix2
fun mat2Of(
        m00: Number, m01: Number,
        m10: Number, m11: Number
): IMatrix2 = IMatrixFactory.factory.mat2Of(m00, m01, m10, m11)

fun mat2Of(i: Number = 1): IMatrix2 = mat2Of(
        i, 0,
        0, i)

fun mutableMat2Of(
        m00: Number, m01: Number,
        m10: Number, m11: Number
): IMutableMatrix2 = IMatrixFactory.factory.mutableMat2Of(m00, m01, m10, m11)

fun mutableMat2Of(i: Number = 1): IMutableMatrix2 = mutableMat2Of(
        i, 0,
        0, i)

// IMatrix3
fun mat3Of(
        m00: Number, m01: Number, m02: Number,
        m10: Number, m11: Number, m12: Number,
        m20: Number, m21: Number, m22: Number
): IMatrix3 = IMatrixFactory.factory.mat3Of(m00, m01, m02, m10, m11, m12, m20, m21, m22)

fun mat3Of(i: Number = 1): IMatrix3 = mat3Of(
        i, 0, 0,
        0, i, 0,
        0, 0, i)

fun mutableMat3Of(
        m00: Number, m01: Number, m02: Number,
        m10: Number, m11: Number, m12: Number,
        m20: Number, m21: Number, m22: Number
): IMutableMatrix3 = IMatrixFactory.factory.mutableMat3Of(m00, m01, m02, m10, m11, m12, m20, m21, m22)

fun mutableMat3Of(i: Number = 1): IMutableMatrix3 = mutableMat3Of(
        i, 0, 0,
        0, i, 0,
        0, 0, i)

// IMatrix4
fun mat4Of(
        m00: Number, m01: Number, m02: Number, m03: Number,
        m10: Number, m11: Number, m12: Number, m13: Number,
        m20: Number, m21: Number, m22: Number, m23: Number,
        m30: Number, m31: Number, m32: Number, m33: Number
): IMatrix4 = IMatrixFactory.factory.mat4Of(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33)

fun mat4Of(i: Number = 1): IMatrix4 = mat4Of(
        i, 0, 0, 0,
        0, i, 0, 0,
        0, 0, i, 0,
        0, 0, 0, i)

fun mutableMat4Of(
        m00: Number, m01: Number, m02: Number, m03: Number,
        m10: Number, m11: Number, m12: Number, m13: Number,
        m20: Number, m21: Number, m22: Number, m23: Number,
        m30: Number, m31: Number, m32: Number, m33: Number
): IMutableMatrix4 = IMatrixFactory.factory.mutableMat4Of(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33)

fun mutableMat4Of(i: Number = 1): IMutableMatrix4 = mutableMat4Of(
        i, 0, 0, 0,
        0, i, 0, 0,
        0, 0, i, 0,
        0, 0, 0, i)