package com.cout970.glutilities.tessellator

import com.cout970.glutilities.util.FloatArrayList
import com.cout970.vector.api.IVector2
import com.cout970.vector.api.IVector3

/**
 * Created by cout970 on 2017/09/08.
 */

class BufferPTC {

    private val regions = mutableListOf<Pair<DrawMode, Int>>()
    private var vertex = 0
    private var mode: DrawMode? = null

    private val pos = FloatArrayList()
    private val tex = FloatArrayList()
    private val col = FloatArrayList()

    fun newRegion(mode: DrawMode) {
        this.mode?.let {
            regions.add(Pair(it, vertex))
            vertex = 0
        }
        this.mode = mode
    }

    fun add(vpos: IVector2, vtex: IVector2, vcol: IVector3) {
        vertex++
        pos.add(vpos.xf)
        pos.add(vpos.yf)
        tex.add(vtex.xf)
        tex.add(vtex.yf)
        col.add(vcol.xf)
        col.add(vcol.yf)
        col.add(vcol.zf)
    }

    fun build(mode: DrawMode, longUse: Boolean = true, func: BufferPTC.() -> Unit): VAO {
        var vao: VAO? = null
        this.mode = mode
        pos.clear()
        tex.clear()
        col.clear()
        vertex = 0
        func(this)
        regions.add(Pair(mode, vertex))

        pos.useAsBuffer(tex, col) { pos, tex, col ->
            val builder = VaoBuilder(longUse)
            builder.bindAttrib(0, pos, 2)
            builder.bindAttrib(1, tex, 2)
            builder.bindAttrib(2, col, 3)
            regions.forEach { builder.addRegion(it.first, it.second) }
            regions.clear()
            vao = builder.build()
        }
        Statistics.buildVaoCount++
        return vao!!
    }
}