import java.nio.file.*;

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
        Point p = new Point(345.564, 87.111);
        System.out.println(p);
        System.out.println(p.distFromOrigin());

    }
}
