package com.example.listviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listviewid);
        final String [] value=getResources().getStringArray(R.array.name);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,R.layout.sample,R.id.textviewid,value);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String x=value[position];

                Toast.makeText(MainActivity.this,x,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
