package com.company.strings;

import java.util.Random;

public class LongestCommonPrefix {
  public static String LongestCommonPrefix(String[] strs) {
    if(strs.length == 0) return "";
    // start with first index as prefix
    String prefix = strs[0];
    // loop through all String[] elements
    for(int i = 1; i < strs.length; i++) {

      // check current element until we have a match at 0
      while(strs[i].indexOf(prefix) != 0) {
        // substring until matches with strs[i]
        prefix = prefix.substring(0, prefix.length() - 1);
      }
    }
    return prefix;
  }

  public static void main(String[] args) {
    String[] test1 = {"flower", "flow", "flight"};
    System.out.println(LongestCommonPrefix(test1));
    Random random = new Random();




  }
}
