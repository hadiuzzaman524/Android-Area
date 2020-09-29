package com.example.storesetting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        linearLayout=findViewById(R.id.linearid);
        loadColor();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_layout,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.redid)
        {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.redcolorid));

            storeColor(getResources().getColor(R.color.redcolorid));
        }
        if(item.getItemId()==R.id.blackid)
        {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

            storeColor(getResources().getColor(R.color.colorPrimaryDark));

        }
        if(item.getItemId()==R.id.green)
        {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            storeColor(getResources().getColor(R.color.colorPrimary));
        }
        return super.onOptionsItemSelected(item);
    }


    void storeColor(int color)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("Background",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("mycolor",color);
        editor.commit();
    }

    int loadColor()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("Background",MODE_PRIVATE);
        int color=sharedPreferences.getInt("mycolor",getResources().getColor(R.color.colorPrimary));

        return color;
    }
}
