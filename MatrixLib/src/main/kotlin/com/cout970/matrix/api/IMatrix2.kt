package com.cout970.matrix.api

import java.io.Serializable

/**
 * Created by cout970 on 24/08/2016.
 */
interface IMatrix2 : Serializable {
    val m00: Number
    val m01: Number
    val m10: Number
    val m11: Number

    // Int
    val m00i: Int get() = m00.toInt()
    val m01i: Int get() = m01.toInt()

    val m10i: Int get() = m10.toInt()
    val m11i: Int get() = m11.toInt()

    // Float
    val m00f: Float get() = m00.toFloat()
    val m01f: Float get() = m01.toFloat()

    val m10f: Float get() = m10.toFloat()
    val m11f: Float get() = m11.toFloat()

    // Double
    val m00d: Double get() = m00.toDouble()
    val m01d: Double get() = m01.toDouble()

    val m10d: Double get() = m10.toDouble()
    val m11d: Double get() = m11.toDouble()
}