package com.company.lc;

public class countingBits {
  public static int[] calcArray(int n) {
    int[] result = new int[n+1];
    for(int i = 0; i<=n;i++){
      result[i]=countBits(i);
    }
    return result;
  }

  public static int countBits(int number) {
    int result = 0;
    for(int i = 0; i<32; i++) {
      result += ((number>>i) & 1);
    }
    return result;
  }
  public static void main(String[] args) {

  }
}
