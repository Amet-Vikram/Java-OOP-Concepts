package com.bridgelabz.oop.bankaccount;

public class Account{
     String name;
     long balance;
     Long accNumber;

    public Account(String name, long accNumber, long balance) {
        this.name = name;
        this.balance = balance;
        this.accNumber = accNumber;
    }

    public void debit(int debit) {
        if(debit < balance){
            balance -= debit;
        }
        else{
            System.out.println("The Debit exceeds the Balance. Transaction not allowed!");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", accNumber=" + accNumber +
                ", balance=" + balance +
                '}';
    }
}
