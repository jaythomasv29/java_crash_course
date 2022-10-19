package com.company.lc;

public class ValidPalindrome {
  public static void main(String[] args) {
    String s1 = "A man, a plan, a canal: Panama";
    System.out.println(isValidPalindrome(s1));  // true

    String s2 = "race a car";
    System.out.println(isValidPalindrome(s2)); // false

    String s3 = "0P";
    System.out.println(isValidPalindrome(s3)); // false

    String s4 = "p";
    System.out.println(isValidPalindrome(s4)); // true

  }
  public static boolean isValidPalindrome(String s) {
    String letters = (s.replaceAll("[^a-zA-Z0-9]", "")).toLowerCase();
    int front = 0;
    int back = letters.length() -1;
    int midpoint = letters.length() / 2;
    while(front <= midpoint && back >= midpoint) {
      if(letters.charAt(front) != letters.charAt(back)){
        return false;
      };
      front++; back--;
    }
    return true;
  }
}
