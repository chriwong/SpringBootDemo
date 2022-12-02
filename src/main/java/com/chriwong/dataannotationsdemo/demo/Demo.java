package com.chriwong.dataannotationsdemo.demo;

import java.util.*;

public class Demo {
    public static void main(String[] args) {

        // *Polymorphism*
        List<String> names = new ArrayList<>();
        names = new Vector<>();
        names = new Stack<>();

        // Example of how implementing interfaces is useful
        List<Point2D> myPoints = new ArrayList<>();
        myPoints.add(new Point2D(10000,3481.12301));
        myPoints.add(new Point2D( 2,3));
        myPoints.add(new Point2D(1,1));
        myPoints.add(new Point2D(100,100));
        myPoints.add(new Point2D(-50,-47));

        myPoints.sort(null);        // this is OK because the class implements Comparable!

        // this way of writing it is more common (it's not super intuitive that null would default to using the class' .compareTo())
//        myPoints.sort(Point2D::compareTo);

        for (Point2D p : myPoints) {
            System.out.println(p.getX());
        }


        // *Abstration*
        // What actually happens here...?
        // You can see the source code for ArrayList.add() - pretty complicated for a seemingly trivial operation
        names.add("John Doe");
        names.add("Alice Zhang");
        names.add("Claire Dupont");
        names.add("Christian Wong");

        // and what _exactly_ is .sort()?
        // Sure we could go study sorting algorithm performance and try to really get a grasp.
        // But honestly, I'm ok with it doing its magic and me continuing to live in blissful ignorance...
        String[] namesArray = names.toArray(new String[0]);
        Arrays.sort(namesArray);

        for (String n : namesArray) {
            System.out.println(n);
        }

    }
}
