package com.company.recursion;

public class rFibonacci {
  public static int rFibonacci(int n) {
    if(n < 0) return -1;
    if(n == 0 || n == 1) return n;
    return rFibonacci(n - 1) + rFibonacci(n - 2);
  }

  public static void main(String[] args) {
    System.out.println(rFibonacci(5));
  }
}
