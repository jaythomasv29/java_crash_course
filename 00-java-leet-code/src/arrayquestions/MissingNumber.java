package arrayquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MissingNumber {
  public static int missingNumber(int[] intArray) {
    ArrayList<Integer> nums = new ArrayList<>(Arrays.stream(intArray).boxed().collect(Collectors.toList()));
    for(int i = 1; i < nums.size(); i++) {
      if(!nums.contains(i)) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int intArray[] = {1, 2, 3, 4, 5, 6, 8, 9, 10};
    System.out.println(missingNumber(intArray));
  }
}
