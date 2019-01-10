package com.example.bookkeeping.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ControllerTest {
    @Before
    public void setup() {
        BankAccount bankAccount1 = new BankAccount("acc1", "this is test", (long) 100000);
        BankAccount bankAccount2 = new BankAccount("acc2", "this is test", (long) 340000);
        Controller.addAccount(bankAccount1);
        Controller.addAccount(bankAccount2);
        Operation operation1 = new Operation("coming", 2300, bankAccount1, bankAccount2,
                "expenditure", "test");
        Controller.addOperation(0, 1, operation1);
        Operation operation2 = new Operation("consumption", 5900, bankAccount1, bankAccount2,
                "profitable", "test");
        Controller.addOperation(1, 0, operation2);
    }

    @Test
    public void addOperation() {
        int sizeListOper = Controller.map.get(Controller.listAccounts.get(0)).size();
        Operation operation = new Operation("consumption", 5900,
                Controller.listAccounts.get(0), Controller.listAccounts.get(1), "profitable", "test");
        Controller.addOperation(0, 1, operation);
        assertEquals(sizeListOper + 1, Controller.map.get(Controller.listAccounts.get(0)).size());
    }

    @Test
    public void deleteAccount() {

        int sizeListAccounts = Controller.listAccounts.size();
        int sizeMapAccOper = Controller.map.size();
        int sizeOperOnAcc1 = Controller.map.get(Controller.listAccounts.get(0)).size();
        int sizeOperOnAcc2 = Controller.map.get(Controller.listAccounts.get(1)).size();
        BankAccount bankAccount = Controller.listAccounts.get(1);
        Controller.deleteAccount(0, 1);
        assertEquals(sizeListAccounts - 1, Controller.listAccounts.size());
        assertEquals(sizeMapAccOper - 1, Controller.map.size());
        assertEquals(sizeOperOnAcc1 + sizeOperOnAcc2, Controller.map.get(bankAccount).size());
    }

    @Test
    public void deleteOperation() {
        Controller.deleteOperation(Controller.listAccounts.get(1));
        assertEquals(0, Controller.map.get(Controller.listAccounts.get(1)).size());
    }
}