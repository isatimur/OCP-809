package com.isatimur.ocp.package_3.immutable;

/**
 * Created by tisachenko on 02.03.16.
 */
public final class ImmutableCircle {
    private final Point center;
    private final int radius;

    public ImmutableCircle(int xPos, int yPos, int radius) {
        this.center = new Point(xPos, yPos);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public Point getCenter() {
        return new Point(center.getXPos(),center.getYPos());
    }

    @Override
    public String toString() {
        return "ImmutableCircle[center at :" + center + " and radius is " + radius + "]";
    }

    public static void main(String[] args) {
        ImmutableCircle circle = new ImmutableCircle(0,0,1);
        System.out.println(circle);
    }
}


class Point {
    private int xPos, yPos;

    public Point(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    @Override
    public String toString() {
        return "Point[xPos:" + xPos + ",yPos:" + yPos + "]";
    }
}