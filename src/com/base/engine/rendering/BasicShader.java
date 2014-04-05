package com.base.engine.rendering;

import com.base.engine.core.Matrix4f;
import com.base.engine.core.Transform;

/**
 * Created by Jared on 3/28/2014.
 */

public class BasicShader extends Shader {

    private static final BasicShader instance = new BasicShader();

    public static BasicShader getInstance() {
        return instance;
    }

   private BasicShader() {
        super();

        addVertexShaderFromFile("basicVertex.vs.glsl");
        addFragmentShaderFromFile("basicFragment.fs.glsl");
        compileShader();

        addUniform("transform");
        addUniform("color");
    }

   @Override
   public void updateUniforms(Transform transform, Material material) {
        Matrix4f worldMatrix = transform.getTransformation();
        Matrix4f projectedMatrix = getRenderingEngine().getMainCamera().getViewProjection().mult(worldMatrix);
        material.getTexture().bind();

        setUniform("transform", projectedMatrix);
        setUniform("color", material.getColor());
    }
}
