package com.company.strings;

public class CaesarCipher {
  public static  String caesarCipher(String word, int offset) {
    if(word.isEmpty()) return "";
    StringBuilder result = new StringBuilder();
    String alphabet = "abcdefghijklmnopqrstuvwxyz";

    for(int i = 0; i < word.length(); i++) {
      char currentChar = Character.toLowerCase(word.charAt(i));  // current char ‘h’
      int newIndex = (alphabet.indexOf(currentChar) + offset) % 26; // (10 % 26) -> 10
      result.append(Character.toUpperCase(alphabet.charAt(newIndex)));
    }
    return result.toString();
  }


}
