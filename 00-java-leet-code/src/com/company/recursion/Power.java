package com.company.recursion;

public class Power {
  public static int power(int base, int exp) {
    if(exp < 0) return -1;
    if(exp == 0) return 1;
    if(exp == 1) return base;

    return base * power(base, exp - 1);
  }

  public static void main(String[] args) {
    System.out.println(power(2, -1));
  }
}
