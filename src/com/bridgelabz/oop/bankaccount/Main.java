package com.bridgelabz.oop.bankaccount;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Database db = new Database();

    static int showMenu(){
        System.out.println("""
                1 -> Add Account
                2 -> Show an Account
                3 -> Make Transaction
                4 -> Exit
                """);
        System.out.print("Choice: ");
        return sc.nextInt();
    }

    static void navigator(int choice){
        switch (choice){
            case 1 -> {
                db.addAccount();
                System.out.println("============X============");
            }
            case 2 -> {
                db.showAccount();
                System.out.println("============X============");
            }
            case 3 -> {
                db.debitBalance();
                System.out.println("============X============");
            }
            case 4 -> System.out.println("Closed Successfully.");
            case 5 -> db.getDB();
        }
    }
    public static void main(String[] args) {
        System.out.println("============Welcome============");

        int choice;
        do {
            choice = showMenu();
            navigator(choice);
        } while (choice != 4);
    }
}
