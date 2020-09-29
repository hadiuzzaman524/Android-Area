package com.example.exersice3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    Button b1;
    Button b2;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        t=findViewById(R.id.textid);
    }
    public void showInformation(View v)
    {
        if(v.getId()==R.id.button1)
        {
            Log.d("jaman","my name is hadiuzzaman");
        }
        else
        {
            t.setText("Button 2 is clicked");
        }
    }
}
