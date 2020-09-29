package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.DigitalClock;
import android.widget.Toast;

import static com.example.clock.R.id.analogid;
import static com.example.clock.R.id.digitalid;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

AnalogClock analogClock;
DigitalClock digitalClock;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        analogClock=findViewById(analogid);
        digitalClock=findViewById(digitalid);

        analogClock.setOnClickListener(this);
        digitalClock.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()== analogid)
        {
            Toast.makeText(this,"Analog",Toast.LENGTH_SHORT).show();
        }
        if(v.getId()== digitalid)
        {
            Toast.makeText(this,"Digital",Toast.LENGTH_SHORT).show();
        }
    }
}
