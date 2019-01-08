package com.example.bookkeeping.model;

import java.util.ArrayList;
import java.util.List;

public class ExpenseCategory {

    private final String name = "ExpenseCategory";
    private List<Operation> operations;

    public ExpenseCategory() {
        this.operations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public void setOperation(Operation operation) {
        this.operations.add(operation);
    }
}
