package com.company.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class AverageEvenNumbersOnly {
  public static void main(String[] args) {
    int[] n = {1,2,3,4,5};
    List<Integer> numbers = new ArrayList<>(Arrays.stream(n).boxed().toList());
    List<Integer> evenNumbers = numbers.stream().filter(num -> num % 2 == 0).toList();
    Integer sumOfEvenNumbers = evenNumbers.stream().reduce(0,(a, b)-> a + b);
    System.out.println(sumOfEvenNumbers / evenNumbers.size());
    int[] arr1 = {1,2,3,4};
    int[] arr = new int[arr1.length];
    int sum = 0;
    for(int i = 0; i < arr1.length; i++) {
      sum += arr1[i];
      arr[i] = (sum);
    }
    int count = 0;
    String s1 = "hello";
    for(char s : s1.toCharArray()) {
      count++;
    }
    System.out.println(count);

//    largestAndSmallest
    int[] nums = {1,2,3,4,5};
    largestAndSmallest(nums);

  }
  public static void largestAndSmallest(int[] nums) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for(int i = 0; i < nums.length; i++) {
      if(max < nums[i]) {
         max = nums[i];
      }
      if(min > nums[i]) {
        min = nums[i];
      }
    }
    System.out.println("Min Value: " + min + " Max Value: " + max);
  }
}
