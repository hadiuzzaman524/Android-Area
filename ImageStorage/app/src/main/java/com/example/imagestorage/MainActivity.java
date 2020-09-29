package com.example.imagestorage;

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
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button save,load,choose;
    ImageView imageView;
    private  static final int IMAGE_REQUEST=1;
    EditText name,age;
    int x=0;
    DatabaseReference databaseReference;
    StorageReference storageReference;
    Uri imageuri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save=findViewById(R.id.savebuttonid);
        load=findViewById(R.id.loadbuttonid);
        choose=findViewById(R.id.chooseid);
        imageView=findViewById(R.id.imageviewid);
      //edittext
        name=findViewById(R.id.nameid);
        age=findViewById(R.id.ageid);

        save.setOnClickListener(this);
        load.setOnClickListener(this);
        choose.setOnClickListener(this);

        Bundle bundle=getIntent().getExtras();
        if (bundle!=null)
        {
            String nm=bundle.getString("key");
            databaseReference= FirebaseDatabase.getInstance().getReference(nm);
            storageReference= FirebaseStorage.getInstance().getReference(nm);
        }


    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.chooseid)
        {
            ++x;
            loadData();
            //Toast.makeText(getApplicationContext(),x,Toast.LENGTH_LONG).show();
        }
        if (v.getId()==R.id.savebuttonid)
        {
            Toast.makeText(getApplicationContext(),""+x,Toast.LENGTH_LONG).show();
           // saveData();
        }
        if (v.getId()==R.id.loadbuttonid)
        {

            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
    }

    private void saveData() {

        final String nam=name.getText().toString().trim();
        final String ag=age.getText().toString().trim();

        if (nam.isEmpty())
        {
            name.setError("Enter name");
            name.requestFocus();
            return;

        }

        if (ag.isEmpty())
        {
            age.setError("Enter age");
            age.requestFocus();
            return;

        }
//else
        StorageReference ref=storageReference.child(System.currentTimeMillis()+"."+getFileExtension(imageuri));

        ref.putFile(imageuri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Task<Uri> uriTask=taskSnapshot.getStorage().getDownloadUrl();
                        while (!uriTask.isSuccessful());
                        Uri downloadurl=uriTask.getResult();

                        Upload upload=new Upload(nam,ag,downloadurl.toString());
                        String key=databaseReference.push().getKey();
                        databaseReference.child(key).setValue(upload);

                        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(intent);

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                    }
                });

    }

    private void loadData() {

        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==IMAGE_REQUEST&&resultCode==RESULT_OK&&data!=null&&data.getData()!=null){

            imageuri=data.getData();
            Picasso.with(this).load(imageuri).into(imageView);
        }
    }

    public String getFileExtension(Uri imageuri)
    {
        ContentResolver contentResolver=getContentResolver();
        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(imageuri));
    }



}
