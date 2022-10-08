package org.example.Volin.sippo;

import java.util.Objects;

public class Point2D {
    private double xCoordinate;
    private double yCoordinate;

    public Point2D ( double xCoordinate, double yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
    public Point2D (){
        this.xCoordinate = 0.0;
        this.yCoordinate = 0.0;
    }

    public Point2D (String coordinates) {
        try {
            int startPosition = coordinates.indexOf("(");
            int endPosition = coordinates.indexOf(")");
            int middlePosition = coordinates.indexOf(";");
            this.xCoordinate = Double.parseDouble(coordinates.substring(startPosition + 1, middlePosition));
            this.yCoordinate = Double.parseDouble(coordinates.substring(middlePosition + 1, endPosition));
        }catch (Exception e){
            throw new  IllegalArgumentException("Wrong input");
        }

    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void print (){
        System.out.println("Coordinates : (" + xCoordinate + "; " + yCoordinate + ") ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point2D)) return false;
        Point2D point2D = (Point2D) o;
        return Double.compare(point2D.xCoordinate, xCoordinate) == 0 && Double.compare(point2D.yCoordinate, yCoordinate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
