package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    EditText pass,name;
    TextView textView;
    Button button;
    int count=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pass=findViewById(R.id.passwordid);
        name=findViewById(R.id.nameid);
        textView=findViewById(R.id.textviewid);
        button=findViewById(R.id.buttonid);
        textView.setText("Remining attempts : "+count);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n=name.getText().toString();
                String p=pass.getText().toString();

                if(n.equals("hadi")&&p.equals("1234")){

                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }
                else
                {
                    count--;
                    textView.setText("Remining attempts : "+count);
                    if (count==0)
                    {
                        //button.setVisibility();
                        button.setEnabled(false);
                        textView.setText("You are fail to log in ");
                    }
                }
            }
        });
    }
}
