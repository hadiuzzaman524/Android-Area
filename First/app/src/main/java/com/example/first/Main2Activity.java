package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView=findViewById(R.id.imageid);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            String value=bundle.getString("name");

            if(value.equals("orpi"))
            {
                imageView.setImageResource(R.drawable.orpi);
            }
            if(value.equals("jaman"))
            {
                imageView.setImageResource(R.drawable.jaman);
            }
            if(value.equals("habib"))
            {
                imageView.setImageResource(R.drawable.habib);
            }
        }
    }
}
