/*
Author: Riley Motylinski
Class: CSCI 1913
Data: 11/5/25
 */


public class Greyscale extends Transformation {

    /**
     * averages color of pixel
     * @param x -- the x position of this color
     * @param y -- the y position of the color
     * @param originalColor -- the original color.
     * @param image -- the image being converted. Most transformation should not need to access this at all,
     *                  but some transformations will (maybe they need the width/height of the image...)
     *                  so we make it available here, and encourage most implementations to ignore it.
     * @return greyscale version of an rgb value
     */

    protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image) {
        // averaging all of the RGB values
        int average = (originalColor.getRed() + originalColor.getGreen() + originalColor.getBlue()) / 3;
        return new RGBColor(average, average, average);
    }
}
