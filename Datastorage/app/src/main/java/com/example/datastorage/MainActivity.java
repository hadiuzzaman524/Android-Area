package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText name,age,nb;
Button button,loadbutton;
DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.nameid);
        age=findViewById(R.id.ageid);
        nb=findViewById(R.id.phoneid);
        button=findViewById(R.id.buttonid);
        button.setOnClickListener(this);
        loadbutton=findViewById(R.id.loadbutton);
        loadbutton.setOnClickListener(this);

        databaseReference= FirebaseDatabase.getInstance().getReference("hadi");
    }

    @Override
    public void onClick(View v) {


        if (v.getId()==R.id.buttonid){
            storeData();
        }

        if (v.getId()==R.id.loadbutton)
        {
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
    }

    private void storeData() {

        String nam=name.getText().toString().trim();
        String ag=age.getText().toString().trim();
        String number=nb.getText().toString().trim();

        String key=databaseReference.push().getKey();

        Student obj=new Student(nam,ag,number);

        databaseReference.child(key).setValue(obj);

    }
}
