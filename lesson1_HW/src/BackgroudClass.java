import javax.swing.*;
import java.awt.*;

public class BackgroudClass {
    private Color color;
    JPanel jpanel;
    int currentR = 0;
    int currentG = 0;
    int currentB = 0;


    BackgroudClass(JPanel jpanel){
        this.jpanel = jpanel;
        color = new Color (
                (int)(Math.random() * 255),
                (int)(Math.random() * 255),
                (int)(Math.random() * 255)
        );
    }

    public void changeColor(JPanel jPanel){
/*
        color = new Color (
                (int)(Math.random() * 255),
                (int)(Math.random() * 255),
                (int)(Math.random() * 255)
        );
        jPanel.setBackground(color);*/


        //remake
        int[] colorArr = getIntColor(jpanel);
        if(colorArr[2] >= 0 && colorArr[2] < 255 ){
            colorArr[2]++;
        } else if(colorArr[2] == 255){
            if(colorArr[1] < 255){
                colorArr[1]++;
                colorArr[2] = 0;
            } else if(colorArr[2] == 255){
                if(colorArr[0] < 255){
                    colorArr[0]++;
                    colorArr[1] = 0;
                    colorArr[2] = 0;
                }
            }
            colorArr[1]++;
            colorArr[2] = 0;
        }
        color = new Color(colorArr[0], colorArr[1], colorArr[2]);
        jPanel.setBackground(color);
    }

    public Color getColor() {
        return color;
    }

    private int[] getIntColor(JPanel jpanel){
        Color colorJP = jpanel.getBackground();
        int r = colorJP.getRed();
        int g = colorJP.getGreen();
        int b = colorJP.getBlue();
        int[] rgb = {r, g, b};
        return rgb;
    }
}
