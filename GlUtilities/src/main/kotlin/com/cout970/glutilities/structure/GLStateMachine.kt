package com.cout970.glutilities.structure

import org.lwjgl.opengl.*
import org.lwjgl.opengl.GL11.*
import java.awt.Color

/**
 * Created by cout970 on 31/08/2016.
 */
object GLStateMachine {

    //GL11

    /**
     * If enabled, blend the computed fragment color values with the values in the color buffers. See glBlendFunc.
     */
    val blend = GLFlag(false, GL_BLEND)
    /**
     * If enabled, cull polygons based on their winding in window coordinates. See glCullFace.
     */
    val cullFace = GLFlag(false, GL_CULL_FACE)
    /**
     * If enabled, do depth comparisons and update the depth buffer. Note that even if the depth buffer exists and the
     * depth mask is non-zero, the depth buffer is not updated if the depth test is disabled. See glDepthFunc and glDepthRange.
     */
    val depthTest = GLFlag(false, GL_DEPTH_TEST)
    /**
     * If enabled, dither color components or indices before they are written to the color buffer.
     */
    val dither = GLFlag(true, GL_DITHER)
    /**
     * If enabled, draw lines with correct filtering. Otherwise, draw aliased lines. See glLineWidth.
     */
    val lineSmooth = GLFlag(false, GL_LINE_SMOOTH)
    /**
     * If enabled, apply the currently selected logical operation to the computed fragment color and color buffer
     * values. See glLogicOp.
     */
    val colorLogicOp = GLFlag(false, GL_COLOR_LOGIC_OP)
    /**
     * If enabled, and if the polygon is rendered in GL_FILL mode, an offset is added to depth values of a polygon's
     * fragments before the depth comparison is performed. See glPolygonOffset.
     */
    val polygonOffsetFill = GLFlag(false, GL_POLYGON_OFFSET_FILL)
    /**
     * If enabled, and if the polygon is rendered in GL_LINE mode, an offset is added to depth values of a polygon's
     * fragments before the depth comparison is performed. See glPolygonOffset.
     */
    val polygonOffsetLine = GLFlag(false, GL_POLYGON_OFFSET_LINE)
    /**
     * If enabled, an offset is added to depth values of a polygon's fragments before the depth comparison is performed,
     * if the polygon is rendered in GL_POINT mode. See glPolygonOffset.
     */
    val polygonOffsetPoint = GLFlag(false, GL_POLYGON_OFFSET_POINT)
    /**
     * If enabled, draw polygons with proper filtering. Otherwise, draw aliased polygons. For correct antialiased
     * polygons, an alpha buffer is needed and the polygons must be sorted front to back.
     */
    val polygonSmooth = GLFlag(false, GL_POLYGON_SMOOTH)
    /**
     * If enabled, discard fragments that are outside the scissor rectangle. See glScissor.
     */
    val scissorTest = GLFlag(false, GL_SCISSOR_TEST)
    /**
     * If enabled, do stencil testing and update the stencil buffer. See glStencilFunc and glStencilOp.
     */
    val stencilTest = GLFlag(false, GL_STENCIL_TEST)

    //GL13

    val multisample = GLFlag(false, GL13.GL_MULTISAMPLE)
    /**
     * If enabled, compute a temporary coverage value where each bit is determined by the alpha value at the
     * corresponding sample location. The temporary coverage value is then ANDed with the fragment coverage value.
     */
    val sampleAlphaToCoverage = GLFlag(false, GL13.GL_SAMPLE_ALPHA_TO_COVERAGE)
    /**
     * If enabled, each sample alpha value is replaced by the maximum representable alpha value.
     */
    val sampleAlphaToOne = GLFlag(false, GL13.GL_SAMPLE_ALPHA_TO_ONE)
    /**
     * If enabled, the fragment's coverage is ANDed with the temporary coverage value. If GL_SAMPLE_COVERAGE_INVERT
     * is set to GL_TRUE, invert the coverage value. See glSampleCoverage.
     */
    val sampleCoverage = GLFlag(false, GL13.GL_SAMPLE_COVERAGE)

    //GL30

