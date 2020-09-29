package com.example.checkboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{
Button b;
CheckBox milk,water,sugar;
TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.buttonid);
        milk=findViewById(R.id.milkid);
        water=findViewById(R.id.waterid);
        sugar=findViewById(R.id.sugarid);
        tv=findViewById(R.id.resultid);


    }

    public void onClick(View v) {

       StringBuilder st=new StringBuilder();
        if(milk.isChecked())
        {
            String value=milk.getText().toString();
            st.append("You are selected :"+value+"\n");
        }
        if(sugar.isChecked())
        {
            String value=sugar.getText().toString();
            st.append("You are selected :"+value+"\n");
        }
        if(water.isChecked())
        {
            String value=water.getText().toString();
            st.append("You are selected :"+value+"\n");

        }
        tv.setText(st);

    }
}
