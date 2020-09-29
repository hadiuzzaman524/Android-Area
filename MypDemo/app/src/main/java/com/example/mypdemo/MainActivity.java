package com.example.mypdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private Button add,sub;
private TextView tv;
private EditText num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);
        add=findViewById(R.id.addid);
        sub=findViewById(R.id.subid);
        tv=findViewById(R.id.textid);
        num1=findViewById(R.id.num1id);
        num2=findViewById(R.id.num2id);

        add.setOnClickListener(MainActivity.this);
        sub.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View v) {

        try {

            String number1 = "";
            number1 = num1.getText().toString();
            String number2 = "";
            number2 = num2.getText().toString();
            double x = Double.parseDouble(number1);
            double y = Double.parseDouble(number2);

            if (v.getId() == R.id.addid) {
                tv.setText("add " + (x + y));


            } else if (v.getId() == R.id.subid) {
                tv.setText("sub " + (x - y));
            }
        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this, "Please Enter Number", Toast.LENGTH_SHORT).show();

        }
    }
}
