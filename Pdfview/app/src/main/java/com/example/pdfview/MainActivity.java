package com.example.pdfview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2;
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button1id);
        b2=findViewById(R.id.button2id);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.button1id)
        {
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            intent.putExtra("tag","button1");
            startActivity(intent);
        }
        if (v.getId()==R.id.button2id)
        {
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            intent.putExtra("tag","button2");
            startActivity(intent);
        }

    }
}
