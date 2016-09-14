package com.cout970.matrix.impl

import com.cout970.matrix.api.IMatrix3
import com.cout970.matrix.api.IMutableMatrix3

/**
 * Created by cout970 on 24/08/2016.
 */

data class Matrix3i(
        override val m00: Int,
        override val m01: Int,
        override val m02: Int,

        override val m10: Int,
        override val m11: Int,
        override val m12: Int,

        override val m20: Int,
        override val m21: Int,
        override val m22: Int
) : IMatrix3 {
    override fun toString(): String {
        return "Matrix3i: \n($m00, $m01, $m02,\n $m10, $m11, $m12,\n $m20, $m21, $m22)"
    }
}

data class Matrix3f(
        override val m00: Float,
        override val m01: Float,
        override val m02: Float,

        override val m10: Float,
        override val m11: Float,
        override val m12: Float,

        override val m20: Float,
        override val m21: Float,
        override val m22: Float
) : IMatrix3 {
    override fun toString(): String {
        return "Matrix3f \n($m00, $m01, $m02,\n $m10, $m11, $m12,\n $m20, $m21, $m22)"
    }
}

data class Matrix3d(
        override val m00: Double,
        override val m01: Double,
        override val m02: Double,

        override val m10: Double,
        override val m11: Double,
        override val m12: Double,

        override val m20: Double,
        override val m21: Double,
        override val m22: Double
) : IMatrix3 {
    override fun toString(): String {
        return "Matrix3d: \n($m00, $m01, $m02,\n $m10, $m11, $m12,\n $m20, $m21, $m22)"
    }
}

//@formatter:off
data class MutableMatrix3i(
        var m00i: Int,
        var m01i: Int,
        var m02i: Int,

        var m10i: Int,
        var m11i: Int,
        var m12i: Int,

        var m20i: Int,
        var m21i: Int,
        var m22i: Int
) : IMutableMatrix3 {
    override var m00: Number
        get() = m00i
        set(value) { m00i = value.toInt()}

    override var m01: Number
        get() = m01i
        set(value) { m01i = value.toInt()}

    override var m02: Number
        get() = m02i
        set(value) { m02i = value.toInt()}

    override var m10: Number
        get() = m10i
        set(value) { m10i = value.toInt()}

    override var m11: Number
        get() = m11i
        set(value) { m11i = value.toInt()}

    override var m12: Number
        get() = m12i
        set(value) { m12i = value.toInt()}

    override var m20: Number
        get() = m20i
        set(value) { m20i = value.toInt()}

    override var m21: Number
        get() = m21i
        set(value) { m21i = value.toInt()}

    override var m22: Number
        get() = m22i
        set(value) { m22i = value.toInt()}

    override fun toString(): String {
        return "Matrix3i: \n($m00, $m01, $m02,\n $m10, $m11, $m12,\n $m20, $m21, $m22)"
    }
}

data class MutableMatrix3f(
        var m00f: Float,
        var m01f: Float,
        var m02f: Float,

        var m10f: Float,
        var m11f: Float,
        var m12f: Float,

        var m20f: Float,
        var m21f: Float,
        var m22f: Float
) : IMutableMatrix3 {
    override var m00: Number
        get() = m00f
        set(value) { m00f = value.toFloat()}

    override var m01: Number
        get() = m01f
        set(value) { m01f = value.toFloat()}

    override var m02: Number
        get() = m02f
        set(value) { m02f = value.toFloat()}

    override var m10: Number
        get() = m10f
        set(value) { m10f = value.toFloat()}

    override var m11: Number
        get() = m11f
        set(value) { m11f = value.toFloat()}

    override var m12: Number
        get() = m12f
        set(value) { m12f = value.toFloat()}

    override var m20: Number
        get() = m20f
        set(value) { m20f = value.toFloat()}

    override var m21: Number
        get() = m21f
        set(value) { m21f = value.toFloat()}

    override var m22: Number
        get() = m22f
        set(value) { m22f = value.toFloat()}

    override fun toString(): String {
        return "Matrix3f: \n($m00, $m01, $m02,\n $m10, $m11, $m12,\n $m20, $m21, $m22)"
    }
}

data class MutableMatrix3d(
        var m00d: Double,
        var m01d: Double,
        var m02d: Double,

        var m10d: Double,
        var m11d: Double,
        var m12d: Double,

        var m20d: Double,
        var m21d: Double,
        var m22d: Double
) : IMutableMatrix3 {
    override var m00: Number
        get() = m00d
        set(value) { m00d = value.toDouble()}

    override var m01: Number
        get() = m01d
        set(value) { m01d = value.toDouble()}

    override var m02: Number
        get() = m02d
        set(value) { m02d = value.toDouble()}

    override var m10: Number
        get() = m10d
        set(value) { m10d = value.toDouble()}

    override var m11: Number
        get() = m11d
        set(value) { m11d = value.toDouble()}

    override var m12: Number
        get() = m12d
        set(value) { m12d = value.toDouble()}

    override var m20: Number
        get() = m20d
        set(value) { m20d = value.toDouble()}

    override var m21: Number
        get() = m21d
        set(value) { m21d = value.toDouble()}

    override var m22: Number
        get() = m22d
        set(value) { m22d = value.toDouble()}

    override fun toString(): String {
        return "Matrix3d: \n($m00, $m01, $m02,\n $m10, $m11, $m12,\n $m20, $m21, $m22)"
    }
}
//@formatter:on