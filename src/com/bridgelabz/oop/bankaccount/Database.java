package com.bridgelabz.oop.bankaccount;

import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    ArrayList<Account> database = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    void addAccount(){
        System.out.print("Enter the Name of the Account Holder: ");
        String name = input.next();
        System.out.print("Enter the Account number (6-Digit): ");
        long accNumber = input.nextLong();
        System.out.print("Enter the balance: ");
        long balance = input.nextLong();
        database.add(new Account(name, accNumber, balance));
    }

    Account getAccount(){
        System.out.print("Enter the Account number: ");
        long accNo = input.nextLong();
        for (Account match : database) {
            if (match.accNumber.equals(accNo)){
                return match;
            }
        }
        System.out.println("Account Number Not Found.");
        return null;
    }

    void getDB(){
        System.out.println(database);
    }

    void debitBalance(){
        Account temp = getAccount();
        System.out.print("Enter the amount to be debited: ");
        int amount = input.nextInt();
        temp.debit(amount);
        System.out.println("New Balance: " + temp.balance);
    }

    void showAccount(){
        System.out.print("Enter the Account number: ");
        long accNo = input.nextLong();
        for (Account match : database) {
            if (match.accNumber.equals(accNo)){
                System.out.println(match.toString());
                break;
            }
            else{
                System.out.println("Account Number Not Found.");
            }
        }
    }
}
