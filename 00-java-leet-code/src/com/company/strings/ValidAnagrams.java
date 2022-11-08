package com.company.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidAnagrams {
  public static boolean isValidAnagrams(String s1, String s2) {
    if(s1.length() != s2.length()) return false;
    HashMap<Character, Integer> counter = new HashMap<>();
    for(int i = 0; i < s1.length(); i++) {
      if(counter.containsKey(s1.charAt(i))) {
        counter.put(s1.charAt(i), counter.get(s1.charAt(i))+1);
      } else {
        counter.put(s1.charAt(i), 1);
      }
      if(counter.containsKey(s2.charAt(i))) {
        counter.put(s2.charAt(i), counter.get(s2.charAt(i))-1);
      } else {
        counter.put(s2.charAt(i), -1);
      }
    }
    List<Integer> values = counter.values().stream().toList();
    for(int i = 0; i < values.size(); i++) {
      if(values.get(i) != 0) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isValidAnagrams("car", "rac"));
    System.out.println(isValidAnagrams("bat", "tab"));
    System.out.println(isValidAnagrams("nickelodeon", "toronto"));
  }
}
