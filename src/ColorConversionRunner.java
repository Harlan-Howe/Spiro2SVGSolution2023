public class ColorConversionRunner
{
    public static void main(String[] args)
    {
        ColorConverter converter = new ColorConverter();
        String h1 = "#59118e";
        System.out.println("Creating color for "+h1+".");
        System.out.println("R: "+converter.Hex2Red(h1));
        System.out.println("G: "+converter.Hex2Green(h1));
        System.out.println("B: "+converter.Hex2Blue(h1));

        System.out.println("Making gold for RGB = (255,196,37).");
        System.out.println(converter.toRGBHex(255,196,37));

    }
}
