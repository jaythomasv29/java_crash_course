package com.company.strings;

import java.util.HashMap;

public class UniqueCharactersInAString {
  public static int uniqueCharactersInAString(String input) {
    HashMap<Character, Integer> frequency = new HashMap<Character, Integer>();
    for(int i = 0; i < input.length(); i++) {
      if(frequency.containsKey(input.charAt(i))) {
        frequency.put(input.charAt(i), frequency.get(input.charAt(i))+ 1);
      } else {
        frequency.put(input.charAt(i), 1);
      }
    }
    return frequency.keySet().size();
  }

  public static void main(String[] args) {
    System.out.println(uniqueCharactersInAString("AABBCCaa"));
  }
}
