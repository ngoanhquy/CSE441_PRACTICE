package com.example.bai13_customlistview_1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.bai13_customlistview_1.Phone;
import com.example.bai13_customlistview_1.R;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Phone> {
    private final Context context;
    private final int resource;
    private final ArrayList<Phone> phoneList;

    public MyArrayAdapter(Context context, int resource, ArrayList<Phone> phoneList) {
        super(context, resource, phoneList);
        this.context = context;
        this.resource = resource;
        this.phoneList = phoneList;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        ImageView imageView = convertView.findViewById(R.id.imgPhone);
        TextView textView = convertView.findViewById(R.id.textView);

        Phone phone = phoneList.get(position);
        imageView.setImageResource(phone.getImageResource());
        textView.setText(phone.getName());

        return convertView;
    }
}