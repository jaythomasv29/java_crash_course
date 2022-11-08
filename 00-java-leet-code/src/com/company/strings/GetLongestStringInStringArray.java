package com.company.strings;

public class GetLongestStringInStringArray {
  public static String getLongestStringInArr(String[] words) {
    int longestWordIndex = 0;
    for(int i = 0; i < words.length; i++){
      if(words[longestWordIndex].length() <= words[i].length()) {
        longestWordIndex = i;
      }
    }
    return words[longestWordIndex];
  }

  public static void main(String[] args) {
    String[] sArr1 = {"pig", "blanket", "cone", "lemonade", "tunatuna"};
    System.out.println(getLongestStringInArr(sArr1)); // "lemonade
  }
}
