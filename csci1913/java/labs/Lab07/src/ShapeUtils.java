/*
Author : Riley Motylinski
Class : CSCI 1913
 */

public class ShapeUtils {
    /*
    @param p1 - starting point
    @param p2 - ending point
    @return - distance between starting and ending point using the distance formula ((x1-x0)^2 + (y1-y0)^2)^0.5
     */
    public static double distance(Point p1, Point p2) {
        double xDistance = Math.pow(p2.getX() - p1.getX(),2);
        double yDistance = Math.pow(p2.getY() - p1.getY(),2);
        return Math.pow(xDistance + yDistance,0.5);
    }
    /*
    @param points - list of points defining a 2d shape
    @return - average of all the x and y values of the points (mathematically the center)
     */
    public static Point getCenter(Point[] points) {

        if(points.length == 0) {
            return new Point(0,0);
        }
        double xAverage = 0;
        double yAverage = 0;

        for (Point p : points) {
            xAverage += p.getX();
            yAverage += p.getY();
        }

        return new Point(xAverage/points.length,yAverage/points.length);
    }
    /*
    @param c - circle that to find the area of
    @return - area of the circle per the formula defined in Circle getArea()
     */
    public static double getArea(Circle c) {
        return c.getArea();
    }

    /*
    @param r - the ring to find the area of
    @return - the area of the ring by subtracting area(outerCircle) - area(innerCircle)
     */
    public static double getArea(Ring r) {
        double outerCircleRadius = r.getInnerCircle().getRadius() + r.getThickness();
        // can create a the circle @ 0,0 because the area will be the same no matter the location of the circle
        Circle outerCircle = new Circle(new Point (0,0),outerCircleRadius);
        return outerCircle.getArea() - r.getInnerCircle().getArea();
    }

    /*
    @param c - circle to test if the point is in
    @param p - point to be tested if in the circle
    @return - the area of the ring by subtracting area(outerCircle) - area(innerCircle)
     */
    public static boolean isIn(Circle c, Point p) {
        // the mathematical definition of a circle is the points at a constant distance, r, around
        // a central point. In this case, any point that is less than r away from the center
        // will fall within the circle
        return distance(c.getCenter(), p) <= c.getRadius();
    }
}

