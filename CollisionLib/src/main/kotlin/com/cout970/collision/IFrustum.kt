package com.cout970.collision

import com.cout970.vector.api.IQuaternion
import com.cout970.vector.api.IVector3
import com.cout970.vector.extensions.*

/**
 * Created by cout970 on 02/09/2016.
 */
interface IFrustum : IPolyhedron {

    val fov: Double
    val aspectRatio: Double
    val zNear: Double
    val zFar: Double
    val rotation: IQuaternion

    override fun getVertex(): List<IVector3> {

        val upVector = Vector3.Y_AXIS.rotate(rotation)
        val rightVector = Vector3.X_AXIS.rotate(rotation)
        val frontVector = Vector3.Z_AXIS.rotate(rotation)

        val downVector = -upVector
        val leftVector = -rightVector
        val centerNear = frontVector * zNear
        val centerFar = frontVector * zFar

        val farWidth = zFar * Math.tan(fov)
        val farHeight = farWidth / aspectRatio
        val nearWidth = zNear * Math.tan(fov)
        val nearHeight = nearWidth / aspectRatio

        val farTop = centerFar + vec3Of(upVector.xd * farHeight, upVector.yd * farHeight, upVector.zd * farHeight)
        val farBottom = centerFar + vec3Of(downVector.xd * farHeight, downVector.yd * farHeight, downVector.zd * farHeight)
        val nearTop = centerNear + vec3Of(upVector.xd * nearHeight, upVector.yd * nearHeight, upVector.zd * nearHeight)
        val nearBottom = centerNear + vec3Of(downVector.xd * nearHeight, downVector.yd * nearHeight, downVector.zd * nearHeight)

        val getFrustumCorner = fun(startPoint: IVector3, direction: IVector3, width: Double): IVector3 {
            return startPoint + vec3Of(direction.xd * width, direction.yd * width, direction.zd * width)
        }

        return listOf(
                //far plane
                getFrustumCorner(farTop, rightVector, farWidth), //-x +y +z
                getFrustumCorner(farTop, leftVector, farWidth), //+x +y +z
                getFrustumCorner(farBottom, leftVector, farWidth), //+x -y +z
                getFrustumCorner(farBottom, rightVector, farWidth), //-x -y +z
                //near plane
                getFrustumCorner(nearTop, rightVector, nearWidth), //-x +y -z
                getFrustumCorner(nearTop, leftVector, nearWidth), //+x +y -z
                getFrustumCorner(nearBottom, leftVector, nearWidth), //+x -y -z
                getFrustumCorner(nearBottom, rightVector, nearWidth)    //-x -y -z
        )
    }

    override fun getEdges(): List<Pair<IVector3, IVector3>> {
        val vertex = getVertex()

        return listOf(
                vertex[0] to vertex[1],
                vertex[1] to vertex[2],
                vertex[2] to vertex[3],
                vertex[3] to vertex[0],

                vertex[4] to vertex[5],
                vertex[5] to vertex[6],
                vertex[6] to vertex[7],
                vertex[7] to vertex[4],

                vertex[0] to vertex[4],
                vertex[1] to vertex[5],
                vertex[2] to vertex[6],
                vertex[3] to vertex[7]
        )
    }

    override fun getNormals(): List<IVector3> {
        val vertex = getVertex()

        val frontNormal = Vector3.Z_AXIS.rotate(rotation)
        val backNormal = -frontNormal

        val normal = fun(a: IVector3, b: IVector3, c: IVector3) = (b - a) cross (c - a)

        val upNormal = normal(vertex[0], vertex[1], vertex[4])
        val downNormal = normal(vertex[2], vertex[3], vertex[6])
        val rightNormal = normal(vertex[0], vertex[3], vertex[4])
        val leftNormal = normal(vertex[1], vertex[2], vertex[5])

        return listOf(
                frontNormal,
                backNormal,
                upNormal,
                downNormal,
                rightNormal,
                leftNormal
        )
    }
}