package com.cout970.vector.impl

import com.cout970.vector.api.IMutableQuaternion
import com.cout970.vector.api.IQuaternion

/**
 * Created by cout970 on 03/09/2016.
 */

data class Quaternionf(
        override val xf: Float,
        override val yf: Float,
        override val zf: Float,
        override val wf: Float
): IQuaternion {

    //@formatter:off
    override val x: Number get() = xf
    override val y: Number get() = yf
    override val z: Number get() = zf
    override val w: Number get() = wf

    override val xd: Double get() = xf.toDouble()
    override val yd: Double get() = yf.toDouble()
    override val zd: Double get() = zf.toDouble()
    override val wd: Double get() = wf.toDouble()
    //@formatter:on
}

data class Quaterniond(
        override val xd: Double,
        override val yd: Double,
        override val zd: Double,
        override val wd: Double
): IQuaternion{

    //@formatter:off
    override val x: Number get() = xd
    override val y: Number get() = yd
    override val z: Number get() = zd
    override val w: Number get() = wd

    override val xf: Float get() = xd.toFloat()
    override val yf: Float get() = yd.toFloat()
    override val zf: Float get() = zd.toFloat()
    override val wf: Float get() = wd.toFloat()
    //@formatter:on
}

//mutable

data class MutableQuaternionf(
        override var xf: Float,
        override var yf: Float,
        override var zf: Float,
        override var wf: Float
): IMutableQuaternion {

    //@formatter:off
    override var x: Number get() = xf; set(i) { xf = i.toFloat()}
    override var y: Number get() = yf; set(i) { yf = i.toFloat()}
    override var z: Number get() = zf; set(i) { zf = i.toFloat()}
    override var w: Number get() = wf; set(i) { wf = i.toFloat()}

    override var xd: Double get() = xf.toDouble(); set(i) { xf = i.toFloat()}
    override var yd: Double get() = yf.toDouble(); set(i) { yf = i.toFloat()}
    override var zd: Double get() = zf.toDouble(); set(i) { zf = i.toFloat()}
    override var wd: Double get() = wf.toDouble(); set(i) { wf = i.toFloat()}
    //@formatter:on
}

data class MutableQuaterniond(
        override var xd: Double,
        override var yd: Double,
        override var zd: Double,
        override var wd: Double
): IMutableQuaternion {

    //@formatter:off
    override var xf: Float get() = xd.toFloat(); set(i) { xd = i.toDouble()}
    override var yf: Float get() = yd.toFloat(); set(i) { yd = i.toDouble()}
    override var zf: Float get() = zd.toFloat(); set(i) { zd = i.toDouble()}
    override var wf: Float get() = wd.toFloat(); set(i) { wd = i.toDouble()}

    override var x: Number get() = xd; set(i) { xd = i.toDouble()}
    override var y: Number get() = yd; set(i) { yd = i.toDouble()}
    override var z: Number get() = zd; set(i) { zd = i.toDouble()}
    override var w: Number get() = wd; set(i) { wd = i.toDouble()}
    //@formatter:on
}

