package com.company.linkedlist;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Test {

  public static void main(String[] args) {
//    Integer numbers[] = new Integer[] {10, 20, 30, 40};
//    List<Integer> list = Arrays.asList(numbers);
//    list.size();
////    list.add(50);
//    list.get(3);
//    System.out.println(list);
//
//    HashSet<Integer> nHashSet = new HashSet<>();
//    nHashSet.add(2);
//    nHashSet.add(0);
//    System.out.println(nHashSet);

    Random random = new Random();
    for (int i = 0; i < 50; i++) {
    int r = random.nextInt(3) + 1; // 1 - 3 (Inclusive)
      System.out.println(r);
    }
  }
}
