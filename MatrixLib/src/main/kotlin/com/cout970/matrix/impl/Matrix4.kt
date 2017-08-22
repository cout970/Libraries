package com.cout970.matrix.impl

import com.cout970.matrix.api.IMatrix4
import com.cout970.matrix.api.IMutableMatrix4

/**
 * Created by cout970 on 24/08/2016.
 */

data class Matrix4i(
        override val m00i: Int,
        override val m01i: Int,
        override val m02i: Int,
        override val m03i: Int,

        override val m10i: Int,
        override val m11i: Int,
        override val m12i: Int,
        override val m13i: Int,

        override val m20i: Int,
        override val m21i: Int,
        override val m22i: Int,
        override val m23i: Int,

        override val m30i: Int,
        override val m31i: Int,
        override val m32i: Int,
        override val m33i: Int
) : IMatrix4 {

    override val m00: Number get() = m00i
    override val m01: Number get() = m01i
    override val m02: Number get() = m02i
    override val m03: Number get() = m03i

    override val m10: Number get() = m10i
    override val m11: Number get() = m11i
    override val m12: Number get() = m12i
    override val m13: Number get() = m13i

    override val m20: Number get() = m20i
    override val m21: Number get() = m21i
    override val m22: Number get() = m22i
    override val m23: Number get() = m23i

    override val m30: Number get() = m30i
    override val m31: Number get() = m31i
    override val m32: Number get() = m32i
    override val m33: Number get() = m33i

    override fun toString(): String {
        return "Matrix4i: \n($m00, $m01, $m02, $m03,\n $m10, $m11, $m12, $m13,\n $m20, $m21, $m22, $m23,\n $m30, $m31, $m32, $m33)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is IMatrix4) return false

        if (m00i != other.m00i) return false
        if (m01i != other.m01i) return false
        if (m02i != other.m02i) return false
        if (m03i != other.m03i) return false
        if (m10i != other.m10i) return false
        if (m11i != other.m11i) return false
        if (m12i != other.m12i) return false
        if (m13i != other.m13i) return false
        if (m20i != other.m20i) return false
        if (m21i != other.m21i) return false
        if (m22i != other.m22i) return false
        if (m23i != other.m23i) return false
        if (m30i != other.m30i) return false
        if (m31i != other.m31i) return false
        if (m32i != other.m32i) return false
        if (m33i != other.m33i) return false

        return true
    }

    override fun hashCode(): Int {
        var result = m00i
        result = 31 * result + m01i
        result = 31 * result + m02i
        result = 31 * result + m03i
        result = 31 * result + m10i
        result = 31 * result + m11i
        result = 31 * result + m12i
        result = 31 * result + m13i
        result = 31 * result + m20i
        result = 31 * result + m21i
        result = 31 * result + m22i
        result = 31 * result + m23i
        result = 31 * result + m30i
        result = 31 * result + m31i
        result = 31 * result + m32i
        result = 31 * result + m33i
        return result
    }
}

data class Matrix4f(
        override val m00f: Float,
        override val m01f: Float,
        override val m02f: Float,
        override val m03f: Float,

        override val m10f: Float,
        override val m11f: Float,
        override val m12f: Float,
        override val m13f: Float,

        override val m20f: Float,
        override val m21f: Float,
        override val m22f: Float,
        override val m23f: Float,

        override val m30f: Float,
        override val m31f: Float,
        override val m32f: Float,
        override val m33f: Float
) : IMatrix4 {

    override val m00: Number get() = m00f
    override val m01: Number get() = m01f
    override val m02: Number get() = m02f
    override val m03: Number get() = m03f

    override val m10: Number get() = m10f
    override val m11: Number get() = m11f
    override val m12: Number get() = m12f
    override val m13: Number get() = m13f

    override val m20: Number get() = m20f
    override val m21: Number get() = m21f
    override val m22: Number get() = m22f
    override val m23: Number get() = m23f

    override val m30: Number get() = m30f
    override val m31: Number get() = m31f
    override val m32: Number get() = m32f
    override val m33: Number get() = m33f

    override fun toString(): String {
        return "Matrix4f: \n($m00, $m01, $m02, $m03,\n $m10, $m11, $m12, $m13,\n $m20, $m21, $m22, $m23,\n $m30, $m31, $m32, $m33)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is IMatrix4) return false

        if (m00f != other.m00f) return false
        if (m01f != other.m01f) return false
        if (m02f != other.m02f) return false
        if (m03f != other.m03f) return false
        if (m10f != other.m10f) return false
        if (m11f != other.m11f) return false
        if (m12f != other.m12f) return false
        if (m13f != other.m13f) return false
        if (m20f != other.m20f) return false
        if (m21f != other.m21f) return false
        if (m22f != other.m22f) return false
        if (m23f != other.m23f) return false
        if (m30f != other.m30f) return false
        if (m31f != other.m31f) return false
        if (m32f != other.m32f) return false
        if (m33f != other.m33f) return false

        return true
    }

    override fun hashCode(): Int {
        var result = m00f.hashCode()
        result = 31 * result + m01f.hashCode()
        result = 31 * result + m02f.hashCode()
        result = 31 * result + m03f.hashCode()
        result = 31 * result + m10f.hashCode()
        result = 31 * result + m11f.hashCode()
        result = 31 * result + m12f.hashCode()
        result = 31 * result + m13f.hashCode()
        result = 31 * result + m20f.hashCode()
        result = 31 * result + m21f.hashCode()
        result = 31 * result + m22f.hashCode()
        result = 31 * result + m23f.hashCode()
        result = 31 * result + m30f.hashCode()
        result = 31 * result + m31f.hashCode()
        result = 31 * result + m32f.hashCode()
        result = 31 * result + m33f.hashCode()
        return result
    }
}

