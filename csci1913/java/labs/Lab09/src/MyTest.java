public class MyTest {

    public static void main(String[] args) {

        Transformation[] transformations;
        RGBImage img;
        RGBImage out;

        AddBorder t;

        // example 7 -- AddBorder
        System.out.println("************* Example 7 *************");
        img = RGBImageUtil.load("sourceImages/University_of_Minnesota_entrance_sign_1-large.png");
        t = new AddBorder(10, new RGBColor(255, 255, 0));
        out = t.transform(img);

        int x = 11;
        int y = 11;

        System.out.println(out.getColor(x, y));



        boolean leftOrRight = (x >= 0 && x <= t.getBorderWidth())
                || (x <= img.getWidth() &&  x >= img.getWidth() - t.getBorderWidth());

        // on the tope or bottom on the image
        boolean topOrBottom = (y >= 0 && y <= t.getBorderWidth())
                || (y <= img.getHeight() &&  y >= img.getHeight() - t.getBorderWidth());

        System.out.println(leftOrRight);
        System.out.println(topOrBottom);

    }
}