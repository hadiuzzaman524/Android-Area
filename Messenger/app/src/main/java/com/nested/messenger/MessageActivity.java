package com.nested.messenger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nested.messenger.Adapter.MessageAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageActivity extends AppCompatActivity {

    CircleImageView imageView;
    TextView textView;
    FirebaseUser fuser;
    DatabaseReference databaseReference;
    Intent intent;

    ImageButton sendmsg;
    EditText text;
    RecyclerView recyclerView;
    MessageAdapter messageAdapter;
    List<Chat> mChat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Toolbar toolbar=findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");



        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        imageView=findViewById(R.id.profilepictureid);
        textView=findViewById(R.id.usernameid);
        sendmsg=findViewById(R.id.sendbutton);
        text=findViewById(R.id.txtmsgid);

        recyclerView=findViewById(R.id.recycular_view_msgid);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);



        intent=getIntent();
        final String userId=intent.getStringExtra("userid");
        fuser= FirebaseAuth.getInstance().getCurrentUser();

        sendmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msg=text.getText().toString().trim();
                if (msg.length()>0)
                {
                    message(fuser.getUid(),userId,msg);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"can't send a blank message!",Toast.LENGTH_LONG).show();
                }
                text.setText("");

            }

        });


        databaseReference= FirebaseDatabase.getInstance().getReference("users").child(userId);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                User user=dataSnapshot.getValue(User.class);
                textView.setText(user.getUsername());

                if(user.getImageurl().equals("default"))
                {
                    imageView.setImageResource(R.mipmap.ic_launcher);
                }
                else
                {
                    Glide.with(MessageActivity.this).load(user.getImageurl()).into(imageView);
                }

                readMessage(fuser.getUid(),userId,user.getImageurl());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void message(String sender,String reciever,String msg)
    {

        DatabaseReference databaseReference1=FirebaseDatabase.getInstance().getReference();
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("sender",sender);
        hashMap.put("reciever",reciever);
        hashMap.put("message",msg);
        databaseReference1.child("Chats").push().setValue(hashMap);
    }

    private void readMessage(final String myid,final String userid,final String imageurl)
    {
        mChat=new ArrayList<>();

        databaseReference=FirebaseDatabase.getInstance().getReference("Chats");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                mChat.clear();

                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Chat chat=dataSnapshot1.getValue(Chat.class);

                    if(chat.getReciever().equals(myid)&&chat.getSender().equals(userid) ||
                   chat.getReciever().equals(userid)&&chat.getSender().equals(myid))
                    {
                        mChat.add(chat);
                    }

                    messageAdapter=new MessageAdapter(MessageActivity.this,mChat,imageurl);
                    recyclerView.setAdapter(messageAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
