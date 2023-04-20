package gov.bank.service;

import gov.bank.model.Account;
import gov.bank.model.Bank;
import gov.bank.model.Transaction;
import gov.bank.model.Type;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BankServices extends Bank implements Serializable {

    public BankServices(List<Account> accountList, int currentAccountIndex, String currentDate) {
        super(accountList, currentAccountIndex, currentDate);
    }

    public BankServices(List<Account> accountList, int currentAccountIndex) {
        super(accountList, currentAccountIndex);
    }
    //deposit(int accountNumber, double amount, String description):
    // Allows a user to deposit money into their account.
    // This method should first check if the account exists and
    // if the amount being deposited is greater than zero.
    // If both of these conditions are true, the amount should be added to the account's balance
    // and a new Transaction object should be created and added to the account's list of transactions.


    Transaction deposit(int accountNumber, double amount, String description) {
        if (hasAccountNumber(accountNumber) && depositValidator(amount)) {
            balanceUpdaterDeposit(getAccount(accountNumber), amount);
            incrementCurrentDate();
            Transaction transaction = new Transaction(getCurrentDate(),
                    Type.Central,
                    amount,
                    description);
            getAccount(accountNumber).getTransactions().add(transaction);


            return transaction;
        }
        return null;
    }

    void balanceUpdaterDeposit(Account account, double deposit) {
        double balance = account.getBalance() + deposit;
        account.setBalance(balance);
    }


    public boolean hasAccountNumber(int accountNumber) {

        for (int i = 0; i < getAccountList().size(); i++) {
            if (getAccountList().get(i).getAccountNumber() == accountNumber)
                return true;
        }
        return false;
    }


    public boolean accountValidator(Account account, Bank bank) {
        return bank.getAccountList().contains(account);
    }

    public boolean depositValidator(double deposit) {
        return deposit > 0;
    }

    public boolean withdrawValidator(double withdraw) {
        for (int i = 0; i < getAccountList().size(); i++) {
            if (getAccountList().get(i).getBalance() >= withdraw && withdraw > 0) {
                return true;
            }
        }
        return false;
    }

    void balanceUpdaterWithdrawn(Account account, double withdrawn) {
        double balance = account.getBalance() - withdrawn;
        account.setBalance(balance);
    }


//    withdraw(int accountNumber, double amount, String description):
//    Allows a user to withdraw money from their account.
//    This method should first check if the account exists,
//    if the amount being withdrawn is greater than zero,
//    and if the account has enough money to cover the withdrawal.
//    If all of these conditions are true,
//    the amount should be subtracted from the account's balance
//    and a new Transaction object should be created and added to the account's list of transactions.

    Transaction withdraw(int accountNumber, double amount, String description) {
        if (hasAccountNumber(accountNumber) && withdrawValidator(amount)) {
            incrementCurrentDate();
            balanceUpdaterWithdrawn(getAccount(accountNumber), amount);
            dateUpdater();
            Transaction transaction = new Transaction(getCurrentDate(),
                    Type.Central,
                    amount,
                    description);
            getAccount(accountNumber).getTransactions().add(transaction);


            return transaction;
        }
        return null;
    }


    //getAccount(int accountNumber):
    // Returns the Account object with the specified account number
    // . If no such account exists, this method should return null.

    public Account getAccount(int accountNumber) {
        for (int i = 0; i < getAccountList().size(); i++) {
            if (getAccountList().get(i).getAccountNumber() == accountNumber)
                return getAccountList().get(i);
        }
        return null;
    }


    //incrementCurrentDate():
    // Advances the current date by one day.
    // This method should be called once per day to update the dates of transactions.
    void incrementCurrentDate() {
        setCurrentDate(dateUpdater());
    }

 String   dateUpdater(){
   return getNext()+1+ "/02/1402";

 }


    AtomicInteger value=new AtomicInteger();
    public Integer getNext() {
        return value.getAndIncrement();
    }

}


