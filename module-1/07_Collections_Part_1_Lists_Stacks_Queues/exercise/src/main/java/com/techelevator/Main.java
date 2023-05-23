package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.techelevator.Exercises.interleaveLists;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(7);
        list1.add(1);
        list1.add(3);
        list2.add(2);
        list2.add(5);
        list2.add(7);
        list2.add(9);

        List<Integer> test = interleaveLists(list1,list2);
        System.out.printf(String.valueOf(test));
    }
}
