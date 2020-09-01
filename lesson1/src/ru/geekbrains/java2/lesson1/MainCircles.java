package ru.geekbrains.java2.lesson1;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class MainCircles extends JFrame {

    private static final int POS_X = 400;
    private static final int POS_Y = 400;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    public Sprite[] sprites = new Sprite[12];
    private long currentTimeSeconds = System.nanoTime();
    GameCanvas canvas;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }
    private void createBall(Sprite[] sprites){
        for (int i = 0; i < sprites.length; i++){
            sprites[i] = new Ball();
        }
    }
    private MainCircles(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X,POS_Y,WINDOW_WIDTH,WINDOW_HEIGHT);
        canvas = new GameCanvas(this);
        add(canvas, BorderLayout.CENTER);
        setTitle("Game");
        setVisible(true);
        createBall(sprites);
        currentTimeSeconds = TimeUnit.SECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);


    }
    public void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime){
        renderBall(gameCanvas, g);
        update(gameCanvas, deltaTime);
        renderBackgroundCanvas(gameCanvas);

    }

    private void update(GameCanvas canvas, float deltaTime){
        for (int i = 0; i < sprites.length; i++){
            sprites[i].update(canvas,deltaTime);
        }

    }
    private void renderBall(GameCanvas canvas, Graphics g){
        for (int i = 0; i < sprites.length; i++){
            sprites[i].render(canvas,g);
        }
    }

    private void renderBackgroundCanvas(GameCanvas canvas){
        canvas.setBackgrnd();
    }
}
