package com.bridgelabz.oop.stockmanagement;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static StockPortfolio sp = new StockPortfolio();

    static int showMenu(){
        System.out.println("""
                1 -> Add Stock to Portfolio
                2 -> Display Holdings
                3 -> Display Value of Portfolio
                4 -> Exit.
                """);
        System.out.print("Choice: ");
        return sc.nextInt();
    }

    static void navigator(int choice){
        switch (choice){
            case 1 -> {
                sp.addStock();
                System.out.println("============X============");
            }
            case 2 -> {
                sp.getStockList();
                System.out.println("============X============");
            }
            case 3 -> {
                System.out.println("The total value of all Stocks is: " + sp.totalValue());
                System.out.println("============X============");
            }
            case 4 -> System.out.println("Closed Successfully.");
        }
    }

    public static void main(String[] args) {
        System.out.println("============Welcome to your Stock Account============");

        int choice;
        do {
            choice = showMenu();
            navigator(choice);
        } while (choice != 4);
    }
}
