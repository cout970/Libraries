package com.cout970.vector.impl

import com.cout970.vector.api.IMutableVector2
import com.cout970.vector.api.IVector2

/**
 * Created by cout970 on 17/08/2016.
 */
//TODO implement Comparable

data class Vector2i(override val x: Int, override val y: Int) : IVector2

data class Vector2f(override val x: Float, override val y: Float) : IVector2

data class Vector2d(override val x: Double, override val y: Double) : IVector2

//@formatter:off
data class MutableVector2i(var xi: Int, var yi: Int) : IMutableVector2 {
    override var x: Number get() = xi; set(i) { xi = i.toInt()}
    override var y: Number get() = yi; set(i) { yi = i.toInt()}
}

data class MutableVector2f(var xf: Float, var yf: Float) : IMutableVector2 {
    override var x: Number get() = xf; set(i) { xf = i.toFloat()}
    override var y: Number get() = yf; set(i) { yf = i.toFloat()}
}

data class MutableVector2d(var xd: Double, var yd: Double) : IMutableVector2 {
    override var x: Number get() = xd; set(i) { xd = i.toDouble()}
    override var y: Number get() = yd; set(i) { yd = i.toDouble()}
}
//@formatter:on
