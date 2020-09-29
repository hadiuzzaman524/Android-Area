package com.example.chexkbox_radiobuttonex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
CheckBox hadi,orpi;
Button showb;
Button doneb;
RadioGroup radioGroup;
RadioButton radioButton;
TextView ctv,rtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher_background);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("We are in Love ");
        setContentView(R.layout.activity_main);
        hadi=findViewById(R.id.hadiid);
        orpi=findViewById(R.id.orpiid);
        showb=findViewById(R.id.showbuttonid);
        doneb=findViewById(R.id.donebuttonid);
        ctv=findViewById(R.id.showresultid);
        rtv=findViewById(R.id.radioshow);
        radioGroup=findViewById(R.id.radiogroupid);

        showb.setOnClickListener( MainActivity.this);
        doneb.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View v) {

        StringBuilder str=new StringBuilder();

        if(hadi.isChecked())
        {
            String value=hadi.getText().toString();
            str.append(value+" and ");
        }
        if(orpi.isChecked())
        {
            String value=orpi.getText().toString();
            str.append(value+" are in love");
        }
        ctv.setText(str);

        int selectedid=radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(selectedid);
       String s= radioButton.getText().toString();

       rtv.setText("You are selected "+s);

    }
}
