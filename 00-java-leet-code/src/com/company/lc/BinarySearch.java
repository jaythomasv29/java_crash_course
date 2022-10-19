package com.company.lc;

public class BinarySearch {
  public static int binarySearch(int nums[], int num_to_find) {
    int lo = 0, high = nums.length - 1, mid;
    while (high - lo > 1) {
      mid = (high + lo) / 2;  // find the mid point
      // if mid is lower than number to find, then we must move right in the sorted array
      if (num_to_find > nums[mid]) {  // case where number is in upper half
        lo = mid + 1;
        // if mid is greater than number to find
      } else if (num_to_find < nums[mid]) {  // case where number is in lower half
        high = mid;
      } else {
        System.out.println("Found at index " + mid);
        return mid;
      }
    }
    if (nums[lo] == num_to_find) {
      System.out.println("Found At Index " + lo);
      return lo;
    } else if (nums[high] == num_to_find) {
      System.out.println("Found At Index " + high);
      return high;
    } else {
      System.out.println("Not Found");
      return -1;
    }
  }
  public static void main(String[] args) {
    int v[]={1, 3, 4, 5, 6, 7};

      /* List<ArrayList<Integer>> v = new ArrayList<>();
      v.add(new ArrayList<Integer>(Arrays.asList( 1, 3, 4, 5, 6 )));*/
    int To_Find = 7;
    binarySearch(v, To_Find);
//    To_Find = 6;
//    binarySearch(v, To_Find);
//    To_Find = 10;
//    binarySearch(v, To_Find);
  }


}
