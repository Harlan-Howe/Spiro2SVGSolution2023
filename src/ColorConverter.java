import java.awt.*;
// Note: I am providing this class as a convenience function if you wish to make color blends. It was handy for the
//       student who tried it last year.

/**
 * a class that can be used to convert (r, g, b) in 0-255 ranges to hex (#rrggbb) and back.
 */
public class ColorConverter
{
    /**
     * given a hex code #rrggbb, retrieves the red value (0-255)
     * @param s - a hex code (#rrggbb)
     * @return the 0-255 value of the rr portion.
     */
    public int Hex2Red(String s)
    {
        return Color.decode(s).getRed();
    }
    /**
     * given a hex code #rrggbb, retrieves the green value (0-255)
     * @param s - a hex code (#rrggbb)
     * @return the 0-255 value of the gg portion.
     */
    public int Hex2Green(String s)
    {
        return Color.decode(s).getGreen();
    }
    /**
     * given a hex code #rrggbb, retrieves the blue value (0-255)
     * @param s - a hex code (#rrggbb)
     * @return the 0-255 value of the bb portion.
     */
    public int Hex2Blue(String s)
    {
        return Color.decode(s).getBlue();
    }

    /**
     * given r, g, and b (8-bit), generates a hex version of this color.
     * @param r 0-255
     * @param g 0-255
     * @param b 0-255
     * @return A hex code for the equivalent color in format "#rrggbb"
     */
    public String toRGBHex(int r, int g, int b)
    {
        return String.format("#%02x%02x%02x", r, g, b);
    }
}
