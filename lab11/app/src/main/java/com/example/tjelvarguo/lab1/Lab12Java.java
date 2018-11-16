package com.example.tjelvarguo.lab1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class Lab12Java extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout = new RelativeLayout(this);

        LinearLayout nameLayout = createLinearLayout();
        LinearLayout passwordLayout = createLinearLayout();
        LinearLayout emailLayout= createLinearLayout();
        LinearLayout ageLayout = createLinearLayout();

        RelativeLayout.LayoutParams nameParams = createParams(RelativeLayout.ALIGN_PARENT_TOP ,0);
        RelativeLayout.LayoutParams passwordParams = createParams(RelativeLayout.BELOW, nameLayout.getId());
        RelativeLayout.LayoutParams emailParams = createParams(RelativeLayout.BELOW, passwordLayout.getId());
        RelativeLayout.LayoutParams ageParams = createParams(RelativeLayout.BELOW, emailLayout.getId());

        addViewsToLinearLayout(nameLayout, "Namn", true);
        addViewsToLinearLayout(passwordLayout, "Lösenord",true);
        addViewsToLinearLayout(emailLayout, "Epost",true);
        addViewsToLinearLayout(ageLayout, "Ålder",false);

        relativeLayout.addView(nameLayout, nameParams);
        relativeLayout.addView(passwordLayout, passwordParams);
        relativeLayout.addView(emailLayout, emailParams);
        relativeLayout.addView(ageLayout, ageParams);

        setContentView(relativeLayout);
    }

    private void addViewsToLinearLayout (LinearLayout layout, String text, boolean hasEditText) {
        TextView textView = new TextView(this);
        textView.setText(text);

        LinearLayout.LayoutParams textViewParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT,1f
        );
        layout.addView(textView, textViewParam);
        LinearLayout.LayoutParams contentParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT,4f);

        if (hasEditText) {
            EditText editText = new EditText(this);
            layout.addView(editText,contentParam);
        } else {
            SeekBar seekBar = new SeekBar(this);
            layout.addView(seekBar, contentParam);
        }
    }

    private LinearLayout createLinearLayout() {
        LinearLayout layout = new LinearLayout(this);
        layout.setId(View.generateViewId());
        layout.setOrientation(LinearLayout.HORIZONTAL);
        return layout;
    }

    private RelativeLayout.LayoutParams createParams (int rule, int ruleId) {
        RelativeLayout.LayoutParams params =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        if (ruleId == 0) {
            params.addRule(rule);
        } else {
            params.addRule(rule,ruleId);
        }
        return params;
    }
}
