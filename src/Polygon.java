
public class Polygon implements ComparePoly {
    private static final int minNumOfSides = 3; // Polygon cant have less than 3 sides yo
    private Point[] points;
    private int numOfPoints;

    Polygon() {
        this.numOfPoints = 0;
    }

    Polygon(int inSize) {
        this();
        this.points = new Point[inSize];
    }

    public void setSize(int inSize) {
        this.points = new Point[inSize];
    }

    public void addPoint(double inXCoord, double inYCoord) throws PolygonFullException {
        if (numOfPoints < points.length) {
            this.points[numOfPoints] = new Point(inXCoord, inYCoord);
            this.numOfPoints++; // increment number of points
        } else {
            throw new PolygonFullException();
        }
    }

    public boolean isValid() {
        return this.numOfPoints >= Polygon.minNumOfSides; // returns true of 3 or more points, else returns false
    }


    private double area() throws PolygonInvalidException {
        if (this.isValid()) {
            double a = 0;
            for (int i = 0; i <= (points.length - 2); i++) {
                a += ((points[i+1].getxCoordinate() + points[i].getxCoordinate()) *
                        (points[i+1].getyCoordinate() - points[i].getyCoordinate()));
            }
            // for the last calculation that needs to use the first and last point
            a += ((points[0].getxCoordinate() + points[points.length-1].getxCoordinate()) *
                    (points[0].getyCoordinate() - points[points.length-1].getyCoordinate()));
            return 0.5 * Math.abs(a);
        } else {
            throw new PolygonInvalidException();
        }
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
        try {
            str.append(String.format("]:  %.2f", this.area()));
        } catch (PolygonInvalidException e) {
            return "Invalid Polygon";
        }
        return str.toString();
    }

    static class PolygonFullException extends Exception {}

    static class PolygonInvalidException extends Exception {}
}
