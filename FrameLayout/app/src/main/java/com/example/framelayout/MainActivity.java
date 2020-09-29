package com.example.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView hadi,orpi;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hadi=findViewById(R.id.hadi);
        orpi=findViewById(R.id.orpiid);
        textView=findViewById(R.id.textViewid);

        hadi.setOnClickListener(this);
        orpi.setOnClickListener(this);
        textView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.orpiid)
        {
            orpi.setVisibility(View.GONE);
            hadi.setVisibility(View.VISIBLE);
        }  if (v.getId()==R.id.hadi)
        {
            hadi.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        }
        if (v.getId()==R.id.textViewid)
        {
            textView.setVisibility(View.GONE);
            orpi.setVisibility(View.VISIBLE);
        }
    }
}
