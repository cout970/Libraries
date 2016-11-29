package com.cout970.matrix.impl

import com.cout970.matrix.api.IMatrix4
import com.cout970.matrix.api.IMutableMatrix4

/**
 * Created by cout970 on 24/08/2016.
 */

data class Matrix4i(
        override val m00: Int,
        override val m01: Int,
        override val m02: Int,
        override val m03: Int,

        override val m10: Int,
        override val m11: Int,
        override val m12: Int,
        override val m13: Int,

        override val m20: Int,
        override val m21: Int,
        override val m22: Int,
        override val m23: Int,

        override val m30: Int,
        override val m31: Int,
        override val m32: Int,
        override val m33: Int
) : IMatrix4 {
    override fun toString(): String {
        return "Matrix4i: \n($m00, $m01, $m02, $m03,\n $m10, $m11, $m12, $m13,\n $m20, $m21, $m22, $m23,\n $m30, $m31, $m32, $m33)"
    }
}

data class Matrix4f(
        override val m00: Float,
        override val m01: Float,
        override val m02: Float,
        override val m03: Float,

        override val m10: Float,
        override val m11: Float,
        override val m12: Float,
        override val m13: Float,

        override val m20: Float,
        override val m21: Float,
        override val m22: Float,
        override val m23: Float,

        override val m30: Float,
        override val m31: Float,
        override val m32: Float,
        override val m33: Float
) : IMatrix4 {
    override fun toString(): String {
        return "Matrix4f: \n($m00, $m01, $m02, $m03,\n $m10, $m11, $m12, $m13,\n $m20, $m21, $m22, $m23,\n $m30, $m31, $m32, $m33)"
    }
}

data class Matrix4d(
        override val m00: Double,
        override val m01: Double,
        override val m02: Double,
        override val m03: Double,

        override val m10: Double,
        override val m11: Double,
        override val m12: Double,
        override val m13: Double,

        override val m20: Double,
        override val m21: Double,
        override val m22: Double,
        override val m23: Double,

        override val m30: Double,
        override val m31: Double,
        override val m32: Double,
        override val m33: Double
) : IMatrix4 {
    override fun toString(): String {
        return "Matrix4d: \n($m00, $m01, $m02, $m03,\n $m10, $m11, $m12, $m13,\n $m20, $m21, $m22, $m23,\n $m30, $m31, $m32, $m33)"
    }
}

//@formatter:off
data class MutableMatrix4i(
        var m00i: Int,
        var m01i: Int,
        var m02i: Int,
        var m03i: Int,

        var m10i: Int,
        var m11i: Int,
        var m12i: Int,
        var m13i: Int,

        var m20i: Int,
        var m21i: Int,
        var m22i: Int,
        var m23i: Int,

        var m30i: Int,
        var m31i: Int,
        var m32i: Int,
        var m33i: Int
) : IMutableMatrix4 {
    override var m00: Number
        get() = m00i
        set(value) { m00i = value.toInt()}
    override var m01: Number
        get() = m01i
        set(value) { m01i = value.toInt()}
    override var m02: Number
        get() = m02i
        set(value) { m02i = value.toInt()}
    override var m03: Number
        get() = m03i
        set(value) { m03i = value.toInt()}

    override var m10: Number
        get() = m10i
        set(value) { m10i = value.toInt()}
    override var m11: Number
        get() = m11i
        set(value) { m11i = value.toInt()}
    override var m12: Number
        get() = m12i
        set(value) { m12i = value.toInt()}
    override var m13: Number
        get() = m13i
        set(value) { m13i = value.toInt()}

    override var m20: Number
        get() = m20i
        set(value) { m20i = value.toInt()}
    override var m21: Number
        get() = m21i
        set(value) { m21i = value.toInt()}
    override var m22: Number
        get() = m22i
        set(value) { m22i = value.toInt()}
    override var m23: Number
        get() = m23i
        set(value) { m23i = value.toInt()}

    override var m30: Number
        get() = m30i
        set(value) { m30i = value.toInt()}
    override var m31: Number
        get() = m31i
        set(value) { m31i = value.toInt()}
    override var m32: Number
        get() = m32i
        set(value) { m32i = value.toInt()}
    override var m33: Number
        get() = m33i
        set(value) { m33i = value.toInt()}

    override fun toString(): String {
        return "Matrix4i: \n($m00, $m01, $m02, $m03,\n $m10, $m11, $m12, $m13,\n $m20, $m21, $m22, $m23,\n $m30, $m31, $m32, $m33)"
    }
}

