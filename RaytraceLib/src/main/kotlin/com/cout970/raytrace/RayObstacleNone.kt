package com.cout970.raytrace

/**
 * Created by cout970 on 2017/08/22.
 */
object RayObstacleNone : IRayObstacle {
    override fun rayTrace(ray: Ray): RayTraceResult? = null
}