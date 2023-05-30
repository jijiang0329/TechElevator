package com.techelevator;

public class SavingsAccount extends BankAccount {
    private static final int SERVICE_FEE = 2;

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        if (getBalance() - amountToWithdraw < 150 &&
                getBalance() - amountToWithdraw - SERVICE_FEE >= 0) {

            return super.withdraw(amountToWithdraw + SERVICE_FEE);
        } else if (getBalance() - amountToWithdraw - SERVICE_FEE < 0) {
            return getBalance();
        } else
            return super.withdraw(amountToWithdraw);
    }
}
