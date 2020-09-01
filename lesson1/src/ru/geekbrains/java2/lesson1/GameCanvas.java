package ru.geekbrains.java2.lesson1;

import javax.swing.*;
import java.awt.*;


public class GameCanvas extends JPanel {

    private long lastFrameTime;
    private MainCircles controller;
    private BackgroudClass backgroudClass;

    GameCanvas(MainCircles controller){
        backgroudClass = new BackgroudClass(this);
        this.controller = controller;
        setBackground(backgroudClass.getColor());
        lastFrameTime = System.nanoTime();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        controller.onDrawFrame(this, g, deltaTimeCalc());
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    //getterblock
    public int getLeft(){ return 0;};
    public int getRight(){return getWidth() - 1;};
    public int getTop(){return 0;};
    public int getBottom(){return getHeight() - 1;};

    public void setBackgrnd(){
        backgroudClass.changeColor(this);
    }
    public float deltaTimeCalc(){
        long currentTime = System.nanoTime();
        float deltaTime =  (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        return deltaTime;
    }
}
