package com.example.customadapterwithspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import static com.example.customadapterwithspinner.R.id.tvid;

public class MainActivity extends AppCompatActivity {

    ListView spinner;

    String name[];
   // int flag[]={R.drawable.jaman,R.drawable.orpi,R.drawable.jaman,R.drawable.orpi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinnerid);
        name=getResources().getStringArray(R.array.name);

       // CustomAdapter adapter=new CustomAdapter(this,name,flag);
        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.sample, tvid,name);
        spinner.setAdapter(adapter);


    }
}
