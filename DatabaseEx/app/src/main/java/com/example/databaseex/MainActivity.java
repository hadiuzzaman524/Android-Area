package com.example.databaseex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name,phone,age;
    Button show,load;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference= FirebaseDatabase.getInstance().getReference("Student details");

        name=findViewById(R.id.nameid);
        phone=findViewById(R.id.phoneid);
        age=findViewById(R.id.ageid);
        show=findViewById(R.id.buttonid);
        load=findViewById(R.id.loadbutton);

        show.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.buttonid)
        {
            saveData();

        }
        if (v.getId()==R.id.loadbutton)
        {
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
    }

    private void saveData() {

        String n=name.getText().toString().trim();
        String p=phone.getText().toString().trim();
        String a=age.getText().toString().trim();

        StudentInfo student=new StudentInfo(n,p,a);
        String key=databaseReference.push().getKey();
        databaseReference.child(key).setValue(student);
    }


}
