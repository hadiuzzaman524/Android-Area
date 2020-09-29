package com.example.datepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

Button button;
TextView textView;
DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.buttonid);
        textView=findViewById(R.id.textid);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        DatePicker obj=new DatePicker(this);
        int currentDate=obj.getDayOfMonth();
        int currentMonth=obj.getMonth();
        int currentYear=obj.getYear();

        datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                textView.setText(dayOfMonth+" / "+(month+1)+" / "+year);
            }
        },currentYear,currentMonth,currentDate);
        datePickerDialog.show();

    }
}
