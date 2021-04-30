package com.learnjava.javaforloop;

import java.util.ArrayList;
import java.util.List;

public class JavaForEachLoop {

    public static void main(String[] args) {
        int[] intArrays = { 1,2,3,4,5 };

        for ( int i : intArrays )
            System.out.println("Java for each loop with array - " + i);

        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Banana");
        fruits.add("Litchi");

        for ( String i : fruits )
            System.out.println("Java for each loop with Collection is - " + i);
    }
}
