package com.example.toast_myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.buttonid);
    }
    public void showMassege(View v)
    {
        LayoutInflater inflater=getLayoutInflater();
        View vm=inflater.inflate(R.layout.customlaout, (ViewGroup) findViewById(R.id.laoutid));
       Toast toast=new Toast(MainActivity.this);
       toast.setDuration(Toast.LENGTH_SHORT);
       toast.setView(vm);
       toast.show();

    }
}
