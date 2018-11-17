package com.example.tjelvarguo.lab1.lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tjelvarguo.lab1.R;
import com.example.tjelvarguo.lab1.lab2.Lab2;

public class Lab13Java extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout outerContainer = new LinearLayout(this);
        outerContainer.setOrientation(LinearLayout.VERTICAL);

        TextView q1 = new TextView(this);
        q1.setText("Hur trvis du på LiU");
        q1.setGravity(Gravity.CENTER);

        TextView q2 = new TextView(this);
        q2.setText("Läser du på LiTH");
        q2.setGravity(Gravity.CENTER);

        TextView q3 = new TextView(this);
        q3.setText("Är detta LiUs logotyp");
        q3.setGravity(Gravity.CENTER);

        String[] q1Answers = new String[]{"Bra", "Mycket Bra", "Jättebra"};
        String[] yesNo = new String[]{"Ja", "Nej"};

        LinearLayout q1CheckBoxLayout = createCheckboxLayout(q1Answers);
        LinearLayout q2CheckBoxLayout = createCheckboxLayout(yesNo);
        LinearLayout q3CheckBoxLayout = createCheckboxLayout(yesNo);

        ImageView liuLogo = new ImageView(this);
        liuLogo.setImageDrawable(getDrawable(R.drawable.logo));

        Button sendButton = new Button(this);
        sendButton.setText("LAB 2");

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), Lab2.class);
                startActivity(myIntent);
            }
        });

        LinearLayout.LayoutParams sendButtonParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
        );

        outerContainer.addView(q1);
        outerContainer.addView(q1CheckBoxLayout);
        outerContainer.addView(q2);
        outerContainer.addView(q2CheckBoxLayout);
        outerContainer.addView(liuLogo);
        outerContainer.addView(q3);
        outerContainer.addView(q3CheckBoxLayout);
        outerContainer.addView(sendButton, sendButtonParams);

        setContentView(outerContainer);
    }

    private LinearLayout createCheckboxLayout(String[] answers) {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);

        for (String answer : answers) {
            CheckBox checkBox = new CheckBox(this);

            TextView textView = new TextView(this);
            textView.setText(answer);

            layout.addView(checkBox);
            layout.addView(textView);
        }

        return layout;
    }
}
