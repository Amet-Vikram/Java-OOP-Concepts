package com.bridgelabz.oop.stockmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockPortfolio {

    List<Stock> stockList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    void addStock(){
        System.out.println("Enter the company name: ");
        String stockName = scan.nextLine();
        System.out.println("Enter the number of shares: ");
        int shareNumber = scan.nextInt();
        System.out.println("Enter the share price: ");
        int sharePrice = scan.nextInt();
        stockList.add(new Stock(stockName, shareNumber,sharePrice));
        System.out.println("Added.");
    }

    void getStockList(){
        for (Stock stock : stockList) {
            System.out.println(stock.toString());
        }
    }

    int totalValue(){
        int value = 0;
        for (Stock stock: stockList) {
            value += stock.stockValue;
        }
        return value;
    }
}
