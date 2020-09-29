package com.example.timepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    TextView textView;
    TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.buttonid);
        textView=findViewById(R.id.textviewid);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        TimePicker obj=new TimePicker(this);
        int currentHour=obj.getCurrentHour();
        int currentMinute=obj.getCurrentMinute();

        timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                textView.setText(hourOfDay+" : "+minute);
            }
        },currentHour,currentMinute,false);
        timePickerDialog.show();

    }
}
