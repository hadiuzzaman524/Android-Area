package com.nested.messenger.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nested.messenger.Adapter.UserAdapter;
import com.nested.messenger.R;
import com.nested.messenger.User;

import java.util.ArrayList;
import java.util.List;


public class UserFragment extends Fragment {

    private UserAdapter userAdapter;
    private List<User> mUser;
    private RecyclerView recyclerView;
    ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_user, container, false);

        recyclerView=view.findViewById(R.id.recycularid);
        progressBar=view.findViewById(R.id.progid);
        progressBar.setVisibility(View.VISIBLE);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mUser=new ArrayList<>();
        readUsers();

        return view;
    }

    private void readUsers() {

       // Toast.makeText(getContext(),"readusers",Toast.LENGTH_LONG).show();
        final FirebaseUser firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("users");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                mUser.clear();

                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){

                    User user=dataSnapshot1.getValue(User.class);
                    mUser.add(user);

                }

                userAdapter=new UserAdapter(getContext(),mUser);
                recyclerView.setAdapter(userAdapter);
                progressBar.setVisibility(View.GONE);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(),"faild",Toast.LENGTH_LONG).show();
            }
        });
    }
}
