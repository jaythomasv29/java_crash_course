package com.company.strings;

public class ReplaceVowelsInAString {
  public static String replaceVowelsInAString(String input) {
    StringBuilder result = new StringBuilder();
    String vowels = "aeiou";
    for(int i = 0; i < input.length(); i++) {
      if(vowels.contains(Character.toString(input.charAt(i)).toLowerCase())) {
        result.append("*");
      } else {
        result.append(input.charAt(i));
      }
    }
    return result.toString();

  }

  public static void main(String[] args) {

  }
}
