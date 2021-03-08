import java.nio.file.Files;
import java.nio.file.Path;
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
        MyPolygons p1 = new MyPolygons();
        this.generatePolygonsFromFile(filePath, p1);

        p1.testPrints();
    }

    private void generatePolygonsFromFile(Path filePath, MyPolygons polys) {
        System.out.println(filePath.toAbsolutePath());
        try {
            Scanner inputStream = new Scanner(Path.of(String.valueOf(filePath.toAbsolutePath())));
            Polygon currentPolygon = new Polygon();
            while (inputStream.hasNext()) {
                String str = inputStream.next();
                if(str.equalsIgnoreCase("P")) { // start of a polygon ("P" or "p")
                    if(currentPolygon.isValid()) { // if valid polygon
                        polys.append(currentPolygon); // add last polygon
                    }
                    currentPolygon = new Polygon(Integer.parseInt(inputStream.next()));
                    continue;
                }
                currentPolygon.addPoint(Double.parseDouble(str), Double.parseDouble(inputStream.next())); // gets the next two points
            }
            polys.append(currentPolygon); // add last polygon
        } catch (Exception ignored) {

        }
    }
}
