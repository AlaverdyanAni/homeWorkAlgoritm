package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
      Task1();
      Task2();

    }

    private static void Task1() {
        IntegerListImpl integerList = new IntegerListImpl(10);
        integerList.add(24);
        integerList.add(12);
        integerList.add(18);
        integerList.add(3, 4);
        integerList.add(4, 8);
        integerList.add(5, 2);
        integerList.add(6, 5);
        integerList.add(7, 34);
        integerList.add(8, 6);
        integerList.add(9, 18);
        integerList.add(10, 26);
        integerList.add(11, 3);
        integerList.add(12, 10);

        System.out.println(integerList);
        integerList.sort();
        System.out.println(integerList);

    }
    private static void Task2() {
        IntegerListImpl integerArrayList = new IntegerListImpl();
        Integer[] array = integerArrayList.createRandomArray(10000);
        Integer[] array1 = Arrays.copyOf(array, array.length);
        Integer[] array2 = Arrays.copyOf(array, array.length);
        Integer[] array3 = Arrays.copyOf(array, array.length);
        Integer[] array4 = Arrays.copyOf(array, array.length);

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

        time = System.currentTimeMillis();
        integerArrayList.quickSort(array4, 0, array4.length - 1);
        System.out.println("Quick Sort time is: " + (System.currentTimeMillis() - time));

    }
}