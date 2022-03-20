package com.bridgelabz.oop.stockmanagement;

public class Stock {

    String stockName;
    int shareNumber;
    int sharePrice;
    int stockValue;

    public Stock(String stockName, int shareNumber, int sharePrice) {
        this.stockName = stockName;
        this.shareNumber = shareNumber;
        this.sharePrice = sharePrice;
        calcStockValue();
    }

    void calcStockValue() {
        stockValue =  sharePrice * shareNumber;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockName='" + stockName + '\'' +
                ", shareNumber=" + shareNumber +
                ", sharePrice=" + sharePrice +
                ", stockValue=" + stockValue +
                '}';
    }
}
