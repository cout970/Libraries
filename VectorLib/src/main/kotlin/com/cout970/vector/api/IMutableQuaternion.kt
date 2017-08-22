package com.cout970.vector.api

/**
 * Created by cout970 on 02/09/2016.
 */
interface IMutableQuaternion : IQuaternion {

    override var x: Number
    override var y: Number
    override var z: Number
    override var w: Number

    //@formatter:off
    override var xi: Int get() = x.toInt(); set(v) { x = v }
    override var yi: Int get() = y.toInt(); set(v) { y = v }
    override var zi: Int get() = z.toInt(); set(v) { z = v }
    override var wi: Int get() = w.toInt(); set(v) { w = v }

    override var xf: Float get() = x.toFloat(); set(v) { x = v }
    override var yf: Float get() = y.toFloat(); set(v) { y = v }
    override var zf: Float get() = z.toFloat(); set(v) { z = v }
    override var wf: Float get() = w.toFloat(); set(v) { w = v }

    override var xd: Double get() = x.toDouble(); set(v) { x = v }
    override var yd: Double get() = y.toDouble(); set(v) { y = v }
    override var zd: Double get() = z.toDouble(); set(v) { z = v }
    override var wd: Double get() = w.toDouble(); set(v) { w = v }
    //@formatter:on
}