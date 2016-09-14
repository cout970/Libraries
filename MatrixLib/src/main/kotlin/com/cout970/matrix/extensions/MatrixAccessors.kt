package com.cout970.matrix.extensions

import com.cout970.matrix.api.*

/**
 * Created by cout970 on 24/08/2016.
 */

// Int
val IMatrix2.m00i: Int get() = m00.toInt()
val IMatrix2.m01i: Int get() = m01.toInt()
val IMatrix3.m02i: Int get() = m02.toInt()
val IMatrix4.m03i: Int get() = m03.toInt()

val IMatrix2.m10i: Int get() = m10.toInt()
val IMatrix2.m11i: Int get() = m11.toInt()
val IMatrix3.m12i: Int get() = m12.toInt()
val IMatrix4.m13i: Int get() = m13.toInt()

val IMatrix3.m20i: Int get() = m20.toInt()
val IMatrix3.m21i: Int get() = m21.toInt()
val IMatrix3.m22i: Int get() = m22.toInt()
val IMatrix4.m23i: Int get() = m23.toInt()

val IMatrix4.m30i: Int get() = m30.toInt()
val IMatrix4.m31i: Int get() = m31.toInt()
val IMatrix4.m32i: Int get() = m32.toInt()
val IMatrix4.m33i: Int get() = m33.toInt()

//@formatter:off
var IMutableMatrix2.m00i: Int get() = m00.toInt(); set(i) { m00 = i}
var IMutableMatrix2.m01i: Int get() = m01.toInt(); set(i) { m00 = i}
var IMutableMatrix3.m02i: Int get() = m02.toInt(); set(i) { m00 = i}
var IMutableMatrix4.m03i: Int get() = m03.toInt(); set(i) { m00 = i}

var IMutableMatrix2.m10i: Int get() = m10.toInt(); set(i) { m00 = i}
var IMutableMatrix2.m11i: Int get() = m11.toInt(); set(i) { m00 = i}
var IMutableMatrix3.m12i: Int get() = m12.toInt(); set(i) { m00 = i}
var IMutableMatrix4.m13i: Int get() = m13.toInt(); set(i) { m00 = i}

var IMutableMatrix3.m20i: Int get() = m20.toInt(); set(i) { m00 = i}
var IMutableMatrix3.m21i: Int get() = m21.toInt(); set(i) { m00 = i}
var IMutableMatrix3.m22i: Int get() = m22.toInt(); set(i) { m00 = i}
var IMutableMatrix4.m23i: Int get() = m23.toInt(); set(i) { m00 = i}

var IMutableMatrix4.m30i: Int get() = m30.toInt(); set(i) { m00 = i}
var IMutableMatrix4.m31i: Int get() = m31.toInt(); set(i) { m00 = i}
var IMutableMatrix4.m32i: Int get() = m32.toInt(); set(i) { m00 = i}
var IMutableMatrix4.m33i: Int get() = m33.toInt(); set(i) { m00 = i}
//@formatter:on

// Float
val IMatrix2.m00f: Float get() = m00.toFloat()
val IMatrix2.m01f: Float get() = m01.toFloat()
val IMatrix3.m02f: Float get() = m02.toFloat()
val IMatrix4.m03f: Float get() = m03.toFloat()

val IMatrix2.m10f: Float get() = m10.toFloat()
val IMatrix2.m11f: Float get() = m11.toFloat()
val IMatrix3.m12f: Float get() = m12.toFloat()
val IMatrix4.m13f: Float get() = m13.toFloat()

val IMatrix3.m20f: Float get() = m20.toFloat()
val IMatrix3.m21f: Float get() = m21.toFloat()
val IMatrix3.m22f: Float get() = m22.toFloat()
val IMatrix4.m23f: Float get() = m23.toFloat()

val IMatrix4.m30f: Float get() = m30.toFloat()
val IMatrix4.m31f: Float get() = m31.toFloat()
val IMatrix4.m32f: Float get() = m32.toFloat()
val IMatrix4.m33f: Float get() = m33.toFloat()

