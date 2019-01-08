package com.example.bookkeeping.model;

public class BankAccount {

    private String name;
    private String description;
    private Long balance;

    public BankAccount(String name, String description, Long balance) {
        this.name = name;
        this.description = description;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
