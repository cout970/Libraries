package com.cout970.matrix.extensions

import com.cout970.matrix.api.IMatrix4
import com.cout970.vector.api.IQuaternion
import com.cout970.vector.api.IVector3

/**
 * Created by cout970 on 27/08/2016.
 */

object Matrix2 {
    val IDENTITY = mat2Of(1)
}

object Matrix3 {
    val IDENTITY = mat3Of(1)
}

object Matrix4 {
    val IDENTITY = mat4Of(1)

    fun lookAt(pos: IVector3, lookPoint: IVector3, up: IVector3): IMatrix4 {
        val eyeX = pos.xd
        val eyeY = pos.yd
        val eyeZ = pos.zd
        val centerX = lookPoint.xd
        val centerY = lookPoint.yd
        val centerZ = lookPoint.zd
        val upX = up.xd
        val upY = up.yd
        val upZ = up.zd

        var dirX = eyeX - centerX
        var dirY = eyeY - centerY
        var dirZ = eyeZ - centerZ

        val invDirLength = 1.0 / Math.sqrt(dirX * dirX + dirY * dirY + dirZ * dirZ)
        dirX *= invDirLength
        dirY *= invDirLength
        dirZ *= invDirLength

        var leftX = upY * dirZ - upZ * dirY
        var leftY = upZ * dirX - upX * dirZ
        var leftZ = upX * dirY - upY * dirX

        val invLeftLength = 1.0 / Math.sqrt(leftX * leftX + leftY * leftY + leftZ * leftZ)
        leftX *= invLeftLength
        leftY *= invLeftLength
        leftZ *= invLeftLength

        val upnX = dirY * leftZ - dirZ * leftY
        val upnY = dirZ * leftX - dirX * leftZ
        val upnZ = dirX * leftY - dirY * leftX

        return mutableMat4Of(1).apply {
            m00 = leftX
            m01 = upnX
            m02 = dirX
            m03 = 0.0
            m10 = leftY
            m11 = upnY
            m12 = dirY
            m13 = 0.0
            m20 = leftZ
            m21 = upnZ
            m22 = dirZ
            m23 = 0.0
            m30 = -(leftX * eyeX + leftY * eyeY + leftZ * eyeZ)
            m31 = -(upnX * eyeX + upnY * eyeY + upnZ * eyeZ)
            m32 = -(dirX * eyeX + dirY * eyeY + dirZ * eyeZ)
            m33 = 1.0
        }
    }

    fun perspective(fov: Double, aspectRatio: Double, zFar: Double, zNear: Double): IMatrix4 {
        val aux = Math.tan(fov / 2.0)
        val m00 = 1 / (aspectRatio * aux)
        val m11 = 1 / aux
        val m22 = (zFar + zNear) / (zFar - zNear)
        val m23 = -1
        val m32 = (2 * zFar * zNear) / (zFar - zNear)
        //@formatter:off
        return mat4Of(
                m00, 0,   0,   0,
                0,   m11, 0,   0,
                0,   0,   m22, m23,
                0,   0,   m32, 0.0)
        //@formatter:on
    }

    fun ortho(left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): IMatrix4 {
        val m00 = 2 / (right - left)
        val m11 = 2 / (top - bottom)
        val m22 = -2 / (zFar - zNear)
        val m33 = 1

        val m30 = -(right + left) / (right - left)
        val m31 = -(top + bottom) / (top - bottom)
        val m32 = -(zFar + zNear) / (zFar - zNear)
        //@formatter:off
        return mat4Of(
                m00 = m00, m01 = 0,   m02 = 0,   m03 = 0,
                m10 = 0,   m11 = m11, m12 = 0,   m13 = 0,
                m20 = 0,   m21 = 0,   m22 = m22, m23 = 0,
                m30 = m30, m31 = m31, m32 = m32, m33 = m33
        )
        //@formatter:on
    }

    fun trs(translation: IVector3, rotation: IQuaternion, scale: IVector3): IMatrix4 {
        val w2 = rotation.wd * rotation.wd
        val x2 = rotation.xd * rotation.xd
        val y2 = rotation.yd * rotation.yd
        val z2 = rotation.zd * rotation.zd
        val zw = rotation.zd * rotation.wd
        val xy = rotation.xd * rotation.yd
        val xz = rotation.xd * rotation.zd
        val yw = rotation.yd * rotation.wd
        val yz = rotation.yd * rotation.zd
        val xw = rotation.xd * rotation.wd

        val m00 = (w2 + x2 - z2 - y2) * scale.xd
        val m01 = (xy + zw + zw + xy) * scale.xd
        val m02 = (xz - yw + xz - yw) * scale.xd
        val m03 = 0.0

        val m10 = (-zw + xy - zw + xy) * scale.yd
        val m11 = (y2 - z2 + w2 - x2) * scale.yd
        val m12 = (yz + yz + xw + xw) * scale.yd
        val m13 = 0.0

        val m20 = (yw + xz + xz + yw) * scale.zd
        val m21 = (yz + yz - xw - xw) * scale.zd
        val m22 = (z2 - y2 - x2 + w2) * scale.zd
        val m23 = 0.0

        val m30 = translation.xd
        val m31 = translation.yd
        val m32 = translation.zd
        val m33 = 1.0

        return mat4Of(
            m00 = m00, m01 = m01, m02 = m02, m03 = m03,
            m10 = m10, m11 = m11, m12 = m12, m13 = m13,
            m20 = m20, m21 = m21, m22 = m22, m23 = m23,
            m30 = m30, m31 = m31, m32 = m32, m33 = m33
        )
    }
}