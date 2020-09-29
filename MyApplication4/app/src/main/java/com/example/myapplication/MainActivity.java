package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    StringBuilder name = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (sharedPreferences.contains("key")) {
            name.append(sharedPreferences.getString("key", "jaman"));

            String p = name.toString();
            if (p.equals("")) {

            } else
                Toast.makeText(getApplicationContext(), "" + name, Toast.LENGTH_LONG).show();
        }

        String x = name.toString();
        if (x.equals("hadiuzzaman")) {

            Intent intent = new Intent(MainActivity.this, Main3Activity.class);
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_main);

            button = findViewById(R.id.fastid);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }
            });
        }


    }
}
