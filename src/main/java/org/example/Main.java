package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[]args){
        StringListImpl stringArrayList = new StringListImpl(10);

        stringArrayList.add("ноль");
        stringArrayList.add("один");
        stringArrayList.add("два");
        stringArrayList.add("три");
        stringArrayList.add("четыре");
        stringArrayList.add("пять");
        stringArrayList.add("шесть");
        stringArrayList.add("семь");
        stringArrayList.add("восемь");
        stringArrayList.add("девять");
        System.out.println(stringArrayList);
        //stringArrayList.add("десять");
        //stringArrayList.add(4, "five");

       // stringArrayList.remove(5);
       // stringArrayList.set(0, "0");
       // stringArrayList.set(10, "10");

        //System.out.println(stringArrayList);
       // System.out.println("stringArrayList Item #0: " + stringArrayList.get(0));
      // stringArrayList.clear();
       //System.out.println(stringArrayList);
       //System.out.println("Size: " + stringArrayList.size());
       //System.out.println(stringArrayList.isEmpty());



    }
}