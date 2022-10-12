package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BestBuyAndSell {
    public static void main(String[] args) {
//        int[] prices1 =  {7, 1, 5, 3, 6, 4};
//        System.out.println(bestBuyAndSell(prices1));  // 5: Pass
//
//        int[] prices2 =  {7, 6, 4, 3, 1};
//        System.out.println(bestBuyAndSell(prices2));  // 0: Pass
//
//        int[] prices3 = {1, 2};
//        System.out.println(bestBuyAndSell(prices3)); // 1: Pass

        int[] prices4 = {2, 4, 1};
        System.out.println(bestBuyAndSell(prices4));
    }

    public static int bestBuyAndSell(int[] prices) {
        // set initial variables
        int minBuyPrice = prices[0];
        int buyIdx;
        int maxSellPrice;
        // use list as reference to get index
        ArrayList<Integer> list = IntStream.of(prices)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        // loop through to find minimum price
        for(int i = 0; i < prices.length; i++) {
            minBuyPrice = Math.min(minBuyPrice, prices[i]);
        }
        buyIdx = list.indexOf(minBuyPrice);

        ArrayList<Integer> validSellPrices = new ArrayList(list.subList(buyIdx, list.size() ));
        System.out.println(validSellPrices);
        try {
            // if there is no validSellPrices, then the buyIdx is at the end, therefore no valid sell price
            maxSellPrice = Collections.max(validSellPrices);
            return maxSellPrice - minBuyPrice;
        } catch (Exception e) {
            return 0;
        }

    }
//    Input: prices = [7,1,5,3,6,4]
    public static int maxProfit(int[] prices) {
        int min_val = Integer.MAX_VALUE;  // track min val 7, 1
        int max_profit = 0; // 4, 5
        // loop through each of the prices
        for(int i = 0; i < prices.length; i++) {
            // if current price is LESS THAN min_val (in order to find lowest buy price)
            if(prices[i] < min_val) {
                // store new lowest buy price
                min_val = prices[i];
            // find the new HIGHEST profit value
            } else if ((prices[i] - min_val) > max_profit) {
                // store new max profit
                max_profit = prices[i] - min_val;
            }
        }
        return max_profit;
    }
}
