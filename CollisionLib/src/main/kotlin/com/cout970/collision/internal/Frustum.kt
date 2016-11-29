package com.cout970.collision.internal

import com.cout970.collision.IFrustum
import com.cout970.vector.api.IQuaternion
import com.cout970.vector.api.IVector3
import com.cout970.vector.extensions.Quaternion

/**
 * Created by cout970 on 2016/09/04.
 */
class Frustum(fov: Double, aspectRatio: Double, zNear: Double, zFar: Double) : IFrustum {

    private var dirty = true

    override var fov: Double = fov
        set(i) { field = i; dirty = true }
    override var aspectRatio: Double = aspectRatio
        set(i) { field = i; dirty = true }
    override var zNear: Double = zNear
        set(i) { field = i; dirty = true }
    override var zFar: Double = zFar
        set(i) { field = i; dirty = true }
    override var rotation: IQuaternion = Quaternion.IDENTITY
        set(i) { field = i; dirty = true }

    private var vertexCache = listOf<IVector3>()
    private var normalCache = listOf<IVector3>()
    private var edgeCache = listOf<Pair<IVector3, IVector3>>()

    override fun getVertex(): List<IVector3> {
        if(dirty){
            vertexCache = super.getVertex()
        }
        return vertexCache
    }

    override fun getEdges(): List<Pair<IVector3, IVector3>> {
        if(dirty){
            edgeCache = super.getEdges()
        }
        return edgeCache
    }

    override fun getNormals(): List<IVector3> {
        if(dirty){
            normalCache = super.getNormals()
        }
        return normalCache
    }
}