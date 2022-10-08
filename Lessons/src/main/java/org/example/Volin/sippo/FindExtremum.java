package org.example.Volin.sippo;

import java.io.*;
import java.util.function.Function;


public class FindExtremum {
    Function<Double, Double> func;
    final private double PHI = (1 + Math.sqrt(5)) / 2;
    public Point2D findMin(String fileName, Function<Double, Double> function) {
        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {
            String line = br.readLine();


            int startOfACoordinates = line.indexOf("(");
            int endOfACoordinates = line.indexOf(")");
            String aCoordinates = line.substring(startOfACoordinates, endOfACoordinates + 1 );


            int startOfBCoordinates = line.indexOf("(", endOfACoordinates);
            int endOfBCoordinates = line.indexOf(")", endOfACoordinates+1);
            String bCoordinates = line.substring(startOfBCoordinates , endOfBCoordinates + 1 );


            Point2D leftBound = new Point2D(aCoordinates);
            Point2D rightBound = new Point2D(bCoordinates);

            double e = Double.parseDouble(line.substring(endOfBCoordinates + 1));

            double x1, x2;

            Point2D point1 = new Point2D();
            Point2D point2 = new Point2D();


            if( leftBound.getXCoordinate()  > rightBound.getXCoordinate() ){
                Point2D buffer = rightBound;
                rightBound = leftBound;
                leftBound = buffer;
            }

            do {
                x1 = rightBound.getXCoordinate() - (rightBound.getXCoordinate() - leftBound.getXCoordinate()) / PHI;
                x2 = leftBound.getXCoordinate() + (rightBound.getXCoordinate() - leftBound.getXCoordinate()) / PHI;

                point1.setXCoordinate(x1);
                point1.setYCoordinate(function.apply(x1));
                point2.setXCoordinate(x2);
                point2.setYCoordinate(function.apply(x2));

                if (function.apply(x1) >= function.apply(x2)) {
                    leftBound.setXCoordinate(point1.getXCoordinate());
                } else {
                    rightBound.setXCoordinate(point2.getXCoordinate());
                }
            } while (Math.abs(rightBound.getXCoordinate()) - leftBound.getXCoordinate() >= e);

            return new Point2D((leftBound.getXCoordinate() + rightBound.getXCoordinate()) / 2, function.apply((leftBound.getXCoordinate() + rightBound.getXCoordinate()) / 2));

        } catch (IOException ex) {
            throw new  IllegalArgumentException("Wrong file name or file input");
        }

    }


}
