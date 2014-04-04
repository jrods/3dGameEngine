package com.base.engine.core;

/**
 * Created by Jared on 4/4/2014.
 */

public interface GameComponent {

    public void input(Transform transform);
    public void update(Transform transform);
    public void render(Transform transform);
}
