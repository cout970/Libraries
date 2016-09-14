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
            m00: Number, m01: Number,
            m10: Number, m11: Number): IMatrix2

    fun mutableMat2Of(
            m00: Number, m01: Number,
            m10: Number, m11: Number): IMutableMatrix2

    fun mat3Of(
            m00: Number, m01: Number, m02: Number,
            m10: Number, m11: Number, m12: Number,
            m20: Number, m21: Number, m22: Number): IMatrix3

    fun mutableMat3Of(
            m00: Number, m01: Number, m02: Number,
            m10: Number, m11: Number, m12: Number,
            m20: Number, m21: Number, m22: Number): IMutableMatrix3

    fun mat4Of(
            m00: Number, m01: Number, m02: Number, m03: Number,
            m10: Number, m11: Number, m12: Number, m13: Number,
            m20: Number, m21: Number, m22: Number, m23: Number,
            m30: Number, m31: Number, m32: Number, m33: Number): IMatrix4

    fun mutableMat4Of(
            m00: Number, m01: Number, m02: Number, m03: Number,
            m10: Number, m11: Number, m12: Number, m13: Number,
            m20: Number, m21: Number, m22: Number, m23: Number,
            m30: Number, m31: Number, m32: Number, m33: Number): IMutableMatrix4
}