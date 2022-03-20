package com.bridgelabz.oop.commercialdataproc;

public class MarketUI extends Market{

    MarketUI(){
        populate();
    }

    void transaction(StockAccount currentAcc){
        int choice;
        do {
            System.out.println("""
                    What do you want to do?
                    1 -> Buy Stock
                    2 -> Sell Stock
                    3 -> Exit
                    """);
            System.out.print("\n Choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("========================= \n");
                    System.out.println("Enter the Stock Symbol: ");
                    String symbol = scan.next();
                    System.out.println("Enter the number of shares to buy: ");
                    int count = scan.nextInt();
                    CompanyShares listingShare = getShare(Symbol.valueOf(symbol));
                    if (listingShare.shareCount >= count) {
                        currentAcc.buy(Symbol.valueOf(symbol), count);
                        listingShare.shareCount -= count;
                    } else {
                        System.out.println("Not enough share in Listing.");
                    }
                }
                case 2 -> {
                    System.out.println("========================= \n");
                    System.out.println("Enter the Stock Symbol: ");
                    String symbol = scan.next();
                    System.out.println("Enter the number of shares to Sell: ");
                    int count = scan.nextInt();
                    CompanyShares holdingShare = currentAcc.getShare(Symbol.valueOf(symbol));
                    CompanyShares listingShare = getShare(Symbol.valueOf(symbol));
                    if (holdingShare.shareCount >= count) {
                        currentAcc.sell(Symbol.valueOf(symbol), count);
                        listingShare.shareCount += count;
                    } else {
                        System.out.println("Not enough share in Holding.");
                    }
                }
                case 3 -> {
                    System.out.println("========================= \n");
                    System.out.println("Closed Transaction.");
                }
            }
        }while (choice != 3);
    }

    int showMenu(){
        System.out.println("""
                1 -> Create New Account
                2 -> Make Transaction
                3 -> Display an Account
                4 -> Exit
                """);
        System.out.print("Choice: ");
        return scan.nextInt();
    }

    void navigator(int choice){
        switch (choice){
            case 1 -> {
                System.out.println("========================= \n");
                System.out.println("Enter the Name of Account: ");
                String name = scan.next();
                addAccount(name);
            }
            case 2 -> {
                System.out.println("========================= \n");
                System.out.println("Enter the Account Name for transaction: ");
                String accName = scan.next();
                transaction(getAccount(accName));
            }
            case 3 -> {
                System.out.println("========================= \n");
                System.out.println("Enter the Account Name to Display: ");
                String accName = scan.next();
                StockAccount temp = getAccount(accName);
                System.out.println(temp.toString());
                System.out.println("Current Holdings: ");
//                temp.getReport(); <----- Need to Add proper report
            }
            case 4 -> {
                System.out.println("========================= \n");
                System.out.println("Market App Closed!");
            }
        }
    }

    public static void main(String[] args) {
        MarketUI nyse = new MarketUI();

        System.out.println("===================Welcome to NYSE Interface===================");
        int choice;
        do{
            choice = nyse.showMenu();
            nyse.navigator(choice);
        }while (choice != 4);
    }
}
