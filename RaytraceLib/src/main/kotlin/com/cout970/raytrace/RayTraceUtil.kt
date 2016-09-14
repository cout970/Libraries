package com.cout970.raytrace


import com.cout970.vector.api.IVector3
import com.cout970.vector.extensions.*

/**
 * Created by cout970 on 31/07/2016.
 */

object RayTraceUtil {

    val EPSILON = 1.0000000116860974E-7

    fun rayTraceQuad(ray: Ray, obstacle: IRayObstacle, a: IVector3, b: IVector3, c: IVector3, d: IVector3): RayTraceResult? {
        val r0 = rayTraceTriangle(ray, obstacle, a, b, c)
        if (r0 != null) {
            return r0
        }
        val r1 = rayTraceTriangle(ray, obstacle, a, d, c)
        if (r1 != null) {
            return r1
        }
        return null
    }

    fun rayTraceTriangle(ray: Ray, obstacle: IRayObstacle, a: IVector3, b: IVector3, c: IVector3): RayTraceResult? {
        val i = intersectionPlane(ray, a, b, c) ?: return null

        val edge0 = b - a
        val edge1 = c - b
        val edge2 = a - c

        val C0 = i - a
        val C1 = i - b
        val C2 = i - c

        val ab = b - a
        val ac = c - a
        val N = ab cross ac

        if (N dot (edge0 cross C0) >= 0 &&
                N dot (edge1 cross C1) >= 0 &&
                N dot (edge2 cross C2) >= 0) {
            return RayTraceResult(ray, i, obstacle)
        }
        return null
    }

    private fun intersectionPlane(r: Ray, a: IVector3, b: IVector3, c: IVector3): IVector3? {
        val ab = b - a
        val ac = c - a
        val n = ab cross ac
        val v = r.end - r.start
        val w = a - r.start
        val div = v dot n
        if (Math.abs(div) < 0.0000000001) {
            return null
        }
        val k = (w dot n) / (v dot n)
        return r.start + v * k
    }

    fun rayTraceBox3(boxStart: IVector3, boxEnd: IVector3, ray: Ray, obstacle: IRayObstacle): RayTraceResult? {
        val start = ray.start
        val end = ray.end

        var minX = getIntermediateWithXValue(start, end, boxStart.xd)
        var maxX = getIntermediateWithXValue(start, end, boxEnd.xd)
        var minY = getIntermediateWithYValue(start, end, boxStart.yd)
        var maxY = getIntermediateWithYValue(start, end, boxEnd.yd)
        var minZ = getIntermediateWithZValue(start, end, boxStart.zd)
        var maxZ = getIntermediateWithZValue(start, end, boxEnd.zd)

        if (!isVecInsideYZBounds(minX, boxStart, boxEnd)) {
            minX = null
        }

        if (!isVecInsideYZBounds(maxX, boxStart, boxEnd)) {
            maxX = null
        }

        if (!isVecInsideXZBounds(minY, boxStart, boxEnd)) {
            minY = null
        }

        if (!isVecInsideXZBounds(maxY, boxStart, boxEnd)) {
            maxY = null
        }

        if (!isVecInsideXYBounds(minZ, boxStart, boxEnd)) {
            minZ = null
        }

        if (!isVecInsideXYBounds(maxZ, boxStart, boxEnd)) {
            maxZ = null
        }

        var result: IVector3? = null

        if (minX != null) {
            result = minX
        }

        if (maxX != null && (result == null || start.distanceSq(maxX) < start.distanceSq(result))) {
            result = maxX
        }

        if (minY != null && (result == null || start.distanceSq(minY) < start.distanceSq(result))) {
            result = minY
        }

        if (maxY != null && (result == null || start.distanceSq(maxY) < start.distanceSq(result))) {
            result = maxY
        }

        if (minZ != null && (result == null || start.distanceSq(minZ) < start.distanceSq(result))) {
            result = minZ
        }

        if (maxZ != null && (result == null || start.distanceSq(maxZ) < start.distanceSq(result))) {
            result = maxZ
        }

        if (result == null) {
            return null
        } else {
            return RayTraceResult(ray, result, obstacle)
        }
    }

    fun isVecInsideYZBounds(point: IVector3?, boxStart: IVector3, boxEnd: IVector3): Boolean {
        return point != null && point.yd >= boxStart.yd && point.yd <= boxEnd.yd && point.zd >= boxStart.zd && point.zd <= boxEnd.zd
    }

    fun isVecInsideXZBounds(point: IVector3?, boxStart: IVector3, boxEnd: IVector3): Boolean {
        return point != null && point.xd >= boxStart.xd && point.xd <= boxEnd.xd && point.zd >= boxStart.zd && point.zd <= boxEnd.zd
    }

    fun isVecInsideXYBounds(point: IVector3?, boxStart: IVector3, boxEnd: IVector3): Boolean {
        return point != null && point.xd >= boxStart.xd && point.xd <= boxEnd.xd && point.yd >= boxStart.yd && point.yd <= boxEnd.yd
    }


    fun getIntermediateWithXValue(start: IVector3, end: IVector3, x: Double): IVector3? {
        val diff = end - start

        if (diff.xd * diff.xd < EPSILON) {
            return null
        } else {
            val d3 = (x - start.xd) / diff.xd
            return if (d3 >= 0.0 && d3 <= 1.0) start + (diff * d3) else null
        }
    }

    fun getIntermediateWithYValue(start: IVector3, end: IVector3, y: Double): IVector3? {
        val diff = end - start

        if (diff.yd * diff.yd < EPSILON) {
            return null
        } else {
            val d3 = (y - start.yd) / diff.yd
            return if (d3 >= 0.0 && d3 <= 1.0) start + (diff * d3) else null
        }
    }

    fun getIntermediateWithZValue(start: IVector3, end: IVector3, z: Double): IVector3? {
        val diff = end - start

        if (diff.zd * diff.zd < EPSILON) {
            return null
        } else {
            val d3 = (z - start.zd) / diff.zd
            return if (d3 >= 0.0 && d3 <= 1.0) start + (diff * d3) else null
        }
    }
}
