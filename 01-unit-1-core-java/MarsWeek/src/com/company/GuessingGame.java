package com.company;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public GuessingGame() {
        Scanner input = new Scanner(System.in);
        System.out.println("Let's play a guessing game!");
        boolean correctGuess = false;
        int guess = 0;
        int increment = 0;
        System.out.println("Hello user, What is your name?");
        String name = input.nextLine();
        System.out.println("Welcome " + name + " I'm thinking of a number between 1 and 100");
        Random rand = new Random();
        int generatedNum = rand.nextInt(100);

        System.out.println("Try to guess my number (1 - 100)");
        do {
            try {
                System.out.println(generatedNum);
                increment++;
                int userGuess = input.nextInt();

                if(userGuess == generatedNum) {
                    System.out.println("You guessed correctly in " + increment + " tries");

                    correctGuess = true;

                } else if (userGuess < 1 || userGuess > 100 ) {
                    System.out.println("Your guess is out of range (1 - 100)");
                } else if (userGuess < generatedNum) {
                    System.out.println("You guessed too low, try again");
                } else if (userGuess > generatedNum) {
                    System.out.println("You guessed too high, try again");
                }

            } catch(InputMismatchException e) {
                increment++;
                System.out.println("Please try again and enter a valid integer...Game over");
                input.nextLine();
//                correctGuess = true;
            }
        } while(!correctGuess);


    }





}
