package com.cout970.matrix.extensions

import com.cout970.matrix.api.IMatrix2
import com.cout970.matrix.api.IMatrix3
import com.cout970.matrix.api.IMatrix4
import com.cout970.matrix.api.IMutableMatrix4
import com.cout970.vector.api.IMutableVector3
import com.cout970.vector.api.IQuaternion
import com.cout970.vector.api.IVector2
import com.cout970.vector.api.IVector3
import com.cout970.vector.extensions.*

/**
 * Created by cout970 on 28/08/2016.
 */

//@formatter:off
fun IMatrix2.determinant() = m00d * m11d - m10d * m01d

fun IMatrix3.determinant() =
                (m00d * m11d - m01d * m10d) * m22d +
                (m02d * m10d - m00d * m12d) * m21d +
                (m01d * m12d - m02d * m11d) * m20d

fun IMatrix4.determinant() =
                (m00d * m11d - m01d * m10d) * (m22d * m33d - m23d * m32d) +
                (m02d * m10d - m00d * m12d) * (m21d * m33d - m23d * m31d) +
                (m00d * m13d - m03d * m10d) * (m21d * m32d - m22d * m31d) +
                (m01d * m12d - m02d * m11d) * (m20d * m33d - m23d * m30d) +
                (m03d * m11d - m01d * m13d) * (m20d * m32d - m22d * m30d) +
                (m02d * m13d - m03d * m12d) * (m20d * m31d - m21d * m30d)

fun IMatrix2.getInverse(): IMatrix2 {
    var s = determinant()
    s = 1.0 / s
    val m00 = m11d * s
    val m01 = m10d * s
    val m10 = m01d * s
    val m11 = m00d * s
    return mat2Of(m00, m01, m10, m11)
}

fun IMatrix3.getInverse(): IMatrix3 {
    var s = determinant()
    s = 1.0 / s
    val m00 = (m11d * m22d - m21d * m12d) * s
    val m01 = (m21d * m02d - m01d * m22d) * s
    val m02 = (m01d * m12d - m11d * m02d) * s
    val m10 = (m20d * m12d - m10d * m22d) * s
    val m11 = (m00d * m22d - m20d * m02d) * s
    val m12 = (m10d * m02d - m00d * m12d) * s
    val m20 = (m10d * m21d - m20d * m11d) * s
    val m21 = (m20d * m01d - m00d * m21d) * s
    val m22 = (m00d * m11d - m10d * m01d) * s
    return mat3Of(m00, m01, m02, m10, m11, m12, m20, m21, m22)
}
//@formatter:on

fun perspective(fov: Double, aspectRatio: Double, zFar: Double, zNear: Double): IMatrix4 {
    val aux = Math.tan(fov / 2)
    val m00 = 1 / aspectRatio * aux
    val m11 = 1 / aux
    val m22 = -(zFar + zNear) / (zFar - zNear)
    val m32 = -1
    val m23 = -(2 * zFar * zNear) / (zFar - zNear)
    //@formatter:off
    return mat4Of(
            m00, 0,   0,   0,
            0,   m11, 0,   0,
            0,   0,   m22, m23,
            0,   0,   m32, 0.0)
    //@formatter:on
}

fun ortho(right: Double, left: Double, top: Double, bottom: Double, zFar: Double, zNear: Double): IMatrix4 {
    val m00 = 2 / (right - left)
    val m11 = 2 / (top - bottom)
    val m22 = -2 / (zFar - zNear)
    val m33 = 1

    val m03 = -(right + left) / (right - left)
    val m13 = -(top + bottom) / (top - bottom)
    val m23 = -(zFar + zNear) / (zFar - zNear)
    //@formatter:off
    return mat4Of(
            m00, 0,   0,   m03,
            0,   m11, 0,   m13,
            0,   0,   m22, m23,
            0,   0,   0,   m33
    )
    //@formatter:on
}


fun IMutableMatrix4.translate(vec: IVector3) {
    m30d += vec.xd
    m31d += vec.yd
    m32d += vec.zd
}

fun IMutableMatrix4.rotate(vec: IQuaternion) {
    val other = vec.toMatrix()
    val nm00 = m00d * other.m00d + m10d * other.m01d + m20d * other.m02d
    val nm01 = m01d * other.m00d + m11d * other.m01d + m21d * other.m02d
    val nm02 = m02d * other.m00d + m12d * other.m01d + m22d * other.m02d
    val nm10 = m00d * other.m10d + m10d * other.m11d + m20d * other.m12d
    val nm11 = m01d * other.m10d + m11d * other.m11d + m21d * other.m12d
    val nm12 = m02d * other.m10d + m12d * other.m11d + m22d * other.m12d
    val nm20 = m00d * other.m20d + m10d * other.m21d + m20d * other.m22d
    val nm21 = m01d * other.m20d + m11d * other.m21d + m21d * other.m22d
    val nm22 = m02d * other.m20d + m12d * other.m21d + m22d * other.m22d
    this.m00 = nm00
    this.m01 = nm01
    this.m02 = nm02
    this.m10 = nm10
    this.m11 = nm11
    this.m12 = nm12
    this.m20 = nm20
    this.m21 = nm21
    this.m22 = nm22
}

