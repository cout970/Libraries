package com.cout970.matrix.api

import com.cout970.matrix.impl.MatrixFactory

/**
 * Created by cout970 on 24/08/2016.
 */
interface IMatrixFactory {

    companion object {
        var factory: IMatrixFactory = MatrixFactory
    }

    fun mat2Of(
            m00: Double, m01: Double,
            m10: Double, m11: Double): IMatrix2

    fun mutableMat2Of(
            m00: Double, m01: Double,
            m10: Double, m11: Double): IMutableMatrix2

    fun mat3Of(
            m00: Double, m01: Double, m02: Double,
            m10: Double, m11: Double, m12: Double,
            m20: Double, m21: Double, m22: Double): IMatrix3

    fun mutableMat3Of(
            m00: Double, m01: Double, m02: Double,
            m10: Double, m11: Double, m12: Double,
            m20: Double, m21: Double, m22: Double): IMutableMatrix3

    fun mat4Of(
            m00: Double, m01: Double, m02: Double, m03: Double,
            m10: Double, m11: Double, m12: Double, m13: Double,
            m20: Double, m21: Double, m22: Double, m23: Double,
            m30: Double, m31: Double, m32: Double, m33: Double): IMatrix4

    fun mutableMat4Of(
            m00: Double, m01: Double, m02: Double, m03: Double,
            m10: Double, m11: Double, m12: Double, m13: Double,
            m20: Double, m21: Double, m22: Double, m23: Double,
            m30: Double, m31: Double, m32: Double, m33: Double): IMutableMatrix4
}