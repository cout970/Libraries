import com.cout970.matrix.api.IMatrix4
import com.cout970.matrix.extensions.mat4Of
import com.cout970.vector.api.IVector4
import com.cout970.vector.extensions.vec4Of
import org.joml.Matrix4d
import org.joml.Vector4d

/**
 * Created by cout970 on 2017/08/21.
 */

fun Matrix4d.toIMatrix(): IMatrix4 {
    return mat4Of(
            m00(), m01(), m02(), m03(),
            m10(), m11(), m12(), m13(),
            m20(), m21(), m22(), m23(),
            m30(), m31(), m32(), m33()
    )
}

fun Vector4d.toIVector(): IVector4 = vec4Of(x, y, z, w)