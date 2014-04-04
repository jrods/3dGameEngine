package com.base.engine.core;

/**
 * Created by jared on 3/21/2014.
 */
public class Time {

    public static final long SECOND = 1000000000L;

    private static double delta;

    public static long getTime() {
        return System.nanoTime();
    }

    public static double getDelta() {
        return delta;
    }

    public static void setDelta(double inDelta) {
        Time.delta = inDelta;
    }
}
