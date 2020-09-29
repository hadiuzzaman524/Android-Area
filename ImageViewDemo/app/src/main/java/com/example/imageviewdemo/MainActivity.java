package com.example.imageviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
ImageView i1,i2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        i1=findViewById(R.id.im1id);
        i2=findViewById(R.id.im2id);

        i1.setOnClickListener(this);
        i2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.im1id)
        {
          Toast.makeText(MainActivity.this,"jaman1",Toast.LENGTH_SHORT).show();

        }
        else if(v.getId()==R.id.im2id)
        {
            Toast.makeText(MainActivity.this,"jaman2",Toast.LENGTH_SHORT).show();

        }
    }
}
