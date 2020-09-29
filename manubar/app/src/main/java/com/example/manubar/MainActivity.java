package com.example.manubar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.manu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.settingid)
        {
            Toast.makeText(this,"setting",Toast.LENGTH_SHORT).show();
        }

        if(item.getItemId()==R.id.settingid)
        {
            Toast.makeText(this,"setting",Toast.LENGTH_SHORT).show();
        }

        if(item.getItemId()==R.id.shareid)
        {
            Toast.makeText(this,"share",Toast.LENGTH_SHORT).show();
        }

        if(item.getItemId()==R.id.aboutusid)
        {
            Toast.makeText(this,"Aboutus",Toast.LENGTH_SHORT).show();
        }

        if(item.getItemId()==R.id.feedbackid)
        {
            Toast.makeText(this,"Feedback",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
