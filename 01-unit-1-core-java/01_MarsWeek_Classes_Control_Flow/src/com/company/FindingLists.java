package com.company;

import java.util.*;

public class FindingLists {
    public FindingLists() {
        Scanner scanner = new Scanner(System.in);
        try {
            // ArrayList
            ArrayList<String> rockList = new ArrayList<>();
            Thread.sleep(500);
            System.out.println("Welcome back from your expedition. Time to catalog everything you found.");
            System.out.println("Rock data downloaded");
            rockList.add("Rock");
            rockList.add("Weird Rock");
            rockList.add("Smooth Rock");
            rockList.add("Not Rock");
            System.out.println(rockList);
            System.out.println("Perfect");

            // Map
            Thread.sleep(500);
            HashMap<String, String> fossilDirectory = new HashMap<>();
            System.out.println("Fossil data downloaded");
            fossilDirectory.put("Bird Fossil", "The fossil has wings implying it was capable of flight.");
            fossilDirectory.put("Fish Fossil", "The fossil is vaguely fish shaped implies there was once water.");
            fossilDirectory.put("Tooth Fossil", "The tooth from an unknown fossil.");
            System.out.println("Which of the fossils would you like to learn more about (Spelling and Spacing is important) ?");
            try {
                String fossilChoice = scanner.nextLine();
               if(fossilDirectory.containsKey(fossilChoice.toLowerCase())) {
                   System.out.println("Fossil: " + fossilChoice + "\n Description: " + fossilDirectory.get(fossilChoice));
               } else {
                   System.out.println("That fossil does not exist in the directory");
               }
            } catch (InputMismatchException e) {
                System.out.println("Fossil Directory failed");
            }

            Thread.sleep(500);
            HashSet<String> suppliesBrought = new HashSet<>();
            HashSet<String> suppliesUsed = new HashSet<>();
            suppliesBrought.add("Food");
            suppliesBrought.add("Water");
            suppliesBrought.add("Medicine");
            suppliesUsed.add("Food");
            suppliesUsed.add("Water");
            HashSet<String> remainingSupplies = new HashSet<>();
            suppliesBrought.removeAll(suppliesUsed);
            System.out.println(suppliesBrought);
//            Another way to find differences between two sets
//            for(String item : suppliesBrought) {
//                if(!suppliesUsed.contains(item)) {
//                    System.out.println(item);
//                }
//            }




        } catch (InterruptedException e) {
            System.out.println("Error in thread");
        }

    }
}
