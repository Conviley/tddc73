package com.example.tjelvarguo.lab1.lab3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tjelvarguo.lab1.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tjelvar Guo on 2018-11-19.
 */

public class PopUpList extends LinearLayout {

    Context ctx;
    List<String> names = new ArrayList<>();

    public  PopUpList(Context context) {
        super(context);
        this.ctx = context;
        init();
    }

    public PopUpList(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.ctx = context;
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.PopUpList,
                0, 0);
        init();
    }

    private void init(){
        this.setOrientation(VERTICAL);

        fillView();
    }

    private void fillView(){
        this.removeAllViews();
        TextView textView = new TextView(ctx);
        textView.setText("ASDASDASDASDASW");
        this.addView(textView);
        for (int i = 0; i < names.size(); i++) {
            NameRow nameRow = new NameRow(ctx);
            nameRow.setName(names.get(i));
            this.addView(nameRow);
        }
        TextView textView1 = new TextView(ctx);
        textView1.setText("ASDASDASDASDASW");
        this.addView(textView1);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(840, names.size() * 100 );
    }


    private void redDraw() {
        fillView();
        invalidate();
        requestLayout();
    }

    public void setNames(List<String> names){
        this.names = names;
        redDraw();
    }

    public void clearNames() {
        this.names.clear();
        redDraw();
    }
}
