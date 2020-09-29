package com.nested.storeinformationinfirebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    StorageReference storageReference;

    EditText name,age;
    Button button ,button2;

    ImageView imageView;
    ProgressBar progressBar;
    private static final int IMAGE_REQUEST = 1;
    private Uri imageuri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference=FirebaseDatabase.getInstance().getReference();
storageReference= FirebaseStorage.getInstance().getReference("info");
        name=findViewById(R.id.nameid);
        age=findViewById(R.id.ageid);
        button=findViewById(R.id.buttonid);
        button2=findViewById(R.id.loadid);
        imageView=findViewById(R.id.imageid);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadImage();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=name.getText().toString();
                String a=age.getText().toString();

                HashMap<String ,Object> hashMap=new HashMap<>();

                hashMap.put("name",n);
                hashMap.put("age",a);
                databaseReference.child("Chats").push().setValue(hashMap);
            }
        });
    }


    private void loadImage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageuri = data.getData();
            Picasso.with(this).load(imageuri).into(imageView);
        }

    }

    private String getFileExtension(Uri imageuri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(imageuri));
    }


    private void storeData() {

        progressBar.setVisibility(View.VISIBLE);
        StorageReference ref = storageReference.child(System.currentTimeMillis() + "." + getFileExtension(imageuri));

        ref.putFile(imageuri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                     /*   progressBar.setVisibility(View.GONE);
                        Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uriTask.isSuccessful()) ;
                        Uri downloadurl = uriTask.getResult();
                        String var = downloadurl.toString();


                        sname = name.getText().toString();
                        sage = age.getText().toString();

                        Student info = new Student(sname, sage, var);

                        String key = databaseReference.push().getKey();
                        databaseReference.child(key).setValue(info);
*/
                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                     //   progressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "Upload failed", Toast.LENGTH_LONG).show();
                    }
                });
    }
}
