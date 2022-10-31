package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[]args){
        StringListImpl stringArrayList = new StringListImpl(10);


        stringArrayList.add("один");
        stringArrayList.add("два");
        stringArrayList.add("три");
        stringArrayList.add("четыре");
        stringArrayList.add("пять");
        stringArrayList.add("шесть");
        stringArrayList.add("семь");
        stringArrayList.add("восемь");
        stringArrayList.add("девять");
        stringArrayList.add("десять");
        System.out.println(stringArrayList);
        stringArrayList.add("одиннадцать");
        stringArrayList.add("двиннадцать");
        stringArrayList.add(0, "ноль");
        System.out.println(stringArrayList);
        stringArrayList.remove(5);
        stringArrayList.remove("двиннадцать");
        System.out.println(stringArrayList);
        stringArrayList.set(5,"пять");
        stringArrayList.set(0,"0");
        stringArrayList.add(6,"шесть");
        System.out.println(stringArrayList);


        System.out.println("stringArrayList Item N5: " + stringArrayList.get(5));
        stringArrayList.clear();
        System.out.println(stringArrayList);
        System.out.println("Size: " + stringArrayList.size());
        System.out.println(stringArrayList.isEmpty());



    }
}