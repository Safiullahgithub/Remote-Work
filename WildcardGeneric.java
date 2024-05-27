package com.company;

import java.util.ArrayList;
import java.util.List;

public class WildcardGeneric{
    public static void main(String[] args) {
        // Creating a list of numbers
        List<Number> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20.5);
        numbers.add(30.3f);

        // Passing the list to a method that accepts a wildcard parameter
        printList(numbers);

        // Creating a list of integers
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        // Passing the list of integers to the same method
        printList(integers);

        // Creating a list of objects
        List<Object> objects = new ArrayList<>();
        objects.add("Hello");
        objects.add(100);

        // Passing the list of objects to the same method
        printList(objects);
    }

    // Method that accepts a wildcard parameterDefining a method
    // printList that accepts a wildcard parameter.
    // The wildcard <?> means that the method can accept a list of any type.
    //The wildcard (?) used in the printList method is an example of an unbounded wildcard,
    // which is neither upper-bounded nor lower-bounded.
    public static void printList(List<?> list) {
        // Iterating over the list
        for (Object obj : list) {
            System.out.println(obj);
        }
        System.out.println(); // Empty line for clarity

    }
}

//Upper-bounded wildcards are denoted by <? extends SomeClass>. They allow the wildcard to represent a specific class or any of its subclasses. For example, List<? extends Number> would accept a List<Integer>, List<Double>, etc., but not a List<String>.
//
//Lower-bounded wildcards are denoted by <? super SomeClass>. They allow the wildcard to represent a specific class or any superclass of that class. For example, List<? super Integer> would accept a List<Integer>, List<Number>, or List<Object>, but not a List<Double>.
