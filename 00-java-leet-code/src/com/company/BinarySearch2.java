package com.company;

public class BinarySearch2 {
  public static int binarySearch2(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if(nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) { // if the mid is higher than the target then eliminate right half
        right = mid - 1;
      } else {  // if the mid is less than target, then eliminate left half
        left = mid + 1;
      }
    }
    return -1;
  }
  public static void main(String[] args) {
    int[] test1 = {1, 3, 5, 7, 9 ,10};
    int target = 5;
    System.out.println(binarySearch2(test1, target));
  }
}
