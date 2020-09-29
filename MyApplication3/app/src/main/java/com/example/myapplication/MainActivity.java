package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1,button2;
    // int y;
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=findViewById(R.id.showid);
        button2=findViewById(R.id.sendid);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        if (v.getId()==R.id.showid)
        { ++x;
        // y=x;
            Toast.makeText(getApplicationContext(),""+x,Toast.LENGTH_LONG).show();
        }
        if (v.getId()==R.id.sendid)
        {
            Toast.makeText(getApplicationContext(),""+x,Toast.LENGTH_LONG).show();
        }
    }
}
