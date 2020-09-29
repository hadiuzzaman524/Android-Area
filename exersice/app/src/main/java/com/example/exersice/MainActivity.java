package com.example.exersice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    AnalogClock analogClock;
    Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.buttonid);
        button.setOnClickListener(this);


    }

}
