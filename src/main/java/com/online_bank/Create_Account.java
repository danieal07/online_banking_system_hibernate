package com.online_bank;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
class Create_Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int account_number;  // This is auto-generated, so remove user input

    private String account_holder_name;
    private double balance;
    private String account_type;
    private String bank_name;
    private String branch_name;

    // Default constructor (required by Hibernate)
    public Create_Account() {
    }

    // Parameterized constructor for setting values
    public Create_Account(String account_holder_name,  String account_type, String bank_name, String branch_name) {
        this.account_holder_name = account_holder_name;
        this.account_type = account_type;
        this.bank_name = bank_name;
        this.branch_name = branch_name;
    }

    // Getters and Setters
    public int getAccount_number() {
        return account_number;
    }

    public String getAccount_holder_name() {
        return account_holder_name;
    }

    public void setAccount_holder_name(String account_holder_name) {
        this.account_holder_name = account_holder_name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }
    @Override
    public String toString() {
        return "Account Number: " + account_number + "\n" +
                "Account Holder Name: " + account_holder_name + "\n" +
                "Account Type: " + account_type + "\n" +
                "Bank Name: " + bank_name + "\n" +
                "Branch Name: " + branch_name + "\n"+
                 "Bank Balance: "+ balance;
    }
}