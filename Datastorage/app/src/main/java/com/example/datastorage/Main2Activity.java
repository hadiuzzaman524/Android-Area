package com.example.datastorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    ListView listView;
    DatabaseReference databaseReference;
    List<Student> studentList;
    CustomAdepter customAdepter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        databaseReference= FirebaseDatabase.getInstance().getReference("students");

        listView=findViewById(R.id.listviewid);

        studentList=new ArrayList<>();
        customAdepter=new CustomAdepter(Main2Activity.this,studentList);
    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                studentList.clear();

                for (DataSnapshot snapshot:dataSnapshot.getChildren() ){
                    Student student=snapshot.getValue(Student.class);
                   studentList.add(student);
                }

                listView.setAdapter(customAdepter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}
