package com.example.detailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class F extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f);
        Bundle bundle=getIntent().getExtras();
    }
}
