package com.example.bookkeeping;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class OperationsActivity extends AppCompatActivity {

    ListView listView;
    Button crt_oper_but;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations);
        listView = findViewById(R.id.listOperation);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id", 0);
        if (MainActivity.map.get(MainActivity.listAccounts.get(id)) != null) {
            OperationsAdapter operationsAdapter = new OperationsAdapter(this, R.layout.list_operatons,
                    MainActivity.map.get(MainActivity.listAccounts.get(id)));
            listView.setAdapter(operationsAdapter);
        }
        crt_oper_but = findViewById(R.id.crt_oper_but);
        crt_oper_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OperationsActivity.this,CreateOperActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }
}
