/*
Author: Riley Motylinski
Class: CSCI 1913
Data: 11/5/25
 */


public class ColorPallet extends Transformation {
    private RGBColor[] pallet;

    /**
     * @param pallet Selection of colors for transformation
     */
    public ColorPallet(RGBColor[] pallet) {
        this.pallet = pallet;
    }

    /**
     * calculates the closest color in pallet to originalColor
     * @param x -- the x position of this color
     * @param y -- the y position of the color
     * @param originalColor -- the original color.
     * @param image -- the image being converted. Most transformation should not need to access this at all,
     *                  but some transformations will (maybe they need the width/height of the image...)
     *                  so we make it available here, and encourage most implementations to ignore it.
     * @return color of minimum distance (mathematically) from color in pallet -> RGBColor
     */

    protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image) {
        // assume the closest color is the first pixel; for bootstrapping comparison
        RGBColor minColor = pallet[0];
        for (RGBColor color : pallet) {
            double currentDistance = RGBColor.distance(originalColor,color);
            // compare to current minDistance
            if (currentDistance < RGBColor.distance(originalColor,minColor)) {
                minColor = color;
            }
        }
        return minColor;
    }
}
