package com.cout970.matrix.api

/**
 * Created by cout970 on 24/08/2016.
 */
interface IMutableMatrix3 : IMatrix3, IMutableMatrix2 {
    override var m00: Number
    override var m01: Number
    override var m02: Number

    override var m10: Number
    override var m11: Number
    override var m12: Number

    override var m20: Number
    override var m21: Number
    override var m22: Number
}