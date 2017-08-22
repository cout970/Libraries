package com.cout970.matrix.api

/**
 * Created by cout970 on 24/08/2016.
 */
interface IMutableMatrix3 : IMatrix3 {
    override var m00: Number
    override var m01: Number
    override var m02: Number

    override var m10: Number
    override var m11: Number
    override var m12: Number

    override var m20: Number
    override var m21: Number
    override var m22: Number

    // Int
    override var m00i: Int get() = m00.toInt(); set(i) { m00 = i}
    override var m01i: Int get() = m01.toInt(); set(i) { m01 = i}
    override var m02i: Int get() = m02.toInt(); set(i) { m02 = i}

    override var m10i: Int get() = m10.toInt(); set(i) { m10 = i}
    override var m11i: Int get() = m11.toInt(); set(i) { m11 = i}
    override var m12i: Int get() = m12.toInt(); set(i) { m12 = i}

    override var m20i: Int get() = m20.toInt(); set(i) { m20 = i}
    override var m21i: Int get() = m21.toInt(); set(i) { m21 = i}
    override var m22i: Int get() = m22.toInt(); set(i) { m22 = i}

    // Float
    override var m00f: Float get() = m00.toFloat(); set(i) { m00 = i}
    override var m01f: Float get() = m01.toFloat(); set(i) { m01 = i}
    override var m02f: Float get() = m02.toFloat(); set(i) { m02 = i}

    override var m10f: Float get() = m10.toFloat(); set(i) { m10 = i}
    override var m11f: Float get() = m11.toFloat(); set(i) { m11 = i}
    override var m12f: Float get() = m12.toFloat(); set(i) { m12 = i}

    override var m20f: Float get() = m20.toFloat(); set(i) { m20 = i}
    override var m21f: Float get() = m21.toFloat(); set(i) { m21 = i}
    override var m22f: Float get() = m22.toFloat(); set(i) { m22 = i}

    // Double
    override var m00d: Double get() = m00.toDouble(); set(i) { m00 = i}
    override var m01d: Double get() = m01.toDouble(); set(i) { m01 = i}
    override var m02d: Double get() = m02.toDouble(); set(i) { m02 = i}

    override var m10d: Double get() = m10.toDouble(); set(i) { m10 = i}
    override var m11d: Double get() = m11.toDouble(); set(i) { m11 = i}
    override var m12d: Double get() = m12.toDouble(); set(i) { m12 = i}

    override var m20d: Double get() = m20.toDouble(); set(i) { m20 = i}
    override var m21d: Double get() = m21.toDouble(); set(i) { m21 = i}
    override var m22d: Double get() = m22.toDouble(); set(i) { m22 = i}
}