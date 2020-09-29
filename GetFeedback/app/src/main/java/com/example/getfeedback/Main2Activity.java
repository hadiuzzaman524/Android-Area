package com.example.getfeedback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    Button clear,send;
    EditText name,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main2);

        clear=findViewById(R.id.clearbuttonid);
        send=findViewById(R.id.sendbuttonid);

        name=findViewById(R.id.editTextNameid);
        message=findViewById(R.id.messageId);

        clear.setOnClickListener(this);
        send.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String n=name.getText().toString();
        String me=message.getText().toString();

        if (v.getId()==R.id.clearbuttonid)
        {
            name.setText("");
            message.setText("");
        }

        if(v.getId()==R.id.sendbuttonid)
        {
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/email");
            intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"hadiuzzaman908@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback from apps");
            intent.putExtra(Intent.EXTRA_TEXT,"Name: "+n+"\nMessage: "+me);
            startActivity(Intent.createChooser(intent,"Feedback"));
        }
    }
}
