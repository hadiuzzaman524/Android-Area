package com.example.spinnerex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    TextView textView;
    Button button;
    String names[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textviewid);
        button=findViewById(R.id.buttonid);
        spinner=findViewById(R.id.spinnerid);
        names=getResources().getStringArray(R.array.name);
        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.sample,R.id.tvid,names);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String s=spinner.getSelectedItem().toString();
                textView.setText(s);
            }
        });

    }
}
