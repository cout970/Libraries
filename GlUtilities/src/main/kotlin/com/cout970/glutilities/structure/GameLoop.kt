package com.cout970.glutilities.structure

/**
 * Created by cout970 on 11/08/2016.
 */
open class GameLoop(val tick: (GameLoop) -> Unit, val onStart: (GameLoop) -> Unit = {}) {

    var running = true
        private set

    fun start() {
        onStart(this)
        while (running) {
            tick(this)
        }
        running = true
    }

    fun stop() {
        running = false
    }
}