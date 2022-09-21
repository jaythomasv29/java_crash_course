package com.company;

public class Mars {
    public static void main (String[] args){
        String ColonyName = "Marsopolis";

        int ShipPopulation = 300;
        double ShipFood = 4000.00;
        boolean Landing = false;
//
        ShipFood = ShipFood -= (ShipPopulation * 0.75);
        System.out.println(ShipFood);
        ShipFood = ShipFood -= (ShipPopulation * 0.75);
        System.out.println(ShipFood);
        ShipFood *= 1.50;
        System.out.println(ShipFood);
        ShipPopulation += 5;
        System.out.println(ShipPopulation);

//      Looping Function
         Landing = LandingCheck(100);

    }

    public static boolean LandingCheck(int loops) {
        try {
            for(int i = 0; i <= loops; i++) {
                System.out.println("Value of loop: " + i);
                if(i % 3 == 0 && i % 5 == 0) {
                    System.out.println("Keep Center");
                } else if(i % 5 == 0) {
                    System.out.println("Right");
                } else if(i % 3 == 0) {
                    System.out.println("Left");
                } else {
                    System.out.println("Calculating");
                }
                Thread.sleep(100);
            }
            System.out.println("Landed");

        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
    /*
    public static boolean LandingCheck(int loops) throws InterruptedException {
//        java: unreported exception java.lang.InterruptedException; must be caught or declared to be thrown
        for(int i = 0; i <= loops; i++) {
            System.out.println("Value of loop: " + i);
            if(i % 3 == 0 && i % 5 == 0) {
                System.out.println("Keep Center");
            } else if(i % 5 == 0) {
                System.out.println("Right");
            } else if(i % 3 == 0) {
                System.out.println("Left");
            } else {
                System.out.println("Calculating");
            }
            Thread.sleep(100);
        }
        System.out.println("Landed");
        return false;
    }

     */

}
