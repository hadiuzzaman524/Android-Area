package com.example.firebaseex1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name,email,pass;
    Button button;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        name=findViewById(R.id.nameid);
        email=findViewById(R.id.emailid);
        pass=findViewById(R.id.passid);
        progressBar=findViewById(R.id.pid);

        button=findViewById(R.id.showbuttonid);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.showbuttonid)
        {
            checkValidity();
        }

    }

    private void checkValidity() {

        String n=pass.getText().toString();
        String e=email.getText().toString();

      progressBar.setVisibility(View.VISIBLE);
        if (n.isEmpty()){

           pass.setError("Pass is small");
            name.requestFocus();
        }
        if (e.isEmpty()){

           email.setError("Error email");
            email.requestFocus();
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(e).matches()){

            email.setError("Error email");
            email.requestFocus();
        }


   mAuth.signInWithEmailAndPassword(e,n).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
       @Override
       public void onComplete(@NonNull Task<AuthResult> task) {

           progressBar.setVisibility(View.GONE);
           if (task.isSuccessful())
           {   finish();
               Intent intent=new Intent(MainActivity.this,Main2Activity.class);
               intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               startActivity(intent);
           }
           else
           {
               Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
           }

       }
   });

    }
}
