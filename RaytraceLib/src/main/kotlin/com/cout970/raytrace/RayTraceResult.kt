package com.cout970.raytrace

import com.cout970.vector.api.IVector3

/**
 * Created by cout970 on 2016/09/03.
 *
 * This class represents the data of a hit between a ray and a IRayObstacle
 */
open class RayTraceResult(
        //the ray used to find the IRayObstacle object
        val ray: Ray,
        //the exact point where the ray hits the IRayObstacle object
        val hit: IVector3,
        //the object that collides with the ray
        val target: IRayObstacle
) {
    var extraData: Any? = null
}