package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
TextView textView;
Button button;
TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textviewid);
        button=findViewById(R.id.buttonid);
        timePicker=findViewById(R.id.timepickerid);
        timePicker.setIs24HourView(true);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String time=timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute();

        textView.setText(time);
    }
}