    /**
     * If enabled, clip geometry against user-defined half space 0.
     */
    val clipDistance0 = GLFlag(false, GL30.GL_CLIP_DISTANCE0)
    /**
     * If enabled and the value of GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING for the framebuffer attachment
     * corresponding to the destination buffer is GL_SRGB, the R, G, and B destination color values (after
     * conversion from fixed-point to floating-point) are considered to be encoded for the sRGB color space and hence
     * are linearized prior to their use in blending.
     */
    val framebufferSRGB = GLFlag(false, GL30.GL_FRAMEBUFFER_SRGB)
    /**
     * If enabled, primitives are discarded after the optional transform feedback stage, but before rasterization.
     * Furthermore, when enabled, glClear, glClearBufferData, glClearBufferSubData, glClearTexImage, and
     * glClearTexSubImage are ignored.
     */
    val rasterizerDiscard = GLFlag(false, GL30.GL_RASTERIZER_DISCARD)

    //GL31

    /**
     * Enables primitive restarting. If enabled, any one of the draw commands which transfers a set of generic
     * attribute array elements to the GL will restart the primitive when the index of the vertex is equal to the
     * primitive restart index. See glPrimitiveRestartIndex.
     */
    val primitiveRestart = GLFlag(false, GL31.GL_PRIMITIVE_RESTART)

    //GL32

    /**
     * If enabled, the −wc ≤ zc ≤ wc plane equation is ignored by view volume clipping (effectively, there is no near
     * or far plane clipping). See glDepthRange.
     */
    val depthClamp = GLFlag(false, GL32.GL_DEPTH_CLAMP)
    /**
     * If enabled, the sample coverage mask generated for a fragment during rasterization will be ANDed with the value
     * of GL_SAMPLE_MASK_VALUE before shading occurs. See glSampleMaski.
     */
    val sampleMask = GLFlag(false, GL32.GL_SAMPLE_MASK)
    /**
     * If enabled, cubemap textures are sampled such that when linearly sampling from the border between two adjacent
     * faces, texels from both faces are used to generate the final sample value. When disabled, texels from only a
     * single face are used to construct the final sample value.
     */
    val textureCubeMapSeamless = GLFlag(false, GL32.GL_TEXTURE_CUBE_MAP_SEAMLESS)
    /**
     * If enabled and a vertex or geometry shader is active, then the derived point size is taken from the (potentially
     * clipped) shader builtin gl_PointSize and clamped to the implementation-dependent point size range.
     */
    val programPointSize = GLFlag(false, GL32.GL_PROGRAM_POINT_SIZE)

    //GL40

    /**
     * If enabled, the active fragment shader is run once for each covered sample, or at fraction of this rate as
     * determined by the current value of GL_MIN_SAMPLE_SHADING_VALUE. See glMinSampleShading.
     */
    val sampleShading = GLFlag(false, GL40.GL_SAMPLE_SHADING)

    //GL43

    /**
     * If enabled, debug messages are produced by a debug context. When disabled, the debug message log is silenced.
     * Note that in a non-debug context, very few, if any messages might be produced, even when GL_DEBUG_OUTPUT
     * is enabled.
     */
    val debugOutput = GLFlag(false, GL43.GL_DEBUG_OUTPUT)
    /**
     * If enabled, debug messages are produced synchronously by a debug context. If disabled, debug messages may be
     * produced asynchronously. In particular, they may be delayed relative to the execution of GL commands, and the
     * debug callback function may be called from a thread other than that in which the commands are executed.
     * See glDebugMessageCallback.
     */
    val debugOutputSync = GLFlag(false, GL43.GL_DEBUG_OUTPUT_SYNCHRONOUS)
    /**
     * Enables primitive restarting with a fixed index. If enabled, any one of the draw commands which transfers a set
     * of generic attribute array elements to the GL will restart the primitive when the index of the vertex is equal
     * to the fixed primitive index for the specified index type. The fixed index is equal to 2^n−1 where n is equal
     * to 8 for GL_UNSIGNED_BYTE, 16 for GL_UNSIGNED_SHORT and 32 for GL_UNSIGNED_INT.
     */
    val primitiveRestartFixedIndex = GLFlag(false, GL43.GL_PRIMITIVE_RESTART_FIXED_INDEX)

