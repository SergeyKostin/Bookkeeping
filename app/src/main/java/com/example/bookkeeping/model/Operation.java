package com.example.bookkeeping.model;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.time.LocalDateTime;

public class Operation {

    private LocalDateTime time;
    private String type;
    private int value;
    private BankAccount from;
    private BankAccount on;
    private String category;
    private String description;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Operation(){
        this.time = LocalDateTime.now();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Operation(String type, int value, BankAccount from, BankAccount on,
                     String category, String description) {
        this.time = LocalDateTime.now();
        this.type = type;
        if (value < 0) {
            this.value = 0;
        } else {
            this.value = value;
        }
        this.from = from;
        this.on = on;
        this.category = category;
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value < 0) {
            this.value = 0;
        } else {
            this.value = value;
        }
    }

    public BankAccount getFrom() {
        return from;
    }

    public void setFrom(BankAccount from) {
        this.from = from;
    }

    public BankAccount getOn() {
        return on;
    }

    public void setOn(BankAccount on) {
        this.on = on;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
