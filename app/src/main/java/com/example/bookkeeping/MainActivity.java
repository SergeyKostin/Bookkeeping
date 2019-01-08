package com.example.bookkeeping;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.bookkeeping.model.BankAccount;
import com.example.bookkeeping.model.Operation;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView accounts;
    public static HashMap<BankAccount,ArrayList<Operation>> map = new HashMap<>();
    public static ArrayList<BankAccount> listAccounts = new ArrayList<>();
    Button createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accounts = findViewById(R.id.listView);
        /*BankAccount account1 = new BankAccount("ac1", "desc...", (long)123000);
        BankAccount account2 = new BankAccount("ac2", "desc...", (long)123000);
        listAccounts.add(account1);
        listAccounts.add(account2);
        Operation operation = new Operation("coming",100,account1,account2,"expenditure","desc...");
        ArrayList<Operation> operations = new ArrayList<>();
        operations.add(operation);
        map.put(account1,operations);
        map.put(account2,operations);*/
        for(int i = 0; i < listAccounts.size(); i++) {
            if(map.containsKey(listAccounts.get(i))== false){
                ArrayList<Operation> operations = new ArrayList<>();
                map.put(listAccounts.get(i),operations);
            }
        }
        AccountAdapter accountAdapter = new AccountAdapter(this, R.layout.list_account, listAccounts);
        accounts.setAdapter(accountAdapter);
        accounts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, OperationsActivity.class);
                intent.putExtra("id", position);
                startActivity(intent);
            }
        });
        createAccount = findViewById(R.id.crt_account_but);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CreateAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}
