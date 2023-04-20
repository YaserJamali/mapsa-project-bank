package gov.bank.service;

import gov.bank.model.Account;
import gov.bank.model.Bank;
import gov.bank.model.Transaction;

import java.util.ArrayList;
import java.util.List;

import static gov.bank.model.Type.*;
import static gov.bank.service.BankServices.*;
import static gov.bank.service.Utils.*;

// The Main class should contain the main method,
// which will create a Bank object and add some accounts to it.
// The program should allow users to deposit and withdraw money from their accounts,
// and should keep track of all transactions.
public class Main {
    public static void main(String[] args) {
        //date (a String), type (a String), amount (a double), and description (a String)

        //******************************
        //* Create Transaction Objects *
        //******************************
        Transaction transaction1=new Transaction("29/10/1401", Central,1435,"Extra Budget For Investment:Maskan");
        Transaction transaction2=new Transaction("15/02/1402", Commercial,326,"bought a sandwich:ATM Mellat");
        Transaction transaction3=new Transaction("17/08/1394", Regional,769,"Payed My Bills");
        Transaction transaction4=new Transaction("08/04/1398", Central,500,"Payed For Nothing");
        Transaction transaction5=new Transaction("03/11/1389", Regional,769,"Payed For Gifts");

        List<Transaction> yaserTransactions =new ArrayList<>();
        yaserTransactions.add(transaction1);
        yaserTransactions.add(transaction2);

        List<Transaction> aliTransactions=new ArrayList<>();
        aliTransactions.add(transaction3);

        List<Transaction>rezaTransactions=new ArrayList<>();
        rezaTransactions.add(transaction4);

        //******************************
        //* Create Account Objects *
        //******************************


        // int accountNumber, String accountHolderName, double balance, List<Transaction> transactions

        Account yaserAccount=new Account(123456,"Yaser",3000, yaserTransactions);
        Account aliAccount=new Account(654789,"Ali",4500,aliTransactions);
        Account rezaAccount=new Account(179364,"Reza",600,rezaTransactions);
        List<Account> accountList=new ArrayList<>();
        accountList.add(aliAccount);
        accountList.add(yaserAccount);

        //******************************
        //* Create Bank Objects *
        //******************************

//        List<Account> accountList, int currentAccountIndex, String currentDate

        BankServices bank=new BankServices(accountList,200000,"1/02/1402");

        System.out.println(bank.hasAccountNumber(654789));
        System.out.println( bank.getAccount(654789));
        System.out.println(bank.deposit(654789, 120, "for test"));
        System.out.println(bank.deposit(654789, 120, "for test"));
        System.out.println(bank.withdraw(123456, 300, "for test witr"));
        System.out.println(aliAccount);
        System.out.println(yaserAccount);
//

        System.out.println(bank.getNext());
        System.out.println(bank.getNext());
        System.out.println(bank.getNext());
        System.out.println(bank.getNext());



    }
}