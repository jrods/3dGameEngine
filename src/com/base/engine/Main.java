package com.base.engine;


/**
 * Created by jared on 3/21/2014.
 */

public class Main {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "3D Engine";
    public static final double FRAME_CAP = 5000.0;

    private boolean isRunning;
    private Game game;

    public Main() {
        System.out.println(RenderUtil.getOpenGlVersion());
        RenderUtil.initGraphics();
        isRunning = false;
        game = new Game();
    }

    public static void main(String[] args) {
        Window.createWindow(WIDTH, HEIGHT, TITLE);

        Main game = new Main();

        game.start();
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

        final double frameTime = 1.0/FRAME_CAP;

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
                Input.update();

                game.update();

                if(frameCounter >= Time.SECOND) {
                    System.out.println(frames);
                    frames = 0;
                    frameCounter = 0;
                }
            }

            if(render) {
                this.render();
                frames++;
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            this.render();
        }

        this.cleanUp();
    }

    private void render() {
        RenderUtil.clearScreen();
        game.render();
        Window.render();
    }

    private void cleanUp() {
        Window.dispose();
    }

}
