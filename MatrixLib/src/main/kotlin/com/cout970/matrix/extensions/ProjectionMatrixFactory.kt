package com.cout970.matrix.extensions

import com.cout970.matrix.api.IMatrix4
import com.cout970.vector.api.IVector3

/**
 * Created by cout970 on 2017/08/21.
 */
object ProjectionMatrixFactory {

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

        return mutableMat4Of(1).apply {
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
}