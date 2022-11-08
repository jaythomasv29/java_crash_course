package com.company.arrays;

import java.util.Arrays;
import java.util.Collections;

public class GetGreastNumberBelowTarget {
  public static void main(String[] args) {
    int[] n1 = {1,2,3,4,5,6,7};
    int target1 = 7;

    int [] n2 = {1,5,4,0,2};
    int target2 = 2;

    System.out.println(getGreatestNumberBelowTarget(n2, target2));
  }

  public static int getGreatestNumberBelowTarget(int[] nums, int target) {
    if(nums.length ==0) return target + 1;
    System.out.println(Arrays.toString(nums));
    int maxVal = Integer.MIN_VALUE;
    for(int i = 0; i < nums.length; i++) {
      if (nums[i] > maxVal && nums[i] < target ) {
        maxVal = nums[i];
      }
    }
    return maxVal;
  }
}
