package com.example.tjelvarguo.lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lab11XML extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab11);

        Button change_activity = (Button) findViewById(R.id.knapp);

        change_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), Lab11Java.class);
                startActivity(myIntent);
            }
        });
    }
}