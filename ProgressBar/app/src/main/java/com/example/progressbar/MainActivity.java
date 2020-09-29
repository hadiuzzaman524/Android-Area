package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    int p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progresBarid);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(p=10; p<=100; p+=10)
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
        });

        thread.start();
    }
}
