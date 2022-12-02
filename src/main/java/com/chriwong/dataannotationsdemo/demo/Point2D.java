package com.chriwong.dataannotationsdemo.demo;

public class Point2D implements Comparable<Point2D> {

    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * This returns square root of sum of squares: sqrt(x^2 + y^2)
     */
    public double getCartesianDistance() {
        return Math.sqrt((this.x * this.x) + (this.y * this.y));
    }

    /**
     * Compares two points using Cartesian distances
     */
    @Override
    public int compareTo(Point2D anotherPoint) {
        double myDistance = this.getCartesianDistance();
        double anotherDistance = anotherPoint.getCartesianDistance();

        // return +1 if "greater than"
//        if (myDistance > anotherDistance) {
//            return 1;
//        }
//        // return -1 if "less than"
//        else if (myDistance < anotherDistance) {
//            return -1;
//        }
//        // return 0 if "equal to"
//        else {
//            return 0;
//        }
        // The above works fine, but here's a little trick.
        // Small - large => negative
        // Large - small => positive
        // Same - same => zero.
        // The only thing is, this will result in precision issues due to typecasting (but I'm ok with it since nothing is mission-critial).
        return (int)(myDistance - anotherDistance);
    }
}
