package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressBarid);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {

            work();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                finish();
            }

        });


        thread.start();

    }

    void work()
    {
        for(int p=10; p<=100; p+=10)
        {
            try{
                Thread.sleep(1000);
                progressBar.setProgress(p);
            }
            catch (InterruptedException e)
            {

            }
        }
    }
}
