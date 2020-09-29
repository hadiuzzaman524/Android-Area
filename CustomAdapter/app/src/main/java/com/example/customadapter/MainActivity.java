package com.example.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String countryName[];
    int flags[]={R.drawable.jaman,R.drawable.orpi,R.drawable.orpi,R.drawable.orpi,R.drawable.orpi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listviewid);
        countryName=getResources().getStringArray(R.array.name);

        CustomAdapter adapter=new CustomAdapter(this,countryName,flags);

        listView.setAdapter(adapter);
    }
}
