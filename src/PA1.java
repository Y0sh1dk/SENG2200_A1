import java.io.BufferedInputStream;
import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PA1 {
    public static void main(String[] args) {
        if (args.length != 1) { // If no args given, or too many args, exit
            System.out.println("Usage: PA1 [file]");
            return;
        }
        Path filePath = Paths.get(args[0]);
        if (Files.exists(filePath)) {                               // If file exists, run
            PA1 main = new PA1();
            System.out.println("Using file: " + filePath);
            main.run(filePath);
        } else if (Files.exists(Paths.get((filePath + ".txt")))) {  // If it doesnt, try adding '.txt' extension
            filePath = Paths.get((filePath + ".txt"));
            PA1 main = new PA1();
            System.out.println("Using file: " + filePath);
            main.run(filePath);
        } else {                                                    // else no file can be found, exit
            System.out.println("File " + filePath.getFileName() + " is not found");
            System.out.println("Exiting...");
        }
    }

    private void run(Path filePath) {
        ArrayList<Polygon> polygonArraylist = this.generatePolygonsFromFile(filePath);
        System.out.println("test");
        //Point p = new Point(345.564, 87.111);
        //System.out.println(p);
        //System.out.println(p.distFromOrigin());
    }

    private ArrayList<Polygon> generatePolygonsFromFile(Path filePath) {
        ArrayList<Polygon> polygons = new ArrayList<>();
        System.out.println(filePath.toAbsolutePath());
        try {
            Scanner inputStream = new Scanner(new File(String.valueOf(filePath.toAbsolutePath())));
            Polygon currentPolygon = new Polygon();
            while (inputStream.hasNext()) {
                String str = inputStream.next();
                if(str.equalsIgnoreCase("P")) { // start of a polygon ("P" or "p")
                    inputStream.next(); // skip the size
                    polygons.add(currentPolygon); // add last polygon
                    currentPolygon = new Polygon();
                    continue;
                }
                currentPolygon.addPoint(Double.parseDouble(str), Double.parseDouble(inputStream.next())); // gets the next two points
            }
            polygons.add(currentPolygon); // add last polygon
        } catch (Exception ignored) {

        }
        polygons.remove(0); // remove the first empty polygon (couldn't be bothered to fix this)
        return polygons;
    }
}
