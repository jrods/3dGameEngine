package com.base.engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;

/**
 * Created by jared on 3/21/2014.
 */
public class Window {

    public static void createWindow(int inWidth, int inHeight, String inTitle) {
        Display.setTitle(inTitle);
/*
        PixelFormat pixelFormat = new PixelFormat();
        ContextAttribs contextAttributes = new ContextAttribs(4, 3)
                .withForwardCompatible(true)
                .withProfileCore(true);
*/

        try {
            Display.setDisplayMode(new DisplayMode(inWidth, inHeight));
            Display.create(); //pixelFormat, contextAttributes);
            Keyboard.create();
            Mouse.create();

        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    public static void render() {
        Display.update();
    }

    public static void dispose() {
        Display.destroy();
        Keyboard.destroy();
        Mouse.destroy();
    }

    public static boolean isCloseRequested() {
        return Display.isCloseRequested();
    }

    public static int getWidth() {
        return Display.getDisplayMode().getWidth();
    }

    public static int getHeight() {
        return Display.getDisplayMode().getHeight();
    }

    public static String getTitle() {
        return Display.getTitle();
    }
}
