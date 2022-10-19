package com.company.recursion;

public class rCountDown {
  public static int rCountDown(int n) {
    if(n == 0) {
      System.out.println("countdown complete");
      return 0;
    }
    System.out.println(n);
    return rCountDown(n - 1);
  }

  public static void main(String[] args) {
    rCountDown(10);
  }
}
