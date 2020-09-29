package com.nested.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Splash_screen extends AppCompatActivity {

    FirebaseUser firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        firebaseAuth=FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseAuth!=null)
        {
            startActivity(new Intent(Splash_screen.this,MainActivity.class));
            finish();
        }
        else
        {
            startActivity(new Intent(Splash_screen.this,loginpage.class));
            finish();
        }
    }
}
