package com.cout970.matrix.api

/**
 * Created by cout970 on 24/08/2016.
 */
interface IMatrix4 {

    val m00: Number
    val m01: Number
    val m02: Number
    val m03: Number

    val m10: Number
    val m11: Number
    val m12: Number
    val m13: Number

    val m20: Number
    val m21: Number
    val m22: Number
    val m23: Number

    val m30: Number
    val m31: Number
    val m32: Number
    val m33: Number


    // Int
    val m00i: Int get() = m00.toInt()
    val m01i: Int get() = m01.toInt()
    val m02i: Int get() = m02.toInt()
    val m03i: Int get() = m03.toInt()

    val m10i: Int get() = m10.toInt()
    val m11i: Int get() = m11.toInt()
    val m12i: Int get() = m12.toInt()
    val m13i: Int get() = m13.toInt()

    val m20i: Int get() = m20.toInt()
    val m21i: Int get() = m21.toInt()
    val m22i: Int get() = m22.toInt()
    val m23i: Int get() = m23.toInt()

    val m30i: Int get() = m30.toInt()
    val m31i: Int get() = m31.toInt()
    val m32i: Int get() = m32.toInt()
    val m33i: Int get() = m33.toInt()

    // Float
    val m00f: Float get() = m00.toFloat()
    val m01f: Float get() = m01.toFloat()
    val m02f: Float get() = m02.toFloat()
    val m03f: Float get() = m03.toFloat()

    val m10f: Float get() = m10.toFloat()
    val m11f: Float get() = m11.toFloat()
    val m12f: Float get() = m12.toFloat()
    val m13f: Float get() = m13.toFloat()

    val m20f: Float get() = m20.toFloat()
    val m21f: Float get() = m21.toFloat()
    val m22f: Float get() = m22.toFloat()
    val m23f: Float get() = m23.toFloat()

    val m30f: Float get() = m30.toFloat()
    val m31f: Float get() = m31.toFloat()
    val m32f: Float get() = m32.toFloat()
    val m33f: Float get() = m33.toFloat()

    // Double
    val m00d: Double get() = m00.toDouble()
    val m01d: Double get() = m01.toDouble()
    val m02d: Double get() = m02.toDouble()
    val m03d: Double get() = m03.toDouble()

    val m10d: Double get() = m10.toDouble()
    val m11d: Double get() = m11.toDouble()
    val m12d: Double get() = m12.toDouble()
    val m13d: Double get() = m13.toDouble()

    val m20d: Double get() = m20.toDouble()
    val m21d: Double get() = m21.toDouble()
    val m22d: Double get() = m22.toDouble()
    val m23d: Double get() = m23.toDouble()

    val m30d: Double get() = m30.toDouble()
    val m31d: Double get() = m31.toDouble()
    val m32d: Double get() = m32.toDouble()
    val m33d: Double get() = m33.toDouble()
}