package com.example.sharedpreferenceexersice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button store,save;
    EditText name,phone;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.nameid);
        phone=findViewById(R.id.phoneid);
        store=findViewById(R.id.storebuttonid);
        save=findViewById(R.id.showbutton);
        textView=findViewById(R.id.textviewid);


        store.setOnClickListener(this);
        save.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String n=name.getText().toString();
        String p=phone.getText().toString();

        if(n.equals("")||p.equals(""))
        {
            Toast.makeText(this,"Empty input type",Toast.LENGTH_SHORT).show();
        }else
        {
            if(v.getId()==R.id.storebuttonid)
            {
                SharedPreferences sharedPreferences=getSharedPreferences("Details",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("studentname",n);
                editor.putString("studentphone",p);
                editor.commit();

                Toast.makeText(this,"Data stored successfully",Toast.LENGTH_SHORT).show();
            }
            else if(v.getId()==R.id.showbutton)
            {
                SharedPreferences sharedPreferences=getSharedPreferences("Details",MODE_PRIVATE);
                String nm=sharedPreferences.getString("studentname","hadiuzzaman");
                String pn=sharedPreferences.getString("studentphone","01785304677");

                textView.setText("Name: "+nm+"\nPhone: "+pn);

            }
        }



    }
}
