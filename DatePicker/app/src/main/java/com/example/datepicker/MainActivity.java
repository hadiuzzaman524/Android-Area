package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

TextView textView;
Button button;
DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textid);
        button=findViewById(R.id.buttonid);
        datePicker=findViewById(R.id.datepickerid);

        textView.setText(currentDate());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(currentDate());

            }
        });

    }


    String currentDate()
    {
        StringBuilder str=new StringBuilder();
        str.append(datePicker.getDayOfMonth()+"/");
        str.append((datePicker.getMonth()+1)+"/");
        str.append(datePicker.getYear());

        return str.toString();

    }
}
