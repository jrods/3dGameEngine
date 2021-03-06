package com.base.game;

import com.base.engine.core.GameComponent;
import com.base.engine.core.Transform;
import com.base.engine.rendering.Material;
import com.base.engine.rendering.Mesh;
import com.base.engine.rendering.Shader;

/**
 * Created by Jared on 4/4/2014.
 */

public class MeshRender implements GameComponent {

    private Mesh mesh;
    private Material material;

    public MeshRender(Mesh mesh, Material material) {
        this.mesh = mesh;
        this.material = material;
    }

    @Override
    public void input(Transform transform) {}

    @Override
    public void update(Transform transform) {}

    @Override
    public void render(Transform transform, Shader shader) {
        shader.bind();
        shader.updateUniforms(transform, material);
        mesh.draw();
    }
}
