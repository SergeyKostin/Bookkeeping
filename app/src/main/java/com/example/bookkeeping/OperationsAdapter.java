package com.example.bookkeeping;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.bookkeeping.model.Operation;

import java.util.List;

public class OperationsAdapter extends ArrayAdapter<Operation> {

    private LayoutInflater inflater;
    private int layout;
    List<Operation> operations;


    public OperationsAdapter(@NonNull Context context, int resource, @NonNull List<Operation> objects) {
        super(context, resource, objects);
        this.inflater = LayoutInflater.from(context);
        this.layout = resource;
        this.operations = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final OperationHolder operationHolder;
        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            operationHolder = new OperationHolder(convertView);
            convertView.setTag(operationHolder);
        } else {
            operationHolder = (OperationHolder) convertView.getTag();
        }
        final Operation operation = operations.get(position);
        operationHolder.description.setText(operation.getDescription());
        operationHolder.value.setText(String.valueOf(operation.getValue()));
        operationHolder.category.setText(operation.getCategory().toString());
        operationHolder.type.setText(operation.getType().toString());
        operationHolder.time.setText(operation.getTime().toString());
        return convertView;
    }

    private class OperationHolder {
        private TextView description;
        private TextView value;
        private TextView category;
        private TextView time;
        private TextView type;

        private OperationHolder(@NonNull View itemView) {
            value = itemView.findViewById(R.id.oper_value);
            description = itemView.findViewById(R.id.oper_desc);
            category = itemView.findViewById(R.id.oper_category);
            time = itemView.findViewById(R.id.oper_time);
            type = itemView.findViewById(R.id.oper_type);
        }
    }
}
