package com.cout970.glutilities.tessellator

/**
 * Created by cout970 on 02/09/2016.
 */
interface IFormat {

    fun getBuffers(): List<IBuffer>

    fun injectData(builder: VaoBuilder)

    fun reset()
}