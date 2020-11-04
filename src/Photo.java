import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.*;
import java.util.ArrayList;

public class Photo
{
    static ArrayList<String> points;
    public static void main(String[] args) throws IOException {
        String new_path = "DS9.txt";
        File file = new File(new_path);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        points = new ArrayList<String>();
        String line = reader.readLine();
        while (line != null) {

            line = reader.readLine();
            points.add(line);
        }
        CreateImahe();
    }

   static void CreateImahe() throws IOException {
    int w = 960;
    int h = 540;
    BufferedImage image = new BufferedImage(w, h, ColorSpace.TYPE_RGB);
    Graphics2D graphics = image.createGraphics();
    graphics.setPaint ( new Color ( 200, 200, 200 ) );
       for(int i = 0; i < points.size()-2; i++)
    {
        String[] arrOfStr = points.get(i).split(" ");
        graphics.fillRect (Integer.parseInt(arrOfStr[1]) ,h-Integer.parseInt(arrOfStr[0]), 1, 1);
         }
       File outFile = new File("lab2_image.png");
       ImageIO.write(image, "png", outFile);
}
}
