package com.example.listviewexersice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listviewid);

        String n[]=getResources().getStringArray(R.array.name);
        searchView=findViewById(R.id.searchviewid);

        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.sample,R.id.textviewid,n);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {

            adapter.getFilter().filter(newText);
            return false;
        }
    });
    }
}
