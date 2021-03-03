import java.util.ArrayList;

public class Polygon implements ComparePoly {
    private static final int minNumOfSides = 3; // Polygon cant have less than 3 sides yo
    private ArrayList<Point> points;
    private int numOfPoints;

    Polygon() {
        this.points = new ArrayList<>();
        this.numOfPoints = 0;
    }

    public void addPoint(double inXCoord, double inYCoord) {
        this.points.add(new Point(inXCoord, inYCoord));
        this.numOfPoints++; // increment number of points
    }

    public boolean isValid() {
        return this.numOfPoints >= 3; // returns true of 3 or more points, else returns false
    }


    public double area() {
        return 0;
    }

    @Override
    public boolean ComesBefore(Polygon p) {
        return false; //TODO: this
    }

    @Override
    public String toString() {
        return "";
    }
}