//@formatter:off
var IMutableMatrix2.m00f: Float get() = m00.toFloat(); set(i) { m00 = i}
var IMutableMatrix2.m01f: Float get() = m01.toFloat(); set(i) { m00 = i}
var IMutableMatrix3.m02f: Float get() = m02.toFloat(); set(i) { m00 = i}
var IMutableMatrix4.m03f: Float get() = m03.toFloat(); set(i) { m00 = i}

var IMutableMatrix2.m10f: Float get() = m10.toFloat(); set(i) { m00 = i}
var IMutableMatrix2.m11f: Float get() = m11.toFloat(); set(i) { m00 = i}
var IMutableMatrix3.m12f: Float get() = m12.toFloat(); set(i) { m00 = i}
var IMutableMatrix4.m13f: Float get() = m13.toFloat(); set(i) { m00 = i}

var IMutableMatrix3.m20f: Float get() = m20.toFloat(); set(i) { m00 = i}
var IMutableMatrix3.m21f: Float get() = m21.toFloat(); set(i) { m00 = i}
var IMutableMatrix3.m22f: Float get() = m22.toFloat(); set(i) { m00 = i}
var IMutableMatrix4.m23f: Float get() = m23.toFloat(); set(i) { m00 = i}

var IMutableMatrix4.m30f: Float get() = m30.toFloat(); set(i) { m00 = i}
var IMutableMatrix4.m31f: Float get() = m31.toFloat(); set(i) { m00 = i}
var IMutableMatrix4.m32f: Float get() = m32.toFloat(); set(i) { m00 = i}
var IMutableMatrix4.m33f: Float get() = m33.toFloat(); set(i) { m00 = i}
//@formatter:on

// Double
val IMatrix2.m00d: Double get() = m00.toDouble()
val IMatrix2.m01d: Double get() = m01.toDouble()
val IMatrix3.m02d: Double get() = m02.toDouble()
val IMatrix4.m03d: Double get() = m03.toDouble()

val IMatrix2.m10d: Double get() = m10.toDouble()
val IMatrix2.m11d: Double get() = m11.toDouble()
val IMatrix3.m12d: Double get() = m12.toDouble()
val IMatrix4.m13d: Double get() = m13.toDouble()

val IMatrix3.m20d: Double get() = m20.toDouble()
val IMatrix3.m21d: Double get() = m21.toDouble()
val IMatrix3.m22d: Double get() = m22.toDouble()
val IMatrix4.m23d: Double get() = m23.toDouble()

val IMatrix4.m30d: Double get() = m30.toDouble()
val IMatrix4.m31d: Double get() = m31.toDouble()
val IMatrix4.m32d: Double get() = m32.toDouble()
val IMatrix4.m33d: Double get() = m33.toDouble()

//@formatter:off
var IMutableMatrix2.m00d: Double get() = m00.toDouble(); set(i) { m00 = i}
var IMutableMatrix2.m01d: Double get() = m01.toDouble(); set(i) { m00 = i}
var IMutableMatrix3.m02d: Double get() = m02.toDouble(); set(i) { m00 = i}
var IMutableMatrix4.m03d: Double get() = m03.toDouble(); set(i) { m00 = i}

var IMutableMatrix2.m10d: Double get() = m10.toDouble(); set(i) { m00 = i}
var IMutableMatrix2.m11d: Double get() = m11.toDouble(); set(i) { m00 = i}
var IMutableMatrix3.m12d: Double get() = m12.toDouble(); set(i) { m00 = i}
var IMutableMatrix4.m13d: Double get() = m13.toDouble(); set(i) { m00 = i}

var IMutableMatrix3.m20d: Double get() = m20.toDouble(); set(i) { m00 = i}
var IMutableMatrix3.m21d: Double get() = m21.toDouble(); set(i) { m00 = i}
var IMutableMatrix3.m22d: Double get() = m22.toDouble(); set(i) { m00 = i}
var IMutableMatrix4.m23d: Double get() = m23.toDouble(); set(i) { m00 = i}

var IMutableMatrix4.m30d: Double get() = m30.toDouble(); set(i) { m00 = i}
var IMutableMatrix4.m31d: Double get() = m31.toDouble(); set(i) { m00 = i}
var IMutableMatrix4.m32d: Double get() = m32.toDouble(); set(i) { m00 = i}
var IMutableMatrix4.m33d: Double get() = m33.toDouble(); set(i) { m00 = i}
//@formatter:on


