package com.company;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;

import java.util.Random;

import static java.awt.event.KeyEvent.VK_K;
import static java.awt.event.KeyEvent.VK_O;

public class MyFrame extends MouseInputAdapter implements KeyListener {

    Random random = new Random();

    static JButton bRun;
    static JButton bCancel;

    static JLabel lText;
    static JLabel lTimer;
    static JLabel mouseText;
    static JLabel mouseLocationX;
    static JLabel mouseLocationY;

    JFrame frame;
    Kanwa kanwa;

    int xRun = 150;
    int yRun = 200;
    int t = 0;
    int mouseX;
    int mouseY;
    int xClicked;
    int yClicked;


    public MyFrame() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setResizable(false);


        kanwa = new Kanwa();
        kanwa.setBackground(Color.GRAY);
        kanwa.setFocusable(true);
        kanwa.setLayout(null);
        kanwa.addMouseListener(this);
        kanwa.addKeyListener(this);

        kanwa.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseX = MouseInfo.getPointerInfo().getLocation().x;
                mouseY = MouseInfo.getPointerInfo().getLocation().y;

                mouseLocationX.setText(String.valueOf(mouseX));
                mouseLocationY.setText(String.valueOf(mouseY));

            }
        });

        frame.add(kanwa);


        lText = new JLabel("Licznik: ");
        lText.setBounds(400, 0, 50, 30);
        kanwa.add(lText);

        lTimer = new JLabel("0");
        lTimer.setBounds(460, 0, 40, 30);
        kanwa.add(lTimer);

        mouseText = new JLabel("Położenie kursora:");
        mouseText.setBounds(320, 20, 110, 30);
        kanwa.add(mouseText);

        mouseLocationX = new JLabel("X");
        mouseLocationX.setBounds(430, 20, 30, 30);
        kanwa.add(mouseLocationX);

        mouseLocationY = new JLabel("Y");
        mouseLocationY.setBounds(460, 20, 30, 30);
        kanwa.add(mouseLocationY);


        bRun = new JButton("RUN");
        bRun.setBounds(xRun, yRun, 70, 30);
        bRun.setBackground(Color.GREEN);
        kanwa.add(bRun);

        bRun.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                runAway();
            }
        });

        bCancel = new JButton("Cancel");
        bCancel.setBounds(240, 200, 100, 30);
        bCancel.setBackground(Color.WHITE);
        kanwa.add(bCancel);

        bCancel.addActionListener(e -> doCancelButton());
    }

    private void doCancelButton() {
        xRun = 150;
        yRun = 200;
        t = 0;
        lTimer.setText(String.valueOf(t));
        bRun.setBackground(Color.GREEN);
        bRun.setLocation(xRun, yRun);
        bCancel.setFocusable(false);
        kanwa.point.removingArray();
        kanwa.setFocusable(true);

    }

    private int randomize() {
        return random.nextInt(431);
    }

    private void runAway() {
        if (xRun <= 100 && yRun <= 100) {
            bRun.setBackground(Color.RED);
        } else {
            changingPlace();
        }
    }

    private void changingPlace() {
        xRun = randomize();
        yRun = randomize();
        bRun.setLocation(xRun, yRun);
        t++;
        lTimer.setText(String.valueOf(t));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
            int c = e.getKeyCode();


        switch (c) {
            case VK_K -> kanwa.point.pointsS.add(new Point(xClicked, yClicked));
            case VK_O -> kanwa.point.pointsO.add(new Point(xClicked, yClicked));
        }
        }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            xClicked = e.getX();
            yClicked = e.getY();

        }

}
