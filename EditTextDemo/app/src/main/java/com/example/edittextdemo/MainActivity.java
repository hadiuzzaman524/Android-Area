package com.example.edittextdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
 TextView tv;
 Button add;
 Button sub;
 EditText num1,num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.outputid);
        add=findViewById(R.id.addid);
        sub=findViewById(R.id.subid);
        num1=findViewById(R.id.number1id);
        num2=findViewById(R.id.number2id);

    }

    public void showOutput(View v)
    {
       String number1=num1.getText().toString();
       String number2=num2.getText().toString();

       double n=Double.parseDouble(number1);
       double m=Double.parseDouble(number2);

       if(v.getId()==R.id.addid)
       { double sum=n+m;
           tv.setText("Result: "+sum);
       }

       else if(v.getId()==R.id.subid)
       {
           double sub=n-m;
           tv.setText("Result: "+sub);
       }

    }
}
