package com.cout970.collision

import com.cout970.vector.api.IVector2
import com.cout970.vector.extensions.plus
import com.cout970.vector.extensions.rotate
import com.cout970.vector.extensions.vec2Of

/**
 * Created by cout970 on 01/09/2016.
 */
interface IBox2 : IPolygon {

    val pos: IVector2
    val size: IVector2
    val rotation: Double

    override fun getVertex() = listOf(vec2Of(0, 0), vec2Of(size.x, 0), vec2Of(size.x, size.y), vec2Of(0, size.y))
            .map { it.rotate(rotation) + pos }

    override fun getEdges(): List<Pair<IVector2, IVector2>> = listOf(
            vec2Of(0, 0) to vec2Of(size.x, 0),
            vec2Of(size.x, 0) to vec2Of(size.x, size.y),
            vec2Of(size.x, size.y) to vec2Of(0, size.y),
            vec2Of(0, size.y) to vec2Of(0, 0))
            .map { (it.first.rotate(rotation) + pos) to (it.second.rotate(rotation) + pos) }
}