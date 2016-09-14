package com.cout970.collision

import com.cout970.vector.api.IVector2

/**
 * Created by cout970 on 02/09/2016.
 */
interface IPolygon {

    fun getVertex(): List<IVector2>

    fun getEdges(): List<Pair<IVector2, IVector2>>
}