package com.cout970.vector.extensions

import com.cout970.vector.api.*

/**
 * Created by cout970 on 17/08/2016.
 */

//Int

val IVector2.xi: Int get() = x.toInt()
val IVector2.yi: Int get() = y.toInt()
val IVector3.zi: Int get() = z.toInt()
val IVector4.wi: Int get() = w.toInt()

//@formatter:off
var IMutableVector2.xi: Int get() = x.toInt(); set(i) { x = i }
var IMutableVector2.yi: Int get() = y.toInt(); set(i) { y = i }
var IMutableVector3.zi: Int get() = z.toInt(); set(i) { z = i }
var IMutableVector4.wi: Int get() = w.toInt(); set(i) { w = i }
//@formatter:on

//Float

val IVector2.xf: Float get() = x.toFloat()
val IVector2.yf: Float get() = y.toFloat()
val IVector3.zf: Float get() = z.toFloat()
val IVector4.wf: Float get() = w.toFloat()

//@formatter:off
var IMutableVector2.xf: Float get() = x.toFloat(); set(i) { x = i }
var IMutableVector2.yf: Float get() = y.toFloat(); set(i) { y = i }
var IMutableVector3.zf: Float get() = z.toFloat(); set(i) { z = i }
var IMutableVector4.wf: Float get() = w.toFloat(); set(i) { w = i }
//@formatter:on

//Double

val IVector2.xd: Double get() = x.toDouble()
val IVector2.yd: Double get() = y.toDouble()
val IVector3.zd: Double get() = z.toDouble()
val IVector4.wd: Double get() = w.toDouble()

//@formatter:off
var IMutableVector2.xd: Double get() = x.toDouble(); set(i) { x = i }
var IMutableVector2.yd: Double get() = y.toDouble(); set(i) { y = i }
var IMutableVector3.zd: Double get() = z.toDouble(); set(i) { z = i }
var IMutableVector4.wd: Double get() = w.toDouble(); set(i) { w = i }
//@formatter:on

