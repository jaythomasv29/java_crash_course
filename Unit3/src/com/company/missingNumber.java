package com.company;

import java.util.Arrays;
import java.util.stream.IntStream;

public class missingNumber {
  public static void main(String[] args) {
    int[] nums1 = {3, 0 ,1};
    System.out.println(missingNumber(nums1)); // 2

    int[] nums2 = {0, 1};
    System.out.println(missingNumber(nums2)); // 2

    int[] nums3 = {9,6,4,2,3,5,7,0,1};
    System.out.println(missingNumber(nums3)); // 8
  }
  public static int missingNumber(int[] nums) {
    IntStream range0toLengthInclusive = IntStream.rangeClosed(0, nums.length);
    int sumOfRange = (range0toLengthInclusive.sum());
    int currentSum = (Arrays.stream(nums).sum());
    // the missing number is the sum of the range from (0 to length) minus sum of nums[]
    return sumOfRange - currentSum;
  }
}
