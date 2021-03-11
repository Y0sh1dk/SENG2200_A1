import java.lang.Math;

/**
 *  FileName: Point.java
 *  Assessment: SENG2200 - A1
 *  Author: Yosiah de Koeyer
 *  Student No: c3329520
 *
 *  Description:
 *  Point class, used to represent a point on the cartesian plane. provides method for calculating the distance
 *  from the origin.
 */

public class Point {
    // Presumes that origin is (0,0)
    private static final double originX = 0;
    private static final double originY = 0;

    private double xCoordinate;
    private double yCoordinate;

    Point() {
        this.xCoordinate = 0;
        this.yCoordinate = 0;
    }

    Point(double inXCoord, double inYCoord) {
        this();
        this.xCoordinate = inXCoord;
        this.yCoordinate = inYCoord;
    }

    public String toString() {
        return String.format("(%3.2f , %3.2f)", this.xCoordinate, this.yCoordinate);
    }

    public double distFromOrigin() {
        return Math.sqrt(Math.pow(this.xCoordinate - Point.originX, 2) +
                Math.pow(this.yCoordinate - Point.originY, 2));
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }
}
