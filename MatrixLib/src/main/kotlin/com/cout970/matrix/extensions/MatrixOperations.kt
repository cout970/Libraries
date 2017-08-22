package com.cout970.matrix.extensions

import com.cout970.matrix.api.IMatrix2
import com.cout970.matrix.api.IMatrix3
import com.cout970.matrix.api.IMatrix4
import com.cout970.vector.api.IVector2
import com.cout970.vector.api.IVector3
import com.cout970.vector.api.IVector4
import com.cout970.vector.extensions.vec2Of
import com.cout970.vector.extensions.vec3Of
import com.cout970.vector.extensions.vec4Of

/**
 * Created by cout970 on 27/08/2016.
 */

//plus '+'

operator fun IMatrix2.plus(other: IMatrix2): IMatrix2 = mat2Of(
        m00d + other.m00d, m01d + other.m01d,
        m10d + other.m10d, m11d + other.m11d)

operator fun IMatrix3.plus(other: IMatrix3): IMatrix3 = mat3Of(
        m00d + other.m00d, m01d + other.m01d, m02d + other.m02d,
        m10d + other.m10d, m11d + other.m11d, m12d + other.m12d,
        m20d + other.m20d, m21d + other.m21d, m22d + other.m22d)

operator fun IMatrix4.plus(other: IMatrix4): IMatrix4 = mat4Of(
        m00d + other.m00d, m01d + other.m01d, m02d + other.m02d, m03d + other.m03d,
        m10d + other.m10d, m11d + other.m11d, m12d + other.m12d, m13d + other.m13d,
        m20d + other.m20d, m21d + other.m21d, m22d + other.m22d, m23d + other.m23d,
        m30d + other.m30d, m31d + other.m31d, m32d + other.m32d, m33d + other.m33d)

//minus '-'

operator fun IMatrix2.minus(other: IMatrix2): IMatrix2 = mat2Of(
        m00d - other.m00d, m01d - other.m01d,
        m10d - other.m10d, m11d - other.m11d)

operator fun IMatrix3.minus(other: IMatrix3): IMatrix3 = mat3Of(
        m00d - other.m00d, m01d - other.m01d, m02d - other.m02d,
        m10d - other.m10d, m11d - other.m11d, m12d - other.m12d,
        m20d - other.m20d, m21d - other.m21d, m22d - other.m22d)

operator fun IMatrix4.minus(other: IMatrix4): IMatrix4 = mat4Of(
        m00d - other.m00d, m01d - other.m01d, m02d - other.m02d, m03d - other.m03d,
        m10d - other.m10d, m11d - other.m11d, m12d - other.m12d, m13d - other.m13d,
        m20d - other.m20d, m21d - other.m21d, m22d - other.m22d, m23d - other.m23d,
        m30d - other.m30d, m31d - other.m31d, m32d - other.m32d, m33d - other.m33d)

operator fun IMatrix2.times(other: IMatrix2): IMatrix2 {
    val nm00 = m00d * other.m00d + m10d * other.m01d
    val nm01 = m01d * other.m00d + m11d * other.m01d
    val nm10 = m00d * other.m10d + m10d * other.m11d
    val nm11 = m01d * other.m10d + m11d * other.m11d
    return mat2Of(nm00, nm01, nm10, nm11)
}

//times '*'

operator fun IMatrix3.times(other: IMatrix3): IMatrix3 {
    val nm00 = m00d * other.m00d + m10d * other.m01d + m20d * other.m02d
    val nm01 = m01d * other.m00d + m11d * other.m01d + m21d * other.m02d
    val nm02 = m02d * other.m00d + m12d * other.m01d + m22d * other.m02d
    val nm10 = m00d * other.m10d + m10d * other.m11d + m20d * other.m12d
    val nm11 = m01d * other.m10d + m11d * other.m11d + m21d * other.m12d
    val nm12 = m02d * other.m10d + m12d * other.m11d + m22d * other.m12d
    val nm20 = m00d * other.m20d + m10d * other.m21d + m20d * other.m22d
    val nm21 = m01d * other.m20d + m11d * other.m21d + m21d * other.m22d
    val nm22 = m02d * other.m20d + m12d * other.m21d + m22d * other.m22d
    return mat3Of(nm00, nm01, nm02, nm10, nm11, nm12, nm20, nm21, nm22)
}

operator fun IMatrix4.times(other: IMatrix4): IMatrix4 {
    val nm00 = m00d * other.m00d + m10d * other.m01d + m20d * other.m02d + m30d * other.m03d
    val nm01 = m01d * other.m00d + m11d * other.m01d + m21d * other.m02d + m31d * other.m03d
    val nm02 = m02d * other.m00d + m12d * other.m01d + m22d * other.m02d + m32d * other.m03d
    val nm03 = m03d * other.m00d + m13d * other.m01d + m23d * other.m02d + m33d * other.m03d
    val nm10 = m00d * other.m10d + m10d * other.m11d + m20d * other.m12d + m30d * other.m13d
    val nm11 = m01d * other.m10d + m11d * other.m11d + m21d * other.m12d + m31d * other.m13d
    val nm12 = m02d * other.m10d + m12d * other.m11d + m22d * other.m12d + m32d * other.m13d
    val nm13 = m03d * other.m10d + m13d * other.m11d + m23d * other.m12d + m33d * other.m13d
    val nm20 = m00d * other.m20d + m10d * other.m21d + m20d * other.m22d + m30d * other.m23d
    val nm21 = m01d * other.m20d + m11d * other.m21d + m21d * other.m22d + m31d * other.m23d
    val nm22 = m02d * other.m20d + m12d * other.m21d + m22d * other.m22d + m32d * other.m23d
    val nm23 = m03d * other.m20d + m13d * other.m21d + m23d * other.m22d + m33d * other.m23d
    val nm30 = m00d * other.m30d + m10d * other.m31d + m20d * other.m32d + m30d * other.m33d
    val nm31 = m01d * other.m30d + m11d * other.m31d + m21d * other.m32d + m31d * other.m33d
    val nm32 = m02d * other.m30d + m12d * other.m31d + m22d * other.m32d + m32d * other.m33d
    val nm33 = m03d * other.m30d + m13d * other.m31d + m23d * other.m32d + m33d * other.m33d
    return mat4Of(nm00, nm01, nm02, nm03, nm10, nm11, nm12, nm13, nm20, nm21, nm22, nm23, nm30, nm31, nm32, nm33)
}

//vector transformation

operator fun IVector2.times(other: IMatrix2): IVector2 {
    return vec2Of(
            x = this.xd * other.m00d + this.yd * other.m10d,
            y = this.xd * other.m01d + this.yd * other.m11d)
}

operator fun IVector3.times(other: IMatrix3): IVector3 {
    return vec3Of(
            x = this.xd * other.m00d + this.yd * other.m10d + this.zd * other.m20d,
            y = this.xd * other.m01d + this.yd * other.m11d + this.zd * other.m21d,
            z = this.xd * other.m02d + this.yd * other.m12d + this.zd * other.m22d)
}

operator fun IVector4.times(other: IMatrix4): IVector4 {
    return vec4Of(
            x = this.xd * other.m00d + this.yd * other.m10d + this.zd * other.m20d + this.wd * other.m30d,
            y = this.xd * other.m01d + this.yd * other.m11d + this.zd * other.m21d + this.wd * other.m31d,
            z = this.xd * other.m02d + this.yd * other.m12d + this.zd * other.m22d + this.wd * other.m32d,
            w = this.xd * other.m03d + this.yd * other.m13d + this.zd * other.m23d + this.wd * other.m33d)
}