package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Challenge {

    public static void main (String[] args) {
        Student s1 = new Student("James", 19, 'F');
        Teacher t1 = new Teacher("James", 19, 19000);
//        System.out.println(s1);
//        System.out.println(t1);
//        t1.introduce();
//        t1.introduce("Jenny");
//        s1.introduce();
        ArrayList<Person> people = new ArrayList<>();
        try {
            // file reader reads by character
            File source = new File("people.txt");
            FileReader fr = new FileReader(source);
            // pass FileReader inside BufferedReader instance to read by line
            BufferedReader br = new BufferedReader((fr));
            String line;
            String instanceType = null;
            String[] lineData;

            while ((line = br.readLine()) != null) {
//                System.out.println(Arrays.toString(line.split("\t")));
                lineData = line.split("\t");
                if(lineData.length == 1) {
                    instanceType = lineData[0];
                } else if (instanceType.equals("People")) {
                    // set instance and put in ArrayList people
                    people.add(new Person (lineData[0], Integer.parseInt(lineData[1])));
                } else if (instanceType.equals("Students")) {
                    // set instance and put in ArrayList people
                    people.add(new Student (lineData[0], Integer.parseInt(lineData[1]), lineData[2].charAt(0)));
                } else if (instanceType.equals("Teachers")) {
                    // set instance and put in ArrayList people
                    people.add(new Teacher (lineData[0], Integer.parseInt(lineData[1]), Integer.parseInt(lineData[2])));
                }

            }
            System.out.println(people);
            Collections.sort(people);
            System.out.println(people);
            System.out.printf("%s is the oldest at age %d", people.get(0).getName(), people.get(0).getAge());
            FileWriter fw = new FileWriter(source, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(people.get(0).getName() + " is the oldest at age " + people.get(0).getAge());
            pw.close();

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("File read failed");
            e.printStackTrace();
        }

    }
}
