package com.example.relationallayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView name,roll,gpa,ins;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.nameid);
        roll=findViewById(R.id.rollid);
        gpa=findViewById(R.id.gpaid);
        ins=findViewById(R.id.instituteid);

        name.setText("Shaiduzzaman");
        roll.setText("03");
        gpa.setText("4.00");
        ins.setText("Buet");
    }
}
