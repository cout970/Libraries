package com.cout970.collision

import com.cout970.vector.api.IVector3

/**
 * Created by cout970 on 03/09/2016.
 */
interface IPolyhedron {

    fun getVertex(): List<IVector3>

    fun getEdges(): List<Pair<IVector3, IVector3>>

    fun getNormals(): List<IVector3>
}