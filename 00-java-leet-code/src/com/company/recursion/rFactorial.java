package com.company.recursion;

public class rFactorial {
  public static int rFactorial(int n) {
    if(n < 0) {
      return -1;
    }
    if(n == 0) {
      return 1;
    }
    return n * rFactorial(n - 1);
  }

  public static void main(String[] args) {
    System.out.println(rFactorial(3));
    System.out.println(rFactorial(1));
    System.out.println(rFactorial(0));
  }
}
