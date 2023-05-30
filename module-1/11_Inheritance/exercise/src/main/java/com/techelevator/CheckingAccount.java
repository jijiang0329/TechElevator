package com.techelevator;

public class CheckingAccount extends BankAccount{
    private final int OVERDRAFT_FEE = 10;

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        if (getBalance() - amountToWithdraw <= -100.00) {
            return getBalance();
        } else if (getBalance() - amountToWithdraw < 0 &&
                getBalance() - amountToWithdraw > -100.00) {
            return super.withdraw(amountToWithdraw + OVERDRAFT_FEE);

        } else
            return super.withdraw(amountToWithdraw);
    }

}
