package com.bank;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String holderName;
    private double balance;
    private List<String> transactionHistory;

    // Constructor with initial deposit
    public Account(String accountNumber, String holderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial deposit: ₹" + initialDeposit);
    }

    // Constructor without initial deposit
    public Account(String accountNumber, String holderName) {
        this(accountNumber, holderName, 0.0);
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount);
            System.out.println("✅ Successfully deposited ₹" + amount);
        } else {
            System.out.println("❌ Deposit amount must be positive.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: ₹" + amount);
            System.out.println("✅ Successfully withdrew ₹" + amount);
        } else {
            System.out.println("❌ Insufficient balance or invalid amount.");
        }
    }

    // Show transaction history
    public void printTransactionHistory() {
        System.out.println("\n📜 Transaction History for " + holderName + ":");
        for (String transaction : transactionHistory) {
            System.out.println("- " + transaction);
        }
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }

    // Get account holder's name
    public String getHolderName() {
        return holderName;
    }
}
