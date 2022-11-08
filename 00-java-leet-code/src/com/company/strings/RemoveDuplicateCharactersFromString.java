package com.company.strings;

import java.util.HashMap;

public class RemoveDuplicateCharactersFromString {

  public static void main(String[] args) {
    String input1 = "AAaaBBc"; // "AaBc"
    String input2 = "aaaabbbbcccc"; // "abc"
    String input3 = "caaaaaat"; // "cat"

    System.out.println(removeDuplicateCharacterFromString(input1));
  }
  public static String removeDuplicateCharacterFromString(String word) {
    HashMap<Character, Boolean> count = new HashMap<>();
    for(int i = 0; i < word.length(); i++) {
      Character current = word.charAt(i);
      count.put(current, true);
    }
    System.out.println(count);
    return count.keySet().toString();
  }
}