data class Matrix4d(
        override val m00d: Double,
        override val m01d: Double,
        override val m02d: Double,
        override val m03d: Double,

        override val m10d: Double,
        override val m11d: Double,
        override val m12d: Double,
        override val m13d: Double,

        override val m20d: Double,
        override val m21d: Double,
        override val m22d: Double,
        override val m23d: Double,

        override val m30d: Double,
        override val m31d: Double,
        override val m32d: Double,
        override val m33d: Double
) : IMatrix4 {

    override val m00: Number get() = m00d
    override val m01: Number get() = m01d
    override val m02: Number get() = m02d
    override val m03: Number get() = m03d

    override val m10: Number get() = m10d
    override val m11: Number get() = m11d
    override val m12: Number get() = m12d
    override val m13: Number get() = m13d

    override val m20: Number get() = m20d
    override val m21: Number get() = m21d
    override val m22: Number get() = m22d
    override val m23: Number get() = m23d

    override val m30: Number get() = m30d
    override val m31: Number get() = m31d
    override val m32: Number get() = m32d
    override val m33: Number get() = m33d

    override fun toString(): String {
        return "Matrix4d: \n($m00, $m01, $m02, $m03,\n $m10, $m11, $m12, $m13,\n $m20, $m21, $m22, $m23,\n $m30, $m31, $m32, $m33)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is IMatrix4) return false

        if (m00d != other.m00d) return false
        if (m01d != other.m01d) return false
        if (m02d != other.m02d) return false
        if (m03d != other.m03d) return false
        if (m10d != other.m10d) return false
        if (m11d != other.m11d) return false
        if (m12d != other.m12d) return false
        if (m13d != other.m13d) return false
        if (m20d != other.m20d) return false
        if (m21d != other.m21d) return false
        if (m22d != other.m22d) return false
        if (m23d != other.m23d) return false
        if (m30d != other.m30d) return false
        if (m31d != other.m31d) return false
        if (m32d != other.m32d) return false
        if (m33d != other.m33d) return false

        return true
    }

    override fun hashCode(): Int {
        var result = m00d.hashCode()
        result = 31 * result + m01d.hashCode()
        result = 31 * result + m02d.hashCode()
        result = 31 * result + m03d.hashCode()
        result = 31 * result + m10d.hashCode()
        result = 31 * result + m11d.hashCode()
        result = 31 * result + m12d.hashCode()
        result = 31 * result + m13d.hashCode()
        result = 31 * result + m20d.hashCode()
        result = 31 * result + m21d.hashCode()
        result = 31 * result + m22d.hashCode()
        result = 31 * result + m23d.hashCode()
        result = 31 * result + m30d.hashCode()
        result = 31 * result + m31d.hashCode()
        result = 31 * result + m32d.hashCode()
        result = 31 * result + m33d.hashCode()
        return result
    }
}

