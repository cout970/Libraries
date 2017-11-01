package com.cout970.glutilities.camera

import com.cout970.matrix.api.IMatrix4
import com.cout970.vector.api.IVector2

/**
 * Created by cout970 on 30/08/2016.
 */
interface ICamera {

    fun getVPMatrix(viewPort: IVector2): IMatrix4

    fun getView(): IMatrix4

    fun getProjection(viewPort: IVector2): IMatrix4
}