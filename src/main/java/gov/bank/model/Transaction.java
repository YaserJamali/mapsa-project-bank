package gov.bank.model;

import com.google.gson.Gson;

public class Transaction {
    //date (a String), type (a String), amount (a double), and description (a String)
    private String date;
    private Type type;

    private double amount;

    private String description;

    public Transaction() {
    }

    public Transaction(String date, Type type, double amount, String description) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public Transaction setDate(String date) {
        this.date = date;
        return this;
    }

    public Type getType() {
        return type;
    }

    public Transaction setType(Type type) {
        this.type = type;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public Transaction setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Transaction setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}