data class MutableMatrix4i(
        override var m00i: Int,
        override var m01i: Int,
        override var m02i: Int,
        override var m03i: Int,

        override var m10i: Int,
        override var m11i: Int,
        override var m12i: Int,
        override var m13i: Int,

        override var m20i: Int,
        override var m21i: Int,
        override var m22i: Int,
        override var m23i: Int,

        override var m30i: Int,
        override var m31i: Int,
        override var m32i: Int,
        override var m33i: Int
) : IMutableMatrix4 {

    //@formatter:off
    override var m00: Number get() = m00i; set(value) { m00i = value.toInt()}
    override var m01: Number get() = m01i; set(value) { m01i = value.toInt()}
    override var m02: Number get() = m02i; set(value) { m02i = value.toInt()}
    override var m03: Number get() = m03i; set(value) { m03i = value.toInt()}

    override var m10: Number get() = m10i; set(value) { m10i = value.toInt()}
    override var m11: Number get() = m11i; set(value) { m11i = value.toInt()}
    override var m12: Number get() = m12i; set(value) { m12i = value.toInt()}
    override var m13: Number get() = m13i; set(value) { m13i = value.toInt()}

    override var m20: Number get() = m20i; set(value) { m20i = value.toInt()}
    override var m21: Number get() = m21i; set(value) { m21i = value.toInt()}
    override var m22: Number get() = m22i; set(value) { m22i = value.toInt()}
    override var m23: Number get() = m23i; set(value) { m23i = value.toInt()}

    override var m30: Number get() = m30i; set(value) { m30i = value.toInt()}
    override var m31: Number get() = m31i; set(value) { m31i = value.toInt()}
    override var m32: Number get() = m32i; set(value) { m32i = value.toInt()}
    override var m33: Number get() = m33i; set(value) { m33i = value.toInt()}
    //@formatter:on

    override fun toString(): String {
        return "Matrix4i: \n($m00, $m01, $m02, $m03,\n $m10, $m11, $m12, $m13,\n $m20, $m21, $m22, $m23,\n $m30, $m31, $m32, $m33)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is IMatrix4) return false

        if (m00i != other.m00i) return false
        if (m01i != other.m01i) return false
        if (m02i != other.m02i) return false
        if (m03i != other.m03i) return false
        if (m10i != other.m10i) return false
        if (m11i != other.m11i) return false
        if (m12i != other.m12i) return false
        if (m13i != other.m13i) return false
        if (m20i != other.m20i) return false
        if (m21i != other.m21i) return false
        if (m22i != other.m22i) return false
        if (m23i != other.m23i) return false
        if (m30i != other.m30i) return false
        if (m31i != other.m31i) return false
        if (m32i != other.m32i) return false
        if (m33i != other.m33i) return false

        return true
    }

    override fun hashCode(): Int {
        var result = m00i
        result = 31 * result + m01i
        result = 31 * result + m02i
        result = 31 * result + m03i
        result = 31 * result + m10i
        result = 31 * result + m11i
        result = 31 * result + m12i
        result = 31 * result + m13i
        result = 31 * result + m20i
        result = 31 * result + m21i
        result = 31 * result + m22i
        result = 31 * result + m23i
        result = 31 * result + m30i
        result = 31 * result + m31i
        result = 31 * result + m32i
        result = 31 * result + m33i
        return result
    }
}

data class MutableMatrix4f(
        override var m00f: Float,
        override var m01f: Float,
        override var m02f: Float,
        override var m03f: Float,

        override var m10f: Float,
        override var m11f: Float,
        override var m12f: Float,
        override var m13f: Float,

        override var m20f: Float,
        override var m21f: Float,
        override var m22f: Float,
        override var m23f: Float,

        override var m30f: Float,
        override var m31f: Float,
        override var m32f: Float,
        override var m33f: Float
) : IMutableMatrix4 {

    //@formatter:off
    override var m00: Number get() = m00f; set(value) { m00f = value.toFloat()}
    override var m01: Number get() = m01f; set(value) { m01f = value.toFloat()}
    override var m02: Number get() = m02f; set(value) { m02f = value.toFloat()}
    override var m03: Number get() = m03f; set(value) { m03f = value.toFloat()}

    override var m10: Number get() = m10f; set(value) { m10f = value.toFloat()}
    override var m11: Number get() = m11f; set(value) { m11f = value.toFloat()}
    override var m12: Number get() = m12f; set(value) { m12f = value.toFloat()}
    override var m13: Number get() = m13f; set(value) { m13f = value.toFloat()}

    override var m20: Number get() = m20f; set(value) { m20f = value.toFloat()}
    override var m21: Number get() = m21f; set(value) { m21f = value.toFloat()}
    override var m22: Number get() = m22f; set(value) { m22f = value.toFloat()}
    override var m23: Number get() = m23f; set(value) { m23f = value.toFloat()}

    override var m30: Number get() = m30f; set(value) { m30f = value.toFloat()}
    override var m31: Number get() = m31f; set(value) { m31f = value.toFloat()}
    override var m32: Number get() = m32f; set(value) { m32f = value.toFloat()}
    override var m33: Number get() = m33f; set(value) { m33f = value.toFloat()}
    //@formatter:on

    override fun toString(): String {
        return "Matrix4f: \n($m00, $m01, $m02, $m03,\n $m10, $m11, $m12, $m13,\n $m20, $m21, $m22, $m23,\n $m30, $m31, $m32, $m33)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is IMatrix4) return false

        if (m00f != other.m00f) return false
        if (m01f != other.m01f) return false
        if (m02f != other.m02f) return false
        if (m03f != other.m03f) return false
        if (m10f != other.m10f) return false
        if (m11f != other.m11f) return false
        if (m12f != other.m12f) return false
        if (m13f != other.m13f) return false
        if (m20f != other.m20f) return false
        if (m21f != other.m21f) return false
        if (m22f != other.m22f) return false
        if (m23f != other.m23f) return false
        if (m30f != other.m30f) return false
        if (m31f != other.m31f) return false
        if (m32f != other.m32f) return false
        if (m33f != other.m33f) return false

        return true
    }

    override fun hashCode(): Int {
        var result = m00f.hashCode()
        result = 31 * result + m01f.hashCode()
        result = 31 * result + m02f.hashCode()
        result = 31 * result + m03f.hashCode()
        result = 31 * result + m10f.hashCode()
        result = 31 * result + m11f.hashCode()
        result = 31 * result + m12f.hashCode()
        result = 31 * result + m13f.hashCode()
        result = 31 * result + m20f.hashCode()
        result = 31 * result + m21f.hashCode()
        result = 31 * result + m22f.hashCode()
        result = 31 * result + m23f.hashCode()
        result = 31 * result + m30f.hashCode()
        result = 31 * result + m31f.hashCode()
        result = 31 * result + m32f.hashCode()
        result = 31 * result + m33f.hashCode()
        return result
    }


}

data class MutableMatrix4d(
        override var m00d: Double,
        override var m01d: Double,
        override var m02d: Double,
        override var m03d: Double,

        override var m10d: Double,
        override var m11d: Double,
        override var m12d: Double,
        override var m13d: Double,

        override var m20d: Double,
        override var m21d: Double,
        override var m22d: Double,
        override var m23d: Double,

        override var m30d: Double,
        override var m31d: Double,
        override var m32d: Double,
        override var m33d: Double
) : IMutableMatrix4 {

    //@formatter:off
    override var m00: Number get() = m00d; set(value) { m00d = value.toDouble()}
    override var m01: Number get() = m01d; set(value) { m01d = value.toDouble()}
    override var m02: Number get() = m02d; set(value) { m02d = value.toDouble()}
    override var m03: Number get() = m03d; set(value) { m03d = value.toDouble()}

    override var m10: Number get() = m10d; set(value) { m10d = value.toDouble()}
    override var m11: Number get() = m11d; set(value) { m11d = value.toDouble()}
    override var m12: Number get() = m12d; set(value) { m12d = value.toDouble()}
    override var m13: Number get() = m13d; set(value) { m13d = value.toDouble()}

    override var m20: Number get() = m20d; set(value) { m20d = value.toDouble()}
    override var m21: Number get() = m21d; set(value) { m21d = value.toDouble()}
    override var m22: Number get() = m22d; set(value) { m22d = value.toDouble()}
    override var m23: Number get() = m23d; set(value) { m23d = value.toDouble()}

    override var m30: Number get() = m30d; set(value) { m30d = value.toDouble()}
    override var m31: Number get() = m31d; set(value) { m31d = value.toDouble()}
    override var m32: Number get() = m32d; set(value) { m32d = value.toDouble()}
    override var m33: Number get() = m33d; set(value) { m33d = value.toDouble()}
    //@formatter:on

    override fun toString(): String {
        return "Matrix4d: \n($m00, $m01, $m02, $m03,\n $m10, $m11, $m12, $m13,\n $m20, $m21, $m22, $m23,\n $m30, $m31, $m32, $m33)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is IMatrix4) return false

        if (m00d != other.m00d) return false
        if (m01d != other.m01d) return false
        if (m02d != other.m02d) return false
        if (m03d != other.m03d) return false
        if (m10d != other.m10d) return false
        if (m11d != other.m11d) return false
        if (m12d != other.m12d) return false
        if (m13d != other.m13d) return false
        if (m20d != other.m20d) return false
        if (m21d != other.m21d) return false
        if (m22d != other.m22d) return false
        if (m23d != other.m23d) return false
        if (m30d != other.m30d) return false
        if (m31d != other.m31d) return false
        if (m32d != other.m32d) return false
        if (m33d != other.m33d) return false

        return true
    }

    override fun hashCode(): Int {
        var result = m00d.hashCode()
        result = 31 * result + m01d.hashCode()
        result = 31 * result + m02d.hashCode()
        result = 31 * result + m03d.hashCode()
        result = 31 * result + m10d.hashCode()
        result = 31 * result + m11d.hashCode()
        result = 31 * result + m12d.hashCode()
        result = 31 * result + m13d.hashCode()
        result = 31 * result + m20d.hashCode()
        result = 31 * result + m21d.hashCode()
        result = 31 * result + m22d.hashCode()
        result = 31 * result + m23d.hashCode()
        result = 31 * result + m30d.hashCode()
        result = 31 * result + m31d.hashCode()
        result = 31 * result + m32d.hashCode()
        result = 31 * result + m33d.hashCode()
        return result
    }
}