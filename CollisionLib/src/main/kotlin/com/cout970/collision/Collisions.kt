package com.cout970.collision

import com.cout970.vector.api.IVector2
import com.cout970.vector.api.IVector3
import com.cout970.vector.extensions.*

/**
 * Created by cout970 on 01/09/2016.
 */

// 2D

fun IPolygon.collide(other: IPolygon): Boolean {

    val lines = (this.getEdges() + other.getEdges()).map { (it.second - it.first).normalize() }.distinct().map { it.rotate(90.0) }

    return lines.all { intersects(it, this, other) }
}

// 3D

fun IPolyhedron.collide(other: IPolyhedron): Boolean {

    val factor = 1024.0

    val lines = (this.getNormals() + other.getNormals()).map { it.normalize() }.map {
        it.transform { Math.round(it * factor) / factor }.normalize()
    }.map {
        if (it.xd < 0) {
            -it
        } else if (it.xd > 0) {
            it
        } else {
            if (it.zd < 0) {
                -it
            } else if (it.zd > 0) {
                it
            } else {
                if (it.yd < 0) {
                    -it
                } else {
                    it
                }
            }
        }
    }.map { it.transform { if (it == -0.0) 0.0 else it } }.distinct()

    return lines.all { intersects(it, this, other) }
}

//utilities

private fun intersects(line: IVector2, a: IPolygon, b: IPolygon): Boolean {
    var max0: Double = Double.NEGATIVE_INFINITY
    var min0: Double = Double.POSITIVE_INFINITY

    var max1: Double = Double.NEGATIVE_INFINITY
    var min1: Double = Double.POSITIVE_INFINITY

    for (i in a.getVertex()) {
        val r = line.project(i)
        if (r > max0) {
            max0 = r
        }
        if (r < min0) {
            min0 = r
        }
    }

    for (i in b.getVertex()) {
        val r = line.project(i)
        if (r > max1) {
            max1 = r
        }
        if (r < min1) {
            min1 = r
        }
    }

    return min1 <= max0 && max1 >= min0
}

private fun intersects(line: IVector3, a: IPolyhedron, b: IPolyhedron): Boolean {
    var max0: Double = Double.NEGATIVE_INFINITY
    var min0: Double = Double.POSITIVE_INFINITY

    var max1: Double = Double.NEGATIVE_INFINITY
    var min1: Double = Double.POSITIVE_INFINITY

    for (i in a.getVertex()) {
        val r = line.project(i)
        if (r > max0) {
            max0 = r
        }
        if (r < min0) {
            min0 = r
        }
    }

    for (i in b.getVertex()) {
        val r = line.project(i)
        if (r > max1) {
            max1 = r
        }
        if (r < min1) {
            min1 = r
        }
    }

    return min1 <= max0 && max1 >= min0
}

