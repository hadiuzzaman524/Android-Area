package com.example.multipleactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button=findViewById(R.id.secondbuttonid);
        editText=findViewById(R.id.edittextid);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String value=editText.getText().toString();
            Intent intent=new Intent(Main2Activity.this,MainActivity.class);
            intent.putExtra("key",value);
            setResult(1,intent);
            finish();

        }
    });


    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent);
    }
}
