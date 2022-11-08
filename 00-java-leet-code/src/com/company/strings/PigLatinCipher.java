package com.company.strings;

public class PigLatinCipher {
  public static String pigLatinWord(String word) {
    int firstVowelIdx = findFirstVowel(word);
    if(firstVowelIdx == -1) return word;
    return word.substring(firstVowelIdx, word.length() - 1) + word.substring(0, firstVowelIdx) + "ey";
  }

  public static int findFirstVowel(String word) {
    String vowels = "aeiou";
    for(int i = 0; i < word.length(); i++) {
      if(vowels.indexOf(word.toLowerCase().charAt(i)) > -1) {
        return i;
      }
    }
    return -1;
  }

  public static String pigLatinSentence(String sentence) {
    String[] words = sentence.split(" ");
    String[] pigLatinWords = new String[words.length];
    for(int i = 0; i < words.length; i++) {
      pigLatinWords[i] = pigLatinWord(words[i]);
    }
    return String.join(" ", pigLatinWords);
  }

  public static void main(String[] args) {
    System.out.println(pigLatinWord("church")); // urchch
    System.out.println(pigLatinSentence("hello world")); // hello world -> elloh orldw
  }
}
