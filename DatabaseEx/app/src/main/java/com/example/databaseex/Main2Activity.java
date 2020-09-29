package com.example.databaseex;

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

    DatabaseReference databaseReference;
    ListView listView;
    List<StudentInfo> studentInfoList;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        databaseReference= FirebaseDatabase.getInstance().getReference("Student details");
        listView=findViewById(R.id.listviewid);

        studentInfoList=new ArrayList<>();
        customAdapter=new CustomAdapter(Main2Activity.this,studentInfoList);

    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                studentInfoList.clear();

                for(DataSnapshot snapshot: dataSnapshot.getChildren())
                {
                    StudentInfo studentInfo=snapshot.getValue(StudentInfo.class);
                    studentInfoList.add(studentInfo);

                    listView.setAdapter(customAdapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}
