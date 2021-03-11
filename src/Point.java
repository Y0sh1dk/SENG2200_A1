import java.lang.Math;

/**
 * FileName: Point.java
 * Assessment: SENG2200 - A1
 * Author: Yosiah de Koeyer
 * Student No: c3329520
 * <p>
 * Description:
 * Point class, used to represent a point on the cartesian plane. provides method for calculating the distance
 * from the origin.
 */

public class Point {
    // Presumes that origin is (0,0)
    private static final double originX = 0;
    private static final double originY = 0;

    private double xCoordinate;                                 // X Coord of point
    private double yCoordinate;                                 // Y coord of point

    /**
     * Point class constructor when no args are given
     */
    Point() {
        this.xCoordinate = 0;
        this.yCoordinate = 0;
    }

    /**
     * Point class constructor when x and y coords are given
     *
     * @param inXCoord x coord to set as this points x coordinate
     * @param inYCoord y coord to set as this points y coordinate
     */
    Point(double inXCoord, double inYCoord) {
        this();                                                 // Initialize values from base constructor
        this.xCoordinate = inXCoord;
        this.yCoordinate = inYCoord;
    }

    /**
     * Overridden toString() method
     *
     * @return a String representation of the point
     */
    public String toString() {
        return String.format("(%3.2f , %3.2f)", this.xCoordinate, this.yCoordinate);
    }

    /**
     * distFromOrigin() method
     *
     * @return the distance between this point nad the origin
     */
    public double distFromOrigin() {
        return Math.sqrt(Math.pow(this.xCoordinate - Point.originX, 2) + // ((x - 0)^2) + (y - 0)^2)^(1/2)
                Math.pow(this.yCoordinate - Point.originY, 2));
    }

    /**
     * getyCoordinate() method
     *
     * @return the y coordinate stored in this point
     */
    public double getyCoordinate() {
        return yCoordinate;
    }

    /**
     * setyCoordinate() method
     *
     * @param yCoordinate coord to set as the y coordinate of this point
     */
    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * getxCoordinate() method
     *
     * @return the x coordinate stored in this point
     */
    public double getxCoordinate() {
        return xCoordinate;
    }

    /**
     * setxCoordinate() method
     *
     * @param xCoordinate coord to set as the x coordinate of this point
     */
    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

}
