package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {
FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mAuth=FirebaseAuth.getInstance();
    }

    @Override
    public void onBackPressed() {

        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();
        Intent intent=new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent);
    }
}
