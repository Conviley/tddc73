package com.example.tjelvarguo.lab1.lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tjelvarguo.lab1.R;

public class Lab12XML extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab12);

        Button button = findViewById(R.id.java12);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), Lab12Java.class);
                startActivity(myIntent);
            }
        });

    }

}
