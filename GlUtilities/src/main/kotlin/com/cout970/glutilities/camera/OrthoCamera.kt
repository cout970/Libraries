package com.cout970.glutilities.camera

import com.cout970.matrix.extensions.ProjectionMatrixFactory


/**
 * Created by cout970 on 30/07/2016.
 */
/**
 * Implementation of Camera using an Orthographic projection
 */
open class OrthoCamera(
        var left: Double = -0.5,
        var right: Double = 0.5,
        var bottom: Double = -0.5,
        var top: Double = 0.5,
        var zNear: Double,
        var zFar: Double
) : AbstractCamera() {

    override fun getProjection() = ProjectionMatrixFactory.ortho(left, right, bottom, top, zNear, zFar)
}