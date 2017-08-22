package com.cout970.matrix.impl

import com.cout970.matrix.api.*

/**
 * Created by cout970 on 24/08/2016.
 */
object MatrixFactory : IMatrixFactory {

    override fun mat2Of(m00: Double, m01: Double, m10: Double, m11: Double): IMatrix2 = Matrix2d(
            m00, m01,
            m10, m11)

    override fun mutableMat2Of(m00: Double, m01: Double, m10: Double, m11: Double): IMutableMatrix2 = MutableMatrix2d(
            m00, m01,
            m10, m11)

    override fun mat3Of(m00: Double, m01: Double, m02: Double,
                        m10: Double, m11: Double, m12: Double,
                        m20: Double, m21: Double, m22: Double): IMatrix3 = Matrix3d(

            m00, m01, m02,
            m10, m11, m12,
            m20, m21, m22)

    override fun mutableMat3Of(m00: Double, m01: Double, m02: Double,
                               m10: Double, m11: Double, m12: Double,
                               m20: Double, m21: Double, m22: Double): IMutableMatrix3 = MutableMatrix3d(

            m00, m01, m02,
            m10, m11, m12,
            m20, m21, m22)

    override fun mat4Of(m00: Double, m01: Double, m02: Double, m03: Double,
                        m10: Double, m11: Double, m12: Double, m13: Double,
                        m20: Double, m21: Double, m22: Double, m23: Double,
                        m30: Double, m31: Double, m32: Double, m33: Double): IMatrix4 = Matrix4d(

            m00, m01, m02, m03,
            m10, m11, m12, m13,
            m20, m21, m22, m23,
            m30, m31, m32, m33)

    override fun mutableMat4Of(m00: Double, m01: Double, m02: Double, m03: Double,
                               m10: Double, m11: Double, m12: Double, m13: Double,
                               m20: Double, m21: Double, m22: Double, m23: Double,
                               m30: Double, m31: Double, m32: Double, m33: Double): IMutableMatrix4 = MutableMatrix4d(

            m00, m01, m02, m03,
            m10, m11, m12, m13,
            m20, m21, m22, m23,
            m30, m31, m32, m33)
}