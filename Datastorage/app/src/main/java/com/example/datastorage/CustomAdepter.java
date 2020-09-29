package com.example.datastorage;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdepter extends ArrayAdapter<Student> {

    Activity context;
    List<Student> studentList;

    public CustomAdepter( Activity context, List<Student> studentList) {
        super(context, R.layout.sample_layout, studentList);
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View view=inflater.inflate(R.layout.sample_layout,null,true);

        Student student=studentList.get(position);
        TextView n=view.findViewById(R.id.nametextwiewid);
        TextView p=view.findViewById(R.id.phonetextviewid);
        TextView a=view.findViewById(R.id.agetextviewid);

        n.setText(student.getName());
        p.setText(student.getMobile());
        a.setText(student.getAge());

        return view;
    }
}
