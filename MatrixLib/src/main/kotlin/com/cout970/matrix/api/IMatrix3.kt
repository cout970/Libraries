package com.cout970.matrix.api

/**
 * Created by cout970 on 24/08/2016.
 */
interface IMatrix3 : IMatrix2 {
    override val m00: Number
    override val m01: Number
    val m02: Number

    override val m10: Number
    override val m11: Number
    val m12: Number

    val m20: Number
    val m21: Number
    val m22: Number
}