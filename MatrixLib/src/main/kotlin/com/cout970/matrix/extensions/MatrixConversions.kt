package com.cout970.matrix.extensions

import com.cout970.matrix.api.*

/**
 * Created by cout970 on 25/08/2016.
 */

//@formatter:off
fun IMatrix2.toMatrix3(n: Number = 1) = mat3Of(
        m00, m01, 0,
        m10, m11, 0,
        0,   0,   n)

fun IMatrix2.toMatrix4(n: Number = 1) = mat4Of(
        m00, m01, 0, 0,
        m10, m11, 0, 0,
        0,   0,   n, 0,
        0,   0,   0, n)

fun IMatrix3.toMatrix4(n: Number = 1) = mat4Of(
        m00, m01, m02, 0,
        m10, m11, m12, 0,
        m20, m21, m22, 0,
        0,   0,   0,   n)

fun IMutableMatrix2.toMatrix3(n: Number = 1) = mutableMat3Of(
        m00, m01, 0,
        m10, m11, 0,
        0,   0,   n)

fun IMutableMatrix2.toMatrix4(n: Number = 1) = mutableMat4Of(
        m00, m01, 0, 0,
        m10, m11, 0, 0,
        0,   0,   n, 0,
        0,   0,   0, n)

fun IMutableMatrix3.toMatrix4(n: Number = 1) = mutableMat4Of(
        m00, m01, m02, 0,
        m10, m11, m12, 0,
        m20, m21, m22, 0,
        0,   0,   0,   n)

fun IMatrix2.toMutable() = mutableMat2Of(
        m00, m01,
        m10, m11)

fun IMatrix3.toMutable() = mutableMat3Of(
        m00, m01, m02,
        m10, m11, m12,
        m20, m21, m22)

fun IMatrix4.toMutable() = mutableMat4Of(
        m00, m01, m02, m03,
        m10, m11, m12, m13,
        m20, m21, m22, m23,
        m30, m31, m32, m33)

fun IMutableMatrix2.copy() = mutableMat2Of(
        m00, m01,
        m10, m11)

fun IMutableMatrix3.copy() = mutableMat3Of(
        m00, m01, m02,
        m10, m11, m12,
        m20, m21, m22)

fun IMutableMatrix4.copy() = mutableMat4Of(
        m00, m01, m02, m03,
        m10, m11, m12, m13,
        m20, m21, m22, m23,
        m30, m31, m32, m33)

fun IMatrix2.asImmutable() = if(this is IMutableMatrix2) mat2Of(m00, m01, m10, m11) else this
fun IMatrix3.asImmutable() = if(this is IMutableMatrix3) mat3Of(m00, m01, m02, m10, m11, m12, m20, m21, m22) else this
fun IMatrix4.asImmutable() = if(this is IMutableMatrix4) mat4Of(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33) else this

//@formatter:on