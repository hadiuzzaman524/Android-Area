package com.example.customtoastdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.buttonid);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        LayoutInflater obj=getLayoutInflater();
        View vm=obj.inflate(R.layout.customlayout, (ViewGroup) findViewById(R.id.layoutid));
        Toast toast=new Toast(MainActivity.this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(vm);
        toast.show();
    }
}
