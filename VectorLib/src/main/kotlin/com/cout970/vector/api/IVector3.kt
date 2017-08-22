package com.cout970.vector.api

import java.io.Serializable

/**
 * Created by cout970 on 17/08/2016.
 */
interface IVector3 : Serializable {

    val x: Number
    val y: Number
    val z: Number

    val xi: Int get() = x.toInt()
    val yi: Int get() = y.toInt()
    val zi: Int get() = z.toInt()

    val xf: Float get() = x.toFloat()
    val yf: Float get() = y.toFloat()
    val zf: Float get() = z.toFloat()

    val xd: Double get() = x.toDouble()
    val yd: Double get() = y.toDouble()
    val zd: Double get() = z.toDouble()
}