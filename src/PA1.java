import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class PA1 {
    public static void main(String[] args) {
        if (args.length != 1) { // If no args given, or too many args, exit
            System.out.println("Usage: PA1 [file]");
            return;
        }
        Path filePath = Path.of(args[0]);
        if (Files.exists(filePath)) {                               // If file exists, run
            PA1 main = new PA1();
            System.out.println("Using file: " + filePath);
            main.run(filePath);
        } else if (Files.exists(Path.of((filePath + ".txt")))) {  // If it doesnt, try adding '.txt' extension
            filePath = Path.of((filePath + ".txt"));
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
        MyPolygons p1 = new MyPolygons(polygonArraylist);
        //p1.testAreas();
        p1.testPrints();
        System.out.println("test");
    }

    private ArrayList<Polygon> generatePolygonsFromFile(Path filePath) {
        ArrayList<Polygon> polygons = new ArrayList<>();
        System.out.println(filePath.toAbsolutePath());
        try {
            Scanner inputStream = new Scanner(Path.of(String.valueOf(filePath.toAbsolutePath())));
            Polygon currentPolygon = new Polygon();
            while (inputStream.hasNext()) {
                String str = inputStream.next();
                if(str.equalsIgnoreCase("P")) { // start of a polygon ("P" or "p")
                    inputStream.next(); // skip the size
                    if(currentPolygon.isValid()) { // if valid polygon
                        polygons.add(currentPolygon); // add last polygon
                    }
                    currentPolygon = new Polygon();
                    continue;
                }
                currentPolygon.addPoint(Double.parseDouble(str), Double.parseDouble(inputStream.next())); // gets the next two points
            }
            polygons.add(currentPolygon); // add last polygon
        } catch (Exception ignored) {

        }
        return polygons;
    }
}
