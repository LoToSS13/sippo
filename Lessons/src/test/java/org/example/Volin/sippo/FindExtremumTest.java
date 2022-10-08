package org.example.Volin.sippo;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.function.Function;

public class FindExtremumTest
{

    @Test
    public void constructorTest1() {
        Point2D point = new Point2D(10, 20);
        point.print();
        assertEquals(10.0, point.getXCoordinate(), 0.000001);
        assertEquals(20.0, point.getYCoordinate(), 0.000001);
    }
    @Test
    public void constructorTest2() {
        Point2D point = new Point2D();
        point.print();
        assertEquals(0.0, point.getXCoordinate(), 0.000001);
        assertEquals(0.0, point.getYCoordinate(), 0.000001);
    }

    @Test
    public void equalsTest() {
        Point2D point1 = new Point2D(10, 20);
        Point2D point2 = new Point2D(10, 20);
        Point2D point3 = new Point2D(0, 0);
        Point2D point4 = new Point2D();
        Point2D point5 = new Point2D(20, 10);

        assertEquals(point1, point2);
        assertEquals(point3, point4);
        assertNotEquals(point1, point3);
        assertNotEquals(point1, point5);

    }
    @Test
    public void constructorTest3() {
        String str1 = "(10;20)";
        String str2 = "(10.0;20.0)";
        String str3 = "           ( 10 ;  20  )                     ";
        String str4 = "              (10 ; 20)                 ";
        Point2D point1 = new Point2D(str1);
        Point2D point2 = new Point2D(str2);
        Point2D point3 = new Point2D(str3);
        Point2D point4 = new Point2D(str4);

        assertEquals(10, point1.getXCoordinate(), 0.001);
        assertEquals(10, point2.getXCoordinate(), 0.001);
        assertEquals(10, point3.getXCoordinate(), 0.001);
        assertEquals(10, point4.getXCoordinate(), 0.001);
        assertEquals(20, point1.getYCoordinate(), 0.001);
        assertEquals(20, point2.getYCoordinate(), 0.001);
        assertEquals(20, point3.getYCoordinate(), 0.001);
        assertEquals(20, point4.getYCoordinate(), 0.001);

    }
    @Test (expected = IllegalArgumentException.class)
    public void constructorTest4() {
        String str1 = "        ";
        Point2D point1 = new Point2D(str1);
    }

    @Test
    public void findExtremumTest(){
        FindExtremum findExtremum = new FindExtremum();
        Function<Double, Double> function1 = (x) -> {
            return Math.pow(x + 1, 3) + 5 * Math.pow(x, 2);
        };
        Function<Double, Double> function2 = (x) -> {
            return Math.log(x) + 9 * x*x;
        };
        Function<Double, Double> function3 = (x) -> {
            return Math.pow(x,4) + 2 * x * x + 4 * x + 1;
        };



        assertEquals(10.000002691042, findExtremum.findMin("in.txt", function1).getXCoordinate(), 0.001);
        assertEquals( 1831.0012 , findExtremum.findMin("in.txt", function1).getYCoordinate(), 2);

        assertEquals(10.00000063529, findExtremum.findMin("in.txt", function2).getXCoordinate(), 0.001);
        assertEquals( 901.0001 , findExtremum.findMin("in.txt", function2).getYCoordinate(), 2);


        assertEquals(10.000000392688, findExtremum.findMin("in.txt", function3).getXCoordinate(), 0.001);
        assertEquals( 10241.0016 , findExtremum.findMin("in.txt", function3).getYCoordinate(), 2);


    }

}
