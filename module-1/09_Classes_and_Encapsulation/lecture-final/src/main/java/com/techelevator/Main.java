package com.techelevator;

import java.math.BigDecimal;

public class Main {

    public Main() {
        new Transaction();
    }

    public static void main(String[] args) {

        System.out.println("Hello World!");

        Customer customer = new Customer("Christopher", 38);
      //  customer.setName("Christopher");
      //  customer.setAge(38);
        customer.introduceSelf();

        Customer customer2 = new Customer();
        customer2.setName("Claire");

        BankAccount account = new BankAccount(BankAccount.CHECKING,"938547574393");
        BankAccount savingsAccount = new BankAccount(BankAccount.SAVINGS,"938547577654");

        customer.addAccount(account);
        customer.addAccount(savingsAccount);

        customer.listAccounts();

        Customer.helloWorld();

        System.out.println("End");

        //int customerAge = customer.age;

        Transaction t = new Transaction(Transaction.WITHDRAWAL, BigDecimal.valueOf(1000));
        Transaction t2 = new Transaction(Transaction.DEPOSIT, BigDecimal.valueOf(2000));

        Transaction.addTransactions(t, t2);

        System.exit(0);
    }

}
