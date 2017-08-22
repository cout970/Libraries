package com.cout970.vector.impl

import com.cout970.vector.api.IMutableVector2
import com.cout970.vector.api.IVector2

/**
 * Created by cout970 on 17/08/2016.
 */
//TODO implement Comparable

data class Vector2i(
        override val xi: Int,
        override val yi: Int
) : IVector2 {

    override val x: Number get() = xi
    override val y: Number get() = yi
}

data class Vector2f(
        override val xf: Float,
        override val yf: Float
) : IVector2 {

    override val x: Number get() = xf
    override val y: Number get() = yf
}

data class Vector2d(
        override val xd: Double,
        override val yd: Double
) : IVector2 {

    override val x: Number get() = xd
    override val y: Number get() = yd
}

//@formatter:off
data class MutableVector2i(
        override var xi: Int,
        override var yi: Int
) : IMutableVector2 {

    override var x: Number get() = xi; set(i) { xi = i.toInt()}
    override var y: Number get() = yi; set(i) { yi = i.toInt()}
}

data class MutableVector2f(
        override var xf: Float,
        override var yf: Float
) : IMutableVector2 {

    override var x: Number get() = xf; set(i) { xf = i.toFloat()}
    override var y: Number get() = yf; set(i) { yf = i.toFloat()}
}

data class MutableVector2d(
        override var xd: Double,
        override var yd: Double
) : IMutableVector2 {

    override var x: Number get() = xd; set(i) { xd = i.toDouble()}
    override var y: Number get() = yd; set(i) { yd = i.toDouble()}
}
//@formatter:on
