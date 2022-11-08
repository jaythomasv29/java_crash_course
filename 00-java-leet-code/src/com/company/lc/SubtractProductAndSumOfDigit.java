package com.company.lc;

public class SubtractProductAndSumOfDigit {
  public static int subtractProductAndSumOfDigit(int n) {
    int sum = 0;
    int product = 1;
    while(n > 0) {
      int firstDigit = n % 10;
      sum += firstDigit;
      product *= firstDigit;
      n /= 10;
    }
    return product - sum;
    }
  public static void main(String[] args) {
    System.out.println(subtractProductAndSumOfDigit(243));
    System.out.println(subtractProductAndSumOfDigit(4421));
  }
}
