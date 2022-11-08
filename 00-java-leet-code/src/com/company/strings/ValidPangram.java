package com.company.strings;

public class ValidPangram {
  public static void main(String[] args) {
    String test1 = "Abcdefghijklmnopqrstuvwxyz";
    System.out.println(isValidPangram(test1));

  }

  public static boolean isValidPangram(String word) {
    for(int i = 97; i <= 122; i++) {
      if(!word.contains(Character.toString((char) i).toLowerCase() )) {
        return false;
      }
    }
    return true;
  }
}
