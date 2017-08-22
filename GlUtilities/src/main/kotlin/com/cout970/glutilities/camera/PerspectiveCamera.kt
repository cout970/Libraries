package com.cout970.glutilities.camera

import com.cout970.matrix.extensions.ProjectionMatrixFactory
import com.cout970.vector.api.IVector2

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

    override fun getProjection() = ProjectionMatrixFactory.perspective(fov, aspect, nearPlane, farPlane)

    override fun updateViewport(size: IVector2) {
        aspect = size.xd / size.yd
    }
}