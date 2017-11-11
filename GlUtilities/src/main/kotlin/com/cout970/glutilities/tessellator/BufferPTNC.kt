package com.cout970.glutilities.tessellator

import com.cout970.glutilities.util.FloatArrayList
import com.cout970.vector.api.IVector2
import com.cout970.vector.api.IVector3

/**
 * Created by cout970 on 2017/09/08.
 */

class BufferPTNC {

    private val regions = mutableListOf<Pair<DrawMode, Int>>()
    private var vertex = 0
    private var mode: DrawMode? = null

    private val pos = FloatArrayList()
    private val tex = FloatArrayList()
    private val norm = FloatArrayList()
    private val col = FloatArrayList()

    fun newRegion(mode: DrawMode) {
        this.mode?.let {
            regions.add(Pair(mode, vertex))
            vertex = 0
        }
        this.mode = mode
    }

    fun add(vpos: IVector3, vtex: IVector2, vnorm: IVector3, vcol: IVector3) {
        vertex++
        pos.add(vpos.xf)
        pos.add(vpos.yf)
        pos.add(vpos.zf)
        tex.add(vtex.xf)
        tex.add(vtex.yf)
        norm.add(vnorm.xf)
        norm.add(vnorm.yf)
        norm.add(vnorm.zf)
        col.add(vcol.xf)
        col.add(vcol.yf)
        col.add(vcol.zf)
    }

    fun build(mode: DrawMode, longUse: Boolean = true, func: BufferPTNC.() -> Unit): VAO {
        var vao: VAO? = null
        pos.clear()
        tex.clear()
        norm.clear()
        col.clear()
        vertex = 0
        this.mode = mode
        func(this)
        regions.add(Pair(mode, vertex))

        pos.useAsBuffer(tex, norm, col) { pos, tex, norm, col ->
            val builder = VaoBuilder(longUse)
            builder.bindAttrib(0, pos, 3)
            builder.bindAttrib(1, tex, 2)
            builder.bindAttrib(2, norm, 3)
            builder.bindAttrib(3, col, 3)
            regions.forEach { builder.addRegion(it.first, it.second) }
            regions.clear()
            vao = builder.build()
        }
        Statistics.buildVaoCount++
        return vao!!
    }
}