fun IMutableMatrix4.scale(vec: IVector3) {
    m00d *= vec.xd
    m11d *= vec.yd
    m22d *= vec.zd
}

fun IMatrix2.transpose() = mat2Of(m00, m10, m01, m11)
fun IMatrix3.transpose() = mat3Of(m00, m10, m20, m01, m11, m21, m02, m12, m22)
fun IMatrix4.transpose() = mat4Of(m00, m10, m20, m30, m01, m11, m21, m31, m02, m12, m22, m32, m03, m13, m23, m33)

fun IQuaternion.toMatrix(): IMatrix3 {
    val x2 = xd + xd
    val y2 = yd + yd
    val z2 = zd + zd
    val x2sq = xd * x2
    val y2sq = yd * y2
    val z2sq = zd * z2
    val xy2 = xd * y2
    val xz2 = xd * z2
    val yz2 = yd * z2
    val wx2 = wd * x2
    val wy2 = wd * y2
    val wz2 = wd * z2
    return mat3Of(
            (1.0 - (y2sq + z2sq)), (xy2 - wz2), (xz2 + wy2),
            (xy2 + wz2), (1.0 - (x2sq + z2sq)), (yz2 - wx2),
            (xz2 - wy2), (yz2 + wx2), (1.0 - (x2sq + y2sq)))
}

fun IMatrix4.unproject(base: IVector3, viewportPos: IVector2, viewportSize: IVector2): IVector3 {
    val v = mutableVec3Of()
    unproject(base, viewportPos, viewportSize, v)
    return v
}

fun IMatrix4.unproject(base: IVector3, viewportPos: IVector2, viewportSize: IVector2, result: IMutableVector3) {
    val a = m00d * m11d - m01d * m10d
    val b = m00d * m12d - m02d * m10d
    val c = m00d * m13d - m03d * m10d
    val d = m01d * m12d - m02d * m11d
    val e = m01d * m13d - m03d * m11d
    val f = m02d * m13d - m03d * m12d
    val g = m20d * m31d - m21d * m30d
    val h = m20d * m32d - m22d * m30d
    val i = m20d * m33d - m23d * m30d
    val j = m21d * m32d - m22d * m31d
    val k = m21d * m33d - m23d * m31d
    val l = m22d * m33d - m23d * m32d
    var det = a * l - b * k + c * j + d * i - e * h + f * g
    det = 1.0 / det
    val im00 = (m11d * l - m12d * k + m13d * j) * det
    val im01 = (-m01d * l + m02d * k - m03d * j) * det
    val im02 = (m31d * f - m32d * e + m33d * d) * det
    val im03 = (-m21d * f + m22d * e - m23d * d) * det
    val im10 = (-m10d * l + m12d * i - m13d * h) * det
    val im11 = (m00d * l - m02d * i + m03d * h) * det
    val im12 = (-m30d * f + m32d * c - m33d * b) * det
    val im13 = (m20d * f - m22d * c + m23d * b) * det
    val im20 = (m10d * k - m11d * i + m13d * g) * det
    val im21 = (-m00d * k + m01d * i - m03d * g) * det
    val im22 = (m30d * e - m31d * c + m33d * a) * det
    val im23 = (-m20d * e + m21d * c - m23d * a) * det
    val im30 = (-m10d * j + m11d * h - m12d * g) * det
    val im31 = (m00d * j - m01d * h + m02d * g) * det
    val im32 = (-m30d * d + m31d * b - m32d * a) * det
    val im33 = (m20d * d - m21d * b + m22d * a) * det
    val ndcX = (base.xd - viewportPos.xd) / viewportSize.xd * 2.0 - 1.0
    val ndcY = (base.yd - viewportPos.yd) / viewportSize.yd * 2.0 - 1.0
    val ndcZ = base.zd + base.zd - 1.0
    val w = im03 * ndcX + im13 * ndcY + im23 * ndcZ + im33
    result.x = (im00 * ndcX + im10 * ndcY + im20 * ndcZ + im30) / w
    result.y = (im01 * ndcX + im11 * ndcY + im21 * ndcZ + im31) / w
    result.z = (im02 * ndcX + im12 * ndcY + im22 * ndcZ + im32) / w
}