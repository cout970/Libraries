package com.cout970.matrix.impl

import com.cout970.matrix.api.IMatrix2
import com.cout970.matrix.api.IMutableMatrix2

/**
 * Created by cout970 on 24/08/2016.
 */
data class Matrix2i(
        override val m00: Int,
        override val m01: Int,
        override val m10: Int,
        override val m11: Int
) : IMatrix2 {
    override fun toString(): String {
        return "Matrix2i: \n($m00, $m01,\n $m10, $m11)"
    }
}

data class Matrix2f(
        override val m00: Float,
        override val m01: Float,
        override val m10: Float,
        override val m11: Float
) : IMatrix2 {
    override fun toString(): String {
        return "Matrix2f: \n($m00, $m01,\n $m10, $m11)"
    }
}

data class Matrix2d(
        override val m00: Double,
        override val m01: Double,
        override val m10: Double,
        override val m11: Double
) : IMatrix2 {
    override fun toString(): String {
        return "Matrix2d: \n($m00, $m01,\n $m10, $m11)"
    }
}

//@formatter:off
data class MutableMatrix2i(
        var m00i: Int,
        var m01i: Int,
        var m10i: Int,
        var m11i: Int
) : IMutableMatrix2 {
    override var m00: Number
        get() = m00i
        set(value) { m00i = value.toInt() }

    override var m01: Number
        get() = m01i
        set(value) { m01i = value.toInt() }

    override var m10: Number
        get() = m10i
        set(value) { m10i = value.toInt() }

    override var m11: Number
        get() = m11i
        set(value) { m11i = value.toInt() }

    override fun toString(): String {
        return "Matrix2i: \n($m00, $m01,\n $m10, $m11)"
    }
}

data class MutableMatrix2f(
        var m00f: Float,
        var m01f: Float,
        var m10f: Float,
        var m11f: Float
) : IMutableMatrix2 {
    override var m00: Number
        get() = m00f
        set(value) { m00f = value.toFloat() }

    override var m01: Number
        get() = m01f
        set(value) { m01f = value.toFloat() }

    override var m10: Number
        get() = m10f
        set(value) { m10f = value.toFloat() }

    override var m11: Number
        get() = m11f
        set(value) { m11f = value.toFloat() }

    override fun toString(): String {
        return "Matrix2f: \n($m00, $m01,\n $m10, $m11)"
    }
}

data class MutableMatrix2d(
        var m00d: Double,
        var m01d: Double,
        var m10d: Double,
        var m11d: Double
) : IMutableMatrix2 {
    override var m00: Number
        get() = m00d
        set(value) { m00d = value.toDouble() }

    override var m01: Number
        get() = m01d
        set(value) { m01d = value.toDouble() }

    override var m10: Number
        get() = m10d
        set(value) { m10d = value.toDouble() }

    override var m11: Number
        get() = m11d
        set(value) { m11d = value.toDouble() }

    override fun toString(): String {
        return "Matrix2d: \n($m00, $m01,\n $m10, $m11)"
    }
}
//@formatter:on