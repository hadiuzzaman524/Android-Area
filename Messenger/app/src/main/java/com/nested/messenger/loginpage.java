package com.nested.messenger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginpage extends AppCompatActivity {

    TextView textView;
    Button button;
    private FirebaseAuth mAuth;
    EditText email,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        textView=findViewById(R.id.signid);
        button=findViewById(R.id.logid);

        email=findViewById(R.id.emailid);
        password=findViewById(R.id.passwordid);
          mAuth=FirebaseAuth.getInstance();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginpage.this,signuppage.class));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String e=email.getText().toString();
                String p=password.getText().toString();

                mAuth.signInWithEmailAndPassword(e,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(loginpage.this,MainActivity.class));

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                //
            }
        });
    }
}
