package com.cout970.vector.impl

import com.cout970.vector.api.IMutableVector4
import com.cout970.vector.api.IVector4

/**
 * Created by cout970 on 17/08/2016.
 */
//TODO implement Comparable

data class Vector4i(
        override val xi: Int,
        override val yi: Int,
        override val zi: Int,
        override val wi: Int
) : IVector4 {

    override val x: Number get() = xi
    override val y: Number get() = yi
    override val z: Number get() = zi
    override val w: Number get() = wi

    override val xf: Float get() = xi.toFloat()
    override val yf: Float get() = yi.toFloat()
    override val zf: Float get() = zi.toFloat()
    override val wf: Float get() = wi.toFloat()

    override val xd: Double get() = xi.toDouble()
    override val yd: Double get() = yi.toDouble()
    override val zd: Double get() = zi.toDouble()
    override val wd: Double get() = wi.toDouble()
}

data class Vector4f(
        override val xf: Float,
        override val yf: Float,
        override val zf: Float,
        override val wf: Float
) : IVector4 {

    override val x: Number get() = xf
    override val y: Number get() = yf
    override val z: Number get() = zf
    override val w: Number get() = wf

    override val xi: Int get() = xf.toInt()
    override val yi: Int get() = yf.toInt()
    override val zi: Int get() = zf.toInt()
    override val wi: Int get() = wf.toInt()

    override val xd: Double get() = xf.toDouble()
    override val yd: Double get() = yf.toDouble()
    override val zd: Double get() = zf.toDouble()
    override val wd: Double get() = wf.toDouble()
}

data class Vector4d(
        override val xd: Double,
        override val yd: Double,
        override val zd: Double,
        override val wd: Double
) : IVector4 {

    override val x: Number get() = xd
    override val y: Number get() = yd
    override val z: Number get() = zd
    override val w: Number get() = wd

    override val xi: Int get() = xd.toInt()
    override val yi: Int get() = yd.toInt()
    override val zi: Int get() = zd.toInt()
    override val wi: Int get() = wd.toInt()

    override val xf: Float get() = xd.toFloat()
    override val yf: Float get() = yd.toFloat()
    override val zf: Float get() = zd.toFloat()
    override val wf: Float get() = wd.toFloat()
}

//@formatter:off
data class MutableVector4i(
        override var xi: Int,
        override var yi: Int,
        override var zi: Int,
        override var wi: Int
) : IMutableVector4 {

    override var x: Number get() = xi; set(i) { xi = i.toInt()}
    override var y: Number get() = yi; set(i) { yi = i.toInt()}
    override var z: Number get() = zi; set(i) { zi = i.toInt()}
    override var w: Number get() = wi; set(i) { wi = i.toInt()}
}

data class MutableVector4f(
        override var xf: Float,
        override var yf: Float,
        override var zf: Float,
        override var wf: Float
) : IMutableVector4 {

    override var x: Number get() = xf; set(i) { xf = i.toFloat()}
    override var y: Number get() = yf; set(i) { yf = i.toFloat()}
    override var z: Number get() = zf; set(i) { zf = i.toFloat()}
    override var w: Number get() = wf; set(i) { wf = i.toFloat()}
}

data class MutableVector4d(
        override var xd: Double,
        override var yd: Double,
        override var zd: Double,
        override var wd: Double
) : IMutableVector4 {

    override var x: Number get() = xd; set(i) { xd = i.toDouble()}
    override var y: Number get() = yd; set(i) { yd = i.toDouble()}
    override var z: Number get() = zd; set(i) { zd = i.toDouble()}
    override var w: Number get() = wd; set(i) { wd = i.toDouble()}
}
//@formatter:on