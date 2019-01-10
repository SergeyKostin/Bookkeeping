package com.example.bookkeeping.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    public static Map<BankAccount, ArrayList<Operation>> map = new HashMap<>();
    public static List<BankAccount> listAccounts = new ArrayList<>();

    public static void addAccount(BankAccount bankAccount) {
        listAccounts.add(bankAccount);
        ArrayList<Operation> operations = new ArrayList<>();
        map.put(bankAccount, operations);
    }

    public static void deleteAccount(int from, int on) {
        BankAccount fromAccount = listAccounts.get(from);
        BankAccount onAccount = listAccounts.get(on);
        ArrayList<Operation> operations = map.get(fromAccount);
        map.get(onAccount).addAll(operations);
        map.remove(fromAccount);
        listAccounts.remove(from);
    }

    public static void addOperation(int from, int on, Operation operation) {
        if(from < listAccounts.size() && on < listAccounts.size()) {
            long val = operation.getValue();
            listAccounts.get(from).setBalance(listAccounts.get(from).getBalance() - val);
            listAccounts.get(on).setBalance(listAccounts
                    .get(on).getBalance() + val);
            map.get(listAccounts.get(from)).add(operation);
        }
    }

    public static void deleteOperation(BankAccount account) {
        map.remove(account);
        map.put(account,new ArrayList<Operation>());
    }

    public static ArrayList<String> getAccountListName() {
        ArrayList<String> accountListName = new ArrayList<>();
        for (BankAccount bankAccount : Controller.listAccounts) {
            accountListName.add(bankAccount.getName());
        }
        return accountListName;
    }
    public static BankAccount getAccById(int id) {
        if(id < listAccounts.size()) {
            return listAccounts.get(id);
        } else return new BankAccount("uncknow","uncknow", (long) 0);
    }
    public static ArrayList<Operation> getOperationsOfAcc(int id) {
        if(id < listAccounts.size()) {
            return map.get(listAccounts.get(id));
        } else return new ArrayList<>();
    }
}
