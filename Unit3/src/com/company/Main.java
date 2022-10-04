package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // Test 1 :
        System.out.println("Test 1:");
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));

        // Test 2
        System.out.println("Test 2:");
        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println(coinChange(coins2, amount2));

        // Test 3
        System.out.println("Test 3:");
        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println(coinChange(coins3, amount3));

        // Test 4
        System.out.println("Test 4:");
        int[] coins4 = {2};
        int amount4 = 1;
        System.out.println(coinChange(coins4, amount4));
    }

    public static int coinChange(int[] coins, int amount) {
        int count = 0;
        int remainingTotal = amount;
        // edge case: if amount == 0
        if(amount == 0) return 0;
        // edge case: if coin is larger than amount return 0
        if(coins[coins.length - 1] > amount) return -1;
        // loop through using While total is <= amount
        // each iteration will have an accumulated total
        int i = coins.length - 1;
        while (remainingTotal > 0) {
            try {
                // loop backwards and see which largest coin is <= difference
                // if the coin is too big, move to the next largest coin that is still within range
                if(coins[i] <= remainingTotal) {
                    remainingTotal -= coins[i];
                    count++;

                } else {
                    i--;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return -1;
            }

        }
        return count;
    }

}
