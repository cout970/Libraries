package com.cout970.matrix.api

/**
 * Created by cout970 on 24/08/2016.
 */
interface IMutableMatrix4 : IMatrix4, IMutableMatrix3 {

    override var m00: Number
    override var m01: Number
    override var m02: Number
    override var m03: Number

    override var m10: Number
    override var m11: Number
    override var m12: Number
    override var m13: Number

    override var m20: Number
    override var m21: Number
    override var m22: Number
    override var m23: Number

    override var m30: Number
    override var m31: Number
    override var m32: Number
    override var m33: Number
}