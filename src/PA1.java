import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * FileName: PA1.java
 * Assessment: SENG2200 - A1
 * Author: Yosiah de Koeyer
 * Student No: c3329520
 * <p>
 * Description:
 * Main class file for A1, accepts a file path from the command line args and generates and inserts polygons into
 * a CLL.
 */

// TODO: make getters/setters final!

public class PA1 {
    /**
     * Entry point method for PA1 class
     *
     * @param args takes params from cmd args
     */
    public static void main(String[] args) {
        if (args.length != 1) {                                     // If no args given, or too many args, exit
            System.out.println("Usage: PA1 [file]");
            return;
        }
        Path filePath = Path.of(args[0]);                           // first command line arg
        if (Files.exists(filePath)) {                               // If file exists, run
            PA1 main = new PA1();
            System.out.println("Using file: " + filePath);
            main.run(filePath);
        } else if (Files.exists(Path.of((filePath + ".txt")))) {    // If it doesnt, try adding '.txt' extension
            filePath = Path.of((filePath + ".txt"));
            PA1 main = new PA1();
            System.out.println("Using file: " + filePath);
            main.run(filePath);
        } else {                                                    // else no file can be found, exit
            System.out.println("File " + filePath.getFileName() + " is not found");
            System.out.println("Exiting...");
        }
    }

    /**
     * run() method
     *
     * @param filePath a path object generated from the input file
     */
    private void run(Path filePath) {
        System.out.println("Unsorted list");
        MyPolygons p1 = new MyPolygons();                               // Create new MyPolygons instance
        this.generatePolygonsFromFile(filePath, p1, false);             // Add polygons from file
        System.out.println(p1);                                         // Print string rep of class

        MyPolygons p2 = new MyPolygons();                               // Create new MyPolygons instance
        int p1Size = p1.getSize();
        for (int i = 0; i < p1Size; i++) {
            p2.insertInOrder(p1.take());
        }
        System.out.println("Sorted list");
        System.out.println(p2);                                         // Print string rep of class
    }

    /**
     * generatePolygonsFromFile() method
     *
     * @param filePath      a path object generated from the input file
     * @param inPolys       MyPolygons instance to add polygons too
     * @param insertInOrder a Boolean to determine if polygons are inserted in order or not
     */
    private void generatePolygonsFromFile(Path filePath, MyPolygons inPolys, boolean insertInOrder) {
        try {
            Scanner inputStream = new Scanner(Path.of(String.valueOf(filePath.toAbsolutePath())));  // open file
            Polygon currentPolygon = new Polygon();
            while (inputStream.hasNext()) {                                                         // while not at end of file
                String str = inputStream.next();
                if (str.equalsIgnoreCase("P")) {                                                    // start of a polygon ("P" or "p")
                    if (currentPolygon.isValid()) {                                                 // if valid polygon
                        if (insertInOrder) {
                            inPolys.insertInOrder(currentPolygon);
                        } else {
                            inPolys.append(currentPolygon);
                        }

                    }
                    currentPolygon = new Polygon(Integer.parseInt(inputStream.next()));              // new poly of size specified
                    continue;
                }
                currentPolygon.addPoint(Double.parseDouble(str),
                        Double.parseDouble(inputStream.next()));                                    // gets the next two points
            }
            if (insertInOrder) {
                inPolys.insertInOrder(currentPolygon);                                              // add last poly
            } else {
                inPolys.append(currentPolygon);                                                     // add last polygon
            }
        } catch (Exception ignored) {
        }
    }

}
