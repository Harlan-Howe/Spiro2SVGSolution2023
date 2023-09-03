import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class SpiroWriter
{

    private String filename;
    private int imageWidth, imageHeight;
    private double radius1, radius2, angleRatio, num_revolutions;
    private int num_steps;

    private Scanner keyboardReader;


    /**
     * The constructor. This automatically gets called when we create a SpiroWriter.
     */
    public SpiroWriter()
    {
        System.out.println("Creating the SpiroWriter.");
        imageWidth = 600;
        imageHeight = 600;
        keyboardReader = new Scanner(System.in);
        requestInfo();
        System.out.println("Done creating the SpiroWriter.");
    }

    /**
     * asks the user for the parameters that will affect this drawing.
     * Note: This is not dummy-proofed. In the case of a crash, the user will need to restart the program.
     */
    public void requestInfo()
    {
        System.out.print("Please enter a filename to save. It should end with \".svg\" ");
        filename = keyboardReader.nextLine();
        System.out.print("Please enter radius1. ");
        radius1 = keyboardReader.nextDouble();
        System.out.print("Please enter radius2. ");
        radius2 = keyboardReader.nextDouble();
        System.out.print("Please enter angleRatio. ");
        angleRatio = keyboardReader.nextDouble();
        System.out.print("Please enter the number of revolutions around the outer circle: ");
        num_revolutions = keyboardReader.nextDouble();
        System.out.print("Please enter number of steps. ");
        num_steps = keyboardReader.nextInt();


    }

    /**
     * opens a file to write the .svg data & saves the information. By default, prints a bit of text and a polyline with
     * coordinates specified by linePoints().
     */
    public void createFile()
    {
        System.out.println("Writing the file.");
        FileWriter spiralFileWriter;
        try
        {
            spiralFileWriter = new FileWriter(filename);
            BufferedWriter fileWriter = new BufferedWriter(spiralFileWriter);

            // Write the Header line to make this an SVG file.
            fileWriter.write("<svg version=\"1.1\" width=\""+imageWidth+"\" height=\""+imageHeight+"\" xmlns=\"http://www.w3.org/2000/svg\">\n");

            // Prints your name at the top of the file. You might wish to change this to your actual name....
            fileWriter.write("\t<text x=\""+imageWidth/2+"\" y=\"18\" font-size=\"18\" text-anchor=\"middle\" fill=\"purple\">Your Name</text>\n");

            //-------------
            // Now we're going to make the actual spirograph, using a "polyline" - the polyline will have a format like:
            //  <polyline points="100,100 100,200 200,200 100,200 100,100" stroke="red" stroke-width=1 fill="none" />

            // Start making a polyline....
            fileWriter.write("\t<polyline points=\"");

            // list the points that will make up this polyline.... this linePoints() method will be the part you write.
            String linePointsString = linePoints();
            fileWriter.write(linePointsString);

            // Finish the polyline....
            fileWriter.write("\" stroke=\"red\" stroke-width=\"1\" fill=\"none\" />\n");
            //--------------

            // Write the Footer line that ends the SVG file.
            fileWriter.write("</svg>\n");

            // Save & close the file.
            fileWriter.close();

            System.out.println("File '"+filename+"' has been written.");
        }
        catch (IOException ioExp)
        {
            ioExp.printStackTrace();
        }



    }

    /**
     * creates a string with a sequence of x,y pairs, each pair separated by a space. It is ok to have an extra space
     * at the end.
     * @return a String with the points to connect for our spirograph.
     */
    public String linePoints()
    {
        // A StringBuilder is slightly more efficient than just the String class when it comes to making a string get
        //    longer and longer and longer. See me if you have questions why.
        StringBuilder builder = new StringBuilder();

        // ----------------------------------------
        // TODO: you'll write this section. I've written some example code here to show how to draw a triangle.
        //
        //  This is pretty inefficient - you should use a loop, of course! But you'll essentially want to use the four
        //       "append" lines to draw each dot. I suggest you comment out my code in this section until you are
        //       familiar with how it works (i.e., when you have written some code of your own), then delete my code.

        double x1 = 100;
        double y1 = 100;
        double x2 = 200;
        double y2 = 100;
        double x3 = 150;
        double y3 = 186;

        builder.append(x1);
        builder.append(",");
        builder.append(y1);
        builder.append(" ");

        builder.append(x2);
        builder.append(",");
        builder.append(y2);
        builder.append(" ");

        builder.append(x3);
        builder.append(",");
        builder.append(y3);
        builder.append(" ");

        builder.append(x1);
        builder.append(",");
        builder.append(y1);
        builder.append(" ");

        // -----------------------------------------------

        return builder.toString();  // but don't delete this line. You need it!


    }

}
