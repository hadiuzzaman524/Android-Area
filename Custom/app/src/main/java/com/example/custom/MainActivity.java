package com.example.custom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    SearchView searchView;
    String name[];
    int pictures[]={R.drawable.jaman,R.drawable.orpi,R.drawable.jaman,R.drawable.orpi,R.drawable.jaman,R.drawable.jaman,R.drawable.orpi,R.drawable.jaman};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listviewid);
        name=getResources().getStringArray(R.array.name);
        searchView=findViewById(R.id.searchid);

        final CustomAdapter adapter=new CustomAdapter(this,name,pictures);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String n=name[position];
               // Toast.makeText(MainActivity.this,n,Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("jaman",n);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialogBuilder;

        alertDialogBuilder=new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Family Galary");
        alertDialogBuilder.setMessage("Do you want to close it? ");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               dialog.cancel();
            }
        });

        AlertDialog alertDialog=alertDialogBuilder.create();
        alertDialog.show();
    }

}
