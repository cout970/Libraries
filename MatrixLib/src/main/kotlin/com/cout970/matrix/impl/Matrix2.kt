package com.cout970.matrix.impl

import com.cout970.matrix.api.IMatrix2
import com.cout970.matrix.api.IMutableMatrix2

/**
 * Created by cout970 on 24/08/2016.
 */
data class Matrix2i(
        override val m00i: Int,
        override val m01i: Int,
        override val m10i: Int,
        override val m11i: Int
) : IMatrix2 {

    override val m00: Number get() = m00i
    override val m01: Number get() = m01i
    override val m10: Number get() = m10i
    override val m11: Number get() = m11i

    override fun toString(): String {
        return "Matrix2i: \n($m00, $m01,\n $m10, $m11)"
    }
}

data class Matrix2f(
        override val m00f: Float,
        override val m01f: Float,
        override val m10f: Float,
        override val m11f: Float
) : IMatrix2 {

    override val m00: Number get() = m00f
    override val m01: Number get() = m01f
    override val m10: Number get() = m10f
    override val m11: Number get() = m11f

    override fun toString(): String {
        return "Matrix2f: \n($m00, $m01,\n $m10, $m11)"
    }
}

data class Matrix2d(
        override val m00d: Double,
        override val m01d: Double,
        override val m10d: Double,
        override val m11d: Double
) : IMatrix2 {

    override val m00: Number get() = m00d
    override val m01: Number get() = m01d
    override val m10: Number get() = m10d
    override val m11: Number get() = m11d

    override fun toString(): String {
        return "Matrix2d: \n($m00, $m01,\n $m10, $m11)"
    }
}

data class MutableMatrix2i(
        override var m00i: Int,
        override var m01i: Int,
        override var m10i: Int,
        override var m11i: Int
) : IMutableMatrix2 {

    //@formatter:off
    override var m00: Number get() = m00i; set(value) { m00i = value.toInt() }
    override var m01: Number get() = m01i; set(value) { m01i = value.toInt() }

    override var m10: Number get() = m10i; set(value) { m10i = value.toInt() }
    override var m11: Number get() = m11i; set(value) { m11i = value.toInt() }
    //@formatter:on

    override fun toString(): String {
        return "Matrix2i: \n($m00, $m01,\n $m10, $m11)"
    }
}

data class MutableMatrix2f(
        override var m00f: Float,
        override var m01f: Float,
        override var m10f: Float,
        override var m11f: Float
) : IMutableMatrix2 {

    //@formatter:off
    override var m00: Number get() = m00f; set(value) { m00f = value.toFloat() }
    override var m01: Number get() = m01f; set(value) { m01f = value.toFloat() }

    override var m10: Number get() = m10f; set(value) { m10f = value.toFloat() }
    override var m11: Number get() = m11f; set(value) { m11f = value.toFloat() }
    //@formatter:on

    override fun toString(): String {
        return "Matrix2f: \n($m00, $m01,\n $m10, $m11)"
    }
}

data class MutableMatrix2d(
        override var m00d: Double,
        override var m01d: Double,
        override var m10d: Double,
        override var m11d: Double
) : IMutableMatrix2 {

    //@formatter:off
    override var m00: Number get() = m00d; set(value) { m00d = value.toDouble() }
    override var m01: Number get() = m01d; set(value) { m01d = value.toDouble() }

    override var m10: Number get() = m10d; set(value) { m10d = value.toDouble() }
    override var m11: Number get() = m11d; set(value) { m11d = value.toDouble() }
    //@formatter:on

    override fun toString(): String {
        return "Matrix2d: \n($m00, $m01,\n $m10, $m11)"
    }
}