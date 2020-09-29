package com.example.first;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button habibButton,jamanButton,orpiButton;
Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        jamanButton=findViewById(R.id.jamanid);
        habibButton=findViewById(R.id.habibid);
        orpiButton=findViewById(R.id.orpiid);

        jamanButton.setOnClickListener(this);
        habibButton.setOnClickListener(this);
        orpiButton.setOnClickListener(this);
    }
    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialogBuilder;
        alertDialogBuilder=new AlertDialog.Builder(this);

        alertDialogBuilder.setIcon(R.drawable.ic_launcher_background);
        alertDialogBuilder.setMessage("Do you want to exit? ");
        alertDialogBuilder.setTitle("Personal app");

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog=alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.habibid)
        {
            intent=new Intent(MainActivity.this,Main2Activity.class);
            intent.putExtra("name","habib");
            startActivity(intent);
        }

        if(v.getId()==R.id.jamanid)
        {
            intent=new Intent(MainActivity.this,Main2Activity.class);
            intent.putExtra("name","jaman");
            startActivity(intent);
        }

        if(v.getId()==R.id.orpiid)
        {
            intent=new Intent(MainActivity.this,Main2Activity.class);
            intent.putExtra("name","orpi");
            startActivity(intent);
        }


    }
}