data class MutableMatrix4f(
        var m00f: Float,
        var m01f: Float,
        var m02f: Float,
        var m03f: Float,

        var m10f: Float,
        var m11f: Float,
        var m12f: Float,
        var m13f: Float,

        var m20f: Float,
        var m21f: Float,
        var m22f: Float,
        var m23f: Float,

        var m30f: Float,
        var m31f: Float,
        var m32f: Float,
        var m33f: Float
) : IMutableMatrix4 {
    override var m00: Number
        get() = m00f
        set(value) { m00f = value.toFloat()}
    override var m01: Number
        get() = m01f
        set(value) { m01f = value.toFloat()}
    override var m02: Number
        get() = m02f
        set(value) { m02f = value.toFloat()}
    override var m03: Number
        get() = m03f
        set(value) { m03f = value.toFloat()}

    override var m10: Number
        get() = m10f
        set(value) { m10f = value.toFloat()}
    override var m11: Number
        get() = m11f
        set(value) { m11f = value.toFloat()}
    override var m12: Number
        get() = m12f
        set(value) { m12f = value.toFloat()}
    override var m13: Number
        get() = m13f
        set(value) { m13f = value.toFloat()}

    override var m20: Number
        get() = m20f
        set(value) { m20f = value.toFloat()}
    override var m21: Number
        get() = m21f
        set(value) { m21f = value.toFloat()}
    override var m22: Number
        get() = m22f
        set(value) { m22f = value.toFloat()}
    override var m23: Number
        get() = m23f
        set(value) { m23f = value.toFloat()}

    override var m30: Number
        get() = m30f
        set(value) { m30f = value.toFloat()}
    override var m31: Number
        get() = m31f
        set(value) { m31f = value.toFloat()}
    override var m32: Number
        get() = m32f
        set(value) { m32f = value.toFloat()}
    override var m33: Number
        get() = m33f
        set(value) { m33f = value.toFloat()}

    override fun toString(): String {
        return "Matrix4f: \n($m00, $m01, $m02, $m03,\n $m10, $m11, $m12, $m13,\n $m20, $m21, $m22, $m23,\n $m30, $m31, $m32, $m33)"
    }
}

data class MutableMatrix4d(
        var m00d: Double,
        var m01d: Double,
        var m02d: Double,
        var m03d: Double,

        var m10d: Double,
        var m11d: Double,
        var m12d: Double,
        var m13d: Double,

        var m20d: Double,
        var m21d: Double,
        var m22d: Double,
        var m23d: Double,

        var m30d: Double,
        var m31d: Double,
        var m32d: Double,
        var m33d: Double
) : IMutableMatrix4 {
    override var m00: Number
        get() = m00d
        set(value) { m00d = value.toDouble()}
    override var m01: Number
        get() = m01d
        set(value) { m01d = value.toDouble()}
    override var m02: Number
        get() = m02d
        set(value) { m02d = value.toDouble()}
    override var m03: Number
        get() = m03d
        set(value) { m03d = value.toDouble()}

    override var m10: Number
        get() = m10d
        set(value) { m10d = value.toDouble()}
    override var m11: Number
        get() = m11d
        set(value) { m11d = value.toDouble()}
    override var m12: Number
        get() = m12d
        set(value) { m12d = value.toDouble()}
    override var m13: Number
        get() = m13d
        set(value) { m13d = value.toDouble()}

    override var m20: Number
        get() = m20d
        set(value) { m20d = value.toDouble()}
    override var m21: Number
        get() = m21d
        set(value) { m21d = value.toDouble()}
    override var m22: Number
        get() = m22d
        set(value) { m22d = value.toDouble()}
    override var m23: Number
        get() = m23d
        set(value) { m23d = value.toDouble()}

    override var m30: Number
        get() = m30d
        set(value) { m30d = value.toDouble()}
    override var m31: Number
        get() = m31d
        set(value) { m31d = value.toDouble()}
    override var m32: Number
        get() = m32d
        set(value) { m32d = value.toDouble()}
    override var m33: Number
        get() = m33d
        set(value) { m33d = value.toDouble()}

    override fun toString(): String {
        return "Matrix4d: \n($m00, $m01, $m02, $m03,\n $m10, $m11, $m12, $m13,\n $m20, $m21, $m22, $m23,\n $m30, $m31, $m32, $m33)"
    }
}
//@formatter:on