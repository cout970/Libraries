package com.cout970.raytrace

import com.cout970.vector.api.IVector3
import com.cout970.vector.extensions.minus
import com.cout970.vector.extensions.plus
import com.cout970.vector.extensions.times


/**
 * Created by cout970 on 31/07/2016.
 *
 * This data class represent a ray in 3D space
 */
data class Ray(
        val start: IVector3,
        val end: IVector3
) {

    /**
     * Gets a point between the start and the end of this ray using linear interpolation
     */
    fun interpolate(percent: Double) = start + (end - start) * percent
}