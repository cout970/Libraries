package com.cout970.matrix.api

/**
 * Created by cout970 on 24/08/2016.
 */
interface IMutableMatrix2 : IMatrix2 {
    override var m00: Number
    override var m01: Number
    override var m10: Number
    override var m11: Number

    
    // Int
    override var m00i: Int get() = m00.toInt(); set(i) { m00 = i}
    override var m01i: Int get() = m01.toInt(); set(i) { m00 = i}

    override var m10i: Int get() = m10.toInt(); set(i) { m00 = i}
    override var m11i: Int get() = m11.toInt(); set(i) { m00 = i}

    // Float
    override var m00f: Float get() = m00.toFloat(); set(i) { m00 = i}
    override var m01f: Float get() = m01.toFloat(); set(i) { m00 = i}

    override var m10f: Float get() = m10.toFloat(); set(i) { m00 = i}
    override var m11f: Float get() = m11.toFloat(); set(i) { m00 = i}

    // Double
    override var m00d: Double get() = m00.toDouble(); set(i) { m00 = i}
    override var m01d: Double get() = m01.toDouble(); set(i) { m00 = i}

    override var m10d: Double get() = m10.toDouble(); set(i) { m00 = i}
    override var m11d: Double get() = m11.toDouble(); set(i) { m00 = i}
}