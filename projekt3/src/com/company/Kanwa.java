package com.company;

import javax.swing.*;
import java.awt.*;

public class Kanwa extends JPanel {
    PointLocation point = new PointLocation();

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(40,88,90));
        drawRectangles(g2d);
        repaint();

        g2d.setColor(new Color(100,20,60));
        drawOval(g2d);
        repaint();
    }
    private void drawOval(Graphics2D g2d2) {
        int x,y;
        for(Point p : point.pointsO){
            x = (int) p.getX();
            y = (int) p.getY();
            g2d2.fillOval(x,y,35,20);

        }
    }

    private void drawRectangles(Graphics2D g2d){
        int x,y;
        for(Point p : point.pointsS){
            x = (int) p.getX();
            y = (int) p.getY();
            g2d.fillRect(x,y,30,20);

        }
    }
}
