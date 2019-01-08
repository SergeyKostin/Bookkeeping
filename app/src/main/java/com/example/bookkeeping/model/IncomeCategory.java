package com.example.bookkeeping.model;

import java.util.ArrayList;
import java.util.List;

public class IncomeCategory {

    private final String name = "IncomeCategory";
    private List<Operation> operations;

    public IncomeCategory() {
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
