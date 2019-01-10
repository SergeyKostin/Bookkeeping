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

import com.example.bookkeeping.model.Controller;

public class MainActivity extends AppCompatActivity {

    ListView accounts;
    Button createAccount;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accounts = findViewById(R.id.listView);
        AccountAdapter accountAdapter = new AccountAdapter(this, R.layout.list_account, Controller.listAccounts);
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
                Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
                startActivity(intent);
            }
        });
    }

}
