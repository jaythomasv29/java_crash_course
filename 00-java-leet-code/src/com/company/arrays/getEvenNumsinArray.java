package com.company.arrays;

import java.util.ArrayList;
import java.util.List;

public class getEvenNumsinArray {
  public static int[] getEvenNumbers(int[] nums) {
    if(nums.length == 0) return new int[0];
    List<Integer> evenNums = new ArrayList<>();
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] % 2 == 0) {
        evenNums.add(nums[i]);
      }
    }
    int[] result = new int[evenNums.size()];
    for(int i = 0; i < evenNums.size(); i++) {
      result[i] = (evenNums.get(i));
    }
    return result;
  }

  public static void main(String[] args) {
    int[] numbers = {1,2,3,4,5,6,7,8};
    System.out.println(getEvenNumbers(numbers));
    String s = "hello";
    System.out.println(s.length());

    for(int n : numbers) {
      System.out.println(n);
    }
  }
}
