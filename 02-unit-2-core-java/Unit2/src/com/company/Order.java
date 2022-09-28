package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
                    }  else {
                        System.out.println("Sorry we don't seem to have that on the menu");
                    }
                    System.out.println("Would you like to continue ordering? (Y/N)");
                    if(scanner.nextLine().equalsIgnoreCase("N")) {
                        isOrdering = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error selecting item, try again...");
                }
            }
            // Generate receipt
            System.out.println(order);
            // print out Local Date
            System.out.println(order.get(0));
            // print out Local Time
            System.out.println(order.get(1));
            double orderSubtotal = 0.0;
            System.out.println("**********************************************************************");
            for(int i = 2; i < order.size(); i++) {
                String itemType = order.get(i).getClass().getSuperclass().getSimpleName();
                Object orderItem = order.get(i);
                if(itemType.equals("Cupcake")) {
                    ((Cupcake)orderItem).type();
                    orderSubtotal += ((Cupcake)orderItem).getPrice();
                } else if(itemType.equals("Drink")) {
                    ((Drink)orderItem).type();
                    orderSubtotal += ((Drink)orderItem).getPrice();
                }
            }
            order.add("Subtotal: " + orderSubtotal);
            System.out.println("**********************************************************************");
            new CreateFile();
            new WriteToFile(order);

        } else {
            System.out.println("Have a nice day then");
        }
    }
}

class CreateFile {
    public CreateFile() {
        try {
            File salesData = new File("salesData.txt");
            if(salesData.createNewFile()) {
                System.out.println("Receipt file being created...");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Error creating receipt");
            e.printStackTrace();
        }
    }
}

// class to write to file
class WriteToFile {
    public WriteToFile(ArrayList<Object> order) {
        try {
            FileWriter fw = new FileWriter("salesData.txt", true);
            PrintWriter salesWriter = new PrintWriter(fw);
            for(int i = 0; i < order.size(); i++) {
                salesWriter.println(order.get(i));
            }
            salesWriter.println("******************");
            salesWriter.close();
        } catch (IOException e) {
            System.out.println("Receipt printing error");
        }
        System.out.println("Successfully wrote to the file");
    }
}
