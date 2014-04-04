package com.base.engine.core;

import java.util.ArrayList;

/**
 * Created by Jared on 4/4/2014.
 */

public class GameObject {

    private ArrayList<GameObject> childern;
    private ArrayList<GameComponent> components;
    private Transform transform;

    public GameObject() {
        childern = new ArrayList<>();
        components = new ArrayList<>();
        transform = new Transform();
    }

    public void addChild(GameObject child) {
        childern.add(child);
    }

    public void addComponent(GameComponent component) {
        components.add(component);
    }

    public void input() {
        for(GameComponent component : components) {
            component.input(transform);
        }

        for(GameObject child : childern) {
            child.input();
        }
    }

    public void update() {
        for(GameComponent component : components) {
            component.render(transform);
        }

        for(GameObject child : childern) {
            child.update();
        }
    }

    public void render() {
        for(GameComponent component : components) {
            component.render(transform);
        }

        for(GameObject child : childern) {
            child.render();
        }
    }

    public Transform getTransform() {
        return transform;
    }

}
