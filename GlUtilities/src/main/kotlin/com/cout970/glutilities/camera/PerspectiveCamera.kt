package com.cout970.glutilities.camera

import com.cout970.matrix.extensions.perspective
import com.cout970.vector.api.IVector2
import com.cout970.vector.extensions.xd
import com.cout970.vector.extensions.yd

/**
 * Created by cout970 on 30/07/2016.
 */
/**
 * Implementation of Camera using a perspective projection
 */
open class PerspectiveCamera(
        var fov: Double,
        var aspect: Double,
        var nearPlane: Double,
        var farPlane: Double
) : AbstractCamera(){

    override fun getProjection() = perspective(fov, aspect, nearPlane, farPlane)

    override fun updateViewport(size: IVector2) {
        aspect = size.xd / size.yd
    }
}