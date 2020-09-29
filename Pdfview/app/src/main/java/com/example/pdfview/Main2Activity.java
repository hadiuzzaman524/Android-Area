package com.example.pdfview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Main2Activity extends AppCompatActivity {

    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pdfView=findViewById(R.id.pdfviewid);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            String value=bundle.getString("tag");

            if(value.equals("button1"))
            {
                pdfView.fromAsset("book.pdf").load();
            }
            else if(value.equals("button2"))
            {
                pdfView.fromAsset("bookn.pdf").load();
            }
        }
    }
}
