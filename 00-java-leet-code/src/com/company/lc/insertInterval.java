package com.company.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class insertInterval {

  public static void main(String[] args) {
    int[][] intervals1 = {{1,3},{6,9}};
    int[] newInterval1 = {2,5};
    int[][] result1 = insert(intervals1, newInterval1);
    toString(result1);
//    System.out.println(Arrays.toString(result1));

    int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
    int[] newInterval2 = {4,8};
    int[][] result2 = insert(intervals2, newInterval2);
    toString(result2);
//    System.out.println(Arrays.toString(result2));

  }

//  Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
  public static int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList();
    // loop through each interval
    for(int[] interval: intervals) {
        // check if newInterval upperbound is less than current lowerbound
        // find the lesser interval pairs without overlap
        // interval:[1(check), 3] newInterval: [2 ,5(check)]
        // 5 < 1 ?
       if(interval[0] > newInterval[1]) {
         result.add(newInterval);
         newInterval = interval;
       }  // compare the end value of interval with start value of newInterval
      // if end bound is LESS than new lower bound there is NO overlap
      // add the lesser interval interval:[1,3(check)] newInterval: [2(check), 5] result: []
      // 3 < 2 ?
      else if(interval[1] < newInterval[0]) {
         result.add(interval);
         // In case which there is an overlap, get the min and the max between the two
       } else {
        // check for new lowerbound and upperbound
        newInterval[0] = Math.min(newInterval[0], interval[0]);
        newInterval[1] = Math.max(newInterval[1], interval[1]);
      }
    }
    result.add(newInterval);
    return result.toArray(new int[result.size()][]);
  }

  public static String toString(int[][] intervals) {
    String result= "";
    for(int[] i : intervals) {
      result += Arrays.toString(i);
    }
    System.out.println(result);
    return result;
  }

}
