package com.base.engine;

/**
 * Created by jared on 3/21/2014.
 */

public class Vector2f {

    private float x;
    private float y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public float dot(Vector2f r) {
        return x * r.getX() + y * r.getY();
    }

    public Vector2f normalized() {
        float length = length();

        return new Vector2f(x / length, y / length);
    }

    public Vector2f rotate(float angle) {
        double rad = Math.toRadians(angle);
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);

        return new Vector2f((float)(x * cos - y * sin), (float)(x * sin + y * cos));
    }

    public Vector2f add(Vector2f r) {
        return new Vector2f(x + r.getX(), y + r.getY());
    }

    public Vector2f add(float r) {
        return new Vector2f(x + r, y + r);
    }

    public Vector2f sub(Vector2f r) {
        return new Vector2f(x - r.getX(), y - r.getY());
    }

    public Vector2f sub(float r) {
        return new Vector2f(x - r, y - r);
    }

    public Vector2f mult(Vector2f r) {
        return new Vector2f(x * r.getX(), y * r.getY());
    }

    public Vector2f mult(float r) {
        return new Vector2f(x * r, y * r);
    }

    public Vector2f div(Vector2f r) {
        return new Vector2f(x / r.getX(), y / r.getY());
    }

    public Vector2f div(float r) {
        return new Vector2f(x / r, y / r);
    }

    public Vector2f abs() {
        return new Vector2f(Math.abs(x), Math.abs(y));
    }

    public String toString() {
        return "(" + x + " " + y + ")";
    }

    public float getX() {
        return x;
    }

    public void setX(float inX) {
        this.x = inX;
    }

    public float getY() {
        return y;
    }

    public void setY(float inY) {
        this.y = inY;
    }
}
