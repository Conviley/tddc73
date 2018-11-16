package com.example.tjelvarguo.lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

public class Lab11Java extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button myButton = new Button(this);
        myButton.setText("LAB 1.2XML");

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), Lab12XML.class);
                startActivity(myIntent);
            }
        });

        EditText myEditText = new EditText(this);
        myEditText.setLines(1);
        RatingBar ratingBar = new RatingBar(this);
        EditText multilineEditText = new EditText(this);

        myButton.setId(View.generateViewId());
        myEditText.setId(View.generateViewId());
        ratingBar.setId(View.generateViewId());
        multilineEditText.setId(View.generateViewId());

        RelativeLayout myLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);

        RelativeLayout.LayoutParams textParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        textParams.addRule(RelativeLayout.BELOW, myButton.getId());

        RelativeLayout.LayoutParams ratinBarParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        ratinBarParams.addRule(RelativeLayout.BELOW, myEditText.getId());
        ratinBarParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        RelativeLayout.LayoutParams multilinEditTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        multilinEditTextParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

        myLayout.addView(myButton, buttonParams);
        myLayout.addView(myEditText, textParams);
        myLayout.addView(ratingBar, ratinBarParams);
        myLayout.addView(multilineEditText, multilinEditTextParams);

        setContentView(myLayout);
    }
}
