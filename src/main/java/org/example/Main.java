package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Task1();
        Task2();
    }

    public static void Task1() {
        IntegerListImpl integerList = new IntegerListImpl();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(3,4);

        System.out.println(integerList.contains(4));
        System.out.println(integerList.contains(14));
    }

    public static void Task2() {
        IntegerListImpl integerArrayList = new IntegerListImpl();
        Integer[] array = integerArrayList.createRandomArray(100000);
        Integer[] array1 = Arrays.copyOf(array, array.length);
        Integer[] array2 = Arrays.copyOf(array, array.length);
        Integer[] array3 = Arrays.copyOf(array, array.length);

        long time;

        time = System.currentTimeMillis();
        integerArrayList.sortBubble(array1);
        System.out.println("Sort Bubble time is: " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        integerArrayList.sortSelection(array2);
        System.out.println("Sort Selection time is: " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        integerArrayList.sortInsertion(array3);
        System.out.println("Sort Insertion time is: " + (System.currentTimeMillis() - time));

    }
}
