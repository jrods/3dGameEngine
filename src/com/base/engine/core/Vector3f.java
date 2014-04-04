package com.base.engine.core;

/**
 * Created by jared on 3/21/2014.
 */

public class Vector3f {

    private float x;
    private float y;
    private float z;

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float length() {
        return (float)Math.sqrt(x * x + y * y + z * z);
    }

    public float dot(Vector3f r) {
        return x * r.getX() + y * r.getY() + z * r.getZ();
    }

    public Vector3f cross(Vector3f r) {
        float x_ = y * r.getZ() - z * r.getY();
        float y_ = z * r.getX() - x * r.getZ();
        float z_ = x * r.getY() - y * r.getX();

        return new Vector3f(x_ , y_, z_);
    }

    public Vector3f normalized() {
        float length = this.length();

        return new Vector3f(x / length, y / length, z / length);
    }

    public Vector3f rotate(Quaternion rotation) {

        Quaternion conjugate = rotation.conjugate();

        Quaternion w = rotation.mult(this).mult(conjugate);

        return new Vector3f(w.getX(), w.getY(), w.getZ());
    }

    public Vector3f rotate(float angle, Vector3f axis) {
        float sinAngle = (float)Math.sin(-angle);
        float cosAngle = (float)Math.cos(-angle);

        return this.cross(axis.mult(sinAngle)).add(  // Rotation on local X
                         (this.mult(cosAngle)).add(  // Rotation on local Z
                          axis.mult(this.dot(axis.mult(1 - cosAngle))))); // Rotation on local Y
    }

    public Vector3f add(Vector3f r) {
        return new Vector3f(x + r.getX(), y + r.getY(), z + r.getZ());
    }

    public Vector3f add(float r) {
        return new Vector3f(x + r, y + r, z + r);
    }

    public Vector3f sub(Vector3f r) {
        return new Vector3f(x - r.getX(), y - r.getY(), z - r.getZ());
    }

    public Vector3f sub(float r) {
        return new Vector3f(x - r, y - r, z - r);
    }

    public Vector3f mult(Vector3f r) {
        return new Vector3f(x * r.getX(), y * r.getY(), z * r.getZ());
    }

    public Vector3f mult(float r) {
        return new Vector3f(x * r, y * r, z * r);
    }

    public Vector3f div(Vector3f r) {
        return new Vector3f(x / r.getX(), y / r.getY(), z / r.getZ());
    }

    public Vector3f div(float r) {
        return new Vector3f(x / r, y / r, z / r);
    }

    public Vector3f abs() {
        return new Vector3f(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

}
