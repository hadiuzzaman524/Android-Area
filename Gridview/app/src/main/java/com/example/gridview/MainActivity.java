package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {
GridView gridView;
String names[];
int pictures[]={R.drawable.jaman,R.drawable.orpi,R.drawable.jaman,R.drawable.orpi,R.drawable.jaman,R.drawable.orpi,R.drawable.jaman,R.drawable.orpi,R.drawable.jaman,R.drawable.orpi,R.drawable.jaman,R.drawable.orpi};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView=findViewById(R.id.gridviewid);
        names=getResources().getStringArray(R.array.name);
        CustomAdapter adapter=new CustomAdapter(this,names,pictures);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value=names[position];

                Toast.makeText(MainActivity.this,value, LENGTH_SHORT).show();
            }
        });
    }


}

