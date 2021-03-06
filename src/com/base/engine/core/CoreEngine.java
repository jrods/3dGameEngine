package com.base.engine.core;

import com.base.engine.rendering.Window;

/**
 * Created by jared on 3/21/2014.
 */

public class CoreEngine {

    private boolean isRunning;
    private int width;
    private int height;
    private double frameTime;
    private Game game;
    private RenderingEngine renderingEngine;

    public CoreEngine(int width, int height, double framerate, Game game) {

        this.isRunning = false;
        this.width = width;
        this.height = height;
        this.frameTime = 1.0/framerate;
        this.game = game;

    }

    public void createWindow(String title) {
        Window.createWindow(width, height, title);
        this.renderingEngine = new RenderingEngine();
    }

    public void start() {

        if(isRunning) {
            return;
        }

        this.run();
    }

    public void stop() {

        if( ! isRunning ) {
            return;
        }

        isRunning = false;

    }

    private void run() {

        isRunning = true;

        int frames = 0;
        long frameCounter = 0;

        game.init();

        long lastTime = Time.getTime();
        double unprocessedTime = 0;

        while(isRunning) {

            boolean render = false;

            long startTime = Time.getTime();
            long passedTime = startTime - lastTime;
            lastTime = startTime;

            unprocessedTime += passedTime / (double)Time.SECOND;
            frameCounter += passedTime;

            while(unprocessedTime > frameTime) {

                render = true;

                unprocessedTime -= frameTime;

                if(Window.isCloseRequested()) {
                    this.stop();
                }

                Time.setDelta(frameTime);

                game.input();
                renderingEngine.input();
                Input.update();

                game.update();

                if(frameCounter >= Time.SECOND) {
                    System.out.println(frames);
                    frames = 0;
                    frameCounter = 0;
                }
            }

            if(render) {
                renderingEngine.render(game.getRootObject());
                Window.render();
                frames++;
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        this.cleanUp();
    }

    private void cleanUp() {
        Window.dispose();
    }

}
