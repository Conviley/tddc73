package com.example.tjelvarguo.lab1.lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tjelvarguo.lab1.R;

public class Lab13XML extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab13);

        Button button = findViewById(R.id.lab13);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), Lab13Java.class);
                startActivity(myIntent);
            }
        });
    }
}
