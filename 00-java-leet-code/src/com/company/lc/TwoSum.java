package com.company.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
//    Input: nums = [2,7,11,15], target = 9
//    Output: [0,1]

    // loop through and create a hashmap to store the indicies of each element
    // continuously search for a difference and make sure the search doesn't involve the same index
    // if a pair is found (num - pair = target) then break out the looop and return the indicies
    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println(Arrays.toString(twoSum(nums1, target1)));

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(nums2, target2)));

        int[] nums3 = {3,3};
        int target3 = 6;
        System.out.println(Arrays.toString(twoSum(nums3, target3)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int missingPair;
        HashMap<Integer, Integer> indexes = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            missingPair = target - nums[i];
            // if the missing pair is already in the hashmap && not equal to the same number, then -> return current index & missingPair index
            if(indexes.containsKey(missingPair)) {
                return new int[] {i, indexes.get(missingPair)};
            }
            indexes.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

}
