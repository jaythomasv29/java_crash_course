package com.company.lc;

public class NumberOf1Bits {
  public static int numOf1Bits(int n) {
    System.out.println(n & 11);
    int count = 0;
    while (n != 0) {
      n = n &(n - 1);
      count += 1;

    }
    return count;
  }

  public static void main(String[] args) {
    int n1 = 00000000000000000000000000001011;
    System.out.println(numOf1Bits(n1));
  }

}
