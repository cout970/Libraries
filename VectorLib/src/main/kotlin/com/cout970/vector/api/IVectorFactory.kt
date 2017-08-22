package com.cout970.vector.api

import com.cout970.vector.impl.VectorFactory

/**
 * Created by cout970 on 18/08/2016.
 */
interface IVectorFactory {

    companion object {
        var factory: IVectorFactory = VectorFactory
    }

    fun vec2Of(x: Double, y: Double): IVector2
    fun mutableVec2Of(x: Double, y: Double): IMutableVector2

    fun vec3Of(x: Double, y: Double, z: Double): IVector3
    fun mutableVec3Of(x: Double, y: Double, z: Double): IMutableVector3

    fun vec4Of(x: Double, y: Double, z: Double, w: Double): IVector4
    fun mutableVec4Of(x: Double, y: Double, z: Double, w: Double): IMutableVector4

    fun quatOf(x: Double, y: Double, z: Double, w: Double): IQuaternion
    fun mutableQuatOf(x: Double, y: Double, z: Double, w: Double): IMutableQuaternion
}