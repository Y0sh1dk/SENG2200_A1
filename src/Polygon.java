import java.util.ArrayList;

public class Polygon implements ComparePoly {
    private static final int minNumOfSides = 3; // Polygon cant have less than 3 sides yo
    private final ArrayList<Point> points;
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
        return this.numOfPoints >= Polygon.minNumOfSides; // returns true of 3 or more points, else returns false
    }


    private double area() {
        double a = 0;
        for (int i = 0; i <= (points.size() - 2); i++) {
            a += ((points.get(i+1).getxCoordinate() + points.get(i).getxCoordinate()) *
                    (points.get(i+1).getyCoordinate() - points.get(i).getyCoordinate()));
        }
        // for the last calculation that needs to use the first and last point
        a += ((points.get(0).getxCoordinate() + points.get(points.size()-1).getxCoordinate()) *
                (points.get(0).getyCoordinate() - points.get(points.size()-1).getyCoordinate()));
        return 0.5 * Math.abs(a);
    }

    @Override
    public boolean ComesBefore(Polygon p) {
        return false; //TODO: this
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (Point p : points) {
            str.append(p);
        }
        str.append(String.format("]:  %.2f", this.area()));
        return str.toString();
    }
}
