package com.example.tjelvarguo.lab1.lab2;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ExpandableListView;

import com.example.tjelvarguo.lab1.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lab2 extends Activity {

    HashMap<String, List<String>> movieCollection;
    List<String> genres;
    ExpandableListView expList;
    EditText searchBar;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
        searchBar = findViewById(R.id.searchBar);
        searchBar.setText("/");
        searchBar.setSelection(searchBar.getText().length());
        expList = findViewById(R.id.movieList);
        movieCollection = DataProvider.getInfo();
        genres = new ArrayList<>(movieCollection.keySet());
        adapter = new MovieAdapter(this, movieCollection, genres, searchBar);
        expList.setAdapter(adapter);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.equals("")) {
                    searchBar.setText("/");
                }
            }
        });
    }


}
