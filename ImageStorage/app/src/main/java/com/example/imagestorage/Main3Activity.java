package com.example.imagestorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    EditText dbname;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        dbname=findViewById(R.id.datanameid);
        button=findViewById(R.id.nextButtonid);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String name=dbname.getText().toString().trim();
        if (v.getId()==R.id.nextButtonid)
        {

            Intent intent=new Intent(Main3Activity.this,MainActivity.class);
            intent.putExtra("key",name);
            startActivity(intent);
        }
    }
}
