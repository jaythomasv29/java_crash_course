package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Person bob = new Person("Bob", 28);
        Person alphonse = new Person("Alphonse", 30);
        Person lily = new Person("Lily", 25);
        Person marcus = new Person("Marcus", 22);
        Person jess = new Person("Jess", 20);
        Person[] persons = new Person[] { bob, alphonse, lily, marcus, jess };

        HashMap<Integer, Person> people = new HashMap<>();
        people.put(13530, bob);
        people.put(48851, alphonse);
        people.put(97531, lily);
        people.put(25545, marcus);
        people.put(92862, jess);

        for(Integer key : people.keySet()) {
            System.out.println(people.get(key));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a user name / id to search for");
        String input = scanner.nextLine();
        searchByIdOrName(input, people);


//        End Unit 2 Challenge ^
//        Unit 2 Part 1
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<>();
        Cupcake cupcake = new Cupcake(0.00);
        RedVelvet redVelvet = new RedVelvet(0.00);
        Chocolate chocolate = new Chocolate(0.00);
        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);

        for (Cupcake c : cupcakeMenu) {
            System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing");
            System.out.println("Set price for this item: ");
            c.type();
            System.out.println("Input Price: ");
            try {
                String priceAsStr = scanner.nextLine();
                Double price = Double.parseDouble(priceAsStr);
                DecimalFormat formatter = new DecimalFormat("#.##");

                c.setPrice(Double.parseDouble(formatter.format(price)));
                System.out.println(c);
            } catch (NumberFormatException e) {
                System.out.println("Error in price entry...");
            }

        }
        System.out.println(cupcakeMenu);
        Drink water = new Drink();
        Soda soda = new Soda();
        Milk milk = new Milk();
        ArrayList<Drink> drinkMenu = new ArrayList<>();
        drinkMenu.add(water);
        drinkMenu.add(soda);
        drinkMenu.add(milk);
        for (Drink d : drinkMenu) {
            System.out.println("Set price for item below: ");
            d.type();
            System.out.println("Input price: ");
            try {
                String inputPrice = scanner.nextLine();
                Double price = Double.parseDouble(inputPrice);
                DecimalFormat formatter = new DecimalFormat("#.##");
                d.setPrice(Double.parseDouble(formatter.format(price)));
                System.out.println(d.getClass().getSimpleName() + " " + d);

            } catch (NumberFormatException e) {
                System.out.println("Error occurred while setting price");
            }

        }

        Order o1 = new Order(cupcakeMenu, drinkMenu);




    }
    public static void searchByIdOrName(String input, HashMap<Integer, Person> People) {
        int count = 0;

            // search by ID

                // error here due to NumberFormatException
                if (isNumeric(input)) {
                    System.out.println("Search by Id");
                    System.out.println(People.containsKey(Integer.parseInt(input)));
                    System.out.println("User exists in collection" + People.get(Integer.parseInt(input)));
                    count++;
                } else {
                    System.out.println("Search by Name");
                    for (int i : People.keySet()) {
                        Person person = People.get(i);
                        if(person.getName().equals(input)) {
                            System.out.println("Person found: " + person);
                            break;
                        }
                    }

                }
        if(count == 0) {
            System.out.println("Does not exist in collection");
        }
    }


    public static boolean isNumeric(String str) {
        try {

            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
