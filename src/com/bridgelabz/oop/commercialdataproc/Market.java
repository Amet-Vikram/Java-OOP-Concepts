package com.bridgelabz.oop.commercialdataproc;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Market {

    enum Symbol{
        AAPL, MSFT, GOOG, AMZN, NVDA, FB, TSM, JPM, WMT, UNH, BABA
    }

    List<StockAccount> ledger = new ArrayList<>();
    List<CompanyShares> listings = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    void populate(){
        for(Symbol symbol : Symbol.values()){
            listings.add(new CompanyShares(symbol, 100));
        }
    }

    StockAccount getAccount(String name){
        for(StockAccount match : ledger){
            if(match.name.equals(name)){
                return match;
            }
        }
        System.out.println("NO SUCH ACCOUNT EXISTS!");
        return null;
    }

    void addAccount(String name){
        ledger.add(new StockAccount(name));
    }

    CompanyShares getShare(Market.Symbol symbol){
        for(CompanyShares share : listings){
            if(share.symbol.equals(symbol)){
                return share;
            }
        }
        System.out.println("No such holdings in your account.");
        return null;
    }


}