    //variables
    var clearColor: Color = Color(0, 0, 0, 0)
        set(c) {
            field = c; glClearColor(c.red / 255f, c.green / 255f, c.blue / 255f, c.alpha / 255f)
        }
    var stencilFunc: Triple<GLFunc, Int, Int> = Triple(GLFunc.ALWAYS, 0, -1)
        set(c) {
            field = c; glStencilFunc(c.first.id, c.second, c.third)
        }
    var blendFunc: Pair<BlendFunc, BlendFunc> = BlendFunc.ONE to BlendFunc.ZERO
        set(c) {
            field = c; glBlendFunc(c.first.id, c.second.id)
        }



    fun clear() {
        glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT or GL_STENCIL_BUFFER_BIT)
        glClearDepth(1.0)
    }

    fun pollErrors(): String? {
        val error = glGetError()
        if (error != GL_NO_ERROR) {
            when (error) {
                GL_INVALID_ENUM -> return "GL_INVALID_ENUM"
                GL_INVALID_VALUE -> return "GL_INVALID_VALUE"
                GL_INVALID_OPERATION -> return "GL_INVALID_OPERATION"
                GL_STACK_OVERFLOW -> return "GL_STACK_OVERFLOW"
                GL_STACK_UNDERFLOW -> return "GL_STACK_UNDERFLOW"
                GL_OUT_OF_MEMORY -> return "GL_OUT_OF_MEMORY"
                else -> return "Unknown Error"
            }
        }
        return null
    }

    fun setFlag(id: Int, value: Boolean) = if (value) glEnable(id) else glDisable(id)

    class GLFlag(default: Boolean, val id: Int) {

        var cache = default

        fun isEnable() = cache

        /**
         * Warning this function may be very slow, it's only needed if other lib or api
         * is changing the flags without using this class
         */
        fun update() {
            cache = glIsEnabled(id)
        }

        fun set(value: Boolean) {
            cache = value
            setFlag(id, value)
        }

        fun enable() {
            cache = true
            setFlag(id, true)
        }

        fun disable() {
            cache = false
            setFlag(id, false)
        }
    }

    enum class GLFunc(val id: Int) {
        //@formatter:off
        NEVER(GL11.GL_NEVER),       //Always fails.
        LESS(GL11.GL_LESS),         // <
        LEQUAL(GL11.GL_LEQUAL),     // <=
        GREATER(GL11.GL_GREATER),   // >
        GEQUAL(GL11.GL_GEQUAL),     // >=
        EQUAL(GL11.GL_EQUAL),       // ==
        NOTEQUAL(GL11.GL_NOTEQUAL), // !=
        ALWAYS(GL11.GL_ALWAYS)      //Always passes.
        //@formatter:on
    }

    enum class BlendFunc(val id: Int) {
        ZERO(GL11.GL_ZERO),
        ONE(GL11.GL_ONE),
        SRC_COLOR(GL11.GL_SRC_COLOR),
        ONE_MINUS_SRC_COLOR(GL11.GL_ONE_MINUS_SRC_COLOR),
        DST_COLOR(GL11.GL_DST_COLOR),
        ONE_MINUS_DST_COLOR(GL11.GL_ONE_MINUS_DST_COLOR),
        SRC_ALPHA(GL11.GL_SRC_ALPHA),
        ONE_MINUS_SRC_ALPHA(GL11.GL_ONE_MINUS_SRC_ALPHA),
        DST_ALPHA(GL11.GL_DST_ALPHA),
        ONE_MINUS_DST_ALPHA(GL11.GL_ONE_MINUS_DST_ALPHA),
        CONSTANT_COLOR(GL14.GL_CONSTANT_COLOR),
        ONE_MINUS_CONSTANT_COLOR(GL14.GL_ONE_MINUS_CONSTANT_COLOR),
        CONSTANT_ALPHA(GL14.GL_CONSTANT_ALPHA),
        ONE_MINUS_CONSTANT_ALPHA(GL14.GL_ONE_MINUS_CONSTANT_ALPHA),
        SRC_ALPHA_SATURATE(GL11.GL_SRC_ALPHA_SATURATE),
        SRC1_COLOR(GL33.GL_SRC1_COLOR),
        ONE_MINUS_SRC1_COLOR(GL33.GL_ONE_MINUS_SRC1_COLOR),
        SRC1_ALPHA(GL15.GL_SRC1_ALPHA),
        ONE_MINUS_SRC1_ALPHA(GL33.GL_ONE_MINUS_SRC1_ALPHA),
    }
}