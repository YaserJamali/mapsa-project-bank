package gov.bank.model;

import com.google.gson.Gson;

import java.util.List;

public class Account {
    // accountNumber (an int), accountHolderName (a String), balance (a double),
    // and transactions (an array of Transaction objects)
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private List<Transaction> transactions;

    public Account() {
    }

    public Account(int accountNumber, String accountHolderName, double balance, List<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.transactions = transactions;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Account setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public Account setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        return this;
    }

    public double getBalance() {
        return balance;
    }

    public Account setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Account setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
        return this;
    }



    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}