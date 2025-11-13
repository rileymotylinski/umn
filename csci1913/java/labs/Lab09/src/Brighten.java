/*
Author: Riley Motylinski
Class: CSCI 1913
Data: 11/5/25
 */


public class Brighten extends Transformation {
    private int amount;

    /**
     * @param amount negative/positive value to decrease/increase color of image, respectively.
     */
    public Brighten(int amount) {
        this.amount = amount;
    }

    /**
     *
     * @param x -- the x position of this color
     * @param y -- the y position of the color
     * @param originalColor -- the original color.
     * @param image -- the image being converted. Most transformation should not need to access this at all,
     *                  but some transformations will (maybe they need the width/height of the image...)
     *                  so we make it available here, and encourage most implementations to ignore it.
     * @return darker/lighter pixel within [0,255], inclusive
     */

    protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image) {

        // Adding brightness value to each pixel and capping
        int brighterRed = RGBColor.clamp(originalColor.getRed() + this.amount);
        int brighterGreen = RGBColor.clamp(originalColor.getGreen() + this.amount);
        int brighterBlue = RGBColor.clamp(originalColor.getBlue() + this.amount);


        return new RGBColor(brighterRed, brighterGreen, brighterBlue);
    }
}
