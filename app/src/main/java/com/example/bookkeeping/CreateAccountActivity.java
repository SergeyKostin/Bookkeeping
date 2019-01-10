package com.example.bookkeeping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bookkeeping.model.BankAccount;
import com.example.bookkeeping.model.Controller;

public class CreateAccountActivity extends AppCompatActivity {

    EditText accName;
    EditText accDescript;
    EditText accBalance;
    Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        accName = findViewById(R.id.crt_name_account);
        accDescript = findViewById(R.id.crt_desc_account);
        accBalance = findViewById(R.id.crt_balance_account);
        create = findViewById(R.id.crt_account_but_go);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = accName.getText().toString();
                String description = accDescript.getText().toString();
                long balance = Long.parseLong(accBalance.getText().toString());
                BankAccount bankAccount = new BankAccount(name,description,balance);
                Controller.addAccount(bankAccount);
                Intent intent = new Intent(CreateAccountActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
