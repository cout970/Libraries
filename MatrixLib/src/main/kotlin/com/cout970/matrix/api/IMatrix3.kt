package com.cout970.matrix.api

/**
 * Created by cout970 on 24/08/2016.
 * The matrix is column-major to match OpenGL's interpretation
 *      m00  m10  m20  m30
 *      m01  m11  m21  m31
 *      m02  m12  m22  m32
 *      m03  m13  m23  m33
 *
 */
interface IMatrix3 {
    val m00: Number
    val m01: Number
    val m02: Number

    val m10: Number
    val m11: Number
    val m12: Number

    val m20: Number
    val m21: Number
    val m22: Number

    // Int
    val m00i: Int get() = m00.toInt()
    val m01i: Int get() = m01.toInt()
    val m02i: Int get() = m02.toInt()

    val m10i: Int get() = m10.toInt()
    val m11i: Int get() = m11.toInt()
    val m12i: Int get() = m12.toInt()

    val m20i: Int get() = m20.toInt()
    val m21i: Int get() = m21.toInt()
    val m22i: Int get() = m22.toInt()

    // Float
    val m00f: Float get() = m00.toFloat()
    val m01f: Float get() = m01.toFloat()
    val m02f: Float get() = m02.toFloat()

    val m10f: Float get() = m10.toFloat()
    val m11f: Float get() = m11.toFloat()
    val m12f: Float get() = m12.toFloat()

    val m20f: Float get() = m20.toFloat()
    val m21f: Float get() = m21.toFloat()
    val m22f: Float get() = m22.toFloat()

    // Double
    val m00d: Double get() = m00.toDouble()
    val m01d: Double get() = m01.toDouble()
    val m02d: Double get() = m02.toDouble()

    val m10d: Double get() = m10.toDouble()
    val m11d: Double get() = m11.toDouble()
    val m12d: Double get() = m12.toDouble()

    val m20d: Double get() = m20.toDouble()
    val m21d: Double get() = m21.toDouble()
    val m22d: Double get() = m22.toDouble()
}