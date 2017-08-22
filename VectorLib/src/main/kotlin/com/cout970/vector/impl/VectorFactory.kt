package com.cout970.vector.impl

import com.cout970.vector.api.*

/**
 * Created by cout970 on 18/08/2016.
 */
object VectorFactory : IVectorFactory {

    override fun vec2Of(x: Double, y: Double): IVector2 = Vector2d(x, y)

    override fun mutableVec2Of(x: Double, y: Double): IMutableVector2 = MutableVector2d(x, y)

    override fun vec3Of(x: Double, y: Double, z: Double): IVector3 = Vector3d(x, y, z)

    override fun mutableVec3Of(x: Double, y: Double, z: Double): IMutableVector3 = MutableVector3d(x, y, z)

    override fun vec4Of(x: Double, y: Double, z: Double, w: Double): IVector4 = Vector4d(x, y, z, w)

    override fun mutableVec4Of(x: Double, y: Double, z: Double, w: Double): IMutableVector4 = MutableVector4d(x, y, z, w)

    override fun quatOf(x: Double, y: Double, z: Double, w: Double): IQuaternion = Quaterniond(x, y, z, w)

    override fun mutableQuatOf(x: Double, y: Double, z: Double, w: Double): IMutableQuaternion = MutableQuaterniond(x, y, z, w)
}