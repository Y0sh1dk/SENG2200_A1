/**
 * FileName: Polygon.java
 * Assessment: SENG2200 - A1
 * Author: Yosiah de Koeyer
 * Student No: c3329520
 * <p>
 * Description:
 * Polygon class that implements the ComparePoly interface. Stores a fix number of instances of the Point class
 * and provides relevant methods.
 */

public class Polygon implements ComparePoly {
    private static final int minNumOfSides = 3; // Polygon cant have less than 3 sides yo
    private Point[] points;
    private int numOfPoints;

    /**
     * Polygon class constructor when no args are given
     */
    Polygon() {
        this.numOfPoints = 0;
    }

    /**
     * Polygon class constructor when the size is given
     *
     * @param inSize the number of points the polygon can contain
     */
    Polygon(int inSize) {
        this();
        this.setSize(inSize);
    }

    /**
     * setSize() method
     *
     * @param inSize the number of points the polygon can contain
     */
    public void setSize(int inSize) {
        this.points = new Point[inSize];
    }

    /**
     * addPoint() method
     *
     * @param inXCoord x coord of new point
     * @param inYCoord y coord of new point
     * @throws PolygonFullException when the polygon cannot hold any more points
     */
    public void addPoint(double inXCoord, double inYCoord) throws PolygonFullException {
        if (numOfPoints < points.length) {
            this.points[numOfPoints] = new Point(inXCoord, inYCoord);
            this.numOfPoints++; // increment number of points
        } else {
            throw new PolygonFullException();
        }
    }

    /**
     * isValid() method
     *
     * @return a boolean, true if the polygon is valid, false if not (valid if 3 or more points)
     */
    public boolean isValid() {
        return this.numOfPoints >= Polygon.minNumOfSides; // returns true of 3 or more points, else returns false
    }

    /**
     * shortestDistToOrigin() method
     *
     * @return the shortest distance of all the points to the origin
     */
    public double shortestDistToOrigin() {
        double shortestDist = this.points[0].distFromOrigin(); // Initialize with any value from the array
        for (Point p : this.points) {
            if (p.distFromOrigin() < shortestDist) {
                shortestDist = p.distFromOrigin();
            }
        }
        return shortestDist;
    }

    /**
     * area() method
     *
     * @return the area of the polygon
     */
    private double area() {
        double a = 0;
        for (int i = 0; i <= (points.length - 2); i++) {
            a += ((points[i + 1].getxCoordinate() + points[i].getxCoordinate()) *
                    (points[i + 1].getyCoordinate() - points[i].getyCoordinate()));
        }
        // for the last calculation that needs to use the first and last point
        a += ((points[0].getxCoordinate() + points[points.length - 1].getxCoordinate()) *
                (points[0].getyCoordinate() - points[points.length - 1].getyCoordinate()));
        return 0.5 * Math.abs(a);
    }

    /**
     * Overridden ComesBefore() method
     *
     * @param inObject Polygon to compare to the current polyogn
     * @return true if this polygon comes before the given, else false.
     * A Polygon comes before if it has a larger area, if the same area, it comes before
     * if it has a point closer to the origin
     */
    @Override
    public boolean ComesBefore(Object inObject) { // return true if THIS comes before the arg
        Polygon inPoly = (Polygon) inObject;

        double inPolyArea = inPoly.area();
        double thisPolyArea = this.area();

        // Smallest poly
        Polygon smallestPoly;
        //Polygon largestPoly;
        if (inPolyArea > thisPolyArea) {
            smallestPoly = this;
            //largestPoly = inPoly;
        } else {
            smallestPoly = inPoly;
            //largestPoly = this;
        }

        // If within 0.05% of each other TODO: tests this
        if (Math.abs(inPolyArea - thisPolyArea) <= (0.05 * smallestPoly.area())) {
            return this.shortestDistToOrigin() < inPoly.shortestDistToOrigin();
        } else { // not within 0.05%
            return this.area() > inPoly.area();
        }
    }


    /**
     * Overridden toString() method
     *
     * @return a String representation of the Polygon
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (Point p : points) {
            str.append(p);
        }
        str.append(String.format("]:  %.2f", this.area()));
        return str.toString();
    }

    /**
     * Custom exception to throw when points can no longer be added too the polygon
     */
    static class PolygonFullException extends Exception {
    }

}
