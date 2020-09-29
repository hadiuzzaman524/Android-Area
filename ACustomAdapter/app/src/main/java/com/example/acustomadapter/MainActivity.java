package com.example.acustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
Spinner listView;
String name[];
int flag[]={R.drawable.jaman,R.drawable.orpi};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listviewid);
         name=getResources().getStringArray(R.array.name);

        CustomAdapter adapter=new CustomAdapter(this,name,flag);
        listView.setAdapter(adapter);

    }
}
