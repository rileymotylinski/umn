/*
Author: Riley Motylinski
Class: CSCI 1913
Data: 11/5/25
 */

public class TransformationUtils {

    /**
     * applies a series of transformations to an argument image. Saves to a file
     * @param transformations series of transformations to apply
     * @param inptfle starting image
     * @param otpFile ending image
     */
    public static void transformMany(Transformation[] transformations, String inptfle, String otpFile) {
        RGBImage im = RGBImageUtil.load(inptfle);
        // applying each trasnformation
        for (Transformation t : transformations) {
            im = t.transform(im);
        }

        RGBImageUtil.saveImage(im, otpFile);
    }
}
