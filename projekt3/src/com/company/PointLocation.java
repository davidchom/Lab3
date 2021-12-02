package com.company;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.util.ArrayList;

public class PointLocation extends MouseInputAdapter {
    public ArrayList<Point> pointsS = new ArrayList<>();
    public ArrayList<Point> pointsO = new ArrayList<>();

    public void removingArray(){
        pointsS.clear();
        pointsO.clear();
    }
}
