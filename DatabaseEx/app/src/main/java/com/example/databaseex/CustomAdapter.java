package com.example.databaseex;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter<StudentInfo> {

    Activity context;
    List<StudentInfo> studentInfoList;

    public CustomAdapter(  Activity context1, List<StudentInfo> studentInfoList) {
        super(context1,R.layout.sample_layout,studentInfoList);
        this.context = context1;
        this.studentInfoList = studentInfoList;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View view=inflater.inflate(R.layout.sample_layout,null,true);

        StudentInfo studentInfo=studentInfoList.get(position);

        TextView n,p,a;
        n=view.findViewById(R.id.nametextwiewid);
        p=view.findViewById(R.id.phonetextviewid);
        a=view.findViewById(R.id.agetextviewid);

        n.setText(studentInfo.getName());
        p.setText(studentInfo.getPhone());
        a.setText(studentInfo.getAge());

        return view;
    }
}
