package com.cout970.collision

import com.cout970.vector.api.IQuaternion
import com.cout970.vector.api.IVector3
import com.cout970.vector.extensions.*

/**
 * Created by cout970 on 01/09/2016.
 */
interface IBox3 : IPolyhedron {

    val pos: IVector3
    val size: IVector3
    val rotation: IQuaternion

    override fun getVertex() = listOf(
            vec3Of(0, 0, 0), vec3Of(0, 0, size.z), vec3Of(0, size.y, 0), vec3Of(0, size.y, size.z),
            vec3Of(size.x, 0, 0), vec3Of(size.x, 0, size.z), vec3Of(size.x, size.y, 0),
            vec3Of(size.x, size.y, size.z)).map { it.rotate(rotation) + pos }

    override fun getEdges(): List<Pair<IVector3, IVector3>> = listOf(
            (vec3Of(0.0, 0.0, 0.0).rotate(rotation) + pos) to (vec3Of(size.xd, 0.0, 0.0).rotate(rotation) + pos),
            (vec3Of(0.0, 0.0, 0.0).rotate(rotation) + pos) to (vec3Of(0.0, size.yd, 0.0).rotate(rotation) + pos),
            (vec3Of(0.0, 0.0, 0.0).rotate(rotation) + pos) to (vec3Of(0.0, 0.0, size.zd).rotate(rotation) + pos),
            (vec3Of(size.xd, size.yd, size.zd).rotate(rotation) + pos) to (vec3Of(0.0, size.yd, size.zd).rotate(rotation) + pos),
            (vec3Of(size.xd, size.yd, size.zd).rotate(rotation) + pos) to (vec3Of(size.xd, 0.0, size.zd).rotate(rotation) + pos),
            (vec3Of(size.xd, size.yd, size.zd).rotate(rotation) + pos) to (vec3Of(size.xd, size.yd, 0.0).rotate(rotation) + pos),
            (vec3Of(0.0, size.yd, 0.0).rotate(rotation) + pos) to (vec3Of(size.xd, size.yd, 0.0).rotate(rotation) + pos),
            (vec3Of(size.xd, 0.0, 0.0).rotate(rotation) + pos) to (vec3Of(size.xd, size.yd, 0.0).rotate(rotation) + pos),
            (vec3Of(0.0, size.yd, 0.0).rotate(rotation) + pos) to (vec3Of(0.0, size.yd, size.zd).rotate(rotation) + pos),
            (vec3Of(size.xd, 0.0, size.zd).rotate(rotation) + pos) to (vec3Of(0.0, 0.0, size.zd).rotate(rotation) + pos),
            (vec3Of(0.0, size.yd, size.zd).rotate(rotation) + pos) to (vec3Of(0.0, 0.0, size.zd).rotate(rotation) + pos),
            (vec3Of(size.xd, 0.0, size.zd).rotate(rotation) + pos) to (vec3Of(size.xd, 0.0, 0.0).rotate(rotation) + pos))

    override fun getNormals(): List<IVector3> = listOf(vec3Of(1, 0, 0), vec3Of(0, 1, 0), vec3Of(0, 0, 1), vec3Of(-1, 0, 0), vec3Of(0, -1, 0), vec3Of(0, 0, -1))
}