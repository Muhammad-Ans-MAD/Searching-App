package com.example.searchingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    SearchView searchview;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        searchview = (SearchView) findViewById(R.id.search);
        listView = (ListView) findViewById(R.id.list);
        list = new ArrayList<String>();
        list.add("MAD");
        list.add("DBMS");
        list.add("RE");
        list.add("PF");
        list.add("AWD");
        list.add("WAD");
        list.add("ACP");
        list.add("SE");
        list.add("SDA");
        list.add("DCN");
        list.add("DIP");
        list.add("ITC");
        list.add("ENGLISH");
        list.add("Calculus");
        list.add("Physics");
        list.add("DS");
        list.add("STATS");
        list.add("OR");
        list.add("OS");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!list.contains(query)) {
                    Toast.makeText(MainActivity2.this, "Match Not Found",
                            Toast.LENGTH_SHORT).show();
                }
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