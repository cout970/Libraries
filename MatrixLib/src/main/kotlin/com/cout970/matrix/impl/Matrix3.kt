package com.cout970.matrix.impl

import com.cout970.matrix.api.IMatrix3
import com.cout970.matrix.api.IMutableMatrix3

/**
 * Created by cout970 on 24/08/2016.
 */

data class Matrix3i(
        override val m00i: Int,
        override val m01i: Int,
        override val m02i: Int,

        override val m10i: Int,
        override val m11i: Int,
        override val m12i: Int,

        override val m20i: Int,
        override val m21i: Int,
        override val m22i: Int
) : IMatrix3 {

    override val m00: Number get() = m00i
    override val m01: Number get() = m01i
    override val m02: Number get() = m02i

    override val m10: Number get() = m10i
    override val m11: Number get() = m11i
    override val m12: Number get() = m12i

    override val m20: Number get() = m20i
    override val m21: Number get() = m21i
    override val m22: Number get() = m22i

    override fun toString(): String {
        return "Matrix3i: \n($m00, $m01, $m02,\n $m10, $m11, $m12,\n $m20, $m21, $m22)"
    }
}

data class Matrix3f(
        override val m00f: Float,
        override val m01f: Float,
        override val m02f: Float,

        override val m10f: Float,
        override val m11f: Float,
        override val m12f: Float,

        override val m20f: Float,
        override val m21f: Float,
        override val m22f: Float
) : IMatrix3 {

    override val m00: Number get() = m00f
    override val m01: Number get() = m01f
    override val m02: Number get() = m02f

    override val m10: Number get() = m10f
    override val m11: Number get() = m11f
    override val m12: Number get() = m12f

    override val m20: Number get() = m20f
    override val m21: Number get() = m21f
    override val m22: Number get() = m22f

    override fun toString(): String {
        return "Matrix3f \n($m00, $m01, $m02,\n $m10, $m11, $m12,\n $m20, $m21, $m22)"
    }
}

data class Matrix3d(
        override val m00d: Double,
        override val m01d: Double,
        override val m02d: Double,

        override val m10d: Double,
        override val m11d: Double,
        override val m12d: Double,

        override val m20d: Double,
        override val m21d: Double,
        override val m22d: Double
) : IMatrix3 {

    override val m00: Number get() = m00d
    override val m01: Number get() = m01d
    override val m02: Number get() = m02d

    override val m10: Number get() = m10d
    override val m11: Number get() = m11d
    override val m12: Number get() = m12d

    override val m20: Number get() = m20d
    override val m21: Number get() = m21d
    override val m22: Number get() = m22d

    override fun toString(): String {
        return "Matrix3d: \n($m00, $m01, $m02,\n $m10, $m11, $m12,\n $m20, $m21, $m22)"
    }
}

//@formatter:off
data class MutableMatrix3i(
        override var m00i: Int,
        override var m01i: Int,
        override var m02i: Int,

        override var m10i: Int,
        override var m11i: Int,
        override var m12i: Int,

        override var m20i: Int,
        override var m21i: Int,
        override var m22i: Int
) : IMutableMatrix3 {

    override var m00: Number get() = m00i; set(value) { m00i = value.toInt()}
    override var m01: Number get() = m01i; set(value) { m01i = value.toInt()}
    override var m02: Number get() = m02i; set(value) { m02i = value.toInt()}

    override var m10: Number get() = m10i; set(value) { m10i = value.toInt()}
    override var m11: Number get() = m11i; set(value) { m11i = value.toInt()}
    override var m12: Number get() = m12i; set(value) { m12i = value.toInt()}

    override var m20: Number get() = m20i; set(value) { m20i = value.toInt()}
    override var m21: Number get() = m21i; set(value) { m21i = value.toInt()}
    override var m22: Number get() = m22i; set(value) { m22i = value.toInt()}

    override fun toString(): String {
        return "Matrix3i: \n($m00, $m01, $m02,\n $m10, $m11, $m12,\n $m20, $m21, $m22)"
    }
}

data class MutableMatrix3f(
        override var m00f: Float,
        override var m01f: Float,
        override var m02f: Float,

        override var m10f: Float,
        override var m11f: Float,
        override var m12f: Float,

        override var m20f: Float,
        override var m21f: Float,
        override var m22f: Float
) : IMutableMatrix3 {

    override var m00: Number get() = m00f; set(value) { m00f = value.toFloat()}
    override var m01: Number get() = m01f; set(value) { m01f = value.toFloat()}
    override var m02: Number get() = m02f; set(value) { m02f = value.toFloat()}

    override var m10: Number get() = m10f; set(value) { m10f = value.toFloat()}
    override var m11: Number get() = m11f; set(value) { m11f = value.toFloat()}
    override var m12: Number get() = m12f; set(value) { m12f = value.toFloat()}

    override var m20: Number get() = m20f; set(value) { m20f = value.toFloat()}
    override var m21: Number get() = m21f; set(value) { m21f = value.toFloat()}
    override var m22: Number get() = m22f; set(value) { m22f = value.toFloat()}

    override fun toString(): String {
        return "Matrix3f: \n($m00, $m01, $m02,\n $m10, $m11, $m12,\n $m20, $m21, $m22)"
    }
}

data class MutableMatrix3d(
        override var m00d: Double,
        override var m01d: Double,
        override var m02d: Double,

        override var m10d: Double,
        override var m11d: Double,
        override var m12d: Double,

        override var m20d: Double,
        override var m21d: Double,
        override var m22d: Double
) : IMutableMatrix3 {

    override var m00: Number get() = m00d; set(value) { m00d = value.toDouble()}
    override var m01: Number get() = m01d; set(value) { m01d = value.toDouble()}
    override var m02: Number get() = m02d; set(value) { m02d = value.toDouble()}

    override var m10: Number get() = m10d; set(value) { m10d = value.toDouble()}
    override var m11: Number get() = m11d; set(value) { m11d = value.toDouble()}
    override var m12: Number get() = m12d; set(value) { m12d = value.toDouble()}

    override var m20: Number get() = m20d; set(value) { m20d = value.toDouble()}
    override var m21: Number get() = m21d; set(value) { m21d = value.toDouble()}
    override var m22: Number get() = m22d; set(value) { m22d = value.toDouble()}

    override fun toString(): String {
        return "Matrix3d: \n($m00, $m01, $m02,\n $m10, $m11, $m12,\n $m20, $m21, $m22)"
    }
}
//@formatter:on