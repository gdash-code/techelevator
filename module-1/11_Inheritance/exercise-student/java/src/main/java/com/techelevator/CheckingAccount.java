package com.techelevator;

public class CheckingAccount extends BankAccount {


    public CheckingAccount(String accountHolderName, String accountNumber, int balance, int amountToWithdraw){
        super(accountHolderName, accountNumber, balance);
    }

    public CheckingAccount(String accountHolderName, String accountNumber){
        super(accountHolderName, accountNumber);
    }


            //Methods
            @Override
            public int withdraw(int amountToWithdraw) {
                int balance = this.getBalance();
                int newBalance = balance - amountToWithdraw;
                if (newBalance >= 0) {
                    return super.withdraw(amountToWithdraw);
                } else if (newBalance > -100 && newBalance < 0) {
                    return super.withdraw(amountToWithdraw + 10);
                }
                return balance;
            }
        }



