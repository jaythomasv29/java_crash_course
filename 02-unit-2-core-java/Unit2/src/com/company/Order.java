package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Order {
    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Object> order = new ArrayList<>();
        System.out.println("Hello customer. Would you like to place an order? (Y or N)");
        String placeOrder = scanner.nextLine();
        if(placeOrder.equalsIgnoreCase("y")) {
            order.add(LocalDate.now());
            order.add(LocalTime.now());
            System.out.println("Here is the menu");
            System.out.println("CUPCAKES");
            int itemNumber = 0;
            for (Cupcake c : cupcakeMenu) {
                itemNumber++;
                System.out.println("******** Item number: " + itemNumber + " **********");
                c.type();
                System.out.println("Price: " + c.getPrice());
                System.out.println("************************");

            }
            System.out.println("DRINKS");
            for (Drink d : drinkMenu) {
                itemNumber++;
                System.out.println("******** Item number: " + itemNumber + " **********");
                d.type();
                System.out.println("Price: " + d.getPrice());
                System.out.println("************************");

            }
            boolean isOrdering = true;
            while(isOrdering) {
                System.out.println("What would you like to order? Please use the number associated with each item to order.");
                try {
                    int orderChoice = scanner.nextInt();
                    scanner.nextLine();
                    if(orderChoice <= 3 && orderChoice >= 0) {
                        // ordering from cupcakeMenu
                        order.add(cupcakeMenu.get(orderChoice - 1));
                    } else if (orderChoice > 3 && orderChoice <= 6){
                        // ordering from drinkMenu
                        order.add(drinkMenu.get(orderChoice - 4));
                    } else {
                        System.out.println("Sorry we don't seem to have that on the menu");
                    }
                    System.out.println("Would you like to continue ordering? (Y/N)");
                    if(scanner.nextLine().equalsIgnoreCase("N")) {
                        isOrdering = false;
                    }
                    System.out.println("Your current order: \n");
                    System.out.println(order);

                } catch (InputMismatchException e) {
                    System.out.println("Error selecting item, try again...");
                }



            }

        } else {
            System.out.println("Have a nice day then");
        }
    }
}
