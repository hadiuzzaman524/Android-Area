package com.nested.routinebuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
  private BottomNavigationView bottomNavigationView;
    Fragment fragment=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomnevid);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId()==R.id.homeid)
                {
                    fragment=new firstfrag();
                }
                if (menuItem.getItemId()==R.id.routineid)
                {
                    fragment=new second();
                }

                if(menuItem.getItemId()==R.id.subid)
                {
                    fragment=new third();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frameid,fragment).commit();
                return  false;
            }
        });

    }
}
