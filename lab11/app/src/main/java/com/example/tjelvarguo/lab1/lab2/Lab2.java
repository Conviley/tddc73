package com.example.tjelvarguo.lab1.lab2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.example.tjelvarguo.lab1.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lab2 extends Activity {

    HashMap<String, List<String>> movieCategories;
    List<String> movieList;
    ExpandableListView expList;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);

        expList = findViewById(R.id.movieList);
        movieCategories = DataProvider.getInfo();
        movieList = new ArrayList<>(movieCategories.keySet());
        adapter = new MovieAdapter(this, movieCategories, movieList);
        expList.setAdapter(adapter);
    }
}
