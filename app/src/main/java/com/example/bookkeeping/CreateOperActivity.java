package com.example.bookkeeping;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.bookkeeping.model.BankAccount;
import com.example.bookkeeping.model.Controller;
import com.example.bookkeeping.model.Operation;

import java.util.ArrayList;

public class CreateOperActivity extends AppCompatActivity {

    String[] types = {"coming", "transfer", "consumption"};
    String[] categorys = {"expenditure", "profitable"};

    EditText value;
    EditText description;
    Spinner spinAccountOn;
    Spinner spinType;
    Spinner spinCateg;
    Button createOper;
    String userType = "";
    String userCateg = "";
    BankAccount userAccount;
    int positAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_oper);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id", 0);
        value = findViewById(R.id.bablo);
        description = findViewById(R.id.crt_oper_desc);
        spinAccountOn = findViewById(R.id.account_on);
        spinType = findViewById(R.id.crt_oper_type);
        spinCateg = findViewById(R.id.crt_oper_category);
        ArrayList<String> accountListName = Controller.getAccountListName();
        ArrayAdapter<String> adapterAccount = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, accountListName);
        ArrayAdapter<String> adapterType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, types);
        ArrayAdapter<String> adapterCategory = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categorys);
        adapterAccount.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinAccountOn.setAdapter(adapterAccount);
        spinType.setAdapter(adapterType);
        spinCateg.setAdapter(adapterCategory);
        createOper = findViewById(R.id.crt_oper_but_go);
        spinType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                userType = types[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinCateg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                userCateg = categorys[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinAccountOn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                userAccount = Controller.listAccounts.get(position);
                positAcc = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        createOper.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Operation operation = new Operation();
                operation.setCategory(userCateg);
                operation.setDescription(description.getText().toString());
                operation.setFrom(Controller.getAccById(id));
                operation.setOn(userAccount);
                operation.setType(userType);
                int val = Integer.parseInt(value.getText().toString());
                operation.setValue(val);
                Controller.addOperation(id,positAcc,operation);
                Intent intent1 = new Intent(CreateOperActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });

    }
}
