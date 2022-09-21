package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class MarsExpedition {
    public MarsExpedition(){
        // File Setup & Expedition Bootup

        Scanner input = new Scanner(System.in);
        System.out.println("Expedition prep program starting...");
        System.out.println("Booting up...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("Ready");
        // Team Setup
        System.out.println("Hello user. What is your name?");
        try {
            String name = input.nextLine();
            System.out.println("Hi " + name + " - Welcome to the Expedition prep program. \n Are you ready to head out into the new world? \n"
                    + "Type Y or N");
            String excited = input.nextLine();
            String vehicle;
            if(excited.equalsIgnoreCase("Y")) {
                System.out.println("Knew you would say that. You are team leader for a reason.");
            } else {
                System.out.println("Too bad you are team leader. You have to go.");
            }
            System.out.println("How many people do you want on your expedition team? (Input an int number)");
            int teamSize = input.nextInt();
            input.nextLine();
            if(teamSize > 2) {
                System.out.println("That's way too many people. We can only send 2 more people");

            } else if (teamSize < 2) {
                System.out.println("That's not enough people. We need you and 2 more members");
            }
            else {
                System.out.println("That's a perfect sized team Good job.");
            }
            teamSize = 2;
            // Final Print
            System.out.println("You are allowed to bring one weapon with you. You know, just incase What do you want to bring?");
            String weapon = input.nextLine();
            System.out.println("Nice choice, you will be bringing a " +  weapon + " with you.");
            System.out.println("You have the choice of 3 vehicles \n A: Mars Rover \n B: A Chevy Silverado \n C: A Honda Civic");
            String vehicleChoice = input.nextLine();
            switch(vehicleChoice.toUpperCase()) {
                case "A":
                    vehicle = "Mars Rover";
                    break;
                case "B":
                    vehicle = "Chevy Silverado";
                    break;
                case "C":
                    vehicle = "Honda Civic";
                    break;
                default:
                    vehicle = "No vehicle selected, You will walk with your feet.";
            }
            System.out.println("Your expedition team is now ready " +
                    "\n Led by " + name + " with " + teamSize + " teammates. " +
                    "\n To explore the surface of Mars using " + vehicle + ". " +
                    "\n Exploration team heads out in " +
                    "\n 5\n 4\n 3\n 2 \n 1 \n GO GO GO!");

        } catch (InputMismatchException e) {
            System.out.println("Mars Expedition Failed, Try again...");
        }
        finally {
            input.close();
        }

    }


}
