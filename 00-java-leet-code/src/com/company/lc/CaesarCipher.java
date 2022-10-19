package com.company.lc;

import java.util.ArrayList;
import java.util.List;

public class CaesarCipher {
  public static void main(String[] args) {
//    System.out.println(Character.isSpaceChar(' '));
//    System.out.println(getShiftedChar('a', 1));  // b
//    System.out.println(getShiftedChar('z', 1));  // a
//    System.out.println(caesarCipher("hackbright", 1000)); // hackbright
//     System.out.println(caesarCipher("HACKBRIGHT", 1)); // IBDLCSJHIU
//    System.out.println(caesarCipher("AAAA BBBB CCCC", 2));  // CCCC DDDD EEEE
//
//
//    System.out.println(decodeCaesarCipher("ibdlcsjhiu", 1));  //hackbright
//
//    System.out.println(decodeCaesarCipher("IBDLCSJHIU", 1)); //HACKBRIGHT
//    System.out.println(decodeCaesarCipher("K'nn dg dcem", 2)); // I'll be back
    System.out.println(caesarCipher("I'll be back", 300));  //K'nn dg dcem
    System.out.println(decodeCaesarCipher(caesarCipher("I'll be back", 300), 300)); // I'll be back

//    System.out.println(caesarCipher("xyzabcdef", 3)); // abcdefghi
  }
  /*
  params:
  String s: string input to shift by k
  int k: Shift amount
  return: String
   */

  public static char getShiftedChar(char currentChar, int shiftAmount) {
    // check if in uppercase unicode range: [A-Z]
    int currentCharCode = currentChar;
    if(currentCharCode >= 65 && currentCharCode <= 90) {
      int uppercaseEncodedCharCode = currentCharCode + shiftAmount;
      if(uppercaseEncodedCharCode > 90) {  // if unicode is above 90, we must wrap around
        uppercaseEncodedCharCode = uppercaseEncodedCharCode % 90 + 64;
      }
      return (char) uppercaseEncodedCharCode;
      // check if in lowercase unicode range: [a-z]
    } else if (currentCharCode >= 97 && currentCharCode <= 122) {
        int lowercaseEncodedCharCode = currentCharCode + shiftAmount;
        if(lowercaseEncodedCharCode > 122) {  // if unicode is above 122, we must wrap around
          lowercaseEncodedCharCode = lowercaseEncodedCharCode % 122 + 96;
        }
      return (char) lowercaseEncodedCharCode;
    }
    return (char) currentCharCode;  // case where it is not a valid [a-zA-Z], simply return it
  }


  public static String caesarCipher(String s, int k) {
    // check if it is within unicode characters a-z(97 - 122) A-Z(65-90)
    StringBuilder result = new StringBuilder();
    for(int i = 0; i < s.length(); i++) {
      result.append(getShiftedChar(s.charAt(i), k % 26));
    }
    return result.toString();
  }

  public static String decodeCaesarCipher(String s, int k) {
    return caesarCipher(s, (26 - k % 26) );
  }
}
