package com.base.game;

import com.base.engine.core.CoreEngine;

/**
 * Created by Jared on 4/4/2014.
 */

public class Main {

    public static void main(String[] args) {
        CoreEngine engine = new CoreEngine(800, 600, 120, new TestGame());
        engine.createWindow("3d Game Engine");
        engine.start();
    }
}
