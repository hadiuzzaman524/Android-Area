package com.nested.onlineshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
DrawerLayout drawerLayout;
ActionBarDrawerToggle toggle;
NavigationView navigationView;
FrameLayout frameLayout;

BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState==null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameviewid,new First()).commit();

        }

        drawerLayout=findViewById(R.id.navigation_drawerid);
        navigationView=findViewById(R.id.navigationviewid);
        navigationView.setNavigationItemSelectedListener(this);


        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open_,R.string.close_);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        bottomNavigationView=findViewById(R.id.bottomid);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment=null;

                if(menuItem.getItemId()==R.id.shareappid)
                {
                    fragment=new First();
                }
                if(menuItem.getItemId()==R.id.aboutusid)
                {

                    fragment=new Second();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frameviewid,fragment).commit();


                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(toggle.onOptionsItemSelected(item))
        {
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        return false;
    }
}
