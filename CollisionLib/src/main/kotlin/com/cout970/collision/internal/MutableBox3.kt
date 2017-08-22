package com.cout970.collision.internal

import com.cout970.collision.IBox3
import com.cout970.vector.api.IQuaternion
import com.cout970.vector.api.IVector3

/**
 * Created by cout970 on 2016/09/04.
 */
class MutableBox3(pos: IVector3, size: IVector3, rot: IQuaternion) : IBox3 {

    private var dirty = true

    override var pos: IVector3 = pos
        set(i) { field = i; dirty = true }
    override var size: IVector3 = size
        set(i) { field = i; dirty = true }
    override var rotation: IQuaternion = rot
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