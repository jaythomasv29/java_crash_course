package com.company.strings;

public class ReverseAnInteger {
  public static void main (String[] args) {

    // Integer.valueOf() // Turns to a string
    int n1 = 743; // 347
    int n2 = 100; // 347
    System.out.println(reverseAnInteger(n1));
    System.out.println(reverseAnInteger(n2));
    System.out.println((int)'a');
    System.out.println((int)'A');
  }

  public static int reverseAnInteger(int n) {
    StringBuilder reversedString = new StringBuilder();
    String s1 = Integer.toString(n);
    for(int i = s1.length() - 1; i >=0; i--) {
      reversedString.append(s1.charAt(i));
    }
    return Integer.valueOf(reversedString.toString());
  }

//  public static int reverseAnInteger2(int n) {
//    while (n != 0) {
//
//    }
//  }
}
