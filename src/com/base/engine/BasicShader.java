package com.base.engine;

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
    public void updateUniforms(Matrix4f worldMatrix, Matrix4f projectedMatrix, Material material) {
        if(material.getTexture() != null) {
            material.getTexture().bind();
        } else {
            RenderUtil.unbindTextures();
        }

        setUniform("transform", projectedMatrix);
        setUniform("color", material.getColor());
    }
}
