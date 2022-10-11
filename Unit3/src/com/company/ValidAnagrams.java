package com.company;

import java.util.HashMap;

public class ValidAnagrams {
  public static void main(String[] args) {
    String s1 = "anagram"; String t1 = "nagaram";
    System.out.println(validAnagrams(s1, t1));  // true

    String s2 = "rat"; String t2 = "car";
    System.out.println(validAnagrams(s2, t2));  // false

    String s3 = "aacc"; String t3 = "ccac";
    System.out.println(validAnagrams(s3, t3));  // false
  }

  public static boolean validAnagrams(String s, String t) {
    // edge case where not the same length
    if(s.length() != t.length()) return false;
    int[] alphabet = new int[26];

    // store wordMap to count letters

    for(int i = 0; i < s.length(); i++) {
      // if it exists, increment the count
      alphabet[s.charAt(i) - 'a']++;
      alphabet[t.charAt(i) - 'a']--;
    }

    for (Integer val : alphabet) {
      if(val < 0) return false;
    }
    return true;
  }
}
