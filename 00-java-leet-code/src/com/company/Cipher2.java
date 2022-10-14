
public class Cipher2 {
  public static void main(String[] args) {
    System.out.println(getShiftedChar('a', 1));  // b
    System.out.println(getShiftedChar('z', 1));  // a
    System.out.println(caesarCipher("hackbright", 26)); // ibdlcsjhiu
    System.out.println(caesarCipher("HACKBRIGHT", 1)); // IBDLCSJHIU
    System.out.println(caesarCipher("AAAA BBBB CCCC", 2));  // CCCC DDDD EEEE
    System.out.println(caesarCipher("I'll be back", 2));  //K'nn dg dcem

    System.out.println(decodeCaesarCipher("ibdlcsjhiu", 1));  //hackbright

    System.out.println(decodeCaesarCipher("IBDLCSJHIU", 1)); //HACKBRIGHT
    System.out.println(decodeCaesarCipher("K'nn dg dcem", 2)); // I'll be back

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
    int offset = shiftAmount % 26;
    if(currentCharCode >= 65 && currentCharCode <= 90) {
      currentChar = getNewCharValue(currentCharCode, offset, 65, 90);
    } else if (currentCharCode >= 97 && currentCharCode <= 122) {
      currentChar = getNewCharValue(currentCharCode, offset, 97, 122);
    }

    return currentChar;  // case where it is not a valid [a-zA-Z], simply return it
  }

  private static char getNewCharValue(int originalPos, int offset, int lowerPosIndex, int upperPosIndex) {
    int uppercaseEncodedCharCode = (originalPos + offset) % upperPosIndex;
    if(uppercaseEncodedCharCode < lowerPosIndex)
      uppercaseEncodedCharCode += lowerPosIndex - 1;
    return (char) uppercaseEncodedCharCode;
  }

  public static String caesarCipher(String s, int k) {
    // check if it is within unicode characters a-z(97 - 122) A-Z(65-90)
    StringBuilder result = new StringBuilder();
    for(int i = 0; i < s.length(); i++) {
      result.append(getShiftedChar(s.charAt(i), k));
    }
    return result.toString();
  }

  public static String decodeCaesarCipher(String s, int k) {
    // check if it is within unicode characters a-z(97 - 122) A-Z(65-90)
    // int shiftedAmount = (26 - k) % 26; -> reverse the shift
//        StringBuilder result = new StringBuilder();
//        for(int i = 0; i < s.length(); i++) {
//            result.append(getShiftedChar(s.charAt(i), (26 - k % 26)));
//        }
//        return result.toString();
    return caesarCipher(s, (26 - k % 26));
  }
}
