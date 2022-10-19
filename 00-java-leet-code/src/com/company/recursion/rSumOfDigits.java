package com.company.recursion;

public class rSumOfDigits {
  public static int sumOfDigits(int n) {
    if (n < 0) return -1;
    if(n <= 10) return n; // if(n == 0) return 0;
    return n % 10 + sumOfDigits(n / 10);
  }

  public static void main(String[] args) {
    System.out.println(sumOfDigits(49));
    System.out.println(sumOfDigits(3449));
  }
}
