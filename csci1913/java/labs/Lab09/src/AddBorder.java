/*
Author: Riley Motylinski
Class: CSCI 1913
Data: 11/5/25
 */


public class AddBorder extends Transformation {
    private int borderWidth;
    private RGBColor borderColor;

    /**
     * @param borderWidth pixel width of border
     * @param borderColor RGB color of border
     */
    public AddBorder(int borderWidth, RGBColor borderColor) {
        this.borderWidth = borderWidth;
        this.borderColor = borderColor;
    }

    /**
     *
     * @param x -- the x position of this color
     * @param y -- the y position of the color
     * @param originalColor -- the original color.
     * @param image -- the image being converted. Most transformation should not need to access this at all,
     *                  but some transformations will (maybe they need the width/height of the image...)
     *                  so we make it available here, and encourage most implementations to ignore it.
     * @return border color if pixel is on the border, same color otherwise
     */

    protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image) {
        // on the left or right side of the image
        boolean leftOrRight = (x >= 0 && x < this.borderWidth)
                              || (x <= image.getWidth() &&  x >= image.getWidth() - borderWidth);
        // on the tope or bottom on the image
        boolean topOrBottom = (y >= 0 && y < this.borderWidth)
                              || (y <= image.getHeight() &&  y >= image.getHeight() - borderWidth);
        // any pixel that fulfills either of these conditions is a border pixel
        if (leftOrRight || topOrBottom) {
            return this.borderColor;
        }
        return originalColor;
    }

    public int getBorderWidth() {
        return this.borderWidth;
    }
}
