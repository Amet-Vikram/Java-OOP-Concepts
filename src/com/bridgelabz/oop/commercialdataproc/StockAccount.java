package com.bridgelabz.oop.commercialdataproc;

import java.time.LocalDateTime;
import java.util.*;

public class StockAccount {

    String name;

    StockAccount(String name){
        this.name = name;
    }

    LocalDateTime now = LocalDateTime.now();
    List<CompanyShares> holdings = new ArrayList<>();

    void buy(Market.Symbol symbol, int count){
        for(CompanyShares share : holdings){
            if(share.symbol.equals(symbol)){
                share.shareCount += count;
                share.setDate(now);
                share.setTime(now);
                System.out.println("Stock Bought!");
            }
            else{
                System.out.println("Added New Stock: " + symbol);
                holdings.add(new CompanyShares(symbol, count, true));
            }
        }
    }

    void sell(Market.Symbol symbol, int count){
        for(CompanyShares share : holdings){
            if(share.symbol.equals(symbol)){
                share.shareCount -= count;
                share.setDate(now);
                share.setTime(now);
                System.out.println("Stock Sold!");
            }
            else {
                System.out.println("You don't own such stocks.");
            }
        }
    }

//    String getReport(){
//        for(CompanyShares share : holdings){
//            return share.toString();
//        }
//    }

    double valueOf(){
        double value = 0;
        for(CompanyShares share : holdings){
            value += share.value;
        }
        return value;
    }

    CompanyShares getShare(Market.Symbol symbol){
        for(CompanyShares share : holdings){
            if(share.symbol.equals(symbol)){
                return share;
            }
        }
        System.out.println("No such Share Exists.");
        return null;
    }

    @Override
    public String toString() {
        return "StockAccount{" +
                "name='" + name + '\'' +
                ", holdings=" + holdings +
                '}';
    }
}
