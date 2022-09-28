package com.company;

import java.io.*;

public class FileLesson {

    public static void main (String[] args) {
        File file = new File("/Users/jamesvongampai/Desktop/notepad.txt");
        if(file.exists()) {
            System.out.println("File detected");
            System.out.println(file.getPath());
            System.out.println(file.getAbsolutePath());
            System.out.println(file.isFile());
            System.out.println(file.isDirectory());
//            file.delete();
        } else {
            System.out.println("No file found");
        }
        try {
            // FileWriter class to write to files (in append mode)
            FileWriter writer = new FileWriter("/Users/jamesvongampai/Desktop/poem.txt", true);
//            writer.write("Roses are Red \nViolets are blue \nThis is a poem");
            writer.append("\nBye bye bye");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // FileReader
            FileReader reader = new FileReader("art.txt");
            int data = reader.read();
            // if -1, then there is no more data to be read
            while(data != -1) {
                System.out.print((char)data);
                data = reader.read();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
