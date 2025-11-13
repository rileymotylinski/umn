/*
Author: Riley Motylinski
Class: CSCI 1913
Data: 11/5/25
 */


public class Stamp extends Transformation {
    RGBImage stampImage;

    /**
     * @param stampImage image to be placed upon transformed image.
     */
    public Stamp(RGBImage stampImage) {
        this.stampImage = stampImage;
    }

    /**
     * imprints a pixel on an image by average the two pixels colors
     * @param x -- the x position of this color
     * @param y -- the y position of the color
     * @param originalColor -- the original color.
     * @param image -- the image being converted. Most transformation should not need to access this at all,
     *                  but some transformations will (maybe they need the width/height of the image...)
     *                  so we make it available here, and encourage most implementations to ignore it.
     * @return averaged pixel if there exists a pixel from stamp image at the same position as the argument image
     */

    protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image) {

        // there is no pixel at the same position in the stamp image
        if((x >= stampImage.getWidth()) || (y >= stampImage.getHeight())) {
            return originalColor;
        }

        // the colors of the two images are the same. No need to average.
        if (stampImage.getColor(x, y) == originalColor) {
            return originalColor;
        }

        // averaging stampImage and originalColor
        int averageRed = (stampImage.getColor(x, y).getRed() + originalColor.getRed()) / 2;
        int averageGreen = (stampImage.getColor(x, y).getGreen() + originalColor.getGreen()) / 2;
        int averageBlue = (stampImage.getColor(x, y).getBlue() + originalColor.getBlue()) / 2;

        return new RGBColor(averageRed,averageGreen,averageBlue);
    }
}
