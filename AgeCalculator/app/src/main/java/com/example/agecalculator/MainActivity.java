package com.example.agecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView currentDate;
    TextView birthDate, showAge;
    Button show, cal, jaman;

    DatePickerDialog datePickerDialog;

    int currentYear;
    int currentMonth;
    int currentDay;
    int birthdate, birthmonth, birthyear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getSupportActionBar().hide();


        setContentView(R.layout.activity_main);
        currentDate = findViewById(R.id.currentdateid);
        birthDate = findViewById(R.id.birthdateid);
        show = findViewById(R.id.buttonid);
        cal = findViewById(R.id.calculateid);
        showAge = findViewById(R.id.agetextid);
        jaman = findViewById(R.id.jamanid);


        show.setOnClickListener(this);
        cal.setOnClickListener(this);
        jaman.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.jamanid) {
            currentDate.setText(currentTime());
        }
        if (v.getId() == R.id.buttonid) {
            DatePicker datePicker = new DatePicker(this);
            int cyear = datePicker.getYear();
            int cmonth = datePicker.getMonth();
            int cdate = datePicker.getDayOfMonth();

            datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    birthDate.setText(dayOfMonth + " / " + (month + 1) + " / " + year);
                    birthdate = dayOfMonth;
                    birthmonth = month + 1;
                    birthyear = year;

                }
            }, cyear, cmonth, cdate);

            datePickerDialog.show();
        }

        if (v.getId() == R.id.calculateid) {
            if (currentDate.getText().toString().equals("")) {
                showAge.setText("         Empty CurrentDay ");
            }

            if (birthDate.getText().toString().equals("")) {
                showAge.setText("         Empty BirthDay ");
            } else if ((birthdate > currentDay && birthmonth == (currentMonth + 1) && birthyear == currentYear) || birthyear > currentYear) {
                showAge.setText("        Invalid BirthDay ");
            } else
                calculateAge();
        }


    }

    String currentTime() {
        StringBuilder str = new StringBuilder();
        DatePicker datePicker = new DatePicker(this);
        currentYear = datePicker.getYear();
        currentMonth = datePicker.getMonth();
        currentDay = datePicker.getDayOfMonth();
        str.append(currentDay + " / " + (currentMonth + 1) + " / " + currentYear);

        return str.toString();
    }

    void calculateAge() {
        int currentdate = currentDay, currentmonth = currentMonth + 1, currentyear = currentYear;

        int day, month, year;

        if (currentdate < birthdate) {
            currentdate += +30;
            day = currentdate - birthdate;
            birthmonth += 1;
        } else {
            day = currentdate - birthdate;
        }
        if (currentmonth < birthmonth) {
            currentmonth += 12;
            month = birthmonth - currentmonth;
            birthyear += 1;
        } else {
            month = currentmonth - birthmonth;
        }

        year = currentyear - birthyear;

        String s = year + " Years " + month + " Month " + day + " Days";
        showAge.setText(s);
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialogBuilder;
        alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setTitle("Age Calculator ");
        alertDialogBuilder.setMessage("Do you want to exit it? ");
        alertDialogBuilder.setIcon(R.drawable.ic_calculator);
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dialog = alertDialogBuilder.create();
        dialog.show();
    }
}
