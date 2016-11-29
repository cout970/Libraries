package com.example

/**
 * Created by cout970 on 30/08/2016.
 */

//This requires CollisionLib, I don't want this dependency in this lib
//fun main(args: Array<String>) {
//
//    GLFWLoader.init()
//    val window = WindowBuilder.build {
//        size = vec2Of(800, 600)
//        vSync = false
//    }
//
//    val mouse = Mouse(window.id)
//    val t = Tessellator()
//    val shader = ShaderBuilder.build {
//        compile(GL20.GL_VERTEX_SHADER, shader_vertex)
//        compile(GL20.GL_FRAGMENT_SHADER, shader_fragment)
//        bindAttribute(0, "pos")
//        bindAttribute(1, "color")
//    }
//
//    val consumer = java.util.function.Consumer<VAO> {
//        it.bind()
//        it.bindAttrib()
//        it.draw()
//        it.unbindAttrib()
//        VAO.unbind()
//    }
//    var rot = 0.0
//
//    val frustum = Frustum(Math.toRadians(20.0), 800.0 / 600.0, 0.1, 0.3)
//
//    val boxes = (0..512).map {
//        Box3(vec3Of(((it % 16) - 8) * 1 / 20.0, ((it / 16) - 8) * 1 / 20.0, 0), vec3Of(0.05), Quaternion.IDENTITY)
//    }
//
////    GLStateMachine.clearColor = Color.CYAN.darker()
//    GLStateMachine.cullFace.disable()
//    val timer = Timer()
//
//    while (!window.shouldClose()) {
//        GLStateMachine.clear()
//
//        timer.tick()
//        window.setTitle("FPS: [${timer.fps}]")
//        rot += 0.25
//        mouse.update()
//        shader.start()
//
//        frustum.rotation = vec4Of(0, 1, 0, Math.toRadians(90.0)).fromAxisAngToQuat() * vec4Of(1, 0, 0, Math.toRadians(rot)).fromAxisAngToQuat()
//        var c = vec3Of(0)
//
//        t.draw(GL11.GL_LINES, FormatPC(), consumer) {
//            //+x
//            set(0, 0, 0, 0).set(1, 1, 0, 0).endVertex()
//            set(0, 1, 0, 0).set(1, 1, 0, 0).endVertex()
//            //+y
//            set(0, 0, 0, 0).set(1, 0, 1, 0).endVertex()
//            set(0, 0, 1, 0).set(1, 0, 1, 0).endVertex()
//            //+z
//            set(0, 0, 0, 0).set(1, 0, 0, 1).endVertex()
//            set(0, 0, 0, 1).set(1, 0, 0, 1).endVertex()
//
//            var time = System.nanoTime()
//            for (box in boxes) {
//                if (frustum.collide(box)) {
//                    c = vec3Of(1, 0, 0)
//                } else {
//                    c = vec3Of(1)
//                }
//
//                for (i in box.getEdges()) {
//                    set(0, i.first.x, i.first.y, i.first.z).set(1, c.x, c.y, c.z).endVertex()
//                    set(0, i.second.x, i.second.y, i.second.z).set(1, c.x, c.y, c.z).endVertex()
//                }
//            }
//            time = System.nanoTime() - time
//            println("time: ${time / (1000 * 1000 * 1000.0)}")
//            c = vec3Of(0, 1, 0)
//
//            for (i in frustum.getEdges()) {
//                set(0, i.first.x, i.first.y, i.first.z).set(1, c.x, c.y, c.z).endVertex()
//                set(0, i.second.x, i.second.y, i.second.z).set(1, c.x, c.y, c.z).endVertex()
//            }
//
//        }
//
//        window.swapBuffers()
//        EventManager.pollEvents()
//    }
//
//    GLFWLoader.terminate()
//}
//
//internal val shader_vertex = """
//#version 400 core
//
//in vec3 pos;
//in vec3 color;
//
//out vec3 pass_color;
//
//void main(){
//    gl_Position = vec4(pos, 1.0);
//    pass_color = color;
//}
//        """
//
//internal val shader_fragment = """
//#version 400 core
//
//in vec3 pass_color;
//
//out vec4 pixel;
//
//void main(){
//    pixel = vec4(pass_color, 1.0);
//}
//        """