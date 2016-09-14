package com.cout970.vector.impl

import com.cout970.vector.api.IMutableQuaternion
import com.cout970.vector.api.IQuaternion

/**
 * Created by cout970 on 03/09/2016.
 */

data class Quaternioni(
        override val x: Int,
        override val y: Int,
        override val z: Int,
        override val w: Int
): IQuaternion

data class Quaternionf(
        override val x: Float,
        override val y: Float,
        override val z: Float,
        override val w: Float
): IQuaternion

data class Quaterniond(
        override val x: Double,
        override val y: Double,
        override val z: Double,
        override val w: Double
): IQuaternion

//mutable

data class MutableQuaternioni(
        var xf: Int,
        var yf: Int,
        var zf: Int,
        var wf: Int
): IMutableQuaternion {
    override var x: Number get() = xf; set(i) { xf = i.toInt()}
    override var y: Number get() = yf; set(i) { yf = i.toInt()}
    override var z: Number get() = zf; set(i) { zf = i.toInt()}
    override var w: Number get() = wf; set(i) { wf = i.toInt()}
}

data class MutableQuaternionf(
        var xf: Float,
        var yf: Float,
        var zf: Float,
        var wf: Float
): IMutableQuaternion {
    override var x: Number get() = xf; set(i) { xf = i.toFloat()}
    override var y: Number get() = yf; set(i) { yf = i.toFloat()}
    override var z: Number get() = zf; set(i) { zf = i.toFloat()}
    override var w: Number get() = wf; set(i) { wf = i.toFloat()}
}

data class MutableQuaterniond(
        var xf: Double,
        var yf: Double,
        var zf: Double,
        var wf: Double
): IMutableQuaternion {
    override var x: Number get() = xf; set(i) { xf = i.toDouble()}
    override var y: Number get() = yf; set(i) { yf = i.toDouble()}
    override var z: Number get() = zf; set(i) { zf = i.toDouble()}
    override var w: Number get() = wf; set(i) { wf = i.toDouble()}
}

