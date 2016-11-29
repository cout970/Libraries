package com.cout970.matrix.api

/**
 * Created by cout970 on 24/08/2016.
 */
interface IMatrix4 : IMatrix3 {

    override val m00: Number
    override val m01: Number
    override val m02: Number
    val m03: Number

    override val m10: Number
    override val m11: Number
    override val m12: Number
    val m13: Number

    override val m20: Number
    override val m21: Number
    override val m22: Number
    val m23: Number

    val m30: Number
    val m31: Number
    val m32: Number
    val m33: Number
}