/*
Author : Riley Motylinski
Class : CSCI 1913
 */

import java.util.Random;
import java.awt.Color;

public class DrawSolar {
    /*
    @param c - circle to find the point on
    @param degree - degrees (NOT radians) around the circle i.e. 90 -> top of the circle
     */
    private static Point getPointOnCircle(Circle c, int degree) {
        Point circleCenter = c.getCenter();
        // multiple by -1 here otherwise values are reversed
        // using trig functions to find x/y pos
        double xPos = circleCenter.getX() + Math.cos(-1*degree * Math.PI/180)*c.getRadius();
        double yPos = circleCenter.getY() + Math.sin(-1*degree * Math.PI/180)*c.getRadius();
        return new Point(xPos,yPos);
    }

    public static void main(String[] args) {
        int PICTURE_WIDTH = 500;
        int PICTURE_HEIGHT = 500;

        ShapeDrawer s = new ShapeDrawer(PICTURE_WIDTH,PICTURE_HEIGHT);

        // creating earth
        Circle earthOrbit = new Circle(new Point(250,250),100);
        Circle earth = new Circle(getPointOnCircle(earthOrbit,296),10);
        Circle earthRingCircle = new Circle(earth.getCenter(),30);
        Ring earthRing = new Ring(earthRingCircle,1);

        // creating other planets
        Circle sun = new Circle(new Point(250,250),20);
        Circle moon = new Circle(getPointOnCircle(earthRing.getInnerCircle(),145),5);




        // creating stars
        int MAX_STARS = 100;
        Random r = new Random();
        // basically a bunch of small circles
        Circle[] stars = new Circle[MAX_STARS];
        for (int i = 0; i < MAX_STARS; i++){
            Point randomPos = new Point(r.nextInt(PICTURE_WIDTH), r.nextInt(PICTURE_HEIGHT));
            stars[i] = new Circle(randomPos,1);
        }

        // setting up colors
        Color sunColor = new Color(255,255,20);
        Color ringColor = new Color(100,100,100);
        Color background = new Color(0,0,0);
        Color starColor = new Color(226,211,134);
        Color earthColor = new Color(0,0,255);
        Color moonColor = new Color(181, 177, 166);

        // start drawing

        // must draw this first so the black background doesn't draw over the stars
        s.setStroke(ringColor);
        s.setFill(background);
        s.draw(earthOrbit);

        // because there are so many, better to use a for loop
        s.setStroke(starColor);
        for(Circle c : stars) {
            s.draw(c);
        }

        s.setFill(sunColor);
        s.setStroke(sunColor);
        s.draw(sun);

        s.setStroke(earthColor);
        s.setFill(earthColor);
        s.draw(earth);

        s.setStroke(ringColor);
        s.setFill(ringColor);
        s.draw(earthRing);

        s.setStroke(moonColor);
        s.setFill(moonColor);
        s.draw(moon);

        // writing the image to an actual file
        s.writeToFile("solar.png");
    }
}
