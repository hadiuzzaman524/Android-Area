package com.nested.messenger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class signuppage extends AppCompatActivity {

    TextView alreadyaccount;
    private EditText name, email, password;
    private FirebaseAuth mAuth;
    private DatabaseReference firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);

        alreadyaccount = findViewById(R.id.signupbutton);

        name = findViewById(R.id.nameid);
        email = findViewById(R.id.upemail);
        password = findViewById(R.id.uppasswordid);

        mAuth = FirebaseAuth.getInstance();

        alreadyaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String n = name.getText().toString();
                String e = email.getText().toString();
                String p = password.getText().toString();

                register(n, e, p);

            }
        });
    }

    private void register(final String n, String e, String p) {
        mAuth.createUserWithEmailAndPassword(e, p)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser firebaseUser = mAuth.getCurrentUser();
                            String userId = firebaseUser.getUid();

                            firebaseDatabase = FirebaseDatabase.getInstance().getReference("users").child(userId);

                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("id", userId);
                            hashMap.put("username", n);
                            hashMap.put("imageurl", "default");
                            firebaseDatabase.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    startActivity(new Intent(signuppage.this, MainActivity.class));
                                }
                            });

                        } else {

                            Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_LONG).show();
                        }

                    }
                });
    }
}
