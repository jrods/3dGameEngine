package com.base.engine.core;

/**
 * Created by jared on 3/21/2014.
 */

public abstract class Game {

    private GameObject root;

    public void init() {

    }

    public void input() {
        getRootObject().input();
    }

    public void update() {
        getRootObject().update();
    }

    public GameObject getRootObject() {

        if( root == null) {
            root = new GameObject();
        }

        return root;
    }
}