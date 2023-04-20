package gov.bank.model;

import com.google.gson.Gson;

import java.util.List;

public class Bank {
    //accounts (an array of Account objects),
    // currentAccountIndex (an int), and currentDate (a String).

    private List<Account> accountList;
    private int currentAccountIndex;
    private String currentDate;

    public Bank() {
    }

    public Bank(List<Account> accountList, int currentAccountIndex, String currentDate) {
        this.accountList = accountList;
        this.currentAccountIndex = currentAccountIndex;
        this.currentDate = currentDate;
    }

    public Bank(List<Account> accountList, int currentAccountIndex) {
        this.accountList = accountList;
        this.currentAccountIndex = currentAccountIndex;
        String year = "1402";
        String month = "2";
        int temp = 1;
        ++temp;
        String date = (temp) + "/" + month + "/" + year;
        this.currentDate = date;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public Bank setAccountList(List<Account> accountList) {
        this.accountList = accountList;
        return this;
    }

    public int getCurrentAccountIndex() {
        return currentAccountIndex;
    }

    public Bank setCurrentAccountIndex(int currentAccountIndex) {
        this.currentAccountIndex = currentAccountIndex;
        return this;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public Bank setCurrentDate(String currentDate) {

        this.currentDate = currentDate;
        return this;
    }



    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}