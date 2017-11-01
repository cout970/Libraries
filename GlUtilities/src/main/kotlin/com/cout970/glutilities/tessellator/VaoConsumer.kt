package com.cout970.glutilities.tessellator

import java.util.function.Consumer

/**
 * Created by cout970 on 2017/09/08.
 */
open class VaoConsumer : Consumer<VAO> {

    override fun accept(it: VAO) {
        preRender(it)
        Statistics.drawVboCount += it.vboCount
        Statistics.drawRegionsCount += it.regions.size
        Statistics.drawVaoCount += 1
        render(it)
        postRender(it)
    }

    open fun preRender(it: VAO){
        it.bind()
        it.bindAttrib()
    }

    open fun render(it: VAO){
        it.draw()
    }

    open fun postRender(it: VAO){
        it.unbindAttrib()
        VAO.unbind()
    }
}