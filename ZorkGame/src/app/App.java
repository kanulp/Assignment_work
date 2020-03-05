package app;

import java.util.Scanner;

public class App {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Zork World");


       /*  System.out.print("Enter your name: ");
        String name = input.nextLine();
       
        System.out.print("Enter your gender: ");
        String gender = input.nextLine();
       
        System.out.print("Enter your age: ");
        String age = input.nextLine();
       
        System.out.print("Enter your birthdate: ");
        String bdate = input.nextLine(); */

        Game g = new Game();
        g.play();

    }
}