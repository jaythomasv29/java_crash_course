package lambda_expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3));
        nums.add(4);
        nums.add(5);
        nums.add(6);

        nums.forEach((n)-> System.out.println(n + 5));
        System.out.println(nums);

        String[] names = {"Al", "Betty", "Azir", "Zoe", "James"};
        List<Integer> plus10 = nums.stream()
                .map(x -> x + 10)
                .collect(Collectors.toList());

        List<String> names2 = Arrays.stream(names)
                .filter(x -> x.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println((names2));
        System.out.println(plus10);
    }
}
