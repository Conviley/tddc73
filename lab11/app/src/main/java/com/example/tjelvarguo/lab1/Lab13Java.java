package com.example.tjelvarguo.lab1;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Lab13Java extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout outerContainer = new LinearLayout(this);
        outerContainer.setOrientation(LinearLayout.VERTICAL);

        TextView q1 = new TextView(this);
        q1.setText("Hur trvis du på LiU");

        TextView q2 = new TextView(this);
        q2.setText("Läser du på LiTH");

        TextView q3 = new TextView(this);
        q3.setText("Är detta LiUs logotyp");

        String[] q1Answers = new String[]{"Bra", "Mycket Bra", "Jättebra"};
        String[] yesNo = new String[]{"Ja", "Nej"};

        LinearLayout q1CheckBoxLayout = createCheckboxLayout(q1Answers);
        LinearLayout q2CheckBoxLayout = createCheckboxLayout(yesNo);
        LinearLayout q3CheckBoxLayout = createCheckboxLayout(yesNo);

        ImageView liuLogo = new ImageView(this);
        liuLogo.setImageDrawable(getDrawable(R.drawable.logo));

        outerContainer.addView(q1);
        outerContainer.addView(q1CheckBoxLayout);
        outerContainer.addView(q2);
        outerContainer.addView(q2CheckBoxLayout);
        outerContainer.addView(liuLogo);
        outerContainer.addView(q3);
        outerContainer.addView(q3CheckBoxLayout);

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
