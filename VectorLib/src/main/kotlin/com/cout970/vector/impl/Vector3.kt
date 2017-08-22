package com.cout970.vector.impl

import com.cout970.vector.api.IMutableVector3
import com.cout970.vector.api.IVector3

/**
 * Created by cout970 on 17/08/2016.
 */
//TODO implement Comparable
//TODO add equals and hashcode so doesn't check the class

//@formatter:off
data class Vector3i(
        override val xi: Int,
        override val yi: Int,
        override val zi: Int
) : IVector3{

    override val x: Number get() = xi
    override val y: Number get() = yi
    override val z: Number get() = zi

    override val xf: Float get() = xi.toFloat()
    override val yf: Float get() = yi.toFloat()
    override val zf: Float get() = zi.toFloat()

    override val xd: Double get() = xi.toDouble()
    override val yd: Double get() = yi.toDouble()
    override val zd: Double get() = zi.toDouble()
}

data class Vector3f(
        override val xf: Float,
        override val yf: Float,
        override val zf: Float
) : IVector3{

    override val x: Number get() = xf
    override val y: Number get() = yf
    override val z: Number get() = zf

    override val xi: Int get() = xf.toInt()
    override val yi: Int get() = yf.toInt()
    override val zi: Int get() = zf.toInt()

    override val xd: Double get() = xf.toDouble()
    override val yd: Double get() = yf.toDouble()
    override val zd: Double get() = zf.toDouble()
}

data class Vector3d(
        override val xd: Double,
        override val yd: Double,
        override val zd: Double
) : IVector3 {

    override val x: Number get() = xd
    override val y: Number get() = yd
    override val z: Number get() = zd

    override val xi: Int get() = xd.toInt()
    override val yi: Int get() = yd.toInt()
    override val zi: Int get() = zd.toInt()

    override val xf: Float get() = xd.toFloat()
    override val yf: Float get() = yd.toFloat()
    override val zf: Float get() = zd.toFloat()
}

data class MutableVector3i(
        override var xi: Int,
        override var yi: Int,
        override var zi: Int
) : IMutableVector3 {

    override var x: Number get() = xi; set(i) { xi = i.toInt()}
    override var y: Number get() = yi; set(i) { yi = i.toInt()}
    override var z: Number get() = zi; set(i) { zi = i.toInt()}
}

data class MutableVector3f(
        override var xf: Float,
        override var yf: Float,
        override var zf: Float
) : IMutableVector3 {

    override var x: Number get() = xf; set(i) { xf = i.toFloat()}
    override var y: Number get() = yf; set(i) { yf = i.toFloat()}
    override var z: Number get() = zf; set(i) { zf = i.toFloat()}
}

data class MutableVector3d(
        override var xd: Double,
        override var yd: Double,
        override var zd: Double
) : IMutableVector3 {

    override var x: Number get() = xd; set(i) { xd = i.toDouble()}
    override var y: Number get() = yd; set(i) { yd = i.toDouble()}
    override var z: Number get() = zd; set(i) { zd = i.toDouble()}
}
//@formatter:on