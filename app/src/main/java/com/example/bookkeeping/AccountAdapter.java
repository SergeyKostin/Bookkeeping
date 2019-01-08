package com.example.bookkeeping;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.bookkeeping.model.BankAccount;

import java.util.List;

public class AccountAdapter extends ArrayAdapter<BankAccount> {

    private LayoutInflater inflater;
    private int layout;
    List<BankAccount> accounts;

    public AccountAdapter(@NonNull Context context, int resource, @NonNull List<BankAccount> objects) {
        super(context, resource, objects);
        this.inflater = LayoutInflater.from(context);
        this.layout = resource;
        this.accounts = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final AccountHolder accountHolder;
        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            accountHolder = new AccountHolder(convertView);
            convertView.setTag(accountHolder);
        } else {
            accountHolder = (AccountHolder) convertView.getTag();
        }
        final BankAccount account = accounts.get(position);
        accountHolder.name.setText(account.getName());
        accountHolder.description.setText(account.getDescription());
        accountHolder.balance.setText(String.valueOf(account.getBalance()));
        return convertView;
    }

    private class AccountHolder {

        private TextView name;
        private TextView description;
        private TextView balance;

        private AccountHolder(@NonNull View itemView) {
            name = itemView.findViewById(R.id.account_name);
            description = itemView.findViewById(R.id.account_description);
            balance = itemView.findViewById(R.id.account_balance);
        }
    }
}
