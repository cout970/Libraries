package com.cout970.glutilities.tessellator

/**
 * Created by cout970 on 02/09/2016.
 */
interface ITessellator {

    fun start(format: IFormat)

    fun newSection(drawMode: Int)

    fun set(slot: Int, vararg data: Number):ITessellator

    fun endVertex()

    fun finish(builder: VaoBuilder)